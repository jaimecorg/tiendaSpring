package com.jaimecorg.springprojects.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.springprojects.tienda.model.Producto;

@Controller
 @RequestMapping("/productos")
public class ProductoController {
    
    @GetMapping(value = "/list")
    public ModelAndView list(Model model){
        ModelAndView modelAndView = new ModelAndView("productos/list");
        modelAndView.addObject("productos", getProductos());
        modelAndView.addObject("title", "Productos");
        //modelAndView.setViewName("productos/list");


        return modelAndView;
    }

    @GetMapping(path = { "/edit" })
    public ModelAndView edit(
            @RequestParam(name = "codigo", required = true) int codigo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("producto", getProducto(codigo));
        modelAndView.setViewName("productos/edit");
        return modelAndView;
    }

    private Producto getProducto(int codigo){
        
        List<Producto> productos = getProductos();
        int indexOf = productos.indexOf(new Producto(codigo));

        return productos.get(indexOf);
    }   

    private List<Producto> getProductos(){

        ArrayList<Producto>productos = new ArrayList<Producto>();

        productos.add(new Producto(1, "Coca-Cola", "Coca-Cola es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios. Es el principal producto de The Coca-Cola Company, de origen estadounidense.", "/img/cocacola.jpg", null));
        productos.add(new Producto(2, "Fanta", "Fanta es una marca alemana de propiedad estadounidense de refrescos carbonatados con sabor a frutas creada por Coca-Cola Deutschland bajo el liderazgo del empresario alemán Max Keith. Hay más de 200 sabores en todo el mundo.", "/img/fanta.jpg", null));
        productos.add(new Producto(3, "Sprite", "Sprite es un refresco hecho a base de agua carbonatada con sabor a lima o limón, incolora y sin cafeína, creada por la empresa The Coca-Cola Company.​", "/img/sprite.jpg", null));
        productos.add(new Producto(4, "Casera", "La Casera es una marca de refrescos española. Fue fundada en 1949 por la familia Duffo. En la actualidad es propiedad de la empresa Suntory Beverage & Food Europe, perteneciente al grupo japonés Suntory.", "/img/casera.jpg", null));

        return productos;
    }  
}
