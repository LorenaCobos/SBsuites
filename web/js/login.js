//------------------------------------------------------------------------------
/**
 * Funcion de inicio general
 * @returns {undefined}
 */
function inicioGeneral() {
   window.location.hash="no-back-button";	
   window.location.hash="Again-No-back-button"; //chrome
   window.onhashchange=function(){window.location.hash="no-back-button";};
  if(history.forward(1))
  {
     history.replace('/Suites/login.do'); 
    location.replace(history.forward(1));
  }
    login.validaciones();
    login.listeners();
}
//------------------------------------------------------------------------------
/**
 * Funciones de pantalla
 * @param {type} event
 * @returns {undefined}
 */

var login = {
    listeners: function() {

        $("#button").click(function(event) {
            event.preventDefault();
            login.ingresar();
        });
        $("#usuarioLnk").click(function(event) {
            event.preventDefault();
            login.recuperarUsuario(0);
        });
        $("#pwdLnk").click(function(event) {
            event.preventDefault();
            login.recuperarUsuario(1);
        });

        $("#password").keypress(function(event) {
            if (event.keyCode === 13) {
                login.ingresar();
            }
        });
        $("#amSuite").click(function(event) {
            event.preventDefault();
            login.seleccionSuite(2);
        });
        $("#acmxSuite").click(function(event) {
            event.preventDefault();
            login.seleccionSuite(1);
        });
         $("#buttonRecinto").click(function(event) {
            event.preventDefault();
            var recinto = $("#selectRecinto" ).val();
            if (recinto === "1" || recinto === "2") {
                 login.seleccionSuite(recinto);
            }
           
        });


    },
    validaciones: function() {

        $("#formLogin").validate({
            rules: {
                textfield: {
                    required: true,
                    minlength: 4,
                    xss: true
                },
                password: {
                    required: true,
                    minlength: 4,
                    xss: true
                }
            }
        });
    },
    validarUsuario_key: function(event) {

        var a;
        if (event.charCode) {
            a = event.charCode;
        }
        else {
            a = event.keyCode;
        }

        if (event.keyCode === 13) {
            login.ingresar();
        }
    },
    seleccionSuite: function(valor) {
        setCookie('opcion', valor, 365);
        dwrLogin.seleccionSuite(valor,
                {
                    callback: function(data) {
                        switch (data) {
                           case 0:
                              location.href = "/Suites/logout.do";   
                            break;
                            break;
                            case null:
                            case -1:
                            case -2:
                                mensajeError(error, errorInterno);
                                break;
                            default:
                                bloquear();
                                //navaegacion("login");
                                login.operacionInicial(data);
                                break;
                        }
                    },
                    preHook: function() {
                        bloquear();
                    },
                    postHook: function() {
                    }
                });
    },
    ingresar: function() {
        if ($("#formLogin").valid()) {
            dwrLogin.validaUsuario(Aes.Ctr.encrypt($("#textfield").val(), "x", 0), Aes.Ctr.encrypt(hex_sha1($("#password").val()), "y", 0),
                    {
                        callback: function(data) {
                            switch (data) {
                                case null:
                                    mensajeError(invalido, no_existe_usuario);
                                    break;
                                case -1:
                                    mensajeError(error, errorInterno);
                                    break;
                                case -2:
                                    mensajeError(invalido, usuarioSinPermisos);
                                    break;
                                default:
                                    bloquear();
                                    //login.operacionInicial(data);
                                    navaegacion("seleccionSuite");
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
        }

    },
    recuperarUsuario: function(tipo) {
        recuperarUsuario(tipo);
    },
    reenviarInfo: function(dato, tipo) {
        dwrLogin.recuperarUsuario(Aes.Ctr.encrypt(dato, "x", 0), Aes.Ctr.encrypt(tipo + "", "x", 0),
                {
                    callback: function(data) {
                        switch (data) {
                            case null:
                            case -2:
                                mensajeError(invalido, no_existe_usuario);
                                break;
                            case -1:
                                mensajeError(error, errorInterno);
                                break;
                            case -3:
                                mensajeError(invalido, correoRepetido);
                                break;
                            case -4:
                                mensajeError(invalido, usuarioSinPermisos);
                                break;
                            default:
                                mensaje(informacion, mensajeEnvio);
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
    operacionInicial: function(data) {
        dwrLogin.getModuloOperInicial({
            callback: function(data) {
                if (data === null || data.urlMenuLateral === '') {
                    mensajeError(error, errorInterno);
                } else {
                    var form = $("<form/>", {
                        action: baseNormal + data.urlMenuLateral,
                        id: 'formInicio',
                        method: 'GET'
                    });
                    $("#contForm").html("");
                    $("#contForm").append(form);
                    $("#formInicio").submit();
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
    validacionOpcion:function(){
        $("#contenido").attr("style","max-width:1100px;");
        if(getCookie("opcion")!==null&&getCookie("opcion")!==""){
            login.seleccionSuite(getCookie("opcion"));
        }
    }
};

