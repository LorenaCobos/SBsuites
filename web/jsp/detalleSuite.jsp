<%-- 
    Document   : detalleSuite
    Created on : 26/05/2015, 11:01:36 PM
    Author     : Fabian Molar
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style type="text/css" >
    @media (max-width: 768px) {
        div.col-sm-4.text-right{
            text-align: left! important;
        }
    }
</style>
<script> 
    validacion_();
</script>
<section style="width: 90%">
    <span class="label-titulo-seccion" ><s:message code="key_generico_suite_abc"/></span>
    <span style="float: right">
        <a href="#" name="buttonRegresar" onclick="bloquear();" id="buttonRegresar">
            <i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;<s:message code="key_button_regresar"/>
        </a>
    </span>
    
</section>

<input type="hidden" id="suiteId" value="${suite.seccionUbicacionId}" />
<input type="hidden" id="estacionamientoIdHdn" value="${suite.estacionamientoId}" />
<br>
<form id="formSuite" >


    <div class="row" style="width: 90%">

            <div class="row">

                <div class="col-sm-2 text-left">
                    <label for="textfield2" class="control-label" ><s:message code="key_suite_recinto"/>:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="textfieldRecinto" id="textfieldRecinto" class="form-control" value="${seleccion.recinto}" readonly="true">
                </div>
                
                 <div class="col-sm-2 text-left">
                    *<label for="textfield2" class="control-label" ><s:message code="key_suite_seccion"/>:</label>
                </div>
                <div class="col-sm-4">
                    <select name="selectSeccion" id="selectSeccion" class="form-control">
                        <c:if test="${fn:length(suites)<= 0}">
                            <option value="0" ><s:message code="key_suites_seccion_sin_elementos" /></option>
                        </c:if>
                        <c:forEach var="suite" items="${suites}">
                            <option value="${suite.id}" >${suite.nombre}</option>
                        </c:forEach>
                    </select>
                </div>

            </div>


            <div class="row">

                <div class="col-sm-2 text-left">
                    *<label for="textfield2" class="control-label" ><s:message code="key_placeholder_suite"/>:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="textfieldNombre" id="textfieldNombre" class="form-control" value="${suite.nombre}">
                </div>
                
                <div class="col-sm-2 text-left">
                    *<label for="textfield2" class="control-label" ><s:message code="key_placeholder_suitehabiente"/>:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="textfieldSuiteHabiente" id="textfieldSuiteHabiente" class="form-control" value="${suite.suiteHabiente}">
                </div>

            </div>


            <div class="row">
                <div class="col-sm-2 text-left">
                    *<label for="textfield2" class="control-label" ><s:message code="key_placeholder_tipocontrato"/>:</label>
                </div>
                <div class="col-sm-4">
                    <select name="selectTipoContrato" id="selectTipoContrato" class="form-control">
                        <option value="0" <c:if test="${suite.tipoContrato == 0}">selected</c:if> ></option>
                        <option value="1" <c:if test="${suite.tipoContrato == 1}">selected</c:if> >Evento</option>
                        <option value="2" <c:if test="${suite.tipoContrato == 2}">selected</c:if> >Vigencia</option>
                    </select>
                </div>
                 <div class="col-sm-2 text-left">
                        <label for="textfield2" class="control-label" ><s:message code="key_placeholder_cantidadeventos"/>:</label>
                </div>
                <div class="col-sm-4">
                    <select name="selectCantidadEventos" id="selectCantidadEventos" class="form-control">
                        
                        <option value="0"  <c:if test="${suite.cantidadEventos == 0}">selected</c:if> ></option>
                        <option value="-1"  <c:if test="${suite.cantidadEventos == -1}">selected</c:if> >No Aplica</option>
                        <c:forEach var="cantidadEvento" items="${cantidadEvento}">

                            <option value="${cantidadEvento.id}" <c:if test="${suite.cantidadEventos == cantidadEvento.id}">selected</c:if> >${cantidadEvento.nombre}</option>

                        </c:forEach>

                    </select>
                </div>
            </div> 
            <div class="row">
                <div class="col-sm-2 text-left">
                    <label for="textfield2" class="control-label" ><s:message code="key_placeholder_tipoevento"/>:</label>
                </div>
                <div class="col-sm-4">
                    <select name="selectTipoEvento" id="selectTipoEvento" class="form-control">
                        <option value="0"  <c:if test="${suite.tipoEvento == 0}">selected</c:if> ></option>
                        
                        <c:forEach var="tipoEvento" items="${tipoEvento}">

                            <option value="${tipoEvento.id}" <c:if test="${suite.tipoEvento == tipoEvento.id}">selected</c:if> >${tipoEvento.nombre}</option>

                        </c:forEach>
                    </select>
                </div>
                 <div class="col-sm-2 text-left">
                        *<label for="textfield2" class="control-label" ><s:message code="key_placeholder_aplicavigencia"/>:</label>
                </div>
                <div class="col-sm-4">
                    <select name="selectAplicaVigencia" id="selectAplicaVigencia" class="form-control">
                        <option value="0" <c:if test="${suite.aplicaVigencia == 0}">selected</c:if> ></option>
                        <option value="1" <c:if test="${suite.aplicaVigencia == 1}">selected</c:if> >Sí</option>
                        <option value="2" <c:if test="${suite.aplicaVigencia == 2}">selected</c:if> >No Aplica</option>
                    </select>
                </div>
            </div> 

            <div class="row">
                <div class="col-sm-2 text-left">
                    <label id="lblFechaInicio" class="control-label" ><s:message code="key_suite_vigencia_inicial"/>:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="txtFechaInicio" id="txtFechaInicio" class="form-control" value="${suite.vigenciaInicio}">
                </div>
                <div class="col-sm-2 text-left">
                    <label id="lblFechaFin" class="control-label" ><s:message code="key_suite_vigencia_fin"/>:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="txtFechaFin" id="txtFechaFin" class="form-control" value="${suite.vigenciaFin}">
                </div>  
            </div>
          
            <!--        Estacionamientos        -->
            <div class="row">
                <div class="col-sm-2 text-left">
                    <label for="textfield2" class="control-label" ><s:message code="key_estacionamiento"/>:</label>
                </div>
                <div class="col-sm-4">
                    <select name="selectEstacionamiento" id="selectEstacionamiento" class="form-control">
                        <option value="0"  <c:if test="${suite.estacionamientoId == 0}">selected</c:if> ></option>
                    </select>
                </div>
                <div class="col-sm-2 text-left">
                    <label for="textfield2" class="control-label" ><s:message code="key_estacionamiento_cantidad"/>:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="textfieldestacionamiento" id="textfieldestacionamiento" class="form-control" value="${suite.cantidadEstacionamiento}">
                </div>
            </div> 

                <!--         Estacionamientos               -->
            <div class="row">

                <div class="col-sm-2 text-left">
                    <label for="textfield2" class="control-label" ><s:message code="key_placeholder_activo"/>:</label>
                </div>
                <div class="col-sm-4">
                    <select name="select" id="select" class="form-control">
                        <c:forEach var="estatus" items="${estatus}">
                            <c:choose>
                                <c:when test="${suite.estatusId==5&&estatus.clave=='ACTIVO'}">
                                    <option value="${estatus.clave}" selected="selected">${estatus.nombre}</option>
                                </c:when>
                                <c:when test="${suite.estatusId==6&&estatus.clave=='INACTIVO'}">
                                    <option value="${estatus.clave}" selected="selected">${estatus.nombre}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${estatus.clave}" >${estatus.nombre}</option>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select>
                </div>

                <div class="col-sm-2 text-left">
                    *<label for="textfield2" class="control-label" ><s:message code="key_suite_telefono"/>:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="txtTelefono" id="txtTelefono" class="form-control" value="${suite.telefono}">
                </div>

            </div>

 

            <div class="row">

                <div class="col-sm-2 text-left">
                    *<label for="textfield2" class="control-label" ><s:message code="key_suite_email"/>:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="txtEmail" id="txtEmail" class="form-control" value="${suite.email}">
                </div>
                
                <div class="col-sm-2 text-left">
                    <label for="textfield2" class="control-label" ><s:message code="key_suite_direccion"/>:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="txtDireccion" id="txtDireccion" class="form-control" value="${suite.direccion}">
                </div>

            </div>    


            <div class="row">

                <div class="col-sm-2 text-left">
                    <label for="textfield2" class="control-label" ><s:message code="key_suite_observaciones"/>:</label>
                </div>
                <div class="col-sm-4">
                    <textarea name="txtObservaciones" id="txtObservaciones" class="form-control">
                        ${suite.observaciones}
                    </textarea>
                    <%--<input type="text" name="txtObservaciones" id="txtObservaciones" class="form-control" value="${suite.observaciones}">--%>
                </div>
                
                <div class="col-sm-2"></div>
                
                <div class="col-sm-2 text-center" style="padding-top: 10px">
                    <button type="button" name="button" id="buttonGuardar"  class="button ">
                        <s:message code="key_generico_guardar"/></button>
                </div>
                <div class=" col-sm-2 text-center" style="padding-top: 10px">
                    <button type="button" name="button" id="buttonCancelar" class="button ">
                        <s:message code="key_generico_cancelar"/></button>
                </div>
            </div>
    </div>    


                
        <%--
       <div class="col-sm-4 ">
            <div class="panel panel-default">
                <div class="panel-body">

                    <div class="row ">
                        <div class="col-xs-12 col-sm-12 col-md-12 text-center">
                            <button type="button" name="button" id="buttonGuardar"  class="button btn-default "><s:message code="key_generico_guardar"/></button>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 text-center">
                            <button type="button" name="button" id="buttonCancelar" class="button btn-default "><s:message code="key_generico_cancelar"/></button>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 text-center">

                            <button type="button" name="button" id="buttonRegresar" onclick="bloquear();" class="button btn-default "><s:message code="key_button_regresar"/></button>
                        </div>
                    </div>
                </div>


            </div>


        </div>--%>


</form>



