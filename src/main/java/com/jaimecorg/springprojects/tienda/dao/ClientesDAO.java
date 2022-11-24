package com.jaimecorg.springprojects.tienda.dao;

import java.util.List;

import com.jaimecorg.springprojects.tienda.model.Cliente;

public interface ClientesDAO {
    
    public List<Cliente> findAll();
    public Cliente findById(int codigo);
    public void insert(Cliente cliente);
    public void update(Cliente cliente);
    public void delete(int codigo);
}
