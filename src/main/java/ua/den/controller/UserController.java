package ua.den.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.den.model.dto.NonSensitiveUserData;
import ua.den.model.dto.SearchParam;
import ua.den.model.dto.SensitiveUserData;
import ua.den.model.entity.Car;
import ua.den.model.entity.Order;
import ua.den.model.entity.Subscription;
import ua.den.model.exceprions.PasswordNotMatchingException;
import ua.den.model.exceprions.RowAlreadyExistsException;
import ua.den.model.exceprions.UserNotFoundException;
import ua.den.model.service.*;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarModelService carModelService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private OrderService orderService;

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

        modelAndView.addObject("carList", carService.getDefinedCarList(searchParam));

        preparePredefinedFields(modelAndView);

        return modelAndView;
    }

    @RequestMapping("order")
    public ModelAndView getOrdersPage(@RequestParam("car_id") Car car, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("redirect:/user/orders");

        Order order = new Order();
        order.setCar(car);
        order.setStatus((byte) 0);
        order.setOrderDate(new Timestamp(new Date().getTime()));
        order.setPrice(car.getPrice());
        order.setUser(userService.retrieveUserData(principal.getName()));

        orderService.addNewOrder(order);

        modelAndView.addObject("orderedSuccess", true);

        return modelAndView;
    }

    @RequestMapping("subscribe")
    public ModelAndView subscribeToCar(@RequestParam("car_id") Car car,
                                       Principal principal) {
        Subscription subscription = new Subscription();

        subscription.setCar(car);
        subscription.setUser(userService.retrieveUserData(principal.getName()));


        try {
            subscriptionService.addNewSubscription(subscription);
        } catch (RowAlreadyExistsException e) {
            ModelAndView modelAndView = new ModelAndView("redirect:/user/search");

            modelAndView.addObject("subscriptionExists", true);

            return modelAndView;
        }

        return new ModelAndView("redirect:/user/subscriptions");
    }

    @RequestMapping("subscriptions")
    public ModelAndView subscribtionsPageForUser(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("user/subscription_page");

        modelAndView.addObject("subscriptions",
                subscriptionService.getSubscriptionsByUser(principal.getName()));

        return modelAndView;
    }

    @RequestMapping("remove_subscription")
    public ModelAndView removeSubscriptionFromUser(@RequestParam("subscription_id") Subscription subscription) {
        subscriptionService.removeSubscription(subscription);

        ModelAndView modelAndView = new ModelAndView("redirect:/user/subscriptions");

        modelAndView.addObject("unsubscribeSuccess", true);

        return modelAndView;
    }

    @RequestMapping("orders")
    public ModelAndView getOrdersPage(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("user/orders_page");

        modelAndView.addObject("orderList", orderService.getOrdersListForUser(principal.getName()));

        return modelAndView;
    }

    @RequestMapping("cancel_order")
    public ModelAndView cancelUserOrder(@RequestParam("order_id") Long orderId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/user/orders");

        orderService.deleteOrder(orderId);

        modelAndView.addObject("cancelSuccess", true);

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
