function inicioGeneral() {
    detalleSuite.cargaInicial();
     validacionvigencia();
}
function validacionhorarios(fechainicio,fechafin)
{
     var x= new Date();
      var y= new Date();
      var fechainicio = dateinicio.split("/");
      var fechafin = datefin.split("/");
      x.setFullYear(fechainicio[2],fechainicio[1]-1,fechainicio[0]);
      y.setFullYear(fechafin[2],fechafin[1]-1,fechafin[0]);
      y>=x?mensajeError(error, horario_):mensajeError(error, horario);
}
function validacionvigencia()
{
     if($("#selectAplicaVigencia").val() === "1")
            {
                $("#lblFechaInicio").show();
                $("#lblFechaFin").show();
                $("#txtFechaInicio").show();
                $("#txtFechaFin").show();

                $("#txtFechaInicio").rules("add", {
                    required: true,
                    minlength: 8,
                    xss: true
                });
                $("#txtFechaFin").rules("add", {
                    required: true,
                    minlength: 8,
                    xss: true
                });
            }
            else
            {
                $("#lblFechaInicio").hide();
                $("#lblFechaFin").hide();
                $("#txtFechaInicio").hide();
                $("#txtFechaFin").hide();
                $("#txtFechaInicio").rules("remove");
                $("#txtFechaFin").rules("remove");


            }
}

var detalleSuite = {
    cargaInicial: function () {
        var dateinicio=$("#txtFechaInicio").val();
        var datefin;
       $("#txtFechaInicio").datepicker({changeMonth: true,dateFormat: 'dd/mm/yy',
            changeYear: true, onSelect: function(textoFecha, objDatepicker)
            {
                datefin=$("#txtFechaFin").val();
                dateinicio=textoFecha;
                var z= new Date();
                var w= new Date();
                var fechainicio = dateinicio.split('/');
                var fechafin = datefin.split('/');
                z.setFullYear(fechainicio[2],fechainicio[1]-1,fechainicio[0]);
                w.setFullYear(fechafin[2],fechafin[1]-1,fechafin[0]);
                if(w<=z){mensajeError(error, horario);$("#txtFechaFin").val("")};
            }});
        $("#txtFechaFin").datepicker({changeMonth: true,dateFormat: 'dd/mm/yy',
            changeYear: true,onSelect: function(textoFecha, objDatepicker)
            {
                dateinicio=$("#txtFechaInicio").val();
                datefin=textoFecha;
                var x= new Date();
                var y= new Date();
                var fechainicio = dateinicio.split('/');
                var fechafin = datefin.split('/');
                x.setFullYear(fechainicio[2],fechainicio[1]-1,fechainicio[0]);
                y.setFullYear(fechafin[2],fechafin[1]-1,fechafin[0]);
                if(y<=x){mensajeError(error, horario);$("#txtFechaFin").val("")};
            }});
        $("#buttonGuardar").click(function (event) {
            event.preventDefault();
            detalleSuite.guardarSuite();
        });

        $("#buttonCancelar").click(function (event) {
            event.preventDefault();
            detalleSuite.cancelar();
        });

        $("#buttonRegresar").click(function (event) {
            event.preventDefault();
            navaegacion('suites');
        });

        $("#lblFechaInicio").hide();
        $("#lblFechaFin").hide();
        $("#txtFechaInicio").hide();
        $("#txtFechaFin").hide();

        $("#selectAplicaVigencia").change(function () {
            
            $("label[for='txtFechaInicio']").hide();
            $("label[for='txtFechaFin']").hide();
             validacionvigencia();
            
        });
        detalleSuite.obtenerEstacionamientos();
        detalleSuite.validaciones();
    },
    validaciones: function () {

        $("#formSuite").validate({
            rules: {
                selectTipoContrato: {
                    required: true,
                    selectNoneDireccion: true
                },
                selectAplicaVigencia: {
                    required: true,
                    selectNoneDireccion: true
                },
                selectSeccion: {
                    required: true,
                    selectNoneDireccion: true
                },
                textfieldNombre: {
                    required: true,
                    minlength: 3,
                    xss: true
                },
                textfieldSuiteHabiente: {
                    required: true,
                    minlength: 4,
                    xss: true
                },
                txtTelefono: {
                    required: true,
                    minlength: 8,
                    xss: true
                },
                txtEmail: {
                    required: true,
                    minlength: 8,
                    email: true,
                    xss: true
                },
                txtDireccion: {
                    required: false,
                    minlength: 10,
                    xss: true
                },
                txtObservaciones: {
                    required: false,
                    minlength: 4,
                    xss: true
                },
                selectEstacionamiento: {
                    required: true,
                    selectNoneDireccion: true
                },
                textfieldestacionamiento: {
                    required: true,
                    number: true,
                    xss: true
                }
            }
        });
    },
  
    cancelar: function () {
        dwrSuite.getSuite(Aes.Ctr.encrypt($("#suiteId").val(), "", 1),
                {
                    callback: function (data) {
                        switch (data) {
                            case null:
                            case -1:
                                mensajeError(error, errorInterno);
                                break;
                            default:
                                bloquear();
                                detalleSuite.restaurarInformacion(data);
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
    },
    restaurarInformacion: function (data) {
        $("#textfieldNombre").val(data.nombre);
        $("#textfieldSuiteHabiente").val(data.suiteHabiente);
        $("#txtFechaInicio").val(data.vigenciaInicio);
        $("#txtFechaFin").val(data.vigenciaFin);
        $("#select").val(data.estatusId);
        $("#txtTelefono").val(data.telefono);
        $("#txtEmail").val(data.email);
        $("#txtDireccion").val(data.direccion);
        $("#txtObservaciones").val(data.observaciones);

        $("#selectTipoContrato").val(data.tipoContrato);
        $("#selectCantidadEventos").val(data.cantidadEventos);
        $("#selectTipoEvento").val(data.tipoEvento);
        $("#selectAplicaVigencia").val(data.aplicaVigencia);
        $("#selectEstacionamiento").val(data.estacionamientoId);
        $("#textfieldestacionamiento").val(data.cantidadEstacionamiento);
        if ($("#selectAplicaVigencia").val() === "1")
        {
            $("#txtFechaInicio").show();
            $("#txtFechaFin").show();
        }
        else
        {
            $("#txtFechaInicio").hide();
            $("#txtFechaFin").hide();
        }
         $("#estacionamientoIdHdn").val(data.estacionamientoId);
        desbloquear();
    }, guardarSuite: function () 
    {

        if ($("#formSuite").valid()) {
            suiteEnt = new suiteEntidad();
            suiteEnt.seccionUbicacionId = parseInt($("#selectSeccion").val());
            suiteEnt.nombre = $("#textfieldNombre").val();
            suiteEnt.direccion = $("#txtDireccion").val();
            suiteEnt.telefono = $("#txtTelefono").val();
            suiteEnt.email = $("#txtEmail").val();
            suiteEnt.vigenciaInicio = $("#txtFechaInicio").val();
            suiteEnt.vigenciaFin = $("#txtFechaFin").val();
            suiteEnt.observaciones = $("#txtObservaciones").val();
            suiteEnt.seccionId = parseInt($("#selectSeccion").val());
            suiteEnt.suiteHabiente = $("#textfieldSuiteHabiente").val();
            suiteEnt.estatusId = $("#select").val() === 'ACTIVO' ? 5 : 6;

            suiteEnt.tipoContrato = $("#selectTipoContrato").val();
            suiteEnt.cantidadEventos = $("#selectCantidadEventos").val();
            suiteEnt.tipoEvento = $("#selectTipoEvento").val();
            suiteEnt.aplicaVigencia = $("#selectAplicaVigencia").val();
            suiteEnt.estacionamientoId = $("#selectEstacionamiento").val();
            suiteEnt.cantidadEstacionamiento = $("#textfieldestacionamiento").val();
            
            dwrSuite.saveSuite(suiteEnt,
                    {
                        callback: function (data) {
                            switch (data) {
                                case 0:
                                    mensajeError(error, sesion_);
                                break; 
                                case -1:
                                    mensajeError(error, errorInterno);
                                break;
                                case -2:
                                    mensajeError(error, errorEstacionamientoNoValido);
                                break;
                                default:
                                    $("#suiteId").val(data);
                                    $("#buttonCancelar").click();
                                    mensaje(informacion, guardadoExito);
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
        }
    }, obtenerEstacionamientos:function(){
        
        dwrSuite.getEstacionaminetos(Aes.Ctr.encrypt($("#suiteId").val(), "", 1),
                {
                    callback: function (data) {
                        switch (data) {
                            case null:
                            case -1:
                                mensajeError(error, errorInterno);
                                break;
                            default:
                                var obj =document.getElementById("selectEstacionamiento");
                                dwr.util.removeAllOptions(obj);
                               if(data!==null||data!==''){
                                    dwr.util.addOptions("selectEstacionamiento", data, 'id', 'nombreCompleto');
                                    $("#selectEstacionamiento").val($("#estacionamientoIdHdn").val());
                                }else{
                                     dwr.util.addOptions("selectSuite", [{id:'0',nombreCompleto:'Seleccione'}], 'id', 'nombreCompleto');
                                }
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
    }

};

