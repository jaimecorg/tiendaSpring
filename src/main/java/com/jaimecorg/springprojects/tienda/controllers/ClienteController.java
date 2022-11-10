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
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping(value="/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView("clientes/list");
        modelAndView.addObject("clientes", getClientes());
        modelAndView.addObject("title", "clientes");

        return modelAndView;
    }
    

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cliente", getCliente(codigo));
        modelAndView.setViewName("clientes/edit");

        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Cliente cliente) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cliente", new Cliente());
        modelAndView.setViewName("clientes/new");

        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Cliente cliente) {

        int round = (int) (Math.random()*(100+5));

        cliente.setCodigo(round);

        List<Cliente> clientes = getClientes();
        clientes.add(cliente);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");

        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Cliente cliente) {

        List<Cliente> clientes = getClientes();

        int indexOf = clientes.indexOf(cliente);

        clientes.set(indexOf, cliente);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");

        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        List<Cliente> clientes = getClientes();
        clientes.remove(getCliente(codigo));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");

        return modelAndView;
    }
        

    private Cliente getCliente(int codigo){
        List<Cliente> clientes = getClientes();
        int indexOf = clientes.indexOf(new Cliente(codigo));

        return clientes.get(indexOf);

    }

    private List<Cliente> getClientes() {

        //ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(1, "Juan", "Gomez", "juang@gmail.com","12345678Z", "685741962","C/Real, 13", false));
        clientes.add(new Cliente(2, "Jose", "Martinez", null, "12345678Z", "785412698","C/Madrid, 18", true));
        clientes.add(new Cliente(3, "Noelia", "Lopez", "noelial@gmail.com", "12345678Z", "625857777","Avenida Andalucia, 8", false));
        clientes.add(new Cliente(4, "Laura", "Ruiz", "laurar@gmail.com", "12345678Z", "611234596","C/Paco, 7", true));

        return clientes;

    }

}