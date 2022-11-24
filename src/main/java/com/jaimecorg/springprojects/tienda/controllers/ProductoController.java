package com.jaimecorg.springprojects.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.springprojects.tienda.model.Producto;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductosServices productosServices;
     
    @RequestMapping(path = "/list")
    public ModelAndView list(){

        List<Producto> productos = productosServices.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productos", productos);
        modelAndView.setViewName("productos/list");

        return modelAndView;
    }
    
    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "codigo", required = true) int codigo ){

        ModelAndView modelAndView = new ModelAndView();

        Producto producto = productosServices.findProducto(codigo);
        modelAndView.addObject("producto", productosServices.findProducto(codigo));
        modelAndView.setViewName("productos/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create(){

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("producto", new Producto());
         modelAndView.setViewName("productos/new");

         return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Producto producto){

        productosServices.insert(producto);
        
        List<Producto> productos = productosServices.findAll();

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("productos", productos);
         modelAndView.setViewName("productos/list");

         return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Producto producto){

        productosServices.update(producto);
        List<Producto> productos = productosServices.findAll();
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productos", productos);
        modelAndView.setViewName("productos/list");

         return modelAndView;
    }

    @RequestMapping(path = "/delete/{codigo}")
    public ModelAndView delete(@PathVariable(name = "codigo", required = true) int codigo){

        productosServices.delete(codigo);
        List<Producto> productos = productosServices.findAll();

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("productos", productos);
         modelAndView.setViewName("productos/list");

         return modelAndView;
    }

}