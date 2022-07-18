<%--
  Creado por SEBASTIÁN FACUNDO VERA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>BÚSQUEDA</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="container  pt-5 mt-5">
    <form class="row row-cols-1 row-cols-sm-auto justify-content-center pb-5 pt-5 mt-5 gy-5" action="servlet?accion=busqueda_actualizar"
          method="post">
        <label for="dni" class="col fs-3">INGRESE DNI:</label>
        <input type="number" class="col fs-4 mx-5" name="dni" id="dni" max="2147483648" required>
        <button type="submit" class="col btn btn-primary fs-5 mx-2">Buscar</button>

    </form>
    <a href="index.jsp" class="btn btn-secondary mt-5 w-25 fs-5 "><i class="bi bi-arrow-left"> </i>ATRÁS</a>
</div>

</body>
</html>
