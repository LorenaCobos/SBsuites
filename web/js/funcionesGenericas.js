var tipoPrompt = 0;
var timpoinicio=0;

function validacion_()
{
    var a = new Date();
    var min =a.getMinutes()+10;
    var hrs=a.getHours();
    var myTimer = a.getHours()+":"+a.getMinutes(); //17:58
    if(hrs<=9 && min<60){hrs="0"+hrs;}
    if(min>=60){ min= min-60;hrs=parseInt(hrs)+1;if(min<10){min = "0"+min;}}
     aux = hrs+":"+min; //17:68
   
    timpoinicio=myTimer;
    $("#contenido").click(function(event)
        {
            var myTimer;
             var d = new Date();
            var min =d.getMinutes();
            var hrs=d.getHours();
            if(min<10){min = "0"+min;}
            if(hrs<10){hrs="0"+hrs; }
            var myTimer = hrs+":"+min; //16:05
            //15:68
            
            if(myTimer < aux)
            {
                var s = new Date();
                var min =(s.getMinutes()+10);
                var hrs=s.getHours();
                if(hrs<=9 && min<60){hrs="0"+hrs;}
                if(min>=60){ min= min-60;hrs=parseInt(hrs)+1;if(min<10){min ="0"+min;}}
                aux=hrs+":"+min;
            }
            else
            {
                location.href = "/Suites/logout.do";   
               
            }
        }
     );
}


try {
//validacion de combos

} catch (Exception) {
//    console.log(Exception);
}

function errh(msg, exc)
{
    desbloquear();
    mensajeError("Error", "Error message is: " + msg + " - Error Details: " + dwr.util.toDescriptiveString(exc, 2));

}

function bloquear() {
    $.blockUI();
}

function desbloquear() {
    $.unblockUI();
}

function isNull(obj) {
    return (obj === undefined || obj === null) ? true : false;
}

function truncarCadena(str, l, p) {
    str = (isNull(str)) ? "" : str;
    l = (l > str.length) ? str.length : l;
    return str.substring(0, l) + ((isNull(p)) ? "" : "...");
}

function mensaje(titulo, contenido) {
    //$.unblockUI({ message: null }); 
    //$.blockUI();
    $.blockUI({message: null});
    $.msgBox({
        title: titulo,
        content: contenido,
        type: "info",
        success: function(result, values) {
            $.unblockUI({message: null});
        }
    });

}

function mensajeError(titulo, contenido) {
    $.blockUI({message: null});
    $.msgBox({
        title: titulo,
        content: contenido,
        type: "error",
        showButtons: true,
        opacity: 0.9,
        success: function(result, values) {
            $.unblockUI();
        }
    });

}

function mensajeCall(titulo, contenido, funcion) {
    $.blockUI({message: null});
    $.msgBox({
        title: titulo,
        content: contenido,
        type: "confirm",
        success: function(result) {
            if (result == "Si")
                funcion(result);
            $.unblockUI();
        },
        showButtons: true,
        buttons: [{
                value: "Si"
            }, {
                value: "No"
            }],
        opacity: 0.5
    });
}

function mensajeCall(titulo, contenido, funcion) {
    $.blockUI({message: null});
    $.msgBox({
        title: titulo,
        content: contenido,
        type: "confirm",
        success: function(result) {
            if (result == "Si")
                funcion(result);
            $.unblockUI();
        },
        showButtons: true,
        buttons: [{
                value: "Si"
            }, {
                value: "No"
            }],
        opacity: 0.5
    });
}

function test() {
    if (arguments.length > 0) {
        alert(arguments.length);
//       var someObj["'" + arguments[0] + "'"](arguments.slice(0,1));    
    }
}

function mensajeBttnCallParametros(titulo, contenido, funcion, parametro1, parametro2, param3) {
    $.blockUI({message: null});
    $.msgBox({
        title: titulo,
        content: contenido,
        type: "info",
        success: function(result) {
            funcion(result, parametro1, parametro2, param3);
            $.unblockUI();
        },
        showButtons: true,
        buttons: [{
                value: si
            }, {
                value: no

            }],
        opacity: 0.5
    });
}

function mensajeBttnCorreo(titulo, contenido, correo1, correo2, funcion) {
    $.blockUI({message: null});
    $.msgBox({
        title: titulo,
        content: contenido,
        type: "confirm",
        success: function(result) {
            $.unblockUI();
            if (result == "Correo A")
                result = correo1;
            else if (result == "Correo B")
                result = correo2;

            if (result != "Cancelar")
                funcion(result);
        },
        showButtons: true,
        buttons: [{
                value: "Correo A"
            }, {
                value: "Correo B"
            }, {
                value: "Cancelar"
            }],
        opacity: 0.9
    });
}

function recuperarUsuario(tipo) {
    if (tipo === null || tipo === 'undefined' || tipo === 'Ok') {
        tipo = tipoPrompt;
    } else {
        tipoPrompt = tipo;
    }

    //Colocar background
    $.blockUI({message: null});

    $.msgBox({
        title: "<p>" + tituo + (tipo === 0 ? usuario : contrasenia) + ":</p>",
        type: "prompt",
        buttons: [
            {type: "submit", value: enviar},
            {type: "cancel", value: cancelar}
        ],
        inputs: [
            {type: "text", name: "correoElectronico", header: correoElectronico, value: ""}
        ],
        success: function(result, values) {
            if (result === enviar) {
                $(values).each(function(index, input) {
                    if (input.name === 'correoElectronico' && input.value.length === 0) {
                        mensajeBttnCall(error, correoInvalido, recuperarUsuario);
                    } else if (input.name === 'correoElectronico' && input.value.length > 0) {
                        login.reenviarInfo(input.value, tipo);
                    }
                });
                $.unblockUI();
            }
            else
                $.unblockUI();
        }

    });

}


function FormatToCurrency(num)
{
    num = num.toString().replace(/\$|\,/g, '');

    if (isNaN(num))
        num = "0";

    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 100 + 0.50000000001);
    cents = num % 100;
    num = Math.floor(num / 100).toString();

    if (cents < 10)
        cents = "0" + cents;

    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
        num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));

    return (((sign) ? '' : '-') + '$' + num + '.' + cents);
}

function isInt(n) {
    return n != "" && !isNaN(n) && Math.round(n) == n;
}
function isFloat(n) {
    return n != "" && !isNaN(n) && Math.round(n) != n;
}

function loadnext(divout, divin) {
    $("." + divout).hide();
    $("." + divin).fadeIn("fast");
}

function numberFormat(nStr) {
    nStr += '';
    var x = nStr.split('.');
    var x1 = x[0];
    var x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
}

function redondear2Decimales(numero) {
    var original = parseFloat(numero);
    var result = Math.round(original * 100) / 100;
    if ((result + '').indexOf('.') <= 0) {
        result += '.00';
    }
    return result;
}

function navaegacion(value) {
    switch (value) {
        case 'login':
            window.location.href = baseNormal + '/login.do';
            break;
        case 'eventos':
            window.location.href = baseNormal + '/s/eventos.do';
            break;
        case 'suites':
            window.location.href = baseNormal + '/s/suites.do';
            break;
        case 'eventosAdmin':
            window.location.href = baseNormal + '/s/administracion.do';
            break;
        case 'usuarios':
            window.location.href = baseNormal + '/s/usuarios.do';
            break;
        case 'invitacion':
            window.location.href = baseNormal + '/s/invitacion.do';
            break;
        case 'seleccionSuite':
            window.location.href = baseNormal + '/loginSel.do';
            break;
        case 'AyudaBoletos':
            window.location.href = baseNormal + 's/AyudaBoletos.do';
            break;
    }
}

//function opcionesMenu(){
//    $('[name="operacion_menu"]').click(function(event) {
//            event.preventDefault();
//             var elem = $(this);
//             this.elem(function(){
//                 switch($(this).attr('id')){
//                     case 1:""
//                         break;
//                 }
//             });
//            login.ingresar();
//        });
//}

function agregarFuncionalidad(identificadorHtml, habilitado) {

    if (!habilitado) {
        $("#" + identificadorHtml).prop("disabled", "true");
        $("#" + identificadorHtml).attr("style", "display:none;");
        $("input[name*='"+identificadorHtml+"']").prop("disabled", "true");
        $("input[name*='"+identificadorHtml+"']").attr("style", "display:none;");
    }
}

function recorrerPermisos(){
    $("input[name*='funcionalidad']").each(function(index, input) {
                   agregarFuncionalidad($(this).val(),false);
                });
}

function  getCookie(cookieName) {
    var theCookie = " " + document.cookie;
    var ind = theCookie.indexOf(" " + cookieName + "=");
    if (ind == -1)
        ind = theCookie.indexOf(";" + cookieName + "=");
    if (ind == -1 || cookieName == "")
        return "";
    var ind1 = theCookie.indexOf(";", ind + 1);
    if (ind1 == -1)
        ind1 = theCookie.length;
    return unescape(theCookie.substring(ind + cookieName.length + 2, ind1));
}

function setCookie(cookieName, cookieValue, nDays) {
    var today = new Date();
    var expire = new Date();
    if (nDays == null || nDays == 0)
        nDays = 1;
    expire.setTime(today.getTime() + 3600000 * 24 * nDays);
    document.cookie = cookieName + "=" + escape(cookieValue)
            + ";expires=" + expire.toGMTString();
}


function getMobileOperatingSystem() {
  var userAgent = navigator.userAgent || navigator.vendor || window.opera;

    //userAgent.match( /iPad/i ) || 
  if(userAgent.match( /iPhone/i ) || userAgent.match( /iPod/i ) ||  userAgent.match( /Android/i ) ||  userAgent.match(/BlackBerry/i))
  {
    return 'celular';
  }
  else
  {
    return 'unknown';
  }
}

function cambiarHeader(){
    if($("#selectRecinto").val()===411||$("#selectRecinto").val()==='411'){
      $("#encabezado").attr("style","padding-right:10px; margin:0 auto;background-image:url("+inicioHttp+"/SuperBoletosRepositorio/suites/logoAM_suites.jpg);background-repeat:no-repeat;background-position:left;")  
      $("#textoRecinto").html(" Monterrey | Suites ");
    }else if($("#selectRecinto").val()===716||$("#selectRecinto").val()==='716'){
      $("#encabezado").attr("style","padding-right:10px; margin:0 auto;background-image:url("+inicioHttp+"/SuperBoletosRepositorio/suites/logoACMX_suites.png);background-repeat:no-repeat;background-position:left;");
      $("#textoRecinto").html("&nbsp; CD. de M&eacute;xico | Suites ");
    }else{
        
    }
     
}