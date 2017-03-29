<%-- 
    Document   : AyudaBoletos
    Created on : Mar 27, 2017, 1:04:26 PM
    Author     : Neiteker
--%>
<%-- 
    Document   : EventosAdmin
    Created on : 26/05/2015, 10:23:00 PM
    Author     : Fabian molar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="<%= request.getContextPath()%>/js/bootstrap-toolkit.min.js"></script>

<script>
    validacion_();
    (function ($, document, window, viewport) {
        var colapsa = function () {
            
            os = getMobileOperatingSystem();
            
            if (os.match("celular"))
                $('#collapse1').removeClass('in');
            else
                $('#collapse1').collapse('show');
            
            //if (viewport.is('xs')) {
                //$('#collapse1').collapse('hide');
                //$('#collapse1').removeClass('in');
            //}
            //if (!viewport.is('xs')) {
                //$('#collapse1').collapse('show');
            //}
        };

        $(document).ready(function () {
            colapsa();

        });

        //$(window).resize(viewport.changed(function () {
            //colapsa();
        //}));

    }(jQuery, document, window, ResponsiveBootstrapToolkit));
</script>


<section>
    <span class="label-titulo-seccion" ><s:message code="key_ayudaboletos_titulo"/></span>

</section>

                    

<form id="formSuite" >
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <p>Ve al apartado de "Eventos" dentro del detalle del Evento y empieza a disfutar los beneficios que te brinda. </p>
                <img style="width:100%;height:auto;" src="../assets/img/vntaboletos.png">           
            </div>
        </div>

    </div> 
</form>
<div id="contForm" >
                        <form:form id="formulario" name="formulario"  method="post" action="">
                            
                        </form:form>
                    </div> 


