function inicioGeneral() {
    eventos.cargaInicial();
}

var eventos = {
    cargaInicial: function () {
        $("#txtFechaInicio").datepicker({changeMonth: true,dateFormat: 'dd/mm/yy',
            changeYear: true,
            showButtonPanel: true,
            closeText: 'Limpiar',
            onClose: function(dateText, inst) {
                if ($(window.event.srcElement).hasClass('ui-datepicker-close'))
                {
                    document.getElementById(this.id).value = '';
                }
            }});
        $("#txtFechaFin").datepicker({changeMonth: true,dateFormat: 'dd/mm/yy',
            changeYear: true,
            showButtonPanel: true,
            closeText: 'Limpiar',
            onClose: function(dateText, inst) {
                if ($(window.event.srcElement).hasClass('ui-datepicker-close'))
                {
                    document.getElementById(this.id).value = '';
                }
            }});
        $('<style type="text/css"> .ui-datepicker-current { display: none; } </style>').appendTo("head");
        $("#buttonBuscar").click(function (event) {
            event.preventDefault();
            eventos.obtenerEventos();
        });
        
        $("#selectRecinto").change(function (event) {
            event.preventDefault();
           if($("#selectRecinto").val()===0||$("#selectRecinto").val()==='0'){
                var obj =document.getElementById("selectSuite");
                dwr.util.removeAllOptions(obj);
                dwr.util.addOptions("selectSuite", [{id:'0',nombreCompleto:'Seleccione'}], 'id', 'nombreCompleto');
           }else{
                bloquear();
               dwrEvento.getSuitesUsuario($("#selectRecinto").val(),0,eventos.getSuitesUsuarioCall);
           }
            
        });
         $("#buttonLimpiar").click(function(event) {
            $("#selectRecinto").val(0);
            $("#selectRecinto").change();
            $("#textfieldEvento").val("");
            $("#txtFechaInicio").val("");
            $("#txtFechaFin").val("");
            $("#divEventos").html("");
        });

        event.preventDefault();
        eventos.obtenerEventos();


    },
    getSuitesUsuarioCall : function(data){
        desbloquear()
        if(data!==null||data!==''){
            var obj =document.getElementById("selectSuite");
                dwr.util.removeAllOptions(obj);
                dwr.util.addOptions("selectSuite", data, 'id', 'nombreCompleto');
        }
    },
    obtenerEventos: function () {
        
        if($("#selectSuite").val()!==null&&$("#selectRecinto").val()!==null){
        dwrEvento.getSuitesPresentacionesUsuario(
                Aes.Ctr.encrypt($("#selectRecinto").val(), "", 1),
                Aes.Ctr.encrypt($("#textfieldEvento").val(), "", 1),
                Aes.Ctr.encrypt($("#txtFechaInicio").val(), "", 1),
                Aes.Ctr.encrypt($("#txtFechaFin").val(), "", 1),
                Aes.Ctr.encrypt($("#selectSuite").val(), "", 1),        
                        {
                            callback: function (data) {
                                switch (data) {
                                    case null:
                                       mensajeError(error, sesion_);
                                        break;
                                    default:
                                        bloquear();
                                        eventos.construirTabla(data);
                                        break;
                                }
                            },
                            preHook: function () {
                                bloquear();
                            },
                            postHook: function () {
                                desbloquear();
                            }
                        });
                    }
            },
    construirTabla: function (data) {
        var cadena = "";
        var cadenaR = "";
        
        for (var i = 0; i < data.length; i++) {
            
            
            
            cadenaR += '<div class="panel row panel-horizontal panel-info" id="evento' + data[i].eventoId + '">'
                        +  '<div class="col-xs-5" style="text-align: center">'
                        +  '<div class="panel-heading row">'
                        +  '<div class="col-md-6">'
                        +  '<a href="#" >'
                        +  '<img id="imgT" class="img-thumbnail panel-image"' 
                                + 'src="../assets/img/Evento_29445_L.jpg"'
                                //+  'src="' + inicioHttp + '/SuperBoletosRepositorio/thumbnails/Evento_' + data[i].eventoId + '_T.jpg"'
                                + 'onClick="(eventos.irDetalle(' + data[i].eventoId + ', \'' + data[i].recinto + '\',\'' + data[i].fechaPresentacion + '\',\'' + data[i].evento + '\',' + data[i].presentacionId + ',' + data[i].lugaresDisponibles + ',' + data[i].cantidadEstacionamiento + ',' + data[i].invitaciones + ',' + data[i].estacionamientoId+',\''+ data[i].nombreSuite+ '\'))") src="' + inicioHttp + '/SuperBoletosRepositorio/thumbnails/Evento_' + data[i].eventoId + '_T.jpg' + '" alt="" class="img-thumbnail"/>'
                        +  '</a>'
                        +  '</div>'
                        +  '<div class="col-md-6">'
                        +  '<div style="padding-top: 10px">'
                        +  '<div><label class="label-evento-panel">' + data[i].evento + '</label></div>'
                        +  '<div> <i class="fa fa-calendar-o"></i><label>' + data[i].fechaPresentacion + '</label></div>'
                        +  '</div>'
                        +  '<div style="padding-top: 10px">'
                        +  '<button type="button" name="button" id="buttonBuscar" class="btn bg-mustard "'
                            +  ' onClick="(eventos.irDetalle(' + data[i].eventoId + ', \'' + data[i].recinto + '\',\'' + data[i].fechaPresentacion + '\',\'' + data[i].evento + '\',' + data[i].presentacionId + ',' + data[i].lugaresDisponibles + ',' + data[i].cantidadEstacionamiento + ',' + data[i].invitaciones + ',' + data[i].estacionamientoId + ',\''+data[i].nombreSuite+'\'))")>'
                            +  ' Ver Detalle </button>'
                        +  '</div>'
                        +  '</div>'
                        +  '</div>'
                        +  '</div>'
                        +  '<div class=" col-xs-7">'
                        +  '<div class="panel-body row">'
                        +  '<div class="col-sm-4">'
                        +  '<div class="small-box bg-aqua">'
                        +  '<div class="inner">'
                        +  '<h3>' + data[i].lugaresDisponibles + '</h3> <p>Boletos</p>'
                        +  '</div>'
                        +  '<div class="icon"><img src="../assets/img/boletos.png"></div>'
                        +  '</div>'
                        +  '</div>'
                        +  '<div class="col-sm-4">'
                        +  '<div class="small-box bg-olive">'
                        +  '<div class="inner">'
                        +  '<h3>' + data[i].cantidadEstacionamiento + '</h3> <p>Estacionamientos</p>'
                        +  '</div>'
                        +  '<div class="icon"><img src="../assets/img/estacionamientos.png"></div>'
                        +  '</div>'
                        +  '</div>'
                        +  '<div class="col-sm-4">'
                        +  '<div class="small-box bg-orange">'
                        +  '<div class="inner">'
                        +  '<h3>' + data[i].invitaciones + '</h3> <p>Invitaciones</p>'
                        +  '</div>'
                        +  '<div class="icon"><img src="../assets/img/invitaciones.png"></div>'
                        +  '</div>'
                        +  '</div>'
                        +  '</div>'
                        +  '</div>'
                        +  '</div>'   
            ;


            /*cadenaR += '<div class="panel-group col-xs-12 col-sm-6 col-md-6" id="evento' + data[i].eventoId + '">'
                        +  '<div id="evento' + data[i].eventoId + '" class="panel panel-default">'
                        +  '<div class="panel-heading"><div class="panel-heading">'
                        +  '<a data-toggle="collapse" data-parent="#evento' + data[i].eventoId + '" href="#collapseEvento' + data[i].eventoId + '">'
                        +  '<div class="row">'
                        +  '<div class="col-xs-12 col-sm-12 col-md-12 text-center" style="min-height:45px;vertical-align: middle;"><strong>'
                        +  data[i].evento
                        +  '</strong></div>'
                        +  '<div class="col-xs-12 col-sm-12 col-md-12 text-center">'
                        +  '<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>&nbsp;'
                        +  data[i].fechaPresentacion
                        +  '</div></div></a></div></div>'
                        +  '<div id="collapseEvento' + data[i].eventoId + '" class="panel-collapse collapse in">'
                        +  '<div class="panel-body"><div class="row">'
                        +  '<div class="col-xs-12 col-sm-12 col-md-12 text-center center" style="padding-top:0px; padding-bottom:15px;">'
                        +  '<a href="#" ><img id="imgT" style="max-height:130px; max-width:207px;" onClick="(eventos.irDetalle(' + data[i].eventoId + ', \'' + data[i].recinto + '\',\'' + data[i].fechaPresentacion + '\',\'' + data[i].evento + '\',' + data[i].presentacionId + ',' + data[i].estacionamientoId+',\''+ data[i].nombreSuite+ '\'))") src="' + inicioHttp + '/SuperBoletosRepositorio/thumbnails/Evento_' + data[i].eventoId + '_T.jpg' + '" alt="" class="img-thumbnail"/></a>'
                        +  '</div><div class="col-xs-12 col-sm-12 col-md-12">'
                        +  '<ul class="list-group">'
                        +  '<li class="list-group-item text-center">'
                        +  '<strong>' + data[i].recinto + '</strong> </br>'
                        +  '<strong>' + data[i].nombreSuite + '</strong>'
                        +  '</li>'
                        +  '<li class="list-group-item">'
                        +  '<span class="badge">' + data[i].lugaresDisponibles + '</span>'
                        +  boletos
                        +  '</li>'
                        +  '<li class="list-group-item">'
                        +  '<span class="badge">' + data[i].cantidadEstacionamiento + '</span>'
                        +  estacionamientos
                        +  '</li>'
                        +  '<li class="list-group-item">'
                        +  '<span class="badge">' + data[i].invitaciones + '</span>'
                        +  invitaciones
                        +  '</li>'
                        +  '<li class="list-group-item text-center">'
                        +  '<a href="#" onClick="(eventos.irDetalle(' + data[i].eventoId + ', \'' + data[i].recinto + '\',\'' + data[i].fechaPresentacion + '\',\'' + data[i].evento + '\',' + data[i].presentacionId + ',' + data[i].estacionamientoId + ',\''+data[i].nombreSuite+'\'))")>[Ir a Detalle]</a>'
                        +  '</li></ul> </div></div></div></div></div></div>';*/
    
              

            }
        
        
        $("#eventosWidget").html(cadenaR);
        
        desbloquear();
      
    },
    irDetalle: function (eventoId, recinto, fechaPresentacion, evento, presentacionId, boletos, estacionamientos, invitaciones, estacionamientoId,nombreSuite) {
        bloquear();
        eventos.irDetalleForm(eventoId, recinto, fechaPresentacion, evento, presentacionId,  boletos, estacionamientos, invitaciones, estacionamientoId,nombreSuite);

    },
    cambiarEstatus: function (evento, estatus, nombre) {
        mensajeBttnCallParametros(confirmacion, cambiarEstatusSuite.replace("XX", nombre).replace("YY", (estatus === 5 ? inactivo : activo)), eventos.confirmacionEstatus, evento, estatus);
    },
    confirmacionEstatus: function (resul, param, param2) {
        if (resul === si_n) {
            dwrEvento.cambiarEstatusPresentacion(Aes.Ctr.encrypt(param.toString(), "", 1), Aes.Ctr.encrypt(param2.toString(), "", 1),
                    {
                        callback: function (data) {
                            switch (data) {
                                case null:
                                case -1:
                                    mensajeError(error, errorInterno);
                                    break;
                                default:
                                    $("#buttonBuscar").click();
                                    break;
                            }
                        },
                        preHook: function () {
                            bloquear();
                        },
                        postHook: function () {
                            desbloquear();
                        }

                    }
            );
        } else {
            if (param2 === 5) {
                $("#" + param).prop('checked', true);
            } else {
                $("#" + param).prop('checked', false);
            }
        }

    },
    irDetalleForm: function (eventoId, recinto, fechaPresentacion, evento, presentacionId,  boletos, estacionamientos, invitaciones, estacionamientoId,nombreSuite) {
        $("#formulario").attr("action",baseNormal+"/s/detalleEvento.do");
        var formulario = $("#formulario");

        var suiteId = $("#selectSuite").val();

        formulario.append(
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'eventoId',
                            value: $.trim(eventoId),
                            id: 'eventoId'
                        }
                ),
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'evento',
                            value: $.trim(evento),
                            id: 'evento'
                        }
                ),
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'fechaPresentacion',
                            value: $.trim(fechaPresentacion),
                            id: 'fechaPresentacion'
                        }
                ),
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'presentacionId',
                            value: $.trim(presentacionId),
                            id: 'presentacionId'
                        }
                ),
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'recinto',
                            value: $.trim(recinto),
                            id: 'recinto'
                        }
                ),
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'suiteId',
                            value: $.trim(suiteId),
                            id: 'suiteId'
                        }
                ),
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'estacionamientoId',
                            value: $.trim(estacionamientoId),
                            id: 'suiteId'
                        }
                ),
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'suite',
                            value: $.trim(nombreSuite),
                            id: 'suiteId'
                        }
                ),
        
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'numeroBoletos',
                            value: $.trim(boletos),
                            id: 'numeroBoletos'
                        }
                ),
        
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'numeroEstacionamientos',
                            value: $.trim(estacionamientos),
                            id: 'numeroEstacionamientos'
                        }
                ),
        
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'numeroInvitaciones',
                            value: $.trim(invitaciones),
                            id: 'numeroInvitaciones'
                        }
                )




                );
        //$("#contForm").html("");
        //$("#formulario").append(formulario);
        $("#formulario").submit();
    }



};


