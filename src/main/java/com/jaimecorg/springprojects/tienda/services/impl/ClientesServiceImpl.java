package com.jaimecorg.springprojects.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.springprojects.tienda.dao.ClientesDAO;
import com.jaimecorg.springprojects.tienda.model.Cliente;
import com.jaimecorg.springprojects.tienda.services.ClientesServices;

@Service
public class ClientesServiceImpl implements ClientesServices{

    @Autowired
    ClientesDAO clientesDAO;

    @Override
    public List<Cliente> findAll() {
        return clientesDAO.findAll();
    }
    
}
