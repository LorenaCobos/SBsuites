package com.sb.suites.dwr.usuario;

import com.sb.suites.bss.catalogos.CatalogosBss;
import com.sb.suites.bss.usuarios.UsuariosBss;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dwr.utils.AesDwr;
import com.sb.suites.entidades.usuarios.CatalogoEntidad;

import com.sb.suites.entidades.usuarios.UsuariosEntidad;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fabian Molar
 */
@RemoteProxy(name = "dwrUsuario")
public class UsuarioDwr {

    UsuariosBss usuariosBss = new UsuariosBss();
    CatalogosBss catalogo = new CatalogosBss();

    @RemoteMethod
    public ArrayList<UsuariosEntidad> getUsuarios(String nombre, String correo, String tipo, String estatus, String recinto, String suite, HttpSession session, HttpServletRequest req) throws ExceptionCmm, Exception {

        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {
            return usuariosBss.getUsuarios(
                    usuario.getUsuarioId(),
                    AesDwr.decrypt(nombre),
                    AesDwr.decrypt(correo),
                    Integer.parseInt(AesDwr.decrypt(tipo)),
                    AesDwr.decrypt(estatus),
                    Integer.parseInt(AesDwr.decrypt(recinto)),
                    Integer.parseInt(AesDwr.decrypt(suite)),
                    (req.getLocale().getLanguage().equals("es") ? 1 : 2)
            );
        }
    return null;

    }

    @RemoteMethod
    public int cambiarEstatusUsuario(String usuarioId, String estatus, HttpSession session) throws ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
       if(session.getAttribute("usuarioEntidad") != null)
       {
        return usuariosBss.cambiarEstatusUsuario(usuario.getUsuarioId(), Integer.parseInt(AesDwr.decrypt(usuarioId)), Integer.parseInt(AesDwr.decrypt(estatus)));
        }
       return 0;
    }

    @RemoteMethod
    public UsuariosEntidad getUsuario(String usuarioId, HttpServletRequest req) throws ExceptionCmm, Exception {
        return usuariosBss.getUsuario(Integer.parseInt(AesDwr.decrypt(usuarioId)), req.getLocale().getLanguage().equals("es") ? "1" : "2");
    }

    @RemoteMethod
    public int saveUsuario(UsuariosEntidad usuarioEntity, ArrayList<String> suites, HttpSession session) throws ExceptionCmm, Exception {
        int IdUsuarioOut = 0;
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {
            if(usuarioEntity.getUsuarioId() == 0){
                usuarioEntity.setContrasena(AesDwr.decrypt(usuarioEntity.getContrasena()));

            }

            IdUsuarioOut = usuariosBss.saveUsuario(usuarioEntity, usuario.getUsuarioId());
            if(IdUsuarioOut > 0){
                 //Borramos todas las suites asignadas:
                usuariosBss.cambiarEstatusSuite(usuario.getUsuarioId(), IdUsuarioOut, 0, 5);

                //Guardamos todas las suites:
                for (String suite : suites) {
                    int cambiarEstatusSuite = usuariosBss.cambiarEstatusSuite(usuario.getUsuarioId(), IdUsuarioOut, Integer.parseInt(suite), 6);
                }

            }

            return IdUsuarioOut;
        }
        return 0;
    }

//     public int saveUsuario(UsuariosEntidad usuarioEntity,HttpSession session) throws ExceptionCmm {
//         UsuariosEntidad usuario =  session.getAttribute("usuarioEntidad")==null?new UsuariosEntidad():(UsuariosEntidad)session.getAttribute("usuarioEntidad");
//         return usuariosBss.saveUsuario(usuarioEntity, usuario.getUsuarioId());
//     }
    @RemoteMethod
    public int saveContrasenaUsuario(String nuevaContrasena, String identificadorUsuario, HttpSession session) throws ExceptionCmm, Exception {
        if(session.getAttribute("usuarioEntidad") != null)
        {
        return usuariosBss.saveContrasenaUsuario(AesDwr.decrypt(nuevaContrasena), 0, "", Integer.parseInt(AesDwr.decrypt(identificadorUsuario)));
        }
        return 0;
    }

    @RemoteMethod
    public int cambiarEstatusSuite(String usuarioRefId, String suiteId, String tipo, HttpSession session) throws ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        return usuariosBss.cambiarEstatusSuite(usuario.getUsuarioId(), Integer.parseInt(AesDwr.decrypt(usuarioRefId)), Integer.parseInt(AesDwr.decrypt(suiteId)), Integer.parseInt(AesDwr.decrypt(tipo)));
    }
    
  @RemoteMethod
    public ArrayList<CatalogoEntidad> getSuitesUsuario(int recintoId,int usuarioReg,HttpSession session) throws ExceptionCmm {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
         return catalogo.getSuitesUsuario(recintoId, usuarioReg, usuario.getUsuarioId());
     }
    

    
    
}
