package com.jaimecorg.springprojects.tienda.dao;

import java.util.List;

import com.jaimecorg.springprojects.tienda.model.Cliente;

public interface ClientesDAO {
    
    public List<Cliente> findAll();
}
