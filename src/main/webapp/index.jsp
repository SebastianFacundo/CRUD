
<%--
  Creado por SEBASTIÁN FACUNDO VERA
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>CRUD-CLIENTES</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.0/font/bootstrap-icons.css">
</head>
<body class="mt-5">
<div class="container mt-5">
    <div class="row mt-5 ">
        <h1 class="col text-center mt-5 fw-bold"><u>GESTIÓN DE CLIENTES</u></h1>
    </div>
    <div class=" row row-cols-1 row-cols-sm-2 row-cols-lg-4 mt-5 text-center">

        <div class="col mt-5"><a class=" px-5 btn fs-5 btn-success" href="ingreso.jsp"><i class="bi bi-plus-circle"> </i>Ingresar </a></div>
        <div class="col mt-5"><a class=" px-5 btn fs-5 btn-info" href="mostrarClientes.jsp"><i class="bi bi-card-list"> </i>Listado</a></div>
        <div class="col mt-5"><a class=" px-5 btn fs-5 btn-warning" href="busqueda_actualizar.jsp"><i class="bi bi-arrow-clockwise"> </i>Actualizar</a></div>
        <div class="col mt-5"><a class=" px-5 btn fs-5 btn-danger" href="busqueda_eliminar.jsp"><i class="bi bi-trash"> </i>Eliminar</a></div>
    </div>

</div>
</body>
</html>