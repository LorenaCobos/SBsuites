package com.sb.suites.dwr.suite;

import com.sb.suites.bss.suites.SuitesBss;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dwr.utils.AesDwr;
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
 * @author Fabian molar
 */

@RemoteProxy(name = "dwrSuite")
public class SuiteDwr {
    
    private final SuitesBss suiteBss = new SuitesBss();
    
    @RemoteMethod
    public ArrayList<SuiteEntidad> obtenerSuites(String recintoId, String suite,String vigenciaini,String vigenciaFin,String suiteHabiente,String estatus,HttpSession session) throws ExceptionCmm, Exception {
        UsuariosEntidad usuario =  session.getAttribute("usuarioEntidad")==null?new UsuariosEntidad():(UsuariosEntidad)session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {  
            return suiteBss.obtenerSuites(usuario.getUsuarioId(), Integer.parseInt(AesDwr.decrypt(recintoId)), AesDwr.decrypt(suite), AesDwr.decrypt(vigenciaini), AesDwr.decrypt(vigenciaFin), AesDwr.decrypt(suiteHabiente),
              AesDwr.decrypt(estatus) 
            );
        }
        return null;
    }
    
    @RemoteMethod
    public int cambiarEstatusSuite(String suiteId,String estatus,HttpSession session) throws ExceptionCmm, Exception {
        UsuariosEntidad usuario =  session.getAttribute("usuarioEntidad")==null?new UsuariosEntidad():(UsuariosEntidad)session.getAttribute("usuarioEntidad");
     if(session.getAttribute("usuarioEntidad") != null)
        {  
        return suiteBss.cambiarEstatusSuite(usuario.getUsuarioId(), Integer.parseInt(AesDwr.decrypt( suiteId)), Integer.parseInt(AesDwr.decrypt(estatus)));
        }
     return 0;
    }
    
    @RemoteMethod
     public SuiteEntidad getSuite(String seccionId, HttpServletRequest req) throws ExceptionCmm, Exception { 
         return suiteBss.getSuite(Integer.parseInt(AesDwr.decrypt( seccionId)), req.getLocale().getLanguage().equals("es") ? "1" : "2");
    }
     
     @RemoteMethod
     public int saveSuite(SuiteEntidad suiteEntity,HttpSession session) throws ExceptionCmm {
         UsuariosEntidad usuario =  session.getAttribute("usuarioEntidad")==null?new UsuariosEntidad():(UsuariosEntidad)session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") != null)
        {
         return suiteBss.saveSuite(suiteEntity, usuario.getUsuarioId());
        }
        return 0;
     }
     
     @RemoteMethod
     public ArrayList<CatalogoEntidad> getEstacionaminetos(String seccionId, HttpServletRequest req,HttpSession session) throws ExceptionCmm, Exception {
         UsuariosEntidad usuario =  session.getAttribute("usuarioEntidad")==null?new UsuariosEntidad():(UsuariosEntidad)session.getAttribute("usuarioEntidad");
        return suiteBss.getEstacionaminetos(Integer.parseInt(AesDwr.decrypt( seccionId)),usuario.getUsuarioId());
     }
    
}
