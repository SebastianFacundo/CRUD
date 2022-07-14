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

    Cliente cliente;
    ClienteDAO cliente_dao = new ClienteDAO();
    RequestDispatcher rd = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String accion = request.getParameter("accion");

        if (accion.equals("ingresar")) {
            if (!(cliente_dao.duplicado(Integer.parseInt(request.getParameter("dni"))))) {
                cliente = new Cliente();
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
        }

        if (accion.equals("actualizar1")) {

            cliente = cliente_dao.buscar(Integer.parseInt(request.getParameter("dni")));
            try {
                if (!cliente.equals(null)) {
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("titulo", "Formulario de Actualización");
                    request.setAttribute("h1", "Actualización");
                    request.setAttribute("boton", "Actualizar");
                    request.setAttribute("color_boton", "warning");
                    request.setAttribute("mensaje", "*No se puede modificar el DNI, en ese caso eliminar y volver a ingresar");
                    request.setAttribute("accion", "actualizar2");
                    rd = request.getRequestDispatcher("actualizacion_eliminacion.jsp");
                }
            } catch (Exception e) {
                request.setAttribute("titulo", "Error al Buscar");
                request.setAttribute("mensaje", "CLIENTE NO ENCONTRADO");
                rd = request.getRequestDispatcher("error.jsp");
            }

        }


        if (accion.equals("actualizar2")) {
            try {
                cliente = new Cliente();
                cliente.setNombre(request.getParameter("nombre"));
                cliente.setApellido(request.getParameter("apellido"));
                cliente.setDni(Integer.parseInt(request.getParameter("dni")));
                cliente.setEmail(request.getParameter("email"));
                if (cliente_dao.modificar(cliente)) {
                    request.setAttribute("mensaje", "CLIENTE ACTUALIZADO");
                    rd = request.getRequestDispatcher("exito.jsp");
                }
            } catch (Exception e) {
                request.setAttribute("titulo", "Error al Actualizar");
                request.setAttribute("mensaje", "CLIENTE NO ACTUALIZADO");
                rd = request.getRequestDispatcher("error.jsp");
            }
        }

        if (accion.equals("eliminar1")) {
            cliente = cliente_dao.buscar(Integer.parseInt(request.getParameter("dni")));
            try {
                if (!cliente.equals(null)) {
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("titulo", "Formulario de Eliminación");
                    request.setAttribute("h1", "Eliminación");
                    request.setAttribute("boton", "Eliminar");
                    request.setAttribute("color_boton", "danger");
                    request.setAttribute("accion", "eliminar2");
                    rd = request.getRequestDispatcher("actualizacion_eliminacion.jsp");
                }
            } catch (Exception e) {
                request.setAttribute("titulo", "Error al Buscar");
                request.setAttribute("mensaje", "CLIENTE NO ENCONTRADO");
                rd = request.getRequestDispatcher("error.jsp");
            }
        }

        if (accion.equals("eliminar2")) {

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


}