<%--
  Creado por SEBASTIÁN FACUNDO VERA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title><%=request.getAttribute("titulo")%>
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row flex-column justify-content-center mt-5">
        <div class="col mt-5 text-center">
            <h2><%=request.getAttribute("mensaje")%>
            </h2>
        </div>
        <div class="col text-center mt-5">
            <a href="index.jsp" class="btn btn-primary w-25">Inicio</a>
        </div>
    </div>
</div>


</body>
</html>
