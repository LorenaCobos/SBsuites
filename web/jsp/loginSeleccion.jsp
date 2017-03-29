<%--    
    Author     : Fabian molar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style type="text/css">
    #amSuite, #acmxSuite
        {
            width: 470px; 
            height: 400px;
        }
        
    @media (max-width: 768px) {
        #amSuite, #acmxSuite
        {
            width: 200%; 
            height: 200px;
            margin-bottom: 20px;
        }
    }
</style>


<div style="text-align: center"> 

<div class="login-box">

        <div class="login-header-box">
            <div class="login-header-image col-sm-6"> </div>

            <div class="col-sm-5" > 
                <s:message code="key_login_box"/>
            </div>
        </div>
    
  <!-- /.login-logo -->
    <div class="login-box-body">


    <form id="formLogin" >
        <div class="row" style="padding: 15px">
            </br>
            <select name="selectRecinto" id="selectRecinto" class="form-control">
                <option value="0" ><s:message code="key_select_recinto" /></option>
                <option value="2" ><s:message code="key_selec_recinto_am" /></option>
                <option value="1" ><s:message code="key_selec_recinto_acmx" /></option>
            </select>
        </div>
        <div class="row" style="padding-top: 15px">
            <button type="button" name="button" id="buttonRecinto" value="<s:message code="key_generico_aceptar"/>" 
                            class="button btn-default "><s:message code="key_generico_aceptar"/></button>
        </div>
    </form>

  
    <div id="contForm"/>
    </div>

  </div>
  <!-- /.login-box-body -->
</div>
</div>



<%--<div class="row">
    <div class="col-sm-6" >
        <div class="tilular-seccion">
            <p class="p-titular-seccion"><s:message code="key_sel_monterrey"/></p>
        </div>
        <img id="amSuite" class="img-thumbnail center text-center"  style="cursor: pointer; width: 100%; " alt="" src="${contexto}/SuperBoletosRepositorio/suites/AMSUITES.png" />
    </div>
    <div class="col-sm-6">
        <div class="tilular-seccion">
            <p class="p-titular-seccion"><s:message code="key_sel_mexico"/></p>
        </div>
       <img id="acmxSuite" class="img-thumbnail center text-center" style="cursor: pointer; width: 100%; " alt="" src="${contexto}/SuperBoletosRepositorio/suites/ACMXSUITES.png" />
    </div>


   


</div>


<div class="row hidden hide">
    <table>
        <tr>
            <td>
                <img id="amSuite" style="width: 470px; height: 400px; cursor: pointer; padding-left: 100px;" alt="" src="${contexto}/SuperBoletosRepositorio/suites/AMSUITES.png" />
            </td>
            <td>
                
            </td>
            <td>
                <img id="acmxSuite" style="width: 500px; height: 400px;  cursor: pointer;padding-left: 100px;" alt="" src="${contexto}/SuperBoletosRepositorio/suites/ACMXSUITES.png" />
            </td>
        </tr>
        <tr>
            <td class="tilular-seccion">
                 <p class="p-titular-seccion"><s:message code="key_sel_monterrey"/></p>
            </td>
            <td>
                &nbsp;&nbsp;&nbsp;   &nbsp;&nbsp;&nbsp;
            </td>
            <td class="tilular-seccion">
                 <p class="p-titular-seccion"><s:message code="key_sel_mexico"/></p>
            </td>
        </tr>
    </table>
</div>

<hr>

<div id="contForm"/>
</div>
--%>

<script>
   // login.validacionOpcion();
</script>
