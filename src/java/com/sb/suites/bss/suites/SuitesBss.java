package com.sb.suites.bss.suites;

import com.sb.suites.bss.BaseBss;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.suites.SuitesDAO;
import com.sb.suites.dwr.utils.AesDwr;
import com.sb.suites.entidades.suite.SuiteEntidad;
import com.sb.suites.entidades.usuarios.CatalogoEntidad;
import com.sb.suites.entidades.usuarios.UsuariosEntidad;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fabian Molar
 */
public class SuitesBss extends BaseBss{
    
    private SuitesDAO suiteDao = new SuitesDAO();
    
    public ArrayList<SuiteEntidad> obtenerSuites(int usuarioId,int recintoId, String suite,String vigenciaini,String vigenciaFin,String suiteHabiente,String estatus) throws ExceptionCmm {
        return suiteDao.obtenerSuites(usuarioId, recintoId, suite, vigenciaini, vigenciaFin, suiteHabiente,estatus); 
    }
    
    public SuiteEntidad getSuite(int seccionId, String lenguajeId) throws ExceptionCmm {
        return suiteDao.getSuite(seccionId, lenguajeId);
    }
    
    public int cambiarEstatusSuite(int usuarioId,int suiteId,int estatus) throws ExceptionCmm {
       return suiteDao.cambiarEstatusSuite(usuarioId, suiteId, estatus);
    }
    
    public int saveSuite(SuiteEntidad suiteEntity, int usuarioId) throws ExceptionCmm {
         return suiteDao.saveSuite(suiteEntity, usuarioId);
    }
    
    public ArrayList<CatalogoEntidad> getEstacionaminetos(int seccionId, int usuarioId) throws ExceptionCmm, Exception {
        return suiteDao.getEstacionaminetos(seccionId,usuarioId);
    }
    
}
