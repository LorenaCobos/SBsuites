//------------------------------------------------------------------------------
/**
 * Funcion de inicio general
 * @returns {undefined}
 */
function inicioGeneral() {
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
        
        $( "#password" ).keypress(function(event) {
            if (event.keyCode === 13){
                login.ingresar();
            }
        });
        
        /*
       $( "#password" ).keypress(function(event) {
           event.preventDefault();
           login.validarUsuario_key(event);
        });*/

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
                                    login.operacionInicial(data);
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
                            case 0:
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
                if (data === null||data.urlMenuLateral==='') {
                    mensajeError(error, errorInterno);
                } else {
                    var form = $("<form/>", {
                        action: baseNormal+ data.urlMenuLateral,
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

    }

};

