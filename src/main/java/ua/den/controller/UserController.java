package ua.den.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("settings")
    public String getSettingsPage(){
        return "user/account_settings";
    }
}
