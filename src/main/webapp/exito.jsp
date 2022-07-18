<%--
  Creado por SEBASTIÁN FACUNDO VERA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>PROCESO EXITOSO</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row flex-column justify-content-center mt-5">
        <div class="col text-center mt-5">
            <h2><%=request.getAttribute("mensaje")%>
            </h2>
        </div>
        <div class="row row-cols-1 row-cols-sm-2 text-center">
            <div class="col mt-5"><a class=" px-5 btn fs-5 btn-primary" href="index.jsp">Inicio</a></div>
            <div class="col mt-5"><a class=" px-5 btn fs-5 btn-info" href="mostrarClientes.jsp">Listado</a></div>

        </div>


    </div>
</div>

</body>
</html>
