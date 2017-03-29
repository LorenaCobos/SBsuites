<%String contexto = request.getContextPath();
String servidor = request.getServerName();
 int serverPort = request.getServerPort();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<html style="min-width: 250px;">
    <head>
        <meta charset="utf-8" />
        <title>Suites</title>
       
    </head>
        
    <body class="home" >
        <br/><br/><br/><br/><br/>
        <div class="container-fluid">
                    <table class="contenido">
                        <h2>
                         Informacion no encontrada (404)
                         <script>
                             window.location.href = "http://<%=servidor%>:<%=serverPort%>"+"<%=contexto%>"+"/index.do";
                         </script>
                        </h2>
                        <strong></strong>
                        <br /><br />
  
                    </table>
        </div>
    </body>
</html>