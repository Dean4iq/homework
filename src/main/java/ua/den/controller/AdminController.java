package ua.den.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.den.model.dto.CarParams;
import ua.den.model.entity.Car;
import ua.den.model.entity.Order;
import ua.den.model.service.CarService;
import ua.den.model.service.EmailFormService;
import ua.den.model.service.OrderService;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CarService carService;

    @Autowired
    private EmailFormService emailFormService;

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
            Car savedCar = carService.addNewCar(carParams);
            modelAndView.addObject("successAdd", true);

            //emailFormService.sendNotificationForCar(savedCar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    @RequestMapping("make_order_decision_accept")
    public ModelAndView decideOrderAccept(@RequestParam("order_id") Order order) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/orders");

        order.setStatus((byte) 1);
        order.setPurchasingDate(new Timestamp(new Date().getTime()));

        orderService.updateOrder(order);

        order.getCar().setAmountAvailable(order.getCar().getAmountAvailable() - 1);

        modelAndView.addObject("operationSuccess", true);

        return modelAndView;
    }

    @RequestMapping("make_order_decision_decline")
    public ModelAndView decideOrderDecline(@RequestParam("order_id") Order order) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/orders");

        order.setStatus((byte) 2);
        order.setPurchasingDate(new Timestamp(new Date().getTime()));

        orderService.updateOrder(order);

        modelAndView.addObject("operationSuccess", true);

        return modelAndView;
    }
}
