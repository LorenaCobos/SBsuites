<%-- 
    Document   : suites
    Created on : 26/05/2015, 10:50:37 PM
    Author     : Fabian Molar
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
    <span class="label-titulo-seccion" ><s:message code="key_admin_suites_titulo"/></span>    
</section>

<form id="formSuite" >

    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">                    
                    <h4 class="panel-title">
                        <span class="fa fa-filter "></span>&nbsp;
                        <s:message code="key_placeholder_filtrosbusqueda"/>
                        <i class="indicator glyphicon glyphicon-chevron-down  pull-right"></i>
                    </h4>
                </a>
            </div>

            <div id="collapse1" class="panel-collapse collapse">
                <div class="panel-body">
                    <div class="row">

                        <div class="col-sm-1 text-left">
                            <label for="textfield2" class="control-label" ><s:message code="key_suite_recinto"/>:</label>
                        </div>

                        <div class="col-sm-3">
                            <select name="select" id="selectRecinto" class="form-control">
                                <c:forEach var="recinto" items="${recintos}">
                                    <option value="${recinto.id}">${recinto.nombre}</option>
                                </c:forEach>

                            </select>
                        </div>
                        
                          <div class="col-sm-2 text-left">
                            <label for="textfield2" class="control-label" ><s:message code="key_placeholder_suitehabiente"/>:</label>
                        </div>
                        <div class="col-sm-3">
                            <input type="text" name="textfield" id="textfieldDueno" class="form-control">
                        </div>
                       

                        <div class="col-sm-1 text-left">
                            <label for="textfield2"  class="control-label"><s:message code="key_placeholder_status"/>:</label>
                        </div>
                        <div class="col-sm-2">
                            <select name="select" id="selectEstatus" class="form-control">
                                <option value="0"><s:message code="key_generico_todos"/></option>
                                <c:forEach var="estatus" items="${estatus}">
                                    <option value="${estatus.clave}">${estatus.nombre}</option>
                                </c:forEach>

                            </select>
                        </div>
                                
                       
                                
                                
                    </div>
                    <div class="row">    
                        
                        
                        <div class="col-sm-1 text-left">
                            <label for="textfield2" class="control-label" ><s:message code="key_placeholder_suite"/>:</label>
                        </div>
                        <div class="col-sm-2">
                            <input type="text" name="textfieldSuite" id="textfieldSuite" class="form-control">
                        </div>
                        <div class="col-sm-1 text-left">
                            <label for="textfield2"  class="control-label"><s:message code="key_placeholder_fecha"/>:</label>
                        </div>   
                        
                        <div class="col-sm-4">

                            <div class="row">

                                <div class="col-xs-12 col-sm-6 col-md-6">
                                    <input type="text" readonly="true" placeholder="<s:message code="key_placeholder_inicio"/>" name="textfield" id="txtFechaInicio" class="form-control" style="background-color:white;">

                                </div>

                                <div class="col-xs-12 col-sm-6 col-md-6">
                                    <input type="text" readonly="true" placeholder="<s:message code="key_placeholder_fin"/>" name="textfield" id="txtFechaFin" class="form-control" style="background-color:white;">

                                </div>

                            </div>

                        </div>
                        <div class="col-sm-4">                           
                            <div class="col-xs-4 text-left " style="padding-left: 0px;" >
                                <button type="button" name="button" id="buttonBuscar" value="<s:message code="key_generico_buscar"/>" 
                                        class="button" >
                                    <s:message code="key_generico_buscar"/></button>
                            </div>  
                            <div class="col-xs-4 text-left" style="padding-left: 10px;">
                                <button type="button" name="button" id="buttonNueva" value="<s:message code="key_generico_nuevo"/>" 
                                        class="button">
                                    <s:message code="key_generico_nuevo"/></button>

                            </div>
                            <div class="col-xs-4 text-left" style="padding-left: 10px;">
                                <button type="button" name="button" id="buttonLimpiar" value="<s:message code="key_generico_limpiar"/>" 
                                        class="button">
                                    <s:message code="key_generico_limpiar"/></button>
                            </div>
                        </div>       

                    </div>

                </div>
            </div>

        </div>

    </div> 

    <div class="CSSTableResults table-responsive">
        <table class="table-condensed table-responsive table-hover">
            <thead>
                <tr>
                    <th>
                        <s:message code="key_suite_grid_suite" />
                    </th>
                    <th>
                        <s:message code="key_suite_grid_suiteHabiente" />
                    </th>
                    <th>
                        <s:message code="key_suite_grid_vigencia" />
                    </th>
                    <th class="tdimage">
                        <s:message code="key_suite_grid_acciones" />
                    </th>
                </tr>
            </thead>
            <tbody id="contSuites">

            </tbody>
        </table>
    </div>
</form>
                    <div id="contForm" >
                        <form:form id="formulario" name="formulario"  method="post" action="">
                            
                        </form:form>
                    </div>  






