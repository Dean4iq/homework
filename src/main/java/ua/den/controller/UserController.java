package ua.den.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.den.model.entity.SearchParam;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("settings")
    public String getSettingsPage() {
        return "user/account_settings";
    }

    @RequestMapping("search")
    public ModelAndView getSearchPage() {
        ModelAndView modelAndView = new ModelAndView("user/search_page");

        modelAndView.addObject("search_details", new SearchParam.Builder().build());

        return modelAndView;
    }

    @RequestMapping("search_process")
    public ModelAndView processSearch(@ModelAttribute("search_details") @Valid SearchParam searchParam,
                                      BindingResult bindingResult) {
        System.out.println(searchParam);
        return new ModelAndView("user/search_page");
    }

    private void preparePredefinedFields(ModelAndView modelAndView) {

    }
}
