function inicioGeneral() {
    detalleEvento.cargaInicial();
}

var detalleEvento = {
    limite: 0,
    limiteEstacionamiento: 0,
    urlImprimir: "",
    cargaInicial: function() {
         document.getElementById('inptCorreo').addEventListener('input', function() {
            campo = event.target;
            valido = document.getElementById('emailOK');
            emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
            //Se muestra un texto a modo de ejemplo, luego va a ser un icono
            if (emailRegex.test(campo.value)) {
              valido.innerText = "";
            } else {
              valido.innerText = "coreo electronico incorrecto";
            }
        });
        $("#buttonImprimir").click(function(event) {
            event.preventDefault();

            if ($("#formSuite").valid()) {
                mensajeCall(confirmacion, msgInvitacionImprimir, detalleEvento.imprimirPDF);
            }
            //detalleEvento.imprimirPDF();
        });
        $("#buttonImprimirEsta").click(function(event) {
            event.preventDefault();

            if ($("#formSuiteEstacionamiento").valid()) {
                mensajeCall(confirmacion, msgInvitacionEstaImprimir, detalleEvento.imprimirEstacioanmientoPDF);
            }
            //detalleEvento.imprimirPDF();
        });
        $("#buttonRegresar").click(function(event) {
            event.preventDefault();
            navaegacion('eventos');
        });
        $("#btnEnviar").click(function(event) {
            event.preventDefault();

            
            if ($("#formEnvio").valid()) {
                  if (emailRegex.test(campo.value)) 
                  {
                    mensajeCall(confirmacion, msgInvitacionInvitar, detalleEvento.generarInvitacion);	
                }else{$("#inptCorreo").val("");
                 mensajeError(error,"coreo electronico incorrecto");
                 valido.innerText = "";}
            //detalleEvento.generarInvitacion();
                }
        });


        $("#buttonImprimirCancela").click(function(event) {
            event.preventDefault();
            $("#txtBoletos").val("");
            $('#collapseOne').collapse("hide");
        });
        
         $("#buttonImprimirEstaCancela").click(function(event) {
            event.preventDefault();
            $("#txtBoletosEsta").val("");
            $('#collapseOne').collapse("hide");
        });

        $("#buttonInvitarCancela").click(function(event) {
            event.preventDefault();
            $("#txtBoletos2").val("");
            $("#inptNombre").val("");
            $("#inptCorreo").val("");
            $("#inptNota").val("");
            $('#collapseTwo').collapse("hide");
        });

        $("#txtBoletos").keydown(function(e) {
            // Allow: backspace, delete, tab, escape, enter and . (, 190)
            if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
                    // Allow: Ctrl+A, Command+A
                            (e.keyCode == 65 && (e.ctrlKey === true || e.metaKey === true)) ||
                            // Allow: home, end, left, right, down, up
                                    (e.keyCode >= 35 && e.keyCode <= 40)) {
                        // let it happen, don't do anything
                        return;
                    }
                    if (this.value.length > 2) {
                        return
                    }
                    // Ensure that it is a number and stop the keypress
                    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
                        e.preventDefault();
                    }
                });
        $("#txtBoletos2").keydown(function(e) {
            // Allow: backspace, delete, tab, escape, enter and . (, 190)
            if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
                    // Allow: Ctrl+A, Command+A
                            (e.keyCode == 65 && (e.ctrlKey === true || e.metaKey === true)) ||
                            // Allow: home, end, left, right, down, up
                                    (e.keyCode >= 35 && e.keyCode <= 40)) {
                        // let it happen, don't do anything
                        return;
                    }
                    if (this.value.length > 2) {
                        return
                    }
                    // Ensure that it is a number and stop the keypress
                    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
                        e.preventDefault();
                    }
                });
               
          $("[data-toggle=tooltip]").tooltip({ placement: 'left'});
        detalleEvento.obtenerResumen();
//        detalleEvento.autocomplete();
        detalleEvento.validaciones();
        detalleEvento.validacionesEnvio();
    },
    validaciones: function() {

        $("#formSuite").validate({
            rules: {
                txtBoletos: {
                    required: true,
                    number: true,
                    maxlength: 2,
                    min: 1
                }
            }
        });
        $("#formSuiteEstacionamiento").validate({
            rules: {
                txtBoletosEsta: {
                    required: true,
                    number: true,
                    maxlength: 2,
                    min: 1
                }
            }
        });
    },
    validacionesEnvio: function() {
        $("#formEnvio").validate({
            rules: {
                txtBoletos2: {
                    required: true,
                    number: true,
                    maxlength: 2,
                    min: 1
                },
                inptNombre: {
                    required: true,
                    maxlength: 200
                },
                inptCorreo: {
                    required: true,
                    email: true,
                    maxlength: 50
                },
                inptNota: {
                    required: false,
                    maxlength: 200
                }
            }
        });
    },
    imprimirPDF: function(result) {

        if (result !== "Si")
            return;

        if ($("#formSuite").valid()) {

            if ($("#txtBoletos").val() > 0 && $("#txtBoletos").val() <= detalleEvento.limite) {
                dwrEvento.generarPDF(
                        Aes.Ctr.encrypt($("#hdnsuiteId").val(), "", 1),
                        Aes.Ctr.encrypt($("#hdnpresentacionId").val(), "", 1),
                        Aes.Ctr.encrypt($("#txtBoletos").val(), "", 1),
                        Aes.Ctr.encrypt($("#hdneventoId").val(), "", 1),
                        {
                            callback: function(data) {
                                switch (data) {
                                    case null:
                                        mensajeError(error,sesion_);
                                    break
                                    case 0:
                                       mensajeError(error, sesion_);
                                       break;
                                    case "":
                                    case -1:
                                    case '-1':
                                        mensajeError(error, errorGenerarBoleto);
                                        break;
                                    case 2:
                                    case '2':
                                        mensajeError(error, invitacion_insuficientesLugares);
                                        break;
                                    default:

                                        data = data.replace("C:\\Resources", "").replace("/app1/SuperBoletosRepositorio.war", "");
                                        detalleEvento.urlImprimir = data;
                                        mensajeCall(confirmacion, msgInvitacionVer, detalleEvento.confirmarVer);
                                        break;
                                }
                                detalleEvento.obtenerResumen();
                            },
                            preHook: function() {
                                bloquear();
                            },
                            postHook: function() {
                                desbloquear();
                            }

                        });
            } else {
                mensajeError(error, cantidad_maxima.replace("XX", detalleEvento.limite));
            }

        }
    },
    imprimirEstacioanmientoPDF: function(result) {

        if (result !== "Si")
            return;

        if ($("#formSuiteEstacionamiento").valid()) {

            if ($("#txtBoletosEsta").val() > 0 && $("#txtBoletosEsta").val() <= detalleEvento.limiteEstacionamiento) {
                dwrEvento.generarEstacionamientosPDF(
                        Aes.Ctr.encrypt($("#hdnsuiteId").val(), "", 1),
                        Aes.Ctr.encrypt($("#hdnpresentacionId").val(), "", 1),
                        Aes.Ctr.encrypt($("#txtBoletosEsta").val(), "", 1),
                        Aes.Ctr.encrypt($("#hdneventoId").val(), "", 1),
                        Aes.Ctr.encrypt($("#hdnestacionamientoId").val(), "", 1),
                        {
                            callback: function(data) {
                                switch (data) {
                                    case null:
                                        mensajeError(error, sesion_);
                                    break;
                                    case "":		                                
                                        mensajeError(error, sesion_);
                                    break;
                                    case 0:
                                        mensajeError(error, sesion_);
                                    break;
                                    case -1:
                                    case '-1':
                                        mensajeError(error, errorGenerarBoleto);
                                        break;
                                    case 2:
                                    case '2':
                                        mensajeError(error, invitacion_insuficientesLugares);
                                        break;
                                    default:

                                        data = data.replace("C:\\Resources", "").replace("/app1/SuperBoletosRepositorio.war", "");
                                        detalleEvento.urlImprimir = data;
                                        mensajeCall(confirmacion, msgInvitacionVer, detalleEvento.confirmarVer);
                                        break;
                                }
                                detalleEvento.obtenerResumen();
                            },
                            preHook: function() {
                                bloquear();
                            },
                            postHook: function() {
                                desbloquear();
                            }

                        });
            } else {
                mensajeError(error, cantidad_maxima_estacionamineto.replace("XX", detalleEvento.limiteEstacionamiento));
            }

        }
    },
    confirmarVer: function(result) {
        if (result === "Si") {
            window.open(baseRep + detalleEvento.urlImprimir, '_blank');
        }

    },
    generarInvitacion: function(result) {

        if (result !== "Si")
            return;

        if ($("#formEnvio").valid()) {

            if ($("#txtBoletos2").val() > 0 && $("#txtBoletos2").val() <= detalleEvento.limite) {
            
            if ($("#txtBoletosEst2").val() > 0 && $("#txtBoletosEst2").val() > detalleEvento.limiteEstacionamiento) {
                mensajeError(error, cantidad_maxima_estacionamineto.replace("XX", detalleEvento.limiteEstacionamiento));
                return;
            }
                dwrEvento.generarInvitacion(
                        Aes.Ctr.encrypt($("#hdnsuiteId").val(), "", 1),
                        Aes.Ctr.encrypt($("#hdnpresentacionId").val(), "", 1),
                        Aes.Ctr.encrypt($("#txtBoletos2").val(), "", 1),
                        Aes.Ctr.encrypt($("#hdneventoId").val(), "", 1),
                        Aes.Ctr.encrypt($("#inptNombre").val(), "", 1),
                        Aes.Ctr.encrypt($("#inptCorreo").val(), "", 1),
                        Aes.Ctr.encrypt($("#inptNota").val(), "", 1),
                        Aes.Ctr.encrypt($("#txtBoletosEst2").val()===""?"0":$("#txtBoletosEst2").val(), "", 1),
                        {
                            callback: function(data) {
                                switch (data) { 
                                    case 0:
                                      mensajeError(error, sesion_);
                                    break;
                                    case null:
                                    case "":
                                    case -1:
                                        mensajeError(error, errorGenerarInvitacion);
                                        break;
                                    case -3:
                                    case '-3':
                                        mensajeError(error, invitacion_insuficientesLugares);
                                        break;
                                    case -4:
                                    case '-4':
                                        mensajeError(error, invitacion_insuficientesLugares_estacionamientos);
                                        break;
                                    default:
                                        $("#btnCancelarInvitacion").click();
                                        $("#inptNombre").val("");
                                        $("#inptCorreo").val("");
                                        $("#inptNota").val("");
                                        $("#txtBoletos2").val("");
                                        $("#txtBoletosEst2").val("");
                                        mensaje(informacion, "Enviado");
                                        detalleEvento.obtenerResumen();
                                        break;
                                }
                            },
                            preHook: function() {
                                bloquear();
                            },
                            postHook: function() {
                                desbloquear();
                            }

                        });

            } else {
                mensajeError(error, cantidad_maxima_invitar.replace("XX", detalleEvento.limite));
            }

        }
    },
    obtenerResumen: function() {
        dwrEvento.resumenImpresos(
                Aes.Ctr.encrypt($("#hdneventoId").val(), "", 1),
                Aes.Ctr.encrypt($("#hdnpresentacionId").val(), "", 1),
                Aes.Ctr.encrypt($("#hdnsuiteId").val(), "", 1),
                {
                    callback: function(data) {
                        switch (data) {
                            case null:
                             mensajeError(error, sesion_);
                                break;
                            case "":
                            case -1:
                                mensajeError(error, errorInterno);
                                break;
                            case -2:
                            case '-2':
                                mensajeError(error, errorInterno);
                                break;
                            default:
                                bloquear();
                                detalleEvento.construirTabla(data);
                                break;
                        }
                    },
                    preHook: function() {
                        bloquear();
                    },
                    postHook: function() {
                        desbloquear();
                    }

                });
    },
    construirTabla: function(data) {
        $("#cantidadBoletos").html("" + data.lugaresDisponibles + "");
        $("#cantidadEstacionamientos").html("" + data.estacionamientosDisponibles + "");
        detalleEvento.limite = data.lugaresDisponibles;
        detalleEvento.limiteEstacionamiento= data.estacionamientosDisponibles;
        
        $("#txtBoletos").attr("max", detalleEvento.limite);
        $("#txtBoletos2").attr("max", detalleEvento.limite);
        $("#txtBoletosEsta").attr("max", detalleEvento.limiteEstacionamiento);
        $("#txtBoletosEst2").attr("max", detalleEvento.limiteEstacionamiento);
        var cadena = "";
        for (var i = 0; i < data.detalle.length; i++) {

            if (data.detalle[i].claveEstatus === 'EN_PROCESO' ||
                    data.detalle[i].claveEstatus === 'ACEPTADA' ||
                    data.detalle[i].claveEstatus === 'CANCELADA' ||
                    data.detalle[i].claveEstatus === 'FINALIZADA' ||
                    data.detalle[i].claveEstatus === 'DECLINADA') {
                continue;
            }
            cadena += '<tr name="' + data.detalle[i].claveEstatus + '">'
                    + '<td style="text-align:center;" aling="center" >'
                    + data.detalle[i].nombreUsusario
                    + '</td>'
                    + '<td style="text-align:center" aling="center">'
                    + ((data.detalle[i].correo === null || data.detalle[i].correo === " ") ? "Impresion de boleto" : data.detalle[i].correo)
                    + '</td>'
                    + '<td style="text-align:center" aling="center">';


            switch (data.detalle[i].claveEstatus) {

                case "EN_PROCESO":
                    cadena += data.detalle[i].cantidadImpresos+" "+ boleto_impreso + " "+ data.detalle[i].cantidadEstacionamientos+ " " + boleto_Estacionamiento+" "+ boleto_adjunto + "<br/>";
                    cadena += estatus_proc + " " + data.detalle[i].fechaCreacion;
                    break;
                case "ACEPTADA":
                    cadena += data.detalle[i].cantidadImpresos+" "+ boleto_impreso + " " + data.detalle[i].cantidadEstacionamientos+ " " + boleto_Estacionamiento+" "+ boleto_adjunto + "<br/>";
                    cadena += estatus_acep + " " + data.detalle[i].fechaCreacion;
                    break;
                case "DECLINADA":
                    cadena += estatus_dec + " <br/>" + data.detalle[i].fechaCreacion;
                    break;
                case "CANCELADA":
                    cadena += estatus_can + " <br/>" + data.detalle[i].fechaCreacion;
                    break;
                case "CANCELADO":
                    cadena += data.detalle[i].cantidadCancelados + " " + boleto_cancelado + "<br/>";
                    cadena += data.detalle[i].fechaCreacion;
                    break;
                case "FINALIZADA":
                    cadena += data.detalle[i].cantidadImpresos+ boleto_impreso + " " + data.detalle[i].cantidadEstacionamientos+ " " +boleto_Estacionamiento+" "+ boleto_adjunto + "<br/>";
                    cadena += estatus_fin + " " + data.detalle[i].fechaCreacion;
                    break;
                case "POR_IMPRIMIR_RESERVACION":
                case "RESERVADO_IMPRESO":
                case "IMPRESO":
                case "POR_IMPRIMIR":
                    if(data.detalle[i].claveTipoBoleto==="ESTACIONAMIENTO"){
                       cadena +=  data.detalle[i].cantidadEstacionamientos+ " "  +boleto_Estacionamiento+" "+ impreso + "<br/>"; 
                    }else{
                        cadena += data.detalle[i].cantidadImpresos+" "+ boleto_impreso + impreso + "<br/>";
                    }
                    cadena += data.detalle[i].fechaCreacion;
                    break;
                default:
                    cadena += data.detalle[i].cantidadImpresos+" "+ boleto_impreso + " " + data.detalle[i].cantidadEstacionamientos+ " " + boleto_Estacionamiento+" "+ impreso + "<br/>";
                    cadena += data.detalle[i].claveEstatus + estatus_fin + " " + data.detalle[i].fechaCreacion;
                    break;
            }

            cadena += '</td>'
                    + "<td style='text-align:center' aling='center'>";

            switch (data.detalle[i].claveEstatus) {

                case "EN_PROCESO":
                    cadena += "<a href='#' class='highlightit' onClick='detalleEvento.preguntaAccion(" + data.detalle[i].transaccionId + ",3,0)'><img src='/SuperBoletosRepositorio/suites/assets/CancelarInvitacion.png' alt='[Cancelar invitaci&oacute;n]' /> <span> Cancelar </span></a><br/>";
                    cadena += "<a href='#' class='highlightit' onClick='detalleEvento.preguntaAccion(" + data.detalle[i].transaccionId + ",4,1)'><img src='/SuperBoletosRepositorio/suites/assets/EnviarBoletos.png' alt='[Reenviar invitaci&oacute;n]' /> <span> Re-enviar</span></a>";
                    break;
                case "ACEPTADA":
                    cadena += "<a href='#' class='highlightit' onClick='detalleEvento.preguntaAccion(" + data.detalle[i].transaccionId + ",2,0)'><img src='/SuperBoletosRepositorio/suites/assets/EnviarBoletos.png' alt='[Enviar Boletos]' /> <span> Enviar Boletos </span></a><br/>";
                    cadena += "<a href='#' class='highlightit' onClick='detalleEvento.preguntaAccion(" + data.detalle[i].transaccionId + ",3,0)'><img src='/SuperBoletosRepositorio/suites/assets/CancelarInvitacion.png' alt='[Cancelar invitaci&oacute;n]' /> <span> Cancelar </span></a>";
                    break;
                case "DECLINADA":
                    break;
                case "CANCELADA":
                case "CANCELADO":
                case "IMPRESO":
                    break;
                case "FINALIZADA":
                    cadena += "<a href='#' class='highlightit' onClick='detalleEvento.preguntaAccion(" + data.detalle[i].transaccionId + ",2,1)'><img src='../SuperBoletosRepositorio/suites/assets/ReenviarBoletos.png' alt='[Reenviar Boletos]' /> <span> Re-enviar </span></a>";
                    break;
                default:
                    if(data.detalle[i].claveTipoBoleto==="ESTACIONAMIENTO"){
                        cadena += "<a class='highlightit' target='BLANK_' href='" + baseRep + "/templateSB2/pah/suite/pdfGenerados/estacionamientos/boletosPAH_" + data.detalle[i].transaccionId + ".pdf'><img src='/SuperBoletosRepositorio/suites/assets/Ver.png' alt='[Ver]' /> <span> Ver </span></a>";
                    }else{
                         cadena += "<a class='highlightit' target='BLANK_' href='" + baseRep + "/templateSB2/pah/suite/pdfGenerados/boletosPAH_" + data.detalle[i].transaccionId + ".pdf'><img src='/SuperBoletosRepositorio/suites/assets/Ver.png' alt='[Ver]' /> <span> Ver </span></a>";
                    }
                   
                    break;
            }
            cadena += '</td>'
                    + '</tr>';
        }

        $("#contTablaImpresion").html(cadena);
        desbloquear();
        detalleEvento.construirTablaInvitaciones(data);
    },
    construirTablaInvitaciones: function(data) {
        $("#cantidadBoletos").html("" + data.lugaresDisponibles + "");
        detalleEvento.limite = data.lugaresDisponibles;

        $("#txtBoletos").attr("max", detalleEvento.limite);
        $("#txtBoletos2").attr("max", detalleEvento.limite);
        var cadena = "";
        for (var i = 0; i < data.detalle.length; i++) {
            if (data.detalle[i].claveEstatus === "POR_IMPRIMIR_RESERVACION" ||
                    data.detalle[i].claveEstatus === "RESERVADO_IMPRESO" ||
                    data.detalle[i].claveEstatus === "POR_IMPRIMIR" ||
                    data.detalle[i].claveEstatus === "IMPRESO") {
                continue;
            }
            cadena += '<tr name="' + data.detalle[i].claveEstatus + '">'
                    + '<td style="text-align:center;" aling="center" >'
                    + data.detalle[i].nombreUsusario
                    + '</td>'
                    + '<td style="text-align:center" aling="center">'
                    + ((data.detalle[i].correo === null || data.detalle[i].correo === " ") ? "Impresion de boleto" : data.detalle[i].correo)
                    + '</td>'
                    + '<td style="text-align:center" aling="center">';


            switch (data.detalle[i].claveEstatus) {

                case "EN_PROCESO":
                    cadena += data.detalle[i].cantidadImpresos+" "+ boleto_impreso + " " + data.detalle[i].cantidadEstacionamientos+ " " + boleto_Estacionamiento+" "+  boleto_adjunto + "<br/>";
                    cadena += estatus_proc + " " + ((data.detalle[i].fechaactualizacion===null)?data.detalle[i].fechaCreacion:data.detalle[i].fechaactualizacion);
                    break;
                case "ACEPTADA":
                    cadena += data.detalle[i].cantidadImpresos+" "+ boleto_impreso + " " + data.detalle[i].cantidadEstacionamientos+ " " + boleto_Estacionamiento+" "+  boleto_adjunto + "<br/>";
                    cadena += estatus_acep + " " + ((data.detalle[i].fechaactualizacion===null)?data.detalle[i].fechaCreacion:data.detalle[i].fechaactualizacion);
                    break;
                case "DECLINADA":
                    cadena += estatus_dec + " <br/>" + ((data.detalle[i].fechaactualizacion===null)?data.detalle[i].fechaCreacion:data.detalle[i].fechaactualizacion);
                    break;
                case "CANCELADA":
                    cadena += estatus_can + " <br/>" + ((data.detalle[i].fechaactualizacion===null)?data.detalle[i].fechaCreacion:data.detalle[i].fechaactualizacion);
                    break;
                case "CANCELADO":
                    cadena += data.detalle[i].cantidadCancelados+" "+ boleto_cancelado + " " + data.detalle[i].cantidadEstacionamientos+ " " + boleto_Estacionamiento + "<br/>";
                    cadena += ((data.detalle[i].fechaactualizacion===null)?data.detalle[i].fechaCreacion:data.detalle[i].fechaactualizacion);
                    break;
                case "FINALIZADA":
                    cadena += data.detalle[i].cantidadImpresos+" "+ boleto_impreso + " " + data.detalle[i].cantidadEstacionamientos+ " " + boleto_Estacionamiento+" "+ boleto_enviado + "<br/>";
                    cadena += estatus_fin + " " + ((data.detalle[i].fechaactualizacion===null)?data.detalle[i].fechaCreacion:data.detalle[i].fechaactualizacion);
                    break;
                case "POR_IMPRIMIR_RESERVACION":
                case "RESERVADO_IMPRESO":
                case "IMPRESO":
                    cadena += data.detalle[i].cantidadImpresos+" "+ boleto_impreso + " " + data.detalle[i].cantidadEstacionamientos+ " " + boleto_Estacionamiento +" "+impreso + "<br/>";
                    cadena += ((data.detalle[i].fechaactualizacion===null)?data.detalle[i].fechaCreacion:data.detalle[i].fechaactualizacion);
                    break;
                default:
                    cadena += data.detalle[i].cantidadImpresos+" "+ boleto_impreso + " " + data.detalle[i].cantidadEstacionamientos+ " " + boleto_Estacionamiento+" "+impreso + "<br/>";
                    cadena += data.detalle[i].claveEstatus + estatus_fin + " " + ((data.detalle[i].fechaactualizacion===null)?data.detalle[i].fechaCreacion:data.detalle[i].fechaactualizacion);
                    break;
            }

            cadena += '</td>'
                    + "<td style='text-align:center' aling='center'>";

            switch (data.detalle[i].claveEstatus) {

                case "EN_PROCESO":
                    cadena += "<a href='#' class='highlightit' onClick='detalleEvento.preguntaAccion(" + data.detalle[i].transaccionId + ",3,0)'><img src='/SuperBoletosRepositorio/suites/assets/CancelarInvitacion.png' alt='[Cancelar invitaci&oacute;n]' /> <span> Cancelar </span></a><br/>";
                    cadena += "<a href='#' class='highlightit' onClick='detalleEvento.preguntaAccion(" + data.detalle[i].transaccionId + ",4,1)'><img src='/SuperBoletosRepositorio/suites/assets/ReenviarInvitacion.png' alt='[Reenviar invitaci&oacute;n]' /> <span> Reenviar </span></a>";
                    break;
                case "ACEPTADA":
                    cadena += "<a href='#' class='highlightit' onClick='detalleEvento.preguntaAccion(" + data.detalle[i].transaccionId + ",2,0)'><img src='/SuperBoletosRepositorio/suites/assets/EnviarBoletos.png' alt='[Enviar Boletos]' /> <span> Enviar Boletos </span></a><br/>";
                    cadena += "<a href='#' class='highlightit' onClick='detalleEvento.preguntaAccion(" + data.detalle[i].transaccionId + ",3,0)'><img src='/SuperBoletosRepositorio/suites/assets/CancelarInvitacion.png' alt='[Cancelar invitaci&oacute;n]' /> <span> Cancelar </span></a>";
                    break;
                case "DECLINADA":
                    break;
                case "CANCELADA":
                case "CANCELADO":
                case "IMPRESO":
                    break;
                case "FINALIZADA":
                    cadena += "<a href='#' class='highlightit' onClick='detalleEvento.preguntaAccion(" + data.detalle[i].transaccionId + ",2,1)'><img src='/SuperBoletosRepositorio/suites/assets/ReenviarBoletos.png' alt='[Reenviar Boletos]' /> <span> Re-enviar </span></a>";
                    break;
                default:
                    cadena += "<a class='highlightit' href='" + baseRep + "/templateSB2/pah/suite/pdfGenerados/boletosPAH_" + data.detalle[i].transaccionId + ".pdf'><img src='/SuperBoletosRepositorio/suites/assets/Ver.png' alt='[Ver]' /> <span> Ver </span></a>";
                    break;
            }
            cadena += '</td>'
                    + '</tr>';
        }

        $("#contTablaInvitacion").html(cadena);
        desbloquear();
    },
    actualizarInitacion: function(respuesta, transferencia, estatus, reenvio) {

        if (respuesta.toUpperCase() === "NO")
            return;

        dwrEvento.actualizarInvitacionDetalle(Aes.Ctr.encrypt(transferencia + "", "x", 1), estatus, reenvio === 1 ? true : false, {
            callback: function(data) {
                switch (data) {
                    case 0:
                        mensajeError(error, sesion_);
                    break;
                    case 1:
                        mensaje(informacion, renvioinvita);
                        break;
                    case 2:
                        mensaje(informacion, invitacion_insuficientesLugares);
                        break;
                    case 3:
                    case 4:
                    case 5:
                        mensaje(informacion, noGeneradosBoletos);
                        break;
                    case -1:
                        mensaje(informacion, errorInterno);
                        break;
                    case -3:
                        mensaje(informacion, invitacion_noRechazar);
                        break;
                    case -4:
                        mensaje(informacion, invitacion_noFinalizar);
                        break;
                    case -5:
                        mensaje(informacion, invitacion_noCancelar);
                        break;
                }
                detalleEvento.obtenerResumen();
            },
            preHook: function() {
                bloquear();
            },
            postHook: function() {
            }

        });
    },
    preguntaAccion: function(transferencia, estatus, reenvio) {


        var msg = "";

        if (estatus === 3 && reenvio === 0)
            msg = msgInvitacionCancelar;

        if (estatus === 4 && reenvio === 1)
            msg = msgInvitacionReenviar;

        if (estatus === 2 && reenvio === 0)
            msg = msgInvitacionAceptar;

        if (estatus === 2 && reenvio === 1)
           msg = msgBoletosReenviar_;

        //cambiarEstatusUsuario.replace("XX", nombre).replace("YY", (estatus === 5 ? inactivo : activo))
        mensajeBttnCallParametros(confirmacion, msg, detalleEvento.actualizarInitacion, transferencia, estatus, reenvio);


    },
    mostrarInvitaciones: function() {
        if ($("#selectEstatus").val() === "") {
            $("#contTablaInvitacion tr").slideDown("fast");
        } else {
            $("#contTablaInvitacion tr").slideUp("fast");
            $("#contTablaInvitacion tr[name='" + $("#selectEstatus").val() + "']").slideDown("fast");
        }

    },autocomplete:function(){
          var countries = new Bloodhound({
            datumTokenizer: Bloodhound.tokenizers.whitespace,
            queryTokenizer: Bloodhound.tokenizers.whitespace,
            // url points to a json file that contains an array of country names, see
            // https://github.com/twitter/typeahead.js/blob/gh-pages/data/countries.json
            prefetch: '../invitados.do',
            remote: {
              url: '../invitados.do',
              wildcard: '%QUERY'
            }
          });

        $('#inptNombre').typeahead(null, {
           name: 'invitadosString',
            display: 'invitadosString',
            source: countries
//           name: 'invitados',
//            remote: {
//                url: 'http://localhost:8400/Suites/invitados.do',
//                dataType: 'json',
//            }
          });        
    },
    help:function(data){
        switch(data){
            case 1:
                window.open(baseRep + "/suites/manuales/Guia_rapida_Suites_ImpresionBoletos2.pdf", '_blank');
                break;
            case 2:
                window.open(baseRep + "/suites/manuales/Guia_rapida_Suites_Invitar.pdf", '_blank');
                break;
        }
    }

};

