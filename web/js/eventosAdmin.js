var ids = "";
var files;
var evento = "";
var flagUpload = false;

function inicioGeneral() {
    eventos.cargaInicial();

}

var eventos = {
    cargaInicial: function() {
        $("#txtFechaInicio").datepicker({changeMonth: true, dateFormat: 'dd/mm/yy',
            changeYear: true,
            showButtonPanel: true,
            closeText: 'Limpiar',
            onClose: function(dateText, inst) {
                if ($(window.event.srcElement).hasClass('ui-datepicker-close'))
                {
                    document.getElementById(this.id).value = '';
                }
            }});
        $("#txtFechaFin").datepicker({changeMonth: true, dateFormat: 'dd/mm/yy',
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
        $("#buttonBuscar").click(function(event) {
            event.preventDefault();
            eventos.obtenerEventos();
        });

        $("#buttonLimpiar").click(function(event) {
            $("#selectRecinto").val(0);
            $("#textfieldEvento").val("");
            $("#txtFechaInicio").val("");
            $("#txtFechaFin").val("");
            $("#select").val(0);
        });


    },
    obtenerEventos: function() {
        dwrEvento.getSuitesPresentaciones(Aes.Ctr.encrypt($("#selectRecinto").val(), "", 1), Aes.Ctr.encrypt($("#textfieldEvento").val(), "", 1),
                Aes.Ctr.encrypt($("#select").val(), "", 1), Aes.Ctr.encrypt($("#txtFechaInicio").val(), "", 1), Aes.Ctr.encrypt($("#txtFechaFin").val(), "", 1),
                {
                    callback: function(data) {
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
                    preHook: function() {
                        bloquear();
                    },
                    postHook: function() {
                        desbloquear();
                    }
                });
    },
    construirTabla: function(data) {
        var cadena = "";
        for (var i = 0; i < data.length; i++) {
            
            cadena += '<tr>'
                    + '<td style="text-align:center; width:40%" aling="center">'            


                        +  '<div>'
                            +  '<div class="col-md-5">'
                                    + '<img id="imgT" style="max-height: 130px;min-height: 130px; max-width:150px;min-width:150px;"'
                                    + 'src="../assets/img/Evento_29445_L.jpg"/>'

                            +  '</div>'
                            +  '<div class="col-md-7">'
                                +  '<div style="padding-top: 10px">'
                                    +  '<div><label class="label-evento-panel">' + data[i].evento + '</label></div>'
                                    +  '<div> <i class="fa fa-calendar-o"></i><label>' + data[i].fechaPresentacion + '</label></div>'
                                +  '</div>'

                            +  '</div>'
                        +  '</div>'

            
                    + '</td>'
            
            
                    + '<td style="text-align:center;" class="hidden-xs" aling="center">'

                        +  '<div>'
                            +  '<div class="col-md-5">'
                                    + '<img id="imgE' + data[i].presentacionId + '" style="max-height: 130px;min-height: 130px; max-width:150px;min-width:150px;"'
                                    + 'src="' + inicioHttp + (data[i].ruta==null?"/SuperBoletosRepositorio/suites/estacionamientos/BoletoSuite_Parking_Generico.jpg":data[i].ruta) + '"/>'/*'src="../assets/img/Evento_29445_L.jpg"/>'*/

                            +  '</div>'
                            +  '<div class="col-md-6" style="padding-top: 50px">'
                                + '<form id="form' + data[i].presentacionId + '" method="GET" action="../uploadFile" enctype="multipart/form-data">'
                                + '<div><input type="file" id="imgInp' + data[i].presentacionId + '" /></div>'
                                + '<div><input type="hidden" id="InpHid' + data[i].presentacionId + '" value="' + data[i].eventoId + '" /></div>'
                                + '<input type="hidden" id="fechaHid' + data[i].presentacionId + '" value="' + data[i].fechaPresentacion + '" />'
                                + '<input type="hidden" id="preHid' + data[i].presentacionId + '" value="' + data[i].presentacionId + '" />'
                                //+ '<div style="padding-top:15px;"><input type="submit" id="submt'+ data[i].presentacionId+'" disabled value="Subir"></div>'
                                + '<div style="padding-top:15px;"><button type="submit" name="submt" id="submt'+ data[i].presentacionId+'" disabled value="Subir" class="button btn-default ">Subir</button></div>'
                                + '</form>'
                            +  '</div>'
                        +  '</div>'
  
                    + '</td>'
            
              + '<td style="text-align:center" aling="center">'
                    + (data[i].estatusId === 5 ? "<input type='checkbox' name='savePresentationChk' id='" + data[i].presentacionId + "' checked onClick='eventos.cambiarEstatus(" + data[i].presentacionId + "," + data[i].estatusId + ",\"" + data[i].evento + "\")'>" :
                            "<input type='checkbox' id='" + data[i].presentacionId + "' name='savePresentationChk' onClick='eventos.cambiarEstatus(" + data[i].presentacionId + "," + data[i].estatusId + ",\"" + data[i].evento + "\")'>")
                    + '</td>'
                    + '</tr>';
            
     

            /*cadena += '<tr>'
                    + '<td style="text-align:center" aling="center">'
                    + '<b>' + data[i].evento + '</b>'
                    + '</td>'
                    + '<td style="text-align:center" aling="center" colspan="3">'
                    + data[i].fechaPresentacion
                    + '</td>'
                    + '</tr>'
                    + '<tr>'
                    + '<td style="text-align:center;" class="hidden-xs" aling="center">'
                    + '<img id="imgT" style="max-height: 130px;min-height: 130px; max-width:207px;min-width:207px;"'
                    + 'src="' +eventos.UrlExists(inicioHttp + "/SuperBoletosRepositorio/thumbnails/Evento_" + data[i].eventoId + "_T.jpg" )+ '"/>'
                    
                    + '</td>'
                    + '<td style="text-align:center;" class="hidden-xs" aling="center">'
                    + '<img id="imgE' + data[i].presentacionId + '" style="max-height: 130px;min-height: 130px; max-width:207px;min-width:207px;" src="' + inicioHttp + (data[i].ruta==null?"/SuperBoletosRepositorio/suites/estacionamientos/BoletoSuite_Parking_Generico.jpg":data[i].ruta) + '"/>'
                    + '<form id="form' + data[i].presentacionId + '" method="GET" action="../uploadFile" enctype="multipart/form-data">'
                    + '<input type="file" id="imgInp' + data[i].presentacionId + '" />'
                    + '<input type="hidden" id="InpHid' + data[i].presentacionId + '" value="' + data[i].eventoId + '" />'
                    + '<input type="submit" id="submt'+ data[i].presentacionId+'" disabled value="Subir">'
                    + '</form>'
                    + '</td>'
                    + '<td style="text-align:center" aling="center">'
                    + (data[i].estatusId === 5 ? "<input type='checkbox' name='savePresentationChk' id='" + data[i].presentacionId + "' checked onClick='eventos.cambiarEstatus(" + data[i].presentacionId + "," + data[i].estatusId + ",\"" + data[i].evento + "\")'>" :
                            "<input type='checkbox' id='" + data[i].presentacionId + "' name='savePresentationChk' onClick='eventos.cambiarEstatus(" + data[i].presentacionId + "," + data[i].estatusId + ",\"" + data[i].evento + "\")'>")
                    + '</td>'
                    + '</tr>';*/

        }
        $("#contTabla").html(cadena);
        eventos.preview();
        eventos.submit();
        recorrerPermisos();
        desbloquear();
    },
    irDetalle: function(evento) {
        bloquear();
        eventos.irDetalleForm(evento);

    },
    cambiarEstatus: function(evento, estatus, nombre) {
        mensajeBttnCallParametros(confirmacion, cambiarEstatusEvento.replace("XX", nombre).replace("YY", (estatus === 5 ? inactivo : activo)), eventos.confirmacionEstatus, evento, estatus);
    },
    confirmacionEstatus: function(resul, param, param2) {
        if (resul === si_n) {
            dwrEvento.cambiarEstatusPresentacion(Aes.Ctr.encrypt(param.toString(), "", 1), Aes.Ctr.encrypt(param2.toString(), "", 1),
                    {
                        callback: function(data) {
                            switch (data) {
                                  case 0:
                                    mensajeError(error, sesion_);
                                break;
                                case null:
                                 mensajeError(error, sesion_);
                                break;
                                case -1:
                                    mensajeError(error, errorInterno);
                                    break;
                                default:
                                    $("#buttonBuscar").click();
                                    break;
                            }
                        },
                        preHook: function() {
                            bloquear();
                        },
                        postHook: function() {
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
    irDetalleForm: function(evento) {
        var form = $("<form/>", {
            action: baseNormal + "/s/detalleEventoAdmin.do",
            id: 'formInicio',
            method: 'POST'
        });

        form.append(
                $("<input/>",
                        {
                            type: 'hidden',
                            name: 'suite',
                            value: $.trim(evento)
                        }
                )
                );
        $("#contForm").html("");
        $("#contForm").append(form);
        $("#formInicio").submit();
    },
    preview: function() {
        $("input[id*='imgInp']").change(function(id, name) {
            ids = id.srcElement.id.replace("imgInp", "");
            files = id.target.files;
            evento = $("#InpHid" + ids).val();
            fecha = $("#fechaHid" + ids).val();
            presentacion =$("#preHid" + ids).val();
            if(eventos.fileSizeKb(id.target.files[0].size,ids)){
                mensajeError(error, pesoImagenError);
            }else{
                readURL(this);
            }
            
        });
    }, submit: function() {
        $("form[id*='form']").on('submit', uploadFiles);
    },
    saveFile:function(){
        var ext = files[0].name.substr(files[0].name.lastIndexOf('.'),files[0].name.length);  
        // dwrEvento.saveArchivo( 0,    "Evento_"+evento+ext ,  evento,
         var nombre="Evento_"+evento+"_"+fecha;
        nombre =nombre.replace(" ","_").replace("/","_").replace("/","_").replace(":","_");
        //alert(evento+"==="+nombre);
        dwrEvento.saveArchivo( 0, nombre+ext/*"Evento_"+evento*/ ,  presentacion,
                    {
                        callback: function(data) {
                            
                            switch (data) {
                                 case 0:
                                    mensajeError(error, sesion_);
                                    break;
                                case null:
                                case -1:
                                    mensajeError(error, errorInterno);
                                    break;
                                default:
                                     mensaje(error, guardadoExito);
                                    break;
                            }
                        },
                        preHook: function() {
                            bloquear();
                        },
                        postHook: function() {
                            desbloquear();
                        }

                    }
            );
    },
    UrlExists:function(url) {
       if(url){
        var req = new XMLHttpRequest();
        req.open('GET', url, false);
        req.send();
        if(req.status===200){
           return url; 
        }else{
           return inicioHttp+"/SuperBoletosRepositorio/suites/estacionamientos/nd.png";
        }
        
    } else {
        return inicioHttp+"/SuperBoletosRepositorio/suites/estacionamientos/nd.png";
    } 
        
    },fileSizeKb:function(file,id){
      var iSize = (file/ 1024); 
      iSize = (Math.round(iSize * 100) / 100)
      flagUpload = iSize>50; 
      console.log(iSize+flagUpload);
      if(flagUpload){
         $('#submt'+id).attr('disabled')
      }else{
         $('#submt'+id).removeAttr("disabled");
          
      }
      return flagUpload;
    }
};


function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
            $('#imgE' + ids).attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

// Catch the form submit and upload the files
function uploadFiles(event)
{
    event.stopPropagation(); // Stop stuff happening
    event.preventDefault(); // Totally stop stuff happening

    // START A LOADING SPINNER HERE

    // Create a formdata object and add the files
    if(evento===""){
        return;
    }else{
        
    }

    var oMyForm = new FormData();
    oMyForm.append("file", files[0]);
    oMyForm.append("id", evento);

    $.ajax({
        //url: baseNormal + '/upload.do',
        url:'http://10.19.0.193:8080/Suites/upload.do',
        data: oMyForm,
        dataType: 'text',
        processData: false,
        contentType: false,
        type: 'POST',
        success: function(data) {
           // $('#imgE' + ids).attr("src", data);
            eventos.saveFile();
        },
        error:function(data){
            console.log(data);
            mensajeError(error, errorInterno);
        }
    });
}
