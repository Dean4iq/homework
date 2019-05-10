package ua.den.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.den.model.dto.UserDto;
import ua.den.model.entity.User;
import ua.den.model.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String getLoginPage(Principal principal) {
        return (principal == null) ? "login.html" : "redirect:/home";
    }

    @RequestMapping("/register")
    public ModelAndView getRegisterPage(Principal principal) {
        ModelAndView modelAndView;

        if (principal == null) {
            modelAndView = new ModelAndView("registration.html");
            modelAndView.addObject("userDto", new UserDto());
        } else {
            modelAndView = new ModelAndView("redirect:/home");
        }

        return modelAndView;
    }

    @RequestMapping("/sign-up-process")
    public ModelAndView signUpUser(@ModelAttribute("userDto") @Valid UserDto userDto,
                                   BindingResult result) {
        User registered = new User();

        if (!result.hasErrors()) {
            registered = createUserAccount(userDto);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "userDto", userDto);
        } else {
            return new ModelAndView("redirect:/login?succRegistration", "userDto", userDto);
        }
    }

    private User createUserAccount(UserDto userDto) {
        return userService.registerNewUser(userDto);
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "homepage.html";
    }
}
