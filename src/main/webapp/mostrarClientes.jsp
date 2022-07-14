<%--
  Creado por SEBASTIÁN FACUNDO VERA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.example.crud.Cliente" %>
<%@page import="com.example.crud.ClienteDAO"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>LISTADO</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<%ClienteDAO clienteDao = new ClienteDAO();
    ArrayList<Cliente> listado=clienteDao.obtenerClientes();
%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col">
            <h1 class="text-center bg-dark text-white mt-3"> Mis Clientes</h1>
            <table class="table mt-3 border">
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>APELLIDO</th>
                    <th>DNI</th>
                    <th>EMAIL</th>
                    <th>FECHA_ALTA</th>
                </tr>
                <% for(Cliente c :listado) {%>
                <tr>
                    <td><%=c.getId_cliente()%></td>
                    <td><%=c.getNombre()%></td>
                    <td><%=c.getApellido()%></td>
                    <td><%=c.getDni()%></td>
                    <td><%=c.getEmail()%></td>
                    <td><%=c.getFecha_alta()%></td>

                </tr>
    <%}%>
            </table>
        </div>
    </div>
    <a href="index.jsp" class="btn btn-secondary mt-5 w-25 fs-5"> <- ATRÁS</a>
</div>
</body>
</html>
