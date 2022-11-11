package com.jaimecorg.springprojects.tienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaimecorg.springprojects.tienda.model.Usuario;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping(value = {"/signin"})
    public String signin(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(Model model, Usuario usuario){

        String message = messageSource.getMessage("saludar.usuario", new String[]{usuario.getName()}, LocaleContextHolder.getLocale());

        model.addAttribute("greetings", message);
        return "welcome";
    }

    @GetMapping(value = {"/logout"})
    public String logout(){
        return "login";
    }
    
}