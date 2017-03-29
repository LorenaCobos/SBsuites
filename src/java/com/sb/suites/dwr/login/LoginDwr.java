package com.sb.suites.dwr.login;

import com.sb.formato.utils.Emailer;
import com.sb.suites.bss.utils.Encriptacion;
import com.sb.suites.cmm.AnotacionMetodoAuditoria;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.login.LoginDAO;
import com.sb.suites.dwr.utils.AesDwr;
import com.sb.suites.entidades.usuarios.CatalogoEntidad;
import com.sb.suites.entidades.usuarios.OpcionMenuLateralEntidad;
import com.sb.suites.entidades.usuarios.OpcionMenuPrincipalEntidad;
import com.sb.suites.entidades.usuarios.UsuariosEntidad;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

/**
 *
 * @author fabiam molar
 */
@RemoteProxy(name = "dwrLogin")
public class LoginDwr {

    private LoginDAO loginDAO;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();

    private String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public LoginDwr() {
        loginDAO = new LoginDAO();
    }

    @RemoteMethod
    public int validaUsuario(String usuario, String password, HttpServletRequest req, HttpSession session) throws ExceptionCmm, Exception {
        int resp = 0;
        UsuariosEntidad usr = loginDAO.validaUsuario(AesDwr.decrypt(usuario), AesDwr.decrypt(password), req.getLocale().getLanguage().equals("es") ? 1 : 2);
        if (usr.getUsuarioId() > 0) {
            resp = 1;
            session.setAttribute("usuarioEntidad", usr);
            session.setAttribute("funcionalidades", loginDAO.getFuncionalidadesOperacionesUsuario(usr.getUsuarioId()));
            
        } else {
            resp = usr.getUsuarioId();
        }
        return resp;
    }

    @RemoteMethod
    public int logoutUsuario(HttpServletRequest req, HttpSession session) throws ExceptionCmm, Exception {
        session.setAttribute("usuarioEntidad", null);
        session.setAttribute("funcionalidades", null);
        session.invalidate();
        return 0;
    }

    @RemoteMethod
    public int recuperarUsuario(String correo, String tipo) throws ExceptionCmm, Exception {
        String pwdTmp = randomString(8);
        String pwd = Encriptacion.encriptar(pwdTmp);
        int type = Integer.parseInt(AesDwr.decrypt(tipo));
        String correoElectronico = AesDwr.decrypt(correo);
        CatalogoEntidad resp = loginDAO.recuperarUsuario(correoElectronico, pwd, type);
        int ret = 0;
        Emailer emailSender = new Emailer();
        String to = correoElectronico;
        String subject = "";
        String cuerpoCorreo = "";
        switch (resp.getId()) {
            case 1:
                subject = "Recuperacion de Usuario Suites SuperBoletos.com";
                cuerpoCorreo = "Su Usuario es: " + resp.getClave() + " ";
                emailSender.sendEmail_HTML("noReply@superboletos.com", to, subject, cuerpoCorreo);
                ret = 1;
                break;
            case 0:
            case -1:
            case -2:
            case -3:
            case -4:
                ret = resp.getId();
                break;
            default:
                subject = "Recuperacion de Contraseña Suites SuperBoletos.com";
                cuerpoCorreo = "Su Contrase&ntilde;a es: " + pwdTmp + " <br/> Cambiela lo antes posible entrando a su perfil.";
                emailSender.sendEmail_HTML("noReply@superboletos.com", to, subject, cuerpoCorreo);
                ret = 2;
                break;
        }
        return ret;
    }

    @RemoteMethod
    public ArrayList<OpcionMenuPrincipalEntidad> getMenuModulosUsuario(int usuarioId, int aplicacionId, String lenguajeId) throws ExceptionCmm {
        return loginDAO.getMenuModulosUsuario(usuarioId, aplicacionId, lenguajeId);
    }

    @RemoteMethod
    public ArrayList<OpcionMenuLateralEntidad> getOperacionesUsuarioModulo(int usuarioId, int aplicacionId, int moduloId, String lenguajeId) throws ExceptionCmm {
        return loginDAO.getOperacionesUsuarioModulo(usuarioId, aplicacionId, moduloId, lenguajeId);
    }

    @RemoteMethod
    public OpcionMenuLateralEntidad getModuloOperInicial(HttpSession session) throws ExceptionCmm {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        return loginDAO.getModuloOperInicial(usuario.getUsuarioId());
    }
    
    @RemoteMethod
    public int seleccionSuite(int valor,HttpSession session) throws ExceptionCmm {
        if(session.getAttribute("usuarioEntidad") != null)
        {
            session.setAttribute("opcion", valor);
            return 1;
        }
        return 0;
    }

}
