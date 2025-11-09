package com.idat.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.idat.config.ConexionDb;
import com.idat.model.Cliente;

public class ClienteRepository {

    public List<Cliente> listar() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes ORDER BY id";

        try (Connection conn = ConexionDb.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("telefono")
                ));
            }
        }
        return lista;
    }

    public String registrar(Cliente c) throws SQLException {
        String sql = "INSERT INTO clientes(nombre, apellido, correo, telefono) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDb.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getTelefono());
            ps.executeUpdate();
            return "Cliente registrado correctamente.";
        }
    }

    public String actualizar(Cliente c) throws SQLException {
        String sql = "UPDATE clientes SET nombre=?, apellido=?, correo=?, telefono=? WHERE id=?";
        try (Connection conn = ConexionDb.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getTelefono());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
            return "Cliente actualizado correctamente.";
        }
    }

    public String eliminar(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id=?";
        try (Connection conn = ConexionDb.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Cliente eliminado correctamente.";
        }
    }
}