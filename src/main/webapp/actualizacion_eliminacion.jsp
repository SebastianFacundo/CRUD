
<%--
  Creado por SEBASTIÁN FACUNDO VERA
--%>
<%@ page import="com.example.crud.Cliente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title><%=request.getAttribute("titulo")%>
    </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<%Cliente c = (Cliente) request.getAttribute("cliente");%>
<div class="container">
    <div class="row mt-2">
        <h1><%=request.getAttribute("h1")%>
        </h1>
        <form action="servlet?accion=<%=request.getAttribute("accion")%>" method="post">
            <div class="form-group mt-3">
                <label class="fs-5" for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" placeholder="<%=c.getNombre()%>"
                       <%if(request.getAttribute("accion").equals("eliminar")){%>
                           value="<%=c.getNombre()%>" readonly
                       <%}%>
                       required>
            </div>
            <div class="form-group mt-3">
                <label class="fs-5" for="apellido">Apeliido:</label>
                <input type="text" id="apellido" name="apellido" class="form-control"
                       placeholder="<%=c.getApellido()%>"
                    <%if(request.getAttribute("accion").equals("eliminar")){%>
                       value="<%=c.getApellido()%>" readonly
                       <%}%>required>
            </div>
            <div class="form-group mt-3">
                <label class="fs-5" for="dni">Dni:</label>
                <input type="number" id="dni" name="dni" class="form-control" max="2147483648"
                       placeholder="<%=String.valueOf(c.getDni())%>"
                    <%if(request.getAttribute("accion").equals("eliminar")){%>
                       value="<%=String.valueOf(c.getDni())%>" readonly
                    <%}%>
                       required>
            </div>
            <div class="form-group mt-3">
                <label class="fs-5" for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control" placeholder="<%=c.getEmail()%>"
                    <%if(request.getAttribute("accion").equals("eliminar")){%>
                       value="<%=c.getEmail()%>" readonly
                    <%}%>
                       required>
            </div>
            <div class="row justify-content-center">
                <button type="submit"
                        class="col-6 btn btn-<%=request.getAttribute("color_boton")%> mt-5 fs-5"><%=request.getAttribute("boton")%>
                </button>
            </div>
        </form>
        <a href="index.jsp" class="btn btn-secondary mt-5 w-25 fs-5"><i class="bi bi-arrow-left"> </i>ATRÁS</a>

    </div>
</div>
</body>
</html>
