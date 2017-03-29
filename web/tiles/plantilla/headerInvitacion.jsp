<%String contexto = request.getContextPath();%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- α Header -->
<%@ page session="true" %>
<div> 
    <!-- principio de header -->      
     
            <c:choose>
                <c:when test="${ fn:contains(fn:toUpperCase(evento.recinto), 'RREY')}">
                       <div id="encabezado" style="padding-right:10px; margin:0 auto;background-image:url(${contexto}/SuperBoletosRepositorio/suites/logoAM_suites.jpg);background-repeat:no-repeat;background-position:left;"> 
                    <div   class="tilular-encabezado" style="margin-left: 150px;">
                        <span style="width: 300px; margin-left: 50px;" /> Monterrey | Suites 
                </c:when>
                <c:when test="${ fn:contains(fn:toUpperCase(evento.recinto), 'XICO')}">
                       <div id="encabezado" style="padding-right:10px; margin:0 auto;background-image:url(${contexto}/SuperBoletosRepositorio/suites/logoACMX_suites.png);background-repeat:no-repeat;background-position:left;"> 
                    <div class="tilular-encabezado" style="margin-left:70px;">
                       <span style="width: 300px; margin-left: 50px;" />&nbsp; CD. de M&eacute;xico | Suites 
                </c:when>
                <c:otherwise>
                       <div id="encabezado">
                    <div class="tilular-encabezado">
                        Suites 
                </c:otherwise>
            </c:choose>
            
            
                
            </div>
                           <label style="font-size: 10px; margin-left: 1000px; margin-bottom: 50px;"><s:message code="key_version" /></label>  
       	</div>      
                               
</div>
                           
<!-- Ω Header -->
