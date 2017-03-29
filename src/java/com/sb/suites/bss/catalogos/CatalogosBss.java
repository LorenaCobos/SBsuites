package com.sb.suites.bss.catalogos;

import com.sb.suites.bss.BaseBss;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.catalogos.CatalogosDAO;
import com.sb.suites.entidades.usuarios.CatalogoEntidad;
import java.util.ArrayList;

/**
 *
 * @author Fabian Molar
 */
public class CatalogosBss extends BaseBss {

    CatalogosDAO catalogosDAO = new CatalogosDAO();

    public CatalogosBss() {
    }

    public ArrayList<CatalogoEntidad> getEstatus(int lenguajeId) throws ExceptionCmm {
        return catalogosDAO.getCatalogoParametros(codigos.getString("key_estatus"), lenguajeId);
    }

    public ArrayList<CatalogoEntidad> getNumeroEventos(int lenguajeId) throws ExceptionCmm {
        return catalogosDAO.getCatalogoParametros(codigos.getString("key_nuemero_eventos"), lenguajeId);
    }

    public ArrayList<CatalogoEntidad> getTiposEvento(int lenguajeId) throws ExceptionCmm {
        return catalogosDAO.getCatalogoParametros(codigos.getString("key_tipo_evento"), lenguajeId);
    }

    public ArrayList<CatalogoEntidad> getRecintos(int usuarioid) throws ExceptionCmm {
        return catalogosDAO.getRecintos(usuarioid);
    }

    public ArrayList<CatalogoEntidad> getTipos(int usuarioid, int leng) throws ExceptionCmm {
        return catalogosDAO.getTipos(usuarioid, leng);
    }

    public ArrayList<CatalogoEntidad> getSuitesUsuario(int recintoId, int usuarioReg, int usuarioid) throws ExceptionCmm {
        return catalogosDAO.getSuitesUsuario(recintoId, usuarioReg, usuarioid);
    }

    public ArrayList<CatalogoEntidad> getSuitesUsuario(int usuarioReg, int usuarioid) throws ExceptionCmm {
        return catalogosDAO.getSuitesUsuario(0, usuarioReg, usuarioid);
    }

    public ArrayList<CatalogoEntidad> getSuitesDisponibles(int usuarioid, int recintoId, int suiteId) throws ExceptionCmm {
        return catalogosDAO.getSuitesDisponibles(usuarioid, recintoId, suiteId);
    }

    public CatalogoEntidad getPathRepositorio(int repositorio) throws ExceptionCmm {
        return catalogosDAO.getDatosRepositorio(repositorio);
    }
}
