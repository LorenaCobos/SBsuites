package com.sb.suites.dwr.eventos;

import com.sb.formato.bss.SuitesBss;
import com.sb.formato.dao.PrintAtHomeDAO;
import com.sb.formato.entidades.ResultadoEntidad;
import com.sb.suites.bss.catalogos.CatalogosBss;
import com.sb.suites.bss.eventos.EventosBss;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dwr.utils.AesDwr;
import com.sb.suites.entidades.eventos.ResumenDetalleImpresion;
import com.sb.suites.entidades.suite.SuiteEntidad;
import com.sb.suites.entidades.usuarios.CatalogoEntidad;
import com.sb.suites.entidades.usuarios.UsuariosEntidad;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

/**
 *
 * @author Fabian Molar
 */
@RemoteProxy(name = "dwrEvento")
public class EventosDwr {

    EventosBss eventos = new EventosBss();
    SuitesBss suite = new SuitesBss();
    CatalogosBss catalogo = new CatalogosBss();
    ResultadoEntidad resp;

    @RemoteMethod
    public ArrayList<SuiteEntidad> getSuitesPresentaciones(String recintoId, String evento, String estatus, String fechaInicio, String fechaFin, HttpSession session) throws ExceptionCmm, Exception {
        if(session.getAttribute("usuarioEntidad") != null)
        {
        return eventos.getSuitesPresentaciones(Integer.parseInt(AesDwr.decrypt(recintoId)), AesDwr.decrypt(evento), AesDwr.decrypt(estatus), AesDwr.decrypt(fechaInicio), AesDwr.decrypt(fechaFin));
        }
        return null;
        }

    @RemoteMethod
    public ArrayList<SuiteEntidad> getSuitesPresentacionesUsuario(String recintoId, String evento, String fechaInicio, String fechaFin, String suite,HttpSession session) throws ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {
        return eventos.getSuitesPresentacionesUsuario(Integer.parseInt(AesDwr.decrypt(recintoId)), AesDwr.decrypt(evento), AesDwr.decrypt(fechaInicio), AesDwr.decrypt(fechaFin), Integer.parseInt(AesDwr.decrypt(suite)));
        }
        return null;
     }

    @RemoteMethod
    public int cambiarEstatusPresentacion(String presentacionId, String estatus, HttpSession session) throws ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {
        return eventos.cambiarEstatusPresentacion(usuario.getUsuarioId(), Integer.parseInt(AesDwr.decrypt(presentacionId)), Integer.parseInt(AesDwr.decrypt(estatus)));
        }
        return 0;
    }
 
    @RemoteMethod
    public String generarPDF(String suiteID, String presentacionId, String cantidadBoletos, String eventoId, HttpSession session, HttpServletRequest req) throws com.sb.core.cmm.ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {
            String tipoFP = PrintAtHomeDAO.FORMATO_PAH;
           resp = suite.imprimirLugaresSuites(usuario.getUsuarioId(), Integer.parseInt(AesDwr.decrypt(suiteID)), Integer.parseInt(AesDwr.decrypt(presentacionId)), Integer.parseInt(AesDwr.decrypt(cantidadBoletos)), Integer.parseInt(AesDwr.decrypt(eventoId)), req.getLocale().getLanguage().equals("es") ? "1" : "2", tipoFP, Boolean.FALSE, 0);
            return resp.getRespuesta() == 1 ? resp.getResultado() : resp.getRespuesta() + "";
        }
       return null;
    }
    @RemoteMethod
    public String generarEstacionamientosPDF(String suiteID, String presentacionId, String cantidadBoletos, String eventoId,String estacionamientoId, HttpSession session, HttpServletRequest req) throws com.sb.core.cmm.ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
         if(session.getAttribute("usuarioEntidad") != null)
        {
            String tipoFP = PrintAtHomeDAO.FORMATO_PAH;
            resp = suite.imprimirEstacionaminetosSuites( usuario.getUsuarioId(), Integer.parseInt(AesDwr.decrypt(suiteID)),
                                                                          Integer.parseInt(AesDwr.decrypt(presentacionId)), Integer.parseInt(AesDwr.decrypt(cantidadBoletos)), 
                                                                          Integer.parseInt(AesDwr.decrypt(eventoId)), Integer.parseInt(AesDwr.decrypt(estacionamientoId)), 
                                                                          req.getLocale().getLanguage().equals("es") ? "1" : "2", tipoFP, Boolean.FALSE, 0);
       return resp.getRespuesta() == 1 ? resp.getResultado() : resp.getRespuesta() + ""; 
        }
        return null;
        
    }

    @RemoteMethod
    public ResumenDetalleImpresion resumenImpresos(String eventoId, String presentacionId, String suiteID, HttpSession session, HttpServletRequest req) throws ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {
            return eventos.resumenImpresos(usuario.getUsuarioId(), Integer.parseInt(AesDwr.decrypt(eventoId)), Integer.parseInt(AesDwr.decrypt(presentacionId)), Integer.parseInt(AesDwr.decrypt(suiteID)), req.getLocale().getLanguage().equals("es") ? 1 : 2);   
        }
        return null;
    }

    @RemoteMethod
    public int generarInvitacion(String suiteID, String presentacionId, String cantidadBoletos, String eventoId, String nombre, String correo, String nota,String cantidadEstacionamiento, HttpSession session, HttpServletRequest req) throws com.sb.core.cmm.ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {
            return suite.generarInvitacion(usuario.getUsuarioId(),
                    Integer.parseInt(AesDwr.decrypt(eventoId)),
                    Integer.parseInt(AesDwr.decrypt(presentacionId)),
                    AesDwr.decrypt(nombre),
                    AesDwr.decrypt(correo),
                    AesDwr.decrypt(nota),
                    Integer.parseInt(AesDwr.decrypt(cantidadBoletos)),
                    Integer.parseInt(AesDwr.decrypt(suiteID)),
                    Integer.parseInt(AesDwr.decrypt(cantidadEstacionamiento))
            );
        }
        return 0;
    }

    @RemoteMethod
    public int actualizarInvitacion(int usuarioId, int transferenciaId, int estatus, boolean reenvio, HttpSession session, HttpServletRequest req) throws com.sb.core.cmm.ExceptionCmm, Exception {
        if(session.getAttribute("usuarioEntidad") != null)
        {
            return suite.actualizarInvitacion(usuarioId, transferenciaId, estatus, reenvio);
        }
        return 0;
    }

    @RemoteMethod
    public int actualizarInvitacionDetalle(String transferenciaId, int estatus, boolean reenvio, HttpSession session, HttpServletRequest req) throws com.sb.core.cmm.ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
         if(session.getAttribute("usuarioEntidad") != null)
        {
            return suite.actualizarInvitacion(usuario.getUsuarioId(), Integer.parseInt(AesDwr.decrypt(transferenciaId)), estatus, reenvio);
        }
         return 0;
    }

    @RemoteMethod
    public ArrayList<CatalogoEntidad> getSuitesUsuario(int recintoId, int usuarioReg, HttpSession session) throws ExceptionCmm {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {
        return catalogo.getSuitesUsuario(recintoId, usuarioReg, usuario.getUsuarioId());
        }
        return null;
    }

    @RemoteMethod
    public int saveArchivo(int archivoId, String nombre, int entidadId, HttpSession session) throws ExceptionCmm {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {
         return eventos.saveArchivo(archivoId, /*Integer.parseInt(session.getAttribute("REPOSITORIO_ESTACIONAMIENTO").toString())*/56, nombre, entidadId, usuario.getUsuarioId());
        }
        return 0;
    }
}
