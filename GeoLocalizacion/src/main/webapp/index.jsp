<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
  <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GEOLOCALIZACION</title>
        </head>
    <body>
    <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="Foto"/>
        </jsp:include>
    
        <center>
                 <form action="PersonaControlador" method="POST" enctype="multipart/form-data">
                    <input type="submit" name="accion" value="listar">
                    <input  type="submit" name="accion" value="nuevo">
                </form>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Foto</th>
                            <th>Accion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dato" items="${lista}">
                            <tr>
                                <td>${dato.getId()}</td>
                                <td><img src="ImagenControlador?id=${dato.getId()}"width="250"height="230"></td>
                                <td>
       <a href="InformacionControlador" onclick="return(confirm('estas seguro de dar informacion¡¡¡ debe ser informacion real !!CIUDADO¡¡'))" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i> Dar Informacion</a>
          
              
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </center>
            
             <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
   
    </body>
</html>
