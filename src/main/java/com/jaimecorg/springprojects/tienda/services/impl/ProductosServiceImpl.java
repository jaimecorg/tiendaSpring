package com.jaimecorg.springprojects.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.springprojects.tienda.dao.ProductosDAO;
import com.jaimecorg.springprojects.tienda.model.Producto;
import com.jaimecorg.springprojects.tienda.services.ProductosServices;

@Service
public class ProductosServiceImpl implements ProductosServices{

    @Autowired
    ProductosDAO productosDAO;

    @Override
    public List<Producto> findAll() {        
        
        return productosDAO.findAll();
    }

    @Override
    public Producto findProducto(int codigo) {        
        
        return productosDAO.findProducto(codigo);
    }

    @Override
    public void insert(Producto producto) {
        productosDAO.insert(producto);
    }

    @Override
    public void update(Producto producto) {
        productosDAO.update(producto);        
    }

    @Override
    public void delete(int codigo) {
        productosDAO.delete(codigo);
    }
    
}
