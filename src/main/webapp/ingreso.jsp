<%--
  Creado por SEBASTIÁN FACUNDO VERA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>INGRESO</title>
</head>
<body>
<div class="container">
    <div class="row mt-2">
        <h1>Ingreso</h1>
        <form action="servlet?accion=ingresar" method="post" >
            <div class="form-group mt-3">
                <label class="fs-5" for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" required>
            </div>
            <div class="form-group mt-3">
                <label class="fs-5"  for="apellido">Apellido:</label>
                <input type="text" id="apellido" name="apellido" class="form-control" required>
            </div>
            <div class="form-group mt-3">
                <label class="fs-5"  for="dni">Dni:</label>
                <input type="number" id="dni" name="dni" class="form-control" required>
            </div>
            <div class="form-group mt-3">
                <label class="fs-5"  for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>
            <div class="row justify-content-center">
            <button type="submit" class="col-6 btn btn-success mt-5 fs-5">Agregar</button>
            </div>
        </form>

        <a href="index.jsp" class="btn btn-secondary mt-5 w-25 fs-5"> <- ATRÁS</a>
    </div>
</div>
</body>
</html>
