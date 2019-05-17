package ua.den.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.den.model.dto.CarParams;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("add_car")
    public ModelAndView getFormToAdd() {
        ModelAndView modelAndView = new ModelAndView("admin/add_car");

        modelAndView.addObject("car_details", new CarParams());

        return modelAndView;
    }

    @RequestMapping("create_new_car")
    public ModelAndView createNewCar(@ModelAttribute("car_details") @Valid CarParams carParams,
                                     BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("admin/add_car");

        modelAndView.addObject("search_details", new CarParams());

        return modelAndView;
    }
}
