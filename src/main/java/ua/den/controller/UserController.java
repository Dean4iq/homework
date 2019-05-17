package ua.den.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.den.model.dto.NonSensitiveUserData;
import ua.den.model.dto.SearchParam;
import ua.den.model.dto.SensitiveUserData;
import ua.den.model.dto.UserDto;
import ua.den.model.exceprions.PasswordNotMatchingException;
import ua.den.model.exceprions.UserNotFoundException;
import ua.den.model.service.CarModelService;
import ua.den.model.service.CarService;
import ua.den.model.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarModelService carModelService;
    @Autowired
    private UserService userService;

    @RequestMapping("settings")
    public ModelAndView getSettingsPage(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("user/account_settings");

        addObjectsToSettingsPage(modelAndView, principal);

        return modelAndView;
    }

    @RequestMapping("change_non_sensitive_data")
    public ModelAndView updateNonSensitiveUserData(@ModelAttribute("nonSensitiveData") @Valid NonSensitiveUserData userData,
                                                   BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("user/account_settings");

        if (!bindingResult.hasErrors()) {
            try {
                userService.updateUserData(userData);
                modelAndView.addObject("successProcess", true);
            } catch (UserNotFoundException e) {
                modelAndView.addObject("userNotFound", true);
            }
        }

        modelAndView.addObject("sensitiveData", new SensitiveUserData());

        return modelAndView;
    }

    @RequestMapping("change_sensitive_data")
    public ModelAndView updateSensitiveUserData(@ModelAttribute("sensitiveData") @Valid SensitiveUserData userData,
                                                BindingResult bindingResult,
                                                Principal principal) {
        ModelAndView modelAndView = new ModelAndView("user/account_settings");

        if (!bindingResult.hasErrors()) {
            try {
                userService.updateUserData(userData, principal.getName());
                modelAndView.addObject("successProcess", true);
            } catch (PasswordNotMatchingException e) {
                modelAndView.addObject("invalidPass", true);
            }
        }

        modelAndView.addObject("nonSensitiveData", userService.getNonSensitiveUserDataByLogin(principal.getName()));

        return modelAndView;
    }

    @RequestMapping("search")
    public ModelAndView getSearchPage() {
        ModelAndView modelAndView = new ModelAndView("user/search_page");

        modelAndView.addObject("search_details", new SearchParam.Builder().build());
        modelAndView.addObject("submitted", false);

        preparePredefinedFields(modelAndView);

        return modelAndView;
    }

    @RequestMapping("search_process")
    public ModelAndView processSearch(@ModelAttribute("search_details") @Valid SearchParam searchParam,
                                      BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("user/search_page");
        modelAndView.addObject("submitted", true);

        preparePredefinedFields(modelAndView);

        return modelAndView;
    }

    private void addObjectsToSettingsPage(ModelAndView modelAndView, Principal principal) {
        modelAndView.addObject("nonSensitiveData", userService.getNonSensitiveUserDataByLogin(principal.getName()));
        modelAndView.addObject("sensitiveData", new SensitiveUserData());
    }

    private void preparePredefinedFields(ModelAndView modelAndView) {
        modelAndView.addObject("modelList", carModelService.getSetOfCarModels());
        modelAndView.addObject("carModelList", carModelService.getAllCarModels());
    }
}
