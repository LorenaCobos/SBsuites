<%-- 
    Document   : detalleEvento
    Created on : 26/05/2015, 10:46:59 PM
    Author     : Fabian molar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script> 		
    validacion_();		
</script>
<section>
    <span class="label-titulo-seccion" ><s:message code="key_placeholder_eventos"/></span>
    <span style="float: right">
        <a href="#" name="buttonRegresar" onclick="bloquear();" id="buttonRegresar">
            <i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;<s:message code="key_button_regresar"/>
        </a>
    </span>
    
</section>

<input type="hidden" id="hdneventoId" value="${evento.eventoId}">
<input type="hidden" id="hdnrecinto" value="${evento.recinto}">
<input type="hidden" id="hdnfechaPresentacion" value="${evento.fechaPresentacion}">
<input type="hidden" id="hdnevento" value="${evento.evento}">
<input type="hidden" id="hdnpresentacionId" value="${evento.presentacionId}">
<input type="hidden" id="hdnsuiteId" value="${evento.suiteId}">
<input type="hidden" id="hdnestacionamientoId" value="${evento.estacionamientoId}">
<input type="hidden" id="hdnnumeroBoletos" value="${evento.numeroBoletos}">
<input type="hidden" id="hdnnumeroEstacionamientos" value="${evento.numeroEstacionamientos}">
<input type="hidden" id="hdnnumeroInvitaciones" value="${evento.numeroInvitaciones}">

    <div id="eventosWidget">    
        <div class="panel row panel-horizontal panel-info" id="evento11563">
            <div class="col-xs-5" style="text-align: center">
                <div class="panel-heading row">
                    <div class="col-md-6">
                        <a href="#" >
                            <img id="imgT" class="img-thumbnail panel-image" 
                                 <%--src="${contexto}/SuperBoletosRepositorio/thumbnails/Evento_${evento.eventoId}_T.jpg"/>--%>
                                 src="../assets/img/Evento_29445_L.jpg"
                        </a>
                    </div>  
                    <div class="col-md-6">
                        <div style="padding-top: 10px">
                            <div><label class="label-evento-panel">${evento.evento}</label></div>
                            <div>  
                                <i class="fa fa-calendar-o"></i>
                                <label>${evento.fechaPresentacion}</label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class=" col-xs-7">
                <div class="panel-body row">

                     <div class="col-sm-4">
                        <div class="small-box bg-aqua">
                           <div class="inner">
                                <h3>${evento.numeroBoletos}</h3>
                                <p>Boletos</p>
                            </div>
                            <div class="icon">
                              <img src="../assets/img/boletos.png">
                            </div>
                        <!-- /.info-box-content -->
                        </div>
                     </div>
                    <div class="col-sm-4">
                        <div class="small-box bg-olive">
                           <div class="inner">
                                <h3>${evento.numeroEstacionamientos}</h3>
                                <p>Estacionamientos</p>
                            </div>
                            <div class="icon">
                                <img src="../assets/img/estacionamientos.png">
                            </div>
                        <!-- /.info-box-content -->
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="small-box bg-orange">
                           <div class="inner">
                                <h3>${evento.numeroInvitaciones}</h3>
                                <p>Invitaciones</p>
                            </div>
                            <div class="icon">
                              <img src="../assets/img/invitaciones.png" >
                            </div>
                        <!-- /.info-box-content -->
                        </div>
                    </div>
                </div>
            </div>
        </div>        
    </div>
                                
               
    <div class="nav-tabs-custom">
        <ul class="nav nav-tabs">
            <li style="display:none">Dummy</a></li>
            <li class="active"><a href="#tabImpBoletos" data-toggle="tab">Impresión de Boletos</a></li>
            <li><a href="#tabEstacionamientos" data-toggle="tab">Estacionamientos</a></li>
            <li><a href="#tabInvitaEvento" data-toggle="tab">Invitar a Evento</a></li>
            <li><a href="#tabResumenInv" data-toggle="tab" onclick="detalleEvento.obtenerResumen();">Resumen de Invitaciones</a></li>
            <li><a href="#tabResumenImp" data-toggle="tab" onclick="detalleEvento.obtenerResumen();">Resumen de Impresiones</a></li>
            <li><a href="#tabVentaBoletos" data-toggle="tab">Vende tus boletos</a></li>
        </ul>
        <div class="tab-content">
            <div class="active tab-pane" id="tabImpBoletos">
                <div class="box box-primary">
            <!-- form start -->
                    <form role="form" id="formSuite" >
                        <div class="box-body" style="padding-top: 15px;">
                            <div class="col-md-3"></div>
                            <div class="col-md-1 ">
                                <label for="txtBoletos"><s:message code="key_placeholder_boletos"/></label>
                            </div>
                            <div class="col-md-2 ">
                                
                                <input type="number"  min="0" max="24" maxlength="2" placeholder="# Boletos"   
                                       pattern="[0-9]" name="txtBoletos" id="txtBoletos" 
                                       class="numeric form-control text-center">
                               
                            </div> 
                            <div class="col-md-1 ">
                                <span class="glyphicon glyphicon-info-sign" data-toggle="tooltip" 
                                      title="<s:message code="key_help_imprimir" />" id='example' 
                                      onclick="detalleEvento.help(1)"></span>
                            </div>
                            <div class="form-group col-md-3">
                                <button type="button" name="buttonImprimir" id="buttonImprimir" value="<s:message code="key_placeholder_imprimir"/>" class="button btn-default "><s:message code="key_placeholder_imprimir"/></button>
                                &nbsp;
                                <button type="button" name="buttonImprimirCancela" id="buttonImprimirCancela" class="button btn-default" value="<s:message code="key_generico_cancelar"/>"><s:message code="key_generico_cancelar"/></button>
                            </div>
                        </div>
                    </form>
                </div>
                
            </div>
                <!-- /.tab-pane -->
            <div class="tab-pane" id="tabEstacionamientos">
                <div class="box box-primary">
            <!-- form start -->
                    <form role="form" id="formSuiteEstacionamiento" >
                        <div class="box-body" style="padding-top: 15px;">
                            <div class="col-md-3"></div>
                            <div class="col-md-1 ">
                                <label for="txtBoletos"><s:message code="key_placeholder_boletos"/></label>
                            </div>
                            <div class="col-md-2 ">
                                <input type="number"  min="0" max="24" maxlength="2" placeholder="# Boletos"   
                                       pattern="[0-9]" name="txtBoletosEsta" id="txtBoletosEsta" 
                                       class="numeric form-control text-center">
                            </div> 
                            <div class="col-md-1 ">
                                <span class="glyphicon glyphicon-info-sign" data-toggle="tooltip" 
                                      title="<s:message code="key_help_imprimir" />" id='example' 
                                      onclick="detalleEvento.help(1)"></span>
                            </div>
                            <div class="form-group col-md-4">
                                <button type="button" name="buttonImprimirEsta" id="buttonImprimirEsta" value="<s:message code="key_placeholder_imprimir"/>" class="button btn-default "><s:message code="key_placeholder_imprimir"/></button>
                                &nbsp;
                                <button type="button" name="buttonImprimirEstaCancela" id="buttonImprimirEstaCancela" class="button btn-default" value="<s:message code="key_generico_cancelar"/>"><s:message code="key_generico_cancelar"/></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="tab-pane" id="tabInvitaEvento">
                <form role="form" id="formEnvio">
                    <div class="box-body" style="padding-top: 15px;">
                        <div class="row">
                            <div class="col-md-2 text-sm-right">
                                <label for="inptNombre" ><s:message code="key_placeholder_nombre"/>:</label>
                            </div>
                            <div class="col-md-4 ">

                                <input type="text" placeholder="Nombre del invitado" 
                                       class="text-sm-left form-control " 
                                       id="inptNombre" name="inptNombre">

                            </div>
                            <div class="col-md-2 text-sm-right">
                                <label for="txtBoletos2"  ><s:message code="key_placeholder_boletos"/>&nbsp;</label>:
                            </div>
                            <div class="col-md-2 ">
                                <input type="number"  min="0" max="24" maxlength="2" placeholder="# Boletos"   
                                   pattern="[0-9]" name="txtBoletos2" id="txtBoletos2" 
                                   class="numeric text-center form-control">
                             
                            </div>
                            <div class="col-md-1">
                                <span class="glyphicon glyphicon-info-sign" data-toggle="tooltip" 
                                  title="<s:message code="key_help_detalle_invitar" />" id='example' 
                                  onclick="detalleEvento.help(2)"></span>  
                            </div>
                        </div>
                                  
                        <div class="row">
                            <div class="col-md-2 text-sm-right">
                                <label for="inptCorreo"  ><s:message code="key_placeholder_correo"/>:</label>
                            </div>
                            <div class="col-md-4 ">
                                <input type="email" placeholder="Correo electr&oacute;nico del invitado" 
                                    class="text-sm-left  form-control" id="inptCorreo" name="inptCorreo">
                            </div>
                            <div class="col-md-2 text-sm-right">
                                <label for="txtBoletosEst2" ><s:message code="key_estacionamiento"/>&nbsp;</label>:
                            </div>
                            <div class="col-md-2 ">
                                <input type="number"  min="0" max="24" maxlength="2" placeholder="# Boletos"   
                                   pattern="[0-9]" name="txtBoletosEst2" id="txtBoletosEst2" 
                                   class="numeric text-center form-control">
                            </div>
                        </div>
                            
                         <div class="row">
                            <div class="col-md-2 text-sm-right">
                                <label for="inptNota" ><s:message code="key_placeholder_mensaje"/>:</label>  
                            </div>
                            <div class="col-md-6 ">
                                <input type="text" placeholder="Detalle del mensaje" 
                                   id="inptNota" name="inptNota" class="text-sm-left form-control">
                            </div>
                            <div class="col-md-3 text-sm-left">
                                <button type="button" id="btnEnviar" name="btnEnviar" 
                                        class="button btn-default" value="<s:message code="key_placeholder_invitar"/>"><s:message code="key_placeholder_invitar"/></button>
                                &nbsp;
                                <button type="button" name="buttonInvitarCancela" id="buttonInvitarCancela" 
                                        class="button btn-default" value="<s:message code="key_generico_cancelar"/>"><s:message code="key_generico_cancelar"/></button>     
                            </div>
                            <div class="col-md-1"></div>
                         </div>                       
                    </div>                    
                </form>
            </div>
                        
            <div class="tab-pane" id="tabResumenInv">
                <div class="row" style="padding-top: 15px">
                    <div class="col-sm-2 text-center" style="padding-left:0px;padding-right:0px;width:100px;">
                        <label for="textfield2" class="control-label" >Filtrar por:</label>
                    </div>
                    <div class="col-sm-3" style="padding-left:0px;padding-right:0px;">
                        <select name="selectEstatus" id="selectEstatus" class="form-control" onchange="detalleEvento.mostrarInvitaciones()">
                            <option value=""  >Todas</option>
                            <option value="EN_PROCESO"  >Enviadas</option>
                            <option value="ACEPTADA"  >Aceptadas</option>
                            <option value="DECLINADA"  >Declinadas</option>
                            <option value="FINALIZADA"  >Finalizadas</option>
                            <option value="CANCELADA"  >Canceladas</option>
                        </select>
                    </div>
                </div>
                <div class="row" style="padding-top: 15px">
                    <div class="CSSTableResults table-responsive">
                        <table id="invitacionesTable" class="table-condensed table-responsive table-hover">
                            <thead>
                                <tr >
                                    <th>
                                        <s:message code="key_usuario_grid_nombre" />
                                    </th>
                                    <th>
                                        <s:message code="key_usuario_grid_correo" />
                                    </th>
                                    <th>
                                        <s:message code="key_usuario_grid_estatus" />
                                    </th>
                                    <th>
                                        <s:message code="key_usuario_grid_accion" />
                                    </th>
                                </tr>
                            </thead>
                            <tbody id="contTablaInvitacion">

                            </tbody>
                        </table>
                    </div>
                </div> 
            </div>
                                    
            <div class="tab-pane" id="tabResumenImp">   
                <div style="padding-top: 15px">
                    <div class="CSSTableResults table-responsive">
                        <table class="table-condensed table-responsive table-hover">
                            <thead>
                                <tr >
                                    <th>
                                        <s:message code="key_placeholder_usuario" />
                                    </th>
                                    <th>

                                    </th>
                                    <th>
                                        <s:message code="key_usuario_grid_estatus" />
                                    </th>
                                    <th>
                                        <s:message code="key_usuario_grid_accion" />
                                    </th>
                                </tr>
                            </thead>
                            <tbody id="contTablaImpresion">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
                                    
            <div class="tab-pane" id="tabVentaBoletos">
                <div class="box box-primary">
            <!-- form start -->
                    <form role="form" id="formSuiteVenta" >
                        <div class="box-body" style="padding-top: 15px;">
                            <div class="col-md-3"></div>
                            <div class="col-md-1 ">
                                <label for="txtBoletos"><s:message code="key_placeholder_boletos"/></label>
                            </div>
                            <div class="col-md-2 ">
                                <input type="number"  min="0" max="24" maxlength="2" placeholder="# Boletos"   
                                       pattern="[0-9]" name="txtBoletos" id="txtBoletos" 
                                       class="numeric form-control text-center">
                            </div> 
                            <div class="col-md-1 ">
                                <span class="glyphicon glyphicon-info-sign" data-toggle="tooltip" 
                                      title="<s:message code="key_help_imprimir" />" id='example' 
                                      onclick="detalleEvento.help(1)"></span>
                            </div>
                            <div class="form-group col-md-4">
                                <button type="button" name="buttonVenderAceptar" id="buttonAceptar" value="<s:message code="key_generico_aceptar"/>" class="button btn-default "><s:message code="key_generico_aceptar"/></button>
                                    &nbsp;
                                <button type="button" name="buttonVenderCancela" id="buttonVenderCancela" class="button btn-default" value="<s:message code="key_generico_cancelar"/>"><s:message code="key_generico_cancelar"/></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
                            
                                    
                                    
<%--<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
   
    <div class="panel panel-default">
        <div class="panel-heading text-center" role="tab" id="headingOne">
            <h4 class="panel-title">
                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapsethree" aria-expanded="true" aria-controls="collapseOne" >
                    <label for="textfield2" class="control-label" ><s:message code="key_placeholder_resumen_mov"/></label>
                </a>
            </h4>
        </div>
        <div id="collapsethree" class="panel-collapse collapse"  role="tabpanel" aria-labelledby="headingOne">
            <div class="panel-body">
                <div class="panel-group" id="accordion1" role="tablist" aria-multiselectable="true">
                    <div class="panel panel-default">
                        <div class="panel-heading text-center" role="tab" id="headingOne1">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion1" href="#collapseOne1" aria-expanded="true" aria-controls="collapseOne1" onclick="v">
                                    <label for="textfield2" class="control-label" ><s:message code="key_detalle_invitaciones" /></label>
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne1">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-sm-2 text-center" style="padding-left:0px;padding-right:0px;width:100px;">
                                        <label for="textfield2" class="control-label" >Filtrar por:</label>
                                    </div>
                                    <div class="col-sm-3" style="padding-left:0px;padding-right:0px;">
                                        <select name="selectEstatus" id="selectEstatus" class="form-control" onchange="detalleEvento.mostrarInvitaciones()">
                                            <option value=""  >Todas</option>
                                            <option value="EN_PROCESO"  >Enviadas</option>
                                            <option value="ACEPTADA"  >Aceptadas</option>
                                            <option value="DECLINADA"  >Declinadas</option>
                                            <option value="FINALIZADA"  >Finalizadas</option>
                                            <option value="CANCELADA"  >Canceladas</option>
                                        </select>
                                    </div>
                                </div> 
                            </div>
                            <div class="CSSTableResults">
                                <table id="invitacionesTable" class="table-condensed table-responsive table-hover">
                                    <thead>
                                        <tr >
                                            <th>
                                                <s:message code="key_usuario_grid_nombre" />
                                            </th>
                                            <th>
                                                <s:message code="key_usuario_grid_correo" />
                                            </th>
                                            <th>
                                                <s:message code="key_usuario_grid_estatus" />
                                            </th>
                                            <th>
                                                <s:message code="key_usuario_grid_accion" />
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody id="contTablaInvitacion">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading text-center" role="tab" id="headingTwo1">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion1" href="#collapseTwo1" aria-expanded="false" aria-controls="collapseTwo1" onclick="detalleEvento.obtenerResumen();">
                                <label for="textfield2" class="control-label" ><s:message code="key_detalle_Impresiones" /></label>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo1">
                        <div class="panel-body">
                            <div class="CSSTableResults">
                                <table class="table-condensed table-responsive table-hover">
                                    <thead>
                                        <tr >
                                            <th>
                                                <s:message code="key_placeholder_usuario" />
                                            </th>
                                            <th>

                                            </th>
                                            <th>
                                                <s:message code="key_usuario_grid_estatus" />
                                            </th>
                                            <th>
                                                <s:message code="key_usuario_grid_accion" />
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody id="contTablaImpresion">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
<!-- Venta de Boletos-->
    <div class="panel panel-default">
        <div class="panel-heading text-center" role="tab" id="headingFour">
            <h4 class="panel-title">
                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
                    <label for="textfield2" class="control-label" ><s:message code="key_placeholder_ventaBoletos"/></label>
                </a>
            </h4>
        </div>
        <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
            <div class="panel-body">

                
            </div>
        </div>
    </div>
</div>--%>
    