package ua.den.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.den.model.dto.SearchParam;
import ua.den.model.service.CarModelService;
import ua.den.model.service.CarService;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarModelService carModelService;

    @RequestMapping("settings")
    public String getSettingsPage() {
        return "user/account_settings";
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

    private void preparePredefinedFields(ModelAndView modelAndView) {
        modelAndView.addObject("modelList", carModelService.getSetOfCarModels());
        modelAndView.addObject("carModelList", carModelService.getAllCarModels());
    }
}
