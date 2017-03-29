<%String contexto = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- α Header -->
<%@ page session="true" %>
<div> 
    <!-- principio de header -->      
     
    <%--<c:choose>
        <c:when test="${sessionScope.opcion ==2}">
            
            <div id="encabezado" style="padding-right:10px; margin:0 auto;background-image:url(${contexto}/SuperBoletosRepositorio/suites/logoAM_suites.jpg);background-repeat:no-repeat;background-position:left;"> 
            <div   class="tilular-encabezado" style="margin-left: 150px;">
                <span style="width: 300px; margin-left: 50px;" id="textoRecinto" /> Monterrey | Suites
            </div>
            </div>
        </c:when>
        <c:when test="${sessionScope.opcion ==1}">
               <div id="encabezado" style="padding-right:10px; margin:0 auto;background-image:url(${contexto}/SuperBoletosRepositorio/suites/logoACMX_suites.png);background-repeat:no-repeat;background-position:left;"> 
            <div class="tilular-encabezado" style="margin-left:70px;">
               <span style="width: 300px; margin-left: 50px;" id="textoRecinto"/>&nbsp; CD. de M&eacute;xico | Suites 
            </div>
            </div>
        </c:when>
        <c:otherwise>
               <div id="encabezado">
            <div class="tilular-encabezado">
                Suites 
            </div>
            </div>
        </c:otherwise>
    </c:choose>
            

    <label style="font-size: 10px; margin-left: 1000px; margin-bottom: 50px;"><s:message code="key_version" /></label>  
    --%>
                               
</div>
                           
<!-- Ω Header -->