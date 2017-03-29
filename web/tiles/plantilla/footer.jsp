<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%String contexto = request.getContextPath();%>

<c:choose>
    <c:when test="${empty footer}">
        <div id="footer">
            <div class="main clearfix">
                <div class="width70 floatL padding10t">
                    <div class="margin30b">
                        <div class="margin5b">
                            <a class="margin15r" href="http://www.superfan.com.mx" target="_blank"><s:message code="key_footer_membresias"/></a><span>|</span>
                            <a class="m015" href="<%=contexto%>/puntosDeVenta.do"><s:message code="key_menu_punto_venta"/></a><span>|</span>
                            <a class="m015" href="<%=contexto%>/seguridad.do"><s:message code="key_menu_seguridad"/></a><span>|</span>

                            <a class="m015" href="<%=contexto%>/privacidad.do"><s:message code="key_menu_privacidad"/></a><span>|</span>
                            <a class="m015"     href="<%=contexto%>/preguntasFrecuentes.do" style=" padding-left: 0px;"><s:message code="key_footer_preguntas_frecuentes"/></a><span></span> <br>
                            <a class="m015" href="">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a><span>|</span>
                            <a class="m015" href="<%=contexto%>/vendeConNosotros.do"><s:message code="key_menu_vende_con_nosotros"/></a><span>|</span>
                            <a class="m015" href="javascript:;" onClick="openFB('639', '540', '<%=contexto%>/contacto.do'); return false;"><s:message code="key_menu_contacto"/></a><span>|</span>
                        </div>
                        <p><strong>Copyright 2014 © Superboletos.</strong></p>
                    </div>  
                    <div class="clearfix">
                        <img class="margin15r" src="${contexto}/SuperBoletos/assets/img/icons/zignia.png" width="116" height="20" alt="Zignia">
                        <img class="margin15r" src="${contexto}/SuperBoletos/assets/img/icons/mastercard.png" width="36" height="24" alt="Mastercard">
                        <img class="margin15r" src="${contexto}/SuperBoletos/assets/img/icons/visa.png" width="57" height="20" alt="Visa">
                        <img class="margin15r" src="${contexto}/SuperBoletos/assets/img/icons/amex.jpg" width="29" height="29" alt="American Express">
                    </div>
                </div>

                <div class="width30 floatR" align="right">
                    <h2><strong><s:message code="key_menu_enterate_de_promociones"/></strong></h2>
                    <a href="https://twitter.com/SuperboletosMx" target="_blank"><img src="${contexto}/SuperBoletos/assets/img/btns/twitter.gif" width="134" height="28" alt="Twitter @SuperboletosMx"></a>
                    <a href="https://www.facebook.com/SuperboletosMx" target="_blank"><img src="${contexto}/SuperBoletos/assets/img/btns/facebook.gif" width="134" height="28" alt="Facebook Superboletos Oficial"></a>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        ${footer}
    </c:otherwise>
</c:choose>
