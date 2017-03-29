<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="com.sb.suites.entidades.usuarios.FuncionalidadOperacion"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String contexto = request.getContextPath();
    String servidor = request.getServerName();
    int serverPort = request.getServerPort();
%>

<html style="background: white;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <link rel="stylesheet" type="text/css" href="<%=contexto%>/css/msgBoxLight.css" />
        <link rel="stylesheet" type="text/css" href="<%=contexto%>/css/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="<%=contexto%>/css/jquery.ui.datepicker.css" />

        <link rel="stylesheet" type="text/css" href="<%=contexto%>/css/suites.css">
        <link rel="stylesheet" type="text/css" href="<%=contexto%>/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="<%=contexto%>/css/login.css">
        
        
        <link rel="stylesheet" type="text/css" href="<%=contexto%>/css/suitescss-v2.css">
        <link rel="stylesheet" type="text/css" href="<%=contexto%>/css/skins/_all-skins.css">
        
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

<!--        <link rel="stylesheet" type="text/css" href="<%=contexto%>/css/default.css" />-->
        <tiles:useAttribute id="estilos" name="estilos" classname="java.util.List"/>
        <c:forEach var="estilos" items="${estilos}">            
            <link rel="stylesheet" type="text/css" href="<%=contexto%><c:out value="${estilos}"/>"></link>
        </c:forEach>       
        <script>
            contexto = '<%=contexto%>';
            var servidor = '<%=servidor%>';
            var puerto = '<%=serverPort%>';

            var inicioHttp = "http://" + servidor + ":" + puerto;
            servidor = '<%=servidor%>';
            baseSecure = "http://<%=servidor%>" + ":" + puerto + contexto;// ":8080"; // ":9400";
            baseNormal = "http://<%=servidor%>" + ":" + puerto + contexto; //":8080";// ":8080";  
            baseRep = "http://<%=servidor%>" + ":" + puerto + "/SuperBoletosRepositorio"; //":8080";// ":8080";  
        </script>
        <%-- ** DWR Implementation ** --%>        
        <script type="text/javascript" src="<%=contexto%>/js/jquery/jquery-1.8.0.min.js"></script>

        <script type="text/javascript" src="<%=contexto%>/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="<%=contexto%>/js/jquery/blockUI.js"></script>
        <script type="text/javascript" src="<%=contexto%>/js/jquery/jquery.ui.core.js"></script>
        <script type="text/javascript" src="<%=contexto%>/js/jquery/msgBox/jquery.msgBox.js"></script>
        <script type="text/javascript" src="<%=contexto%>/js/jquery/datepicker/jquery.ui.datepicker.min.js"></script>
        <script type="text/javascript" src="<%=contexto%>/js/jquery/datepicker/jquery.ui.datepicker-es.min.js"></script>
        <script type="text/javascript" src="<%=contexto%>/dwr/engine.js"></script>
        <script type="text/javascript" src="<%=contexto%>/dwr/util.js"></script>
        <script type="text/javascript" src="<%=contexto%>/js/funcionesGenericas.js"></script>
        <script type="text/javascript" src="<%=contexto%>/js/appextras.js"></script>
        
        <script type="text/javascript">
              (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
            })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

            ga('create', 'UA-42236547-3', 'auto');
            ga('send', 'pageview');
        </script>

        
        <script> dwr.engine.setErrorHandler(errh);</script>

        <title><tiles:insertAttribute name="title" ignore="true" defaultValue="Suites" /></title>

        <c:choose>
            <c:when test='${rc.locale.language == "es" || rc.locale.language=="en"}'>
                <script type="text/javascript" src="<%=contexto%>/js/locale/locale_<c:out value="${rc.locale.language}"/>.js"></script>
            </c:when>
            <c:otherwise>
                <script type="text/javascript" src="<%=contexto%>/js/locale/locale_es.js"></script>
            </c:otherwise>
        </c:choose>

        <tiles:useAttribute id="librerias" name="librerias" classname="java.util.List"/>
        <c:forEach var="libreria" items="${librerias}">            
            <script type="text/javascript" src="<%=contexto%><c:out value="${libreria}"/>"></script>
        </c:forEach>

        <script type="text/javascript">
            $(document).ready(function () {
                inicioGeneral();

            });
        </script>

    </head>


    <body  class="sidebar-mini">
        <div >
            <tiles:insertAttribute name="header" />
        </div>

    <fmt:setLocale value="en_US"/>

    <div id="div_messajes" class="hidden floatL"></div>
    <div id="div_contacto" class="hidden"></div>

    <div id="padre" style="margin:0 auto;position:relative;">
        <tiles:insertAttribute name="menu" />   
            <div class="content-wrapper">
            <div id="contenido" class="">
                <tiles:insertAttribute name="body" />
            </div>
        </div><!--container--> 
        <aside   class="m">
            <footer id="imagen_" class="left-menu-footer">    
                    <img src="../assets/img/superboletos.png">     
            </footer>
        </aside>
        <footer class="container-fluid text-center foo">
            <p><strong>Superboletos.</strong></p>
        </footer>
        <br style="clear:both"/>
         
    </div>
            
 
         
    <c:if test="${funcionalidades!=null}">
        <c:forEach var="funcionalidad" items="${funcionalidades}">
            <script>
                agregarFuncionalidad('${funcionalidad.htmlId}',${funcionalidad.habilitado});
            </script>
            <c:if test="${!funcionalidad.habilitado==true}">
                <input type="hidden" name="funcionalidad" value="${funcionalidad.htmlId}">
            </c:if>
            
        </c:forEach>
    </c:if>
</body>
</html>