<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
    String contexto = request.getContextPath();
%>
<%--
<div class="navbar-left navbar-inverse navbar-fixed-left">
    <div class="navbar-header">
        <a class="navbar-toggle collapsed " onclick="" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <a class="navbar-brand" href="#">SUPERBOLETOS</a>
    </div>
       <ul class="nav navbar-nav"/>
        <ul class="nav navbar-nav">
            <c:forEach var="menu" items="${menu}">
                <li class="dropdown" >
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">${menu.nombreMenuPrincipal} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <c:forEach var="operaciones" items="${menu.operaciones}">
                            <li><a onclick="bloquear();" href="<%=contexto%>${operaciones.urlMenuLateral}" name="operacion_menu"  id="operacion_${operaciones.accionMenuLateral}}" >${operaciones.nombreMenuLateral}</a></li>
                            </c:forEach>
                    </ul>
                </li>     
            </c:forEach>
        </ul>

        <ul class="nav navbar-nav">
            <li class="dropdown" >                
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;
                    ${user.nombres} <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="/Suites/logout.do" name="operacion_menu"  id="lnkSalir" ><s:message code="key_label_cerrar_sesion"/></a></li>

                </ul>
            </li>  
        </ul>
</div>--%>


 <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        
        <div class="user-panel">           
            <div class="pull-left image">
                <c:choose>
                    <c:when test="${sessionScope.opcion ==1}">
                        <img src="http://10.19.0.193:8080/SuperBoletosRepositorio/suites/logoACMX_suites.png" alt="User Image">                        
                    </c:when>
                    <c:when test="${sessionScope.opcion ==2}">
                        <img src="http://10.19.0.193:8080/SuperBoletosRepositorio/suites/logoAM_suites.jpg" alt="User Image">
                     </c:when>
                </c:choose>
            </div>
        </div>

      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
        <div> 
            <ul class="sidebar-menu">
              <c:forEach var="menu" items="${menu}">
                  <li class="treeview" >
                      <a href="#">
                          <i class=" fa fa-circle-o text-gray"></i> 
                              <span>${menu.nombreMenuPrincipal} <b class="caret"></b></span>
                              
                              

                      </a>
                      <ul class="treeview-menu">
                          <c:forEach var="operaciones" items="${menu.operaciones}">
                              <li><a onclick="bloquear();" href="<%=contexto%>${operaciones.urlMenuLateral}" name="operacion_menu"  id="operacion_${operaciones.accionMenuLateral}}" >${operaciones.nombreMenuLateral}</a></li>
                              </c:forEach>
                      </ul>
                           
                  </li> 
                  
                   
               </c:forEach>
                  <li class="treeview">
                      <a href="#">
                          <i class=" fa fa-circle-o text-gray"></i> 
                          <span>Ayuda <b class="caret"></b></span>
                      </a> 
                      <ul class="treeview-menu"><li><a onclick="bloquear();" href="/Suites/s/AyudaBoletos.do">Vende tus Boletos</a></li></ul>
                  </li>
            </ul>
        </div>
    </section>
   <!-- <footer class="left-menu-footer">           
                
                <img src="../assets/img/superboletos.png">                        
                    
        </footer>
    
    <!-- /.sidebar -->
  </aside>


