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
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView login(Model model, Usuario usuario, HttpSession session){

        String message = messageSource.getMessage("saludar.usuario", new String[]{usuario.getName()}, LocaleContextHolder.getLocale());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("greetings", message);
        modelAndView.setViewName("welcome");

        session.setAttribute("usuario", usuario);

        return modelAndView;
    }

    @GetMapping(value = "/logout")
    public ModelAndView logout(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("login/signin");

        //session.setAttribute("usuario", null);
        session.invalidate();

        return modelAndView;
    }
    
    @GetMapping(value = {"/welcome"})
    public String welcome(Model model, HttpSession session){
        model.addAttribute("sessionid", session.getId());
        return "welcome";
    }
    
}