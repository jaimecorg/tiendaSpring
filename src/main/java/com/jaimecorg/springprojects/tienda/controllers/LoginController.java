package com.jaimecorg.springprojects.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.springprojects.tienda.model.Cliente;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping(value={"/login"})
    public String hola(){
        return "login"; //Es el nombre del archivo html
    }
    
}