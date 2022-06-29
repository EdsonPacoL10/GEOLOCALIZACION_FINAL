<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="es">
    <head >
        <meta charset="UTF-8">
           <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Geolocalizacion</title>
        <style>
            #map{
                margin: 20px;
            }
        </style>
    </head>
    <body >
    <CENTER><h1>UBICACION ACTUAL </h1>

        <button onclick="findMe()">Mostrar ubicación actual</button>
        <div id="map"></div>

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCFLwwcZvcDF9J81GFtnoJXfJflg_NzGEs"></script>
        <script>

            function findMe() {
                var output = document.getElementById('map');
                // Verificar si soporta geolocalizacion
                if (navigator.geolocation) {
                    output.innerHTML = "<p>Tu navegador soporta Geolocalizacion</p>";
                } else {
                    output.innerHTML = "<p>Tu navegador no soporta Geolocalizacion</p>";
                }
                //Obtenemos latitud y longitud
                function localizacion(posicion) {
                    var latitude = posicion.coords.latitude;
                    var longitude = posicion.coords.longitude;
                    output.innerHTML = "<p>LATITUD:. " + latitude + "<br>LONGITUD:. " + longitude + "</p>";
                }
                function error() {
                    output.innerHTML = "<p>No se pudo obtener tu ubicación</p>";
                }
                navigator.geolocation.getCurrentPosition(localizacion, error);
            }
        </script>
        <div class="text-center">
            <img src=""https://www.google.com/imgres?imgurl=https%3A%2F%2Fd500.epimg.net%2Fcincodias%2Fimagenes%2F2015%2F10%2F29%2Flifestyle%2F1446136907_063470_1446137018_noticia_normal.jpg&imgrefurl=https%3A%2F%2Fcincodias.elpais.com%2Fcincodias%2F2015%2F10%2F29%2Flifestyle%2F1446136907_063470.html&tbnid=U0XYEyhcIy2BJM&vet=12ahUKEwjk5eim5pL4AhWTuZUCHUWoBQYQMygEegUIARDhAQ..i&docid=jwNkJZLoTSM17M&w=664&h=373&q=imagen%20de%20google%20maps&ved=2ahUKEwjk5eim5pL4AhWTuZUCHUWoBQYQMygEegUIARDhAQ" class="rounded" alt="" width="100" height="100">
        </div><br>
        <li>
            <a href="https://www.google.com.bo/maps/">ENTRA A GOOGLE MAPS I PON TU UBICACION 
            </a>
        </li>
        <li>
            <p>has clic para ver tus ayudas en la informacion que das para ubicar a la persona desaparecida</p>
            <p>Estos datos toman tiempo en si actualizacion ya que los profesionales del area los trabaja</p>
            
            <a href="https://qgiscloud.com/EDSON_PACO/EXAMEN_FINAL/">URBANIZACIONES DE EL ALTO 
            </a>
        </li>
        
        <br>
    </CENTER>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
   
</body>
</html>
