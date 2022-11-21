package com.jaimecorg.springprojects.tienda.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.jaimecorg.springprojects.tienda.dao.ClientesDAO;
import com.jaimecorg.springprojects.tienda.model.Cliente;

@Repository
public class ClientesDAOImpl extends JdbcDaoSupport implements ClientesDAO{

    @Autowired 
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public List<Cliente> findAll() {
        
        String query = "select * from Clientes";

        List<Cliente> clientes = getJdbcTemplate().query(query, new BeanPropertyRowMapper(Cliente.class));

        return clientes;
    }
    

}
