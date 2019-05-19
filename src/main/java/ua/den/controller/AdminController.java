package ua.den.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.den.model.dto.CarParams;
import ua.den.model.entity.Order;
import ua.den.model.service.CarService;
import ua.den.model.service.OrderService;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CarService carService;

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

        try {
            carService.addNewCar(carParams);
            modelAndView.addObject("successAdd", true);
        } catch (Exception e) {
            modelAndView.addObject("errorAdd", true);
        }

        return modelAndView;
    }

    @RequestMapping("orders")
    public ModelAndView getOrders() {
        ModelAndView modelAndView = new ModelAndView("admin/orders_page");

        modelAndView.addObject("orders", orderService.getListOfUnresolvedOrders());

        return modelAndView;
    }

    @RequestMapping("consider_order")
    public ModelAndView considerOrder(@RequestParam("order_id") Order order) {
        ModelAndView modelAndView = new ModelAndView("admin/order");

        modelAndView.addObject("order", order);

        return modelAndView;
    }
}
