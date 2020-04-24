package com.example.loginapp.controller;

import com.example.loginapp.model.User;
import com.example.loginapp.service.UserService;
//import com.example.loginapp.utility.UserValidator;
import com.example.loginapp.utility.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(user);

        return "redirect:/login";
    }

    @RequestMapping(value = {"/", "/login"}, method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping("/helloDummy")
    public String welcome(Model model) {
        return "helloDummy";
    }
}