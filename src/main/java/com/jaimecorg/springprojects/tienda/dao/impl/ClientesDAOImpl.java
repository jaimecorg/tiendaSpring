package com.jaimecorg.springprojects.tienda.dao.impl;

import java.sql.Types;
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
    
    /*
     
     */
    @Override
    public Cliente findById(int codigo) {
        String query = "select * from Clientes where codigo = ?";

        Object params [] = {codigo};
        int types[] = {Types.INTEGER};

        Cliente cliente = (Cliente) getJdbcTemplate().queryForObject(query, params, types, new BeanPropertyRowMapper(Cliente.class));

        return cliente;
    }

    @Override
    public void insert(Cliente cliente){
        String query = "insert into Clientes (nombre," +
                                            " apellidos," +
                                            " dni," +
                                            " direccion," +
                                            " telefono," +
                                            " email," +
                                            " vip)" +
                                            " values (?, ?, ?, ?, ?, ?, ?)";
        
        Object[] params = {
            cliente.getNombre(),
            cliente.getApellidos(),
            cliente.getDni(),
            cliente.getDireccion(),
            cliente.getTelefono(),
            cliente.getEmail(),
            cliente.isVip()
        };

        final int[] types = {
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.BOOLEAN,
            Types.INTEGER
        };

        int update = getJdbcTemplate().update(query, params, types);
    }

    @Override //Signifa que estás sobreescribiendo un método ya existente 
    public void update(Cliente cliente){
        String query = "update Clientes set nombre = ?," +
                                            " apellidos = ?," +
                                            " dni = ?," +
                                            " direccion = ?," +
                                            " telefono = ?," +
                                            " email = ?," +
                                            " vip = ?" +
                                            " where codigo = ?";
        
        Object[] params = {
            cliente.getNombre(),
            cliente.getApellidos(),
            cliente.getDni(),
            cliente.getDireccion(),
            cliente.getTelefono(),
            cliente.getEmail(),
            cliente.isVip()
        };

        final int[] types = {
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.BOOLEAN,
            Types.INTEGER
        };

        int update = getJdbcTemplate().update(query, params, types);
    }

    

    @Override
    public void delete(int codigo) {
        // TODO Auto-generated method stub
        
    }


    
}

