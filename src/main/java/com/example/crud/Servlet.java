/* Autor: SEBASTIÁN FACUNDO VERA */
package com.example.crud;

import java.io.*;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "servlet", value = "/servlet")
public class Servlet extends HttpServlet {

    private Cliente cliente = new Cliente();
    private ClienteDAO cliente_dao = new ClienteDAO();
    private RequestDispatcher rd = null;
    private String accion;

    private void ingresar(String accion, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!(cliente_dao.existe(Integer.parseInt(request.getParameter("dni"))))) {
            cliente.setNombre(request.getParameter("nombre"));
            cliente.setApellido(request.getParameter("apellido"));
            cliente.setDni(Integer.parseInt(request.getParameter("dni")));
            cliente.setEmail(request.getParameter("email"));
            cliente.setFecha_alta(new Date(System.currentTimeMillis()));
            if (cliente_dao.insertar(cliente)) {
                request.setAttribute("mensaje", "INGRESO EXITOSO");
                rd = request.getRequestDispatcher("exito.jsp");
            }
        } else {
            request.setAttribute("titulo", "Error al Ingresar");
            request.setAttribute("mensaje", "DNI YA INGRESADO");
            rd = request.getRequestDispatcher("error.jsp");
        }
        rd.forward(request, response);
    }


    private void actualizar(String accion, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (accion.equals("actualizar1") && cliente_dao.existe(Integer.parseInt(request.getParameter("dni")))) {
            cliente = cliente_dao.buscar(Integer.parseInt(request.getParameter("dni")));
            request.setAttribute("cliente", cliente);
            request.setAttribute("titulo", "Formulario de Actualización");
            request.setAttribute("h1", "Actualización");
            request.setAttribute("boton", "Actualizar");
            request.setAttribute("color_boton", "warning");
            request.setAttribute("mensaje", "*No se puede modificar el DNI, en ese caso eliminar y volver a ingresar");
            request.setAttribute("accion", "actualizar2");
            rd = request.getRequestDispatcher("actualizacion_eliminacion.jsp");

        } else if (accion.equals("actualizar1")) {
            request.setAttribute("titulo", "Error al Buscar");
            request.setAttribute("mensaje", "CLIENTE NO ENCONTRADO");
            rd = request.getRequestDispatcher("error.jsp");

        } else if (accion.equals("actualizar2")) {
            cliente.setNombre(request.getParameter("nombre"));
            cliente.setApellido(request.getParameter("apellido"));
            cliente.setDni(Integer.parseInt(request.getParameter("dni")));
            cliente.setEmail(request.getParameter("email"));
            if (cliente_dao.modificar(cliente)) {
                request.setAttribute("mensaje", "CLIENTE ACTUALIZADO");
                rd = request.getRequestDispatcher("exito.jsp");

            } else {
                request.setAttribute("titulo", "Error al Actualizar");
                request.setAttribute("mensaje", "CLIENTE NO ACTUALIZADO");
                rd = request.getRequestDispatcher("error.jsp");
            }
        }
        rd.forward(request, response);

    }

    private void eliminar(String accion, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (accion.equals("eliminar1") && cliente_dao.existe(Integer.parseInt(request.getParameter("dni")))) {
            cliente = cliente_dao.buscar(Integer.parseInt(request.getParameter("dni")));
            request.setAttribute("cliente", cliente);
            request.setAttribute("titulo", "Formulario de Eliminación");
            request.setAttribute("h1", "Eliminación");
            request.setAttribute("boton", "Eliminar");
            request.setAttribute("color_boton", "danger");
            request.setAttribute("accion", "eliminar2");
            rd = request.getRequestDispatcher("actualizacion_eliminacion.jsp");

        } else if (accion.equals("eliminar1")) {
            request.setAttribute("titulo", "Error al Buscar");
            request.setAttribute("mensaje", "CLIENTE NO ENCONTRADO");
            rd = request.getRequestDispatcher("error.jsp");

        } else if (accion.equals("eliminar2")) {
            System.out.println(cliente);
            if (cliente_dao.eliminar(cliente.getId_cliente())) {
                request.setAttribute("mensaje", "CLIENTE ELIMINADO");
                rd = request.getRequestDispatcher("exito.jsp");
            } else {
                request.setAttribute("titulo", "Error al eliminar");
                request.setAttribute("mensaje", "CLIENTE NO ELIMINADO");
                rd = request.getRequestDispatcher("error.jsp");
            }
        }
        rd.forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        accion = request.getParameter("accion");
        if (accion.equals("ingresar")) {
            ingresar(accion, request, response);
        } else if (accion.equals("actualizar1") || accion.equals("actualizar2")) {
            actualizar(accion, request, response);
        } else {
            eliminar(accion, request, response);
        }


    }

}