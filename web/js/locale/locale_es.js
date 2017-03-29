/**
 * Locale
 * Autor: Fabian molar
 */

//Genericos
var horario ="Error, la fecha es incorrecta";
var horario_ ="Error, la fecha es correcta";
var sesion_="Error de Session , Favor de iniciar Nuevamente";
var invalido ="invalido";
var error ="Error";
var errorInterno ="Error Interno";
var enviar ="Enviar";
var cancelar ="Cancelar";
var informacion ="Informaci&oacute;n";
var noDisponible ="No Disponible";
var sinInformacion ="Sin Informaci&oacute;n";
var activo ="Activo";
var confirmacion ="Confirmaci&oacute;n";
var si ="S&iacute;";
var si_n ="Sí";
var no ="No";
var inactivo ="Inactivo ";
var guardadoExito ="Guardado Correctamente ";
var renvioinvita="La invitación se ha reenviado correctamente";


//Login
var no_existe_usuario="Usuario no existe";
var bienvenido = "Bienvenido";
var usuarioSinPermisos = "El usuario no cuenta con el permiso necesario para ingresar";
var tituo = "Ingrese su correo electr&oacute;nico para recuperar su ";
var usuario = "Usuario";
var contrasenia = "Contrase&ntilde;a";
var correoElectronico = "Correo Electr&oacute;nico";
var mensajeEnvio = "La informaci&oacute;n solicitada se enviara a su Correo Electr&oacute;nico";
var correoInvalido = "Ingrese un Correo Electr&oacute;nico v&aacute;lido";
var correoRepetido = "Existe mas de un usuario registrado con ese correo favor de contactar al administrador";
var loginRepetido = "El nombre de Usuario ZZZ ya existe, favor de cambiarlo.";

//Suite
var cambiarEstatusSuite="&iquest;Desea cambiar el estatus de la suite XX a YY?";

/******************PLUGIN VALIDACION DE FORMAS***********************************/
var validacion_mensage_error_required= '<span style="color: red; font-size: 14px;">Campo requerido<span>'; 
var validacion_mensage_error_remote=  '<span style="color: red; font-size: 14px;">Por favor repare este campo.<span>'; 
var validacion_mensage_error_email= '<span style="color: red; font-size: 14px;">Correo inv&aacute;lido.<span>'; 
var validacion_mensage_error_url= '<span style="color: red; font-size: 14px;">Por favor introduzca un URL v&aacute;lida.<span>'; 
var validacion_mensage_error_date= '<span style="color: red; font-size: 14px;">Fecha inv&aacute;lida. Formato:dd/mm/aaaa<span>';
var validacion_mensage_error_dateISO=  '<span style="color: red; font-size: 14px;">Proporcione una fecha tipo(ISO) v&aacute;lida.<span>'; 
var validacion_mensage_error_dateDE= '<span style="color: red; font-size: 14px;">Fecha inv&aacute;lida. Formato: dd/mm/aaaa<span>';
var validacion_mensage_error_number= '<span style="color: red; font-size: 14px;">N&uacute;mero inv&aacute;lido.<span>'; 
var validacion_mensage_error_numberDE= '<span style="color: red; font-size: 14px;">N&uacute;mero inv&aacute;lido.<span>'; 
var validacion_mensage_error_digits= '<span style="color: red; font-size: 14px;">Proporcione solo n&uacute;meros<span>'; 
var validacion_mensage_error_creditcard= '<span style="color: red; font-size: 14px;">Proporcione un n&uacute;mero de tarjeta de cr&eacute;dito v&aacute;lida.<span>'; 
var validacion_mensage_error_equalTo= '<span style="color: red; font-size: 14px;">El valor no coincide.<span>'; 
var validacion_mensage_error_accept= '<span style="color: red; font-size: 14px;">Proporcione un valor con una extenci&oacute;n &aacute;alida.<span>'; 
var validacion_mensage_error_maxlength='<span style="color: red; font-size: 14px;">M&aacute;ximo valido:{0} caracteres.<span>'; 
var validacion_mensage_error_minlength='<span style="color: red; font-size: 14px;">M&iacute;nimo valido:{0} caracteres.<span>'; 
var validacion_mensage_error_rangelength='<span style="color: red; font-size: 14px;">Proporcione un valor entre {0} y {1} caracteres de largo.<span>'; 
var validacion_mensage_error_range='<span style="color: red; font-size: 14px;">Proporcione un valor entre {0} y {1}.<span>'; 
var validacion_mensage_error_max='<span style="color: red; font-size: 14px;">Proporcione un valor menor o igual a {0}.<span>'; 
var validacion_mensage_error_min='<span style="color: red; font-size: 14px;">Proporcione un valor mayor o igual a {0}.<span>'; 
var validacion_mensage_error_selectNone='<span style="color: red; font-size: 14px;">Campo requerido.<span><span>';
var validacion_mensage_error_xss='<span style="color: red; font-size: 14px;">Informaci&oacute;n invalida (XSS).<span>'; 
var validacion_mensage_error_one_digit='<span style="color: red; font-size: 14px;">El password debe de contener al menos 1 numero.<span>'; 
var validacion_mensage_error_capital_letter='<span style="color: red; font-size: 14px;">El password debe de contener al menos una letra.<span>';


//Suite
var cambiarEstatusUsuario="&iquest;Desea cambiar el estatus del Usuario: XX a YY?";

//Eventos Admin
var cambiarEstatusEvento="&iquest;Desea cambiar el estatus del Evento XX a YY?";

//Eventos Usuarios
var boleto_impreso = "Boleto(s)";
var boleto_Estacionamiento = "Estacionamineto(s)";
var impreso = "impreso";
var boleto_cancelado = "Boleto(s) cancelado(s)";
var boleto_enviado = "enviado(s)";
var cantidad_maxima = "Boletos disponibles para imprimir es de: XX ";
var cantidad_maxima_invitar = "La cantidad disponible de boletos para invitaciones es de: XX ";
var boleto_adjunto = "Adjunto";
var boleto_disponible = "Boleto(s) Enviado(s)";
var estatus_proc="Invitacion enviada";
var estatus_acep=" Invitacion Aceptada";
var estatus_dec=" Invitacion Declinada";
var estatus_fin=" Invitacion Finalizada";
var estatus_can=" Invitacion Cancelada";


//Detalle Evento
var msgInvitacionImprimir="&iquest;Est&aacute; seguro que desea imprimir el(los) boleto(s)?";
var msgInvitacionInvitar="&iquest;Est&aacute; seguro que desea enviar la invitaci&oacute;n?";
var msgInvitacionReenviar="&iquest;Est&aacute; seguro que desea reenviar la invitaci&oacute;n?";
var msgBoletosReenviar_="&iquest;Est&aacute; seguro que desea reenviar los boletos?";
var msgInvitacionCancelar="&iquest;Est&aacute; seguro que desea cancelar la invitaci&oacute;n?";
var msgInvitacionAceptar="&iquest;Est&aacute; seguro que desea enviar el(los) boleto(s)?";
var errorGenerarBoleto="No se puede visualize los boletos, por favor de ir a RESUMEN DETALLE y generarlos de nuevo";
var errorGenerarInvitacion="No se pudo generar la invitaci&oacute;n, por favor intente mas tarde";
var msgInvitacionVer="&iquestDesea abrir el(los) boleto(s)?";
var invitacion_noRechazar ="La invitaci&oacute;n no se puede rechazar";
var invitacion_noCancelar ="La invitaci&oacute;n no se puede canelar";
var invitacion_nogenerada ="La invitaci&oacute;n no se ha podido generar";
var invitacion_noFinalizar ="La invitaci&oacute;n no se puede finalizar";
var invitacion_insuficientesLugares ="No cuenta con los suficientes boletos disponibles";
var noGeneradosBoletos ="No se pudieron generar los boletos, favor de contactar a Soporte.";


//Estacionamientos
var errorEstacionamientoNoValido="La cantidad de estacionamiento excede el limite permitido, por favor seleccione una cantidad menor";
var pesoImagenError="El peso de la imagen en kb excede el limite permitido";
var boletos ="Boletos"; 
var estacionamientos ="Estacionamientos"; 
var estacionamiento ="Estacionamiento"; 
var invitaciones ="Invitaciones"; 
var msgInvitacionEstaImprimir="&iquest;Est&aacute; seguro que desea imprimir el(los) boleto(s) de estacionamiento?";
var cantidad_maxima_estacionamineto = "Estacionamientos disponibles para imprimir es de: XX ";
var invitacion_insuficientesLugares_estacionamientos ="No cuenta con los suficientes boletos de estacionamientos disponibles";