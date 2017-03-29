/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suite.controller;

import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.usuarios.UsuarioDAO;
import com.sb.suites.dwr.login.LoginDwr;
import com.sb.suites.entidades.usuarios.OpcionMenuLateralEntidad;
import com.sb.suites.entidades.usuarios.OpcionMenuPrincipalEntidad;
import com.sb.suites.entidades.usuarios.UsuariosEntidad;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabiam molar
 */
public class BaseController {
    
    /** The Constant FQCN. */
    private static final String FQCN = BaseController.class.getName();

    /** The Constant SB_LOGGER. */
    private static final Logger SB_LOGGER = Logger.getLogger(FQCN);
    private LoginDwr loginDwr = new LoginDwr();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public String obtenerContexto(String esquema, String nombreServidor, String puerto ){
        String contexto ="";
        contexto = ((esquema==null || esquema.length()==0)?"http://":(esquema+"://"))+
                   ((nombreServidor==null || nombreServidor.length()==0)?"":nombreServidor)+
                   ((puerto==null||puerto.length()==0)?"":(":"+puerto));
        return contexto;
    }
    
    public ArrayList<OpcionMenuPrincipalEntidad> getMenuModulosUsuario(HttpServletRequest req, HttpSession session) throws ExceptionCmm{
         UsuariosEntidad usuario =  session.getAttribute("usuarioEntidad")==null?new UsuariosEntidad():(UsuariosEntidad)session.getAttribute("usuarioEntidad");
         ArrayList<OpcionMenuPrincipalEntidad> modulos = loginDwr.getMenuModulosUsuario(usuario.getUsuarioId(), usuario.getAplicacionId() ,  req.getLocale().getLanguage().equals("es") ? "1" : "2");
         for(OpcionMenuPrincipalEntidad mod : modulos){
             mod.setOperaciones(getOperacionesUsuarioModulo(mod.getIdentificadorMenuPrincipal(),req,session));
         }
        return modulos;
    }
    
    public ArrayList<OpcionMenuLateralEntidad> getOperacionesUsuarioModulo( int moduloId, HttpServletRequest req, HttpSession session) throws ExceptionCmm {
        UsuariosEntidad usuario =  session.getAttribute("usuarioEntidad")==null?new UsuariosEntidad():(UsuariosEntidad)session.getAttribute("usuarioEntidad");
        return loginDwr.getOperacionesUsuarioModulo(usuario.getUsuarioId(), usuario.getAplicacionId(),moduloId, req.getLocale().getLanguage().equals("es") ? "1" : "2");
    }
    
    
    public UsuariosEntidad getUser(HttpServletRequest req, HttpSession session) throws ExceptionCmm {
        UsuariosEntidad usuario =  session.getAttribute("usuarioEntidad")==null?new UsuariosEntidad():(UsuariosEntidad)session.getAttribute("usuarioEntidad");
        return usuarioDAO.getUsuario(usuario.getUsuarioId());
    }
    
}
