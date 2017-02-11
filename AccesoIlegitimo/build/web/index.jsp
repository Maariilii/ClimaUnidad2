<%-- 
    Document   : 
    Created on : 23-sep-2016, 18:45:15
    Author     : @author 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:forward page="/ClimaController?action=listar"/>
         <jsp:forward  page="/ProfesorController?action=listar"/>
          <jsp:forward  page="/ClimaController?action=listar"/>
         <jsp:forward  page="/ClimaController?action=listar"/>
  
    </body>
</html>