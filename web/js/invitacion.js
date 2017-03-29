function inicioGeneral() {
    $("#buttonAceptar").click(function (event) {
        event.preventDefault();
        invitacion.aceptar();
    });
    $("#buttonDeclinar").click(function (event) {
        event.preventDefault();
        invitacion.declinar();
    });
}


var invitacion = {
    init: function () {
        inicioGeneral();
    },
    aceptar: function () {
        dwrEvento.actualizarInvitacion($("#usuarioId").val(), $("#transferenciaId").val(), 1, false, {
            callback: function (data) {
                mensaje(informacion, guardadoExito);
                $("#buttonAceptar").hide();
                $("#buttonDeclinar").hide();
                window.close();
                //navaegacion("login");
            },
            preHook: function () {
                bloquear();
            },
            postHook: function () {
            }

        });
    }, declinar: function () {
        dwrEvento.actualizarInvitacion($("#usuarioId").val(), $("#transferenciaId").val(), 0, false, {
            callback: function (data) {
                mensaje(informacion, guardadoExito);
                $("#buttonAceptar").hide();
                $("#buttonDeclinar").hide();
                window.close();
                //navaegacion("login");
            },
            preHook: function () {
                bloquear();
            },
            postHook: function () {
            }

        });
    }

};
