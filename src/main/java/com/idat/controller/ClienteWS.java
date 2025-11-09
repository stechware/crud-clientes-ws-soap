package com.idat.controller;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.idat.model.Cliente;
import com.idat.service.ClienteService;

@WebService(serviceName = "CrudClienteWs")
public class ClienteWS {

    private ClienteService service = new ClienteService();

    @WebMethod
    public List<Cliente> listarClientes() {
        return service.listarClientes();
    }

    @WebMethod
    public String registrarCliente(Cliente c) {
        return service.registrarCliente(c);
    }

    @WebMethod
    public String actualizarCliente(Cliente c) {
        return service.actualizarCliente(c);
    }

    @WebMethod
    public String eliminarCliente(int id) {
        return service.eliminarCliente(id);
    }
}
