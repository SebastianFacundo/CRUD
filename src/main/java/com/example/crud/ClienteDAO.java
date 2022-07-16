package com.example.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* Autor: SEBASTIÁN FACUNDO VERA */
public class ClienteDAO {
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean insertar(Cliente cliente) {
        Connection con = Conexion.getConnection();
        boolean estado = false;
        try {
            ps = con.prepareStatement("insert into clientes (nombre,apellido,dni,email,fecha_alta) values (?,?,?,?,?)");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getDni());
            ps.setString(4, cliente.getEmail());
            ps.setDate(5, cliente.getFecha_alta());
            ps.executeUpdate();
            estado=true;
        } catch (SQLException e) {
            estado=false;
            throw new RuntimeException(e);
        }
        return estado;
    }

    public ArrayList<Cliente> obtenerClientes() {
        Connection con = Conexion.getConnection();
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            ps = con.prepareStatement("select * from clientes");
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setEmail(rs.getString("email"));
                cliente.setFecha_alta(rs.getDate("fecha_alta"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                if( rs!=null ) rs.close();
                if( ps!=null ) ps.close();
                if( con!=null ) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean modificar(Cliente cliente) {
        Connection con = Conexion.getConnection();
        boolean estado = false;
        try {
            ps = con.prepareStatement("update clientes set nombre=?,apellido=?,dni=?,email=? where dni=?");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getDni());
            ps.setString(4, cliente.getEmail());
            ps.setInt(5, cliente.getDni());
            ps.executeUpdate();
            estado = true;
        } catch (SQLException e) {
            estado = false;
            throw new RuntimeException(e);
        }
        return estado;
    }

    public boolean eliminar(int id) {
        Connection con = Conexion.getConnection();
        boolean estado = false;
        try {
            ps = con.prepareStatement("delete from clientes where id_cliente=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            estado = true;
        } catch (SQLException e) {
            estado = false;
            throw new RuntimeException(e);
        }
        return estado;
    }

    public Cliente buscar(int dni) {
        Connection con = Conexion.getConnection();
        Cliente cliente = null;
        try {
            ps = con.prepareStatement("select * from clientes where dni=?");
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setEmail(rs.getString("email"));
                cliente.setFecha_alta(rs.getDate("fecha_alta"));
            }


        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return cliente;
    }

    public boolean existe(int dni) {
        Connection con = Conexion.getConnection();
        boolean encontrado = false;
        try {
            ps = con.prepareStatement("select id_cliente from clientes where dni=?");
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                encontrado = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return encontrado;
    }


}


