package com.idat.service;

import java.sql.SQLException;
import java.util.List;

import com.idat.model.Cliente;
import com.idat.repository.ClienteRepository;

public class ClienteService {

    private ClienteRepository repo = new ClienteRepository();

    public List<Cliente> listarClientes() {
        try {
            return repo.listar();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String registrarCliente(Cliente c) {
        try {
            return repo.registrar(c);
        } catch (SQLException e) {
            return "Error al registrar: " + e.getMessage();
        }
    }

    public String actualizarCliente(Cliente c) {
        try {
            return repo.actualizar(c);
        } catch (SQLException e) {
            return "Error al actualizar: " + e.getMessage();
        }
    }

    public String eliminarCliente(int id) {
        try {
            return repo.eliminar(id);
        } catch (SQLException e) {
            return "Error al eliminar: " + e.getMessage();
        }
    }
}
