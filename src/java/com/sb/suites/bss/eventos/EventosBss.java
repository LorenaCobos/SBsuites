package com.sb.suites.bss.eventos;

import com.sb.formato.bss.SuitesBss;
import com.sb.formato.dao.PrintAtHomeDAO;
import com.sb.formato.entidades.ResultadoEntidad;
import com.sb.suites.bss.BaseBss;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.eventos.EventosDAO;
import com.sb.suites.entidades.eventos.ResumenDetalleImpresion;
import com.sb.suites.entidades.suite.SuiteEntidad;
import java.util.ArrayList;

/**
 *
 * @author Fabian molar
 */
public class EventosBss extends BaseBss {

    EventosDAO eventos = new EventosDAO();
    SuitesBss suite = new SuitesBss();

    public ArrayList<SuiteEntidad> getSuitesPresentaciones(int recintoId, String evento, String estatus, String fechaInicio, String fechaFin) throws ExceptionCmm {
        return eventos.getSuitesPresentaciones(recintoId, evento, estatus, fechaInicio, fechaFin, eventos.getTipoSeccionParaVenta(0, recintoId));
    }

    public ArrayList<SuiteEntidad> getSuitesPresentacionesUsuario(int recintoId, String evento, String fechaInicio, String fechaFin,int seccionId) throws ExceptionCmm {
        return eventos.getSuitesPresentacionesUsuario(recintoId, evento, fechaInicio, fechaFin, seccionId);
        //eventos.getTipoSeccionParaVenta(0,recintoId)
    }

    public int cambiarEstatusPresentacion(int usuarioId, int presentacionId, int estatus) throws ExceptionCmm {
        return eventos.cambiarEstatusPresentacion(usuarioId, presentacionId, estatus);
    }

    public String generarPDF(int usuarioId, int suiteID, int presentacionId, int cantidadBoletos, int eventoId, String Leng) throws com.sb.core.cmm.ExceptionCmm {
        String tipoFP = PrintAtHomeDAO.FORMATO_PAH;
        ResultadoEntidad resp = suite.imprimirLugaresSuites(usuarioId, suiteID, presentacionId, cantidadBoletos, eventoId, Leng, tipoFP, Boolean.FALSE,0);
        return resp.getResultado();
    }
    
    public ResumenDetalleImpresion resumenImpresos(int usuarioId,int eventoId,int presentacionId,int seccionId, int lenguajeId) throws ExceptionCmm{
        return eventos.resumenImpresos(usuarioId, eventoId,presentacionId, seccionId, lenguajeId);
    }
    
   public int saveArchivo(int archivoId, int repossitorio, String nombre, int entidadId, int usuarioId) throws ExceptionCmm {
        return eventos.saveArchivo(archivoId, repossitorio, nombre, entidadId, usuarioId);
    }

}
