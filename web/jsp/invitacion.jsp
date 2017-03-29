<%-- 
    Document   : invitacion
    Created on : 29/05/2015, 12:43:53 AM
    Author     : Fabian Molar
--%>

<%String contexto = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="tilular-seccion">
    <p class="p-titular-seccion">Invitación a Evento</p>
</div>


<div class="row">



    <div class="col-xs-12 col-sm-12 col-md-12">
        <div class="panel panel-default">
            <div class="panel-body">

                <div class="row">
                    <input type="hidden" id="suiteId" value="${evento.seccionId}">
                    <input type="hidden" id="usuarioId" value="${evento.usuarioId}">
                    <input type="hidden" id="transferenciaId" value="${evento.transferenciaId}">
                    <div class="col-sm-12 text-center">

                        <!--${evento.eventoId}-->
                        <img src="${contexto}/SuperBoletosRepositorio/eventosIVT/Evento_${evento.eventoId}_I.jpg" alt="" class="img-thumbnail"/>

                    </div>

                </div>
                <div class="row">
                    <br>
                </div>

                <div class="row">

                    <div class="col-sm-12 text-justify">

                        <p>
                            Estimado<strong> ${evento.nombre}:</strong><br>
                            Ha sido invitado para asistir al evento <strong>${evento.evento}</strong> que se llevará a cabo el día 
                            <strong>${evento.fecha}</strong> en la <strong>${evento.recinto}</strong> en la Suite 
                            <strong>${evento.seccion}</strong>, contando con <strong>${evento.cantidad}</strong> boleto(s) disponible(s)
                            <c:if test="${evento.cantidadEstacionamiento>0}">
                            y <strong>${evento.cantidadEstacionamiento}</strong> boleto(s) del estacionamiento <strong>${evento.nombreEstacionamiento}</strong>.
                            </c:if>
                        </p>
                        <p>
                            A continuación, favor de seleccionar su respuesta para la asistencia a este evento y en caso de ser confirmado por el Suite-Habiente se le hará llegar a su correo 
                            <em>${correo}</em> el archivo PDF con el que usted podrá imprimir su(s) boleto(s) para su ingreso al evento.
                        </p>

                    </div>
                </div>  

                <div class="row">
                    <br>
                </div>      


                <c:if test="${evento.claveEstatus=='EN_PROCESO'}">
                    <div class="col-xs-6 col-sm-6 text-center">

                        <button type="button" name="buttonDeclinar" id="buttonDeclinar" value="Nuevo Evento" class="button">Rechazar</button>

                    </div> 


                    <div class="col-xs-6 col-sm-6 text-center">

                        <button type="button" name="buttonAceptar" id="buttonAceptar" value="Nuevo Evento" class="button">Aceptar</button>

                    </div> 
                </c:if>



            </div>

        </div>

    </div>

</div>










