
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar clima</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>state</th>
                    <th>vestimenta</th>
                    <th>estacionAño</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach var="clima" items="${climas}">
                    <tr>
                        <td>${clima.id}</td>
                        <td>${clima.state}</td>
                        <td>${clima.vestimenta}</td>
                        <td>${clima.estacionAno}</td>

                        <td><a href="ClimaController?action=cambiar&id=${clima.id}">Cambiar</a></td>
                        <td><a href="ClimaController?action=borrar&id=${clima.id}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ClimaController?action=agregar">Nuevo clima</a>
        </p>
    </body>
</html>

