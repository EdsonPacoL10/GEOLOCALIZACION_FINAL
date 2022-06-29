<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <title>GEOLOCALIZACION</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="Denuncia"/>
        </jsp:include>        
        <div class="container" >
            <h1>Informacion de la denuncia</h1>   
            <br>
            <form action="DenunciaControlador" method="post" >
                <input type="hidden" name="id" value="${Denuncia.id}" >
                <div class="mb-3">
                    <label for="usuario_id" class="form-label">Usuario Denunciante</label>                    
                    <select name="usuario_id" class="form-label">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_clientes}">                        
                            <option value="${item.id}" <c:if test="${Denuncia.usuario_id == item.id}">
                                    selected
                                </c:if> >${item.nombres}</option>
                        </c:forEach>
                    </select>
                </div>              
                <div class="mb-3">
                    <label for="DescripcionLugar" class="form-label">Descripcion Lugar Denunciado</label>
                    <input type="text"  name="DescripcionLugar" value="${Denuncia.DescripcionLugar}" class="form-control" id="DescripcionLugar" >                    
                </div>
                <div class="mb-3">
                    <label for="TipoLugar" class="form-label">Tipo Lugar Denunciado</label>
                    <input type="text"  name="TipoLugar" value="${Denuncia.TipoLugar}" class="form-control" id="TipoLugar" >                    
                </div>
                <div class="mb-3">
                    <label for="DescripcionDenuncia" class="form-label">Descripcion Denuncia Realizada</label>
                    <input type="text" name="DescripcionDenuncia" value="${Denuncia.DescripcionDenuncia}" class="form-control" id="DescripcionDenuncia" >
                </div>
                <div class="mb-3">
                    <label for="DatosImportanteDenuncia" class="form-label">Datos Importantes de la Denuncia</label>
                    <input type="text" name="DatosImportanteDenuncia" value="${Denuncia.DatosImportanteDenuncia}" class="form-control" id="DatosImportanteDenuncia" >
                </div>
                <div class="mb-3">
                    <label for="localizacion" class="form-label">Dar su ubicaion Geografica</label>
                    <input type="text" name="localizacion" value="${Denuncia.localizacion}" class="form-control" id="localizacion" >
                </div>

                <div class="mb-3">
                    <label for="Fecha" class="form-label">Fecha</label>
                    <input type="text" name="Fecha" value="${Denuncia.Fecha}" class="form-control" id="Fecha" >
                </div>
                <button type="submit" class="btn btn-primary">Procesar</button>
            </form>
              
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
   
        
   
    </body>
</html>
