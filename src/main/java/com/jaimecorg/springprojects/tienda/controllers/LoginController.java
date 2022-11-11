package com.jaimecorg.springprojects.tienda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaimecorg.springprojects.tienda.model.Usuario;

@Controller
@RequestMapping("/login")
public class LoginController {

    


    @GetMapping(value = {"/signin"})
    public String signin(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(Model model, Usuario usuario){

        model.addAttribute("greetings", "¡Bienvenido, " + usuario.getName() + "!");
        return "welcome";
    }

    @GetMapping(value = {"/logout"})
    public String logout(){
        return "login";
    }
    
}