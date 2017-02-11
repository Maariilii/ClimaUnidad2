

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Clima</title>
    </head>
    <body>
        <form action="ClimaController" method="post" border="1">
            <fieldset border="1">
                <div>
                <label> Id:</label>
                <input type="text" name="id" value="${clima.id}"
                       placeholder="id"
                       readonly="readonly"/>
                </div>
                       <div>
                <label>state: </label>
                <input type="text" name="state" value="${clima.state}"
                       placeholder="state"/>
                       </div>
                       <div>       
                <label>vestimenta: </label>
                <input type="text" name="vestimenta" value="${clima.vestimenta}"
                       placeholder="vestimenta"/> 
                       </div>
                       <div>
                <label>estacionAño: </label>
                <input type="text" name="estacionAno" value="${clima.estacionAno}"
                       placeholder="estacionAño"/>
                       </div>
                     
                       
                       <div>
                           <input type="submit" value="Guardar"/>
                       </div>
            </fieldset>
        </form>
    </body>
</html>
