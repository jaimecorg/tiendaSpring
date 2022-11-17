package com.jaimecorg.springprojects.tienda.controllers;

import javax.servlet.http.HttpSession;

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
    public String login(Model model, Usuario usuario, HttpSession session){

        String message = messageSource.getMessage("saludar.usuario", new String[]{usuario.getName()}, LocaleContextHolder.getLocale());

        model.addAttribute("greetings", message);
        //String id;
        //HttpSession session = httpRequest.getSession();
        session.setAttribute("usuario", usuario);
        return "welcome";
    }

    @GetMapping(value = {"/logout"})
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
    
    @GetMapping(value = {"/welcome"})
    public String welcome(Model model, HttpSession session){
        model.addAttribute("sessionid", session.getId());
        return "welcome";
    }
    
}