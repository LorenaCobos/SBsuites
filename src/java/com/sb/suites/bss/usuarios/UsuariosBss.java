/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sb.suites.bss.usuarios;

import com.sb.suites.bss.BaseBss;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.usuarios.UsuarioDAO;
import com.sb.suites.entidades.usuarios.UsuariosEntidad;
import java.util.ArrayList;

/**
 *
 * @author Fabian Molar
 */

public class UsuariosBss extends BaseBss{
    
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    
    public ArrayList<UsuariosEntidad> getUsuarios(int usuarioId, String nombre, String correo, int tipo, String estatus, int recinto, int suite, int lenguajeId) throws ExceptionCmm {
        return usuarioDAO.getUsuarios(usuarioId, nombre, correo, tipo, estatus, recinto, suite, lenguajeId);
    }
    
    public UsuariosEntidad getUsuario(int usuarioId, String lenguajeId) throws ExceptionCmm {
        return usuarioDAO.getUsuario(usuarioId);
    }
    
    public int cambiarEstatusUsuario(int usuarioRegId,int usuarioId, int estatus) throws ExceptionCmm {
       return usuarioDAO.cambiarEstatusUsuario(usuarioRegId,usuarioId, estatus);
    }
    
    public int saveUsuario(UsuariosEntidad usuarioEntity, int usuarioId) throws ExceptionCmm, Exception {
         return usuarioDAO.saveUsuarioSistema(usuarioEntity, usuarioId);
    }
    
    public int saveContrasenaUsuario(String nuevaContrasena, int preguntaSecretaId, String respuesta, int identificadorUsuario) throws ExceptionCmm {
        return usuarioDAO.saveContrasenaUsuario(nuevaContrasena, preguntaSecretaId, respuesta, identificadorUsuario);
    }
 
    public int cambiarEstatusSuite(int usuarioId, int usuarioRefId, int suiteId,int tipo) throws ExceptionCmm {
        return usuarioDAO.cambiarEstatusSuite(usuarioId, usuarioRefId, suiteId, tipo);
    }
    
}
