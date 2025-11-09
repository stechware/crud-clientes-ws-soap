package com.idat.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.idat.model.Cliente;

@WebService
public class ClienteMock {

    private static List<Cliente> clientes = new ArrayList<>();

    static {
        clientes.add(new Cliente(1, "Ana", "Gómez", "ana.gomez@mail.com", "999555444"));
        clientes.add(new Cliente(2, "Luis", "Torres", "luis.torres@mail.com", "988777666"));
        clientes.add(new Cliente(3, "María", "Flores", "maria.flores@mail.com", "955112233"));
        clientes.add(new Cliente(4, "Pedro", "Ramírez", "pedro.ramirez@mail.com", "900111222"));
        clientes.add(new Cliente(5, "Lucía", "Vega", "lucia.vega@mail.com", "911223344"));
    }

    @WebMethod
    public List<Cliente> listarClientesMock() {
        return clientes;
    }

    @WebMethod
    public String registrarClienteMock(Cliente c) {
        c.setId(clientes.size() + 1);
        clientes.add(c);
        return "Mock: Cliente agregado correctamente.";
    }

    @WebMethod
    public String eliminarClienteMock(int id) {
        clientes.removeIf(c -> c.getId() == id);
        return "Mock: Cliente eliminado correctamente.";
    }
}
