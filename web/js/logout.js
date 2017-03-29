//------------------------------------------------------------------------------
/**
 * Funcion de inicio general
 * @returns {undefined}
 */
function inicioGeneral() {
    logout.salir();
}

var logout = {
    salir: function () {

        dwrLogin.logoutUsuario(
                {
                    callback: function () {
                        bloquear();
                        logout.operacionInicial();
                    },
                    preHook: function () {
                        bloquear();
                    },
                    postHook: function () {
                        desbloquear();
                    }
                });


    },
    operacionInicial: function () {
        dwrLogin.getModuloOperInicial({
            callback: function () {

                var form = $("<form/>", {
                    action: '..' + contexto + '/login.do',
                    id: 'formInicio',
                    method: 'GET'//, 
                });

                $("#contForm").html("");
                $("#contForm").append(form);
                $("#formInicio").submit();

            },
            preHook: function () {
                bloquear();
            },
            postHook: function () {
                desbloquear();
            }

        });

    }

};

