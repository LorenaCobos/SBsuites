/**
 * Locale
 * Autor: Fabian molar
 */

//Genericos
var horario ="Error, la fecha es incorrecta";
var sesion_="Session Error, Please Start Again";
var invalido ="Invalid"
var error ="Error";
var errorInterno ="Internal Error";
var enviar ="Send";
var cancelar ="Cancel";
var informacion ="Information";
var noDisponible ="Not available";
var sinInformacion ="No information";
var si ="Yes";
var si_n ="Yes";
var no ="No";
var inactivo ="Inactiv ";
var guardadoExito ="Saved ";

//Login
var no_existe_usuario="User is not exits";
var bienvenido = "welcome";
var usuarioSinPermisos = "The user dont have the proper access rights";
var tituo = "Enter your email to regain your ";
var usuario = "Login";
var contrasenia = "Password";
var correoElectronico = "Email";
var mensajeEnvio = "The requested information will be sent to your Email Address";
var correoInvalido = "Enter a valid Email Address";
var correoRepetido = "There is more than one user registered with that email please contact the administrator";

/******************PLUGIN VALIDACION DE FORMAS***********************************/
var validacion_mensage_error_required= '<br/><span style="color: red; font-size: 14px;">Required field<span>';
var validacion_mensage_error_remote=  '<br/><span style="color: red; font-size: 14px;">Please fix this field.<span>'; 
var validacion_mensage_error_email= '<br/><span style="color: red; font-size: 14px;">Email invalid.<span>';
var validacion_mensage_error_url= '<br/><span style="color: red; font-size: 14px;">Please enter a valid URL.<span>'; 
var validacion_mensage_error_date= '<br/><span style="color: red; font-size: 14px;">Invalid date. Formato:dd/mm/aaaa<span>';
var validacion_mensage_error_dateISO=  '<br/><span style="color: red; font-size: 14px;">Provide a date type(ISO) valid.<span>'; 
var validacion_mensage_error_dateDE= '<br/><span style="color: red; font-size: 14px;">Invalid date. Format: dd/mm/yyyy<span>';
var validacion_mensage_error_number= '<br/><span style="color: red; font-size: 14px;">Invalid number.<span>';
var validacion_mensage_error_numberDE= '<br/><span style="color: red; font-size: 14px;">Invalid number.<span>';
var validacion_mensage_error_digits= '<br/><span style="color: red; font-size: 14px;">Provide only numbers.<span>';
var validacion_mensage_error_creditcard= '<br/><span style="color: red; font-size: 14px;">Provide a credit card number valid.<span>'; 
var validacion_mensage_error_equalTo= '<br/><span style="color: red; font-size: 14px;">The value does not match.<span>';
var validacion_mensage_error_accept= '<br/><span style="color: red; font-size: 14px;">Provide a value output with an extension.<span>'; 
var validacion_mensage_error_maxlength='<br/><span style="color: red; font-size: 14px;">Maximum valid: {0} characters.<span>';
var validacion_mensage_error_minlength='<br/><span style="color: red; font-size: 14px;">Minimum valid: {0} characters.<span>'; 
var validacion_mensage_error_rangelength='<br/><span style="color: red; font-size: 14px;">Provide a value between {0} and {1} characters long.<span>';
var validacion_mensage_error_range='<br/><span style="color: red; font-size: 14px;">Provide a value between {0} and {1}.<span>';
var validacion_mensage_error_max='<br/><span style="color: red; font-size: 14px;">Provide a value less than or equal to {0}.<span>';
var validacion_mensage_error_min='<br/><span style="color: red; font-size: 14px;">Provide a value greater than or equal to {0}.<span>'; 
var validacion_mensage_error_selectNone='<br/><span style="color: red; font-size: 14px;">Required field<span><span>';
var validacion_mensage_error_xss='<br/><span style="color: red; font-size: 14px;">The openings Info is not valid.<span>'; 
var validacion_mensage_error_one_digit='<br/><span style="color: red; font-size: 14px;">The password must contain at least 1 number.<span>'; 
var validacion_mensage_error_capital_letter='<br/><span style="color: red; font-size: 14px;">The password must contain at least one letter.<span>';


//Suite
var cambiarEstatusUsuario="&iquest;Desea cambiar el estatus del Usuario: XX a YY?";

//Eventos Admin
var cambiarEstatusEvento="&iquest;Desea cambiar el estatus del Evento XX a YY?";

//Eventos Usuarios
var boleto_impreso = "Boleto(s) impreso";
var boleto_enviado = "Boleto(s) enviado";
var cantidad_maxima = "Boletos disponibles para imprimir es de: XX ";
var cantidad_maxima_invitar = "La cantidad disponible de boletos para invitaciones es de: XX ";
var boleto_adjunto = "Boleto(s) Adjunto";
var boleto_disponible = "Boleto(s) Enviados";
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
var errorGenerarBoleto="No se puede visualizar los boletos, por favor de ir a RESUMEN DETALLE y generarlos de nuevo";
var errorGenerarInvitacion="No se pudo generar la invitaci&oacute;n, por favor intente mas tarde";
var renvioinvita="La invitación se ha reenviado correctamente";
//Estacionamientos
var errorEstacionamientoNoValido="The amount of parking exceeds the allowed limit , please select fewer";
var pesoImagenError="The weight of the image in the permissible limit Exed kb";
var boletos ="Tickets";
var invitacion_nogenerada ="La invitaci&oacute;n no se ha podido generar";
var estacionamientos ="Parcking"; 
var estacionamiento ="Parcking"; 
var invitaciones ="Invitations"; 
var msgInvitacionEstaImprimir="&iquest;Est&aacute; seguro que desea imprimir el(los) boleto(s) de estacionamiento?";
var cantidad_maxima_estacionamineto = "Estacionamientos disponibles para imprimir es de: XX ";
var invitacion_insuficientesLugares_estacionamientos ="Not have sufficient parking tickets available";