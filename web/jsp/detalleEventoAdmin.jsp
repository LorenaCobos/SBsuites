<%-- 
    Document   : detalleEventoAdmin
    Created on : 26/05/2015, 11:05:55 PM
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


<div class="tilular-seccion">
    <p class="p-titular-seccion"><s:message code="key_generico_evento_abc"/></p>
</div>


<br>

<form id="formSuite" >







    <div class="row">

        <div class="col-sm-2 text-left">
            <label for="textfield2" class="control-label" ><s:message code="key_placeholder_evento"/>:</label>
        </div>
        <div class="col-sm-4">
            <input type="text" name="textfield" id="textfield" class="form-control">
        </div>
        <div class="col-sm-2 text-left">
            <label for="textfield2"  class="control-label"><s:message code="key_placeholder_status"/>:</label>
        </div>
        <div class="col-sm-4">
            <select name="select" id="select" class="form-control">
                <option>-Todo-</option>
            </select>
        </div>


    </div>


    <div class="row">

        <div class="col-sm-2 text-left">
            <label for="textfield2" class="control-label" ><s:message code="key_placeholder_imagen"/>:</label>
        </div>
        <div class="col-sm-4">
            <input type="text" name="textfield" id="textfield" class="form-control">
        </div>
        <div class="col-sm-2 text-left">

        </div>
        <div class="col-sm-4">

        </div>


    </div>






    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-8">
        </div>

        <div class="col-xs-6 col-sm-2 col-md-2 text-center">
            <button type="button" name="button" id="button" value="<s:message code="key_generico_guardar"/>" class="button btn-default "><s:message code="key_generico_guardar"/></button>
        </div>

        <div class="col-xs-6 col-sm-2 col-md-2 text-center">
            <button type="button" name="button" id="button" value="<s:message code="key_generico_nuevo"/>" class="button btn-default "><s:message code="key_generico_nuevo"/></button>
        </div>

    </div>




    <br> <br>



    <div class="CSSTableResults">
        <table class="table-condensed table-responsive table-hover">
            <tbody><tr>
                    <td>
                        Title 1
                    </td>
                    <td>
                        Title 2
                    </td>
                    <td>
                        Title 3
                    </td>
                    <td>
                        Title 4
                    </td>
                </tr>
                <tr>
                    <td>
                        Row 1
                    </td>
                    <td>
                        Row 1
                    </td>
                    <td>
                        Row 1
                    </td>
                    <td>
                        Row 1
                    </td>
                </tr>
                <tr>
                    <td>
                        Row 2
                    </td>
                    <td>
                        Row 2
                    </td>
                    <td>
                        Row 2
                    </td>
                    <td>
                        Row 2
                    </td>
                </tr>
                <tr>
                    <td>
                        Row 2
                    </td>
                    <td>
                        Row 2
                    </td>
                    <td>
                        Row 2
                    </td>
                    <td>
                        Row 2
                    </td>
                </tr>
                <tr>
                    <td>
                        Row 3
                    </td>
                    <td>
                        Row 3
                    </td>
                    <td>
                        Row 3
                    </td>
                    <td>
                        Row 3
                    </td>
                </tr>
            </tbody></table>
    </div>


    <br>


    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-8">
        </div>

        <div class="col-xs-6 col-sm-2 col-md-2 text-center">
          
        </div>

        <div class="col-xs-6 col-sm-2 col-md-2 text-center">
            <button type="button" name="button" id="button" value="<s:message code="key_generico_nuevo_fecha"/>" class="button btn-default "><s:message code="key_generico_nuevo_fecha"/></button>
        </div>

    </div>



</form>
















