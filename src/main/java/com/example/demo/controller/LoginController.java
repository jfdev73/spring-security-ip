package com.example.demo.controller;

import com.example.demo.service.LoginAttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private LoginAttemptService loginAttemptService;
    //logger
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")


    public String login(@RequestParam(required = false) String error, Model model, Principal principal, RedirectAttributes flash) {
        if(loginAttemptService.isBlocked()) {
            logger.error("User is blocked");
        }
        if (principal != null) {
            flash.addFlashAttribute("info", "Ya ha iniciado sesión anteriormente");
            return "redirect:/usuario/list";
        }
        if (error != null) {
            model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
        }
        return "login";
    }
}
