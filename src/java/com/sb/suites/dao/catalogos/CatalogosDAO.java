package com.sb.suites.dao.catalogos;

import com.sb.suites.cmm.AnotacionMetodoAuditoria;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.BaseDAO;
import com.sb.suites.entidades.usuarios.CatalogoEntidad;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Fabian molar
 */
public class CatalogosDAO extends BaseDAO {

    public static final String packageOracle = "XXSB_CATALOGOS_PKG";
    public static final String SUITES_PKG = "XXSB_SUITES_PKG";

    public ArrayList<CatalogoEntidad> getCatalogoParametros(String catalogoId, int lenguajeId) throws ExceptionCmm {
        ArrayList listaResultados = null;
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".OBTENER_CATALOGO_ITEMS_PRC(?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setString(1, catalogoId);
            objlStmnt.setInt(2, lenguajeId);
            objlStmnt.registerOutParameter(3, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(3);
            listaResultados = new ArrayList();
            while (rs.next()) {
                CatalogoEntidad catalogoEntity = new CatalogoEntidad();
                catalogoEntity.setId(rs.getInt("ID"));
                catalogoEntity.setNombre(rs.getString("NOMBRE"));
                catalogoEntity.setTextId(rs.getString("DESCRIPCION"));
                catalogoEntity.setClave(rs.getString("CLAVE"));
                catalogoEntity.setValor(rs.getString("VALOR"));
                listaResultados.add(catalogoEntity);
            }
        } catch (Exception e) {
            System.err.println("");
//			this.generarEventoError(new ExceptionCmm("error_catalogos_getCatalogoParametros", e), "getCatalogoParametros", new Object[]{catalogoId, lenguajeId});
        } finally {
            cleanVariables(rs, conn);
        }
        return listaResultados;
    }
    
    
    public ArrayList<CatalogoEntidad> getRecintos(int usuarioid) throws ExceptionCmm {
        ArrayList listaResultados = null;
        ResultSet rs = null;
        final String QUERY = "{call " + SUITES_PKG + ".RECINTOS_USUARIO_PRC(?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioid);
            objlStmnt.registerOutParameter(2, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(2);
            listaResultados = new ArrayList();
            while (rs.next()) {
                CatalogoEntidad catalogoEntity = new CatalogoEntidad();
                catalogoEntity.setId(rs.getInt("RECINTO_ID"));
                catalogoEntity.setNombre(rs.getString("NOMBRE"));
                listaResultados.add(catalogoEntity);
            }
        } catch (Exception e) {
            System.err.println("");
//			this.generarEventoError(new ExceptionCmm("error_catalogos_getCatalogoParametros", e), "getCatalogoParametros", new Object[]{catalogoId, lenguajeId});
        } finally {
            cleanVariables(rs, conn);
        }
        return listaResultados;
    }
    
    
    
    
    
    
    public ArrayList<CatalogoEntidad> getTipos(int usuarioid, int leng) throws ExceptionCmm {
        ArrayList listaResultados = null;
        ResultSet rs = null;
        final String QUERY = "{call " + SUITES_PKG + ".GET_PERFILES_PRC(?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioid);
            objlStmnt.setInt(2, leng);
            objlStmnt.registerOutParameter(3, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(3);
            listaResultados = new ArrayList();
            while (rs.next()) {
                CatalogoEntidad catalogoEntity = new CatalogoEntidad();
                catalogoEntity.setId(rs.getInt("PERFIL_ID"));
                catalogoEntity.setNombre(rs.getString("NOMBRE"));
                listaResultados.add(catalogoEntity);
            }
        } catch (Exception e) {
            System.err.println("");
//			this.generarEventoError(new ExceptionCmm("error_catalogos_getCatalogoParametros", e), "getCatalogoParametros", new Object[]{catalogoId, lenguajeId});
        } finally {
            cleanVariables(rs, conn);
        }
        return listaResultados;
    }
    
    public ArrayList<CatalogoEntidad> getSuitesUsuario(int recintoId, int usuarioReg,int usuarioid) throws ExceptionCmm {
        ArrayList listaResultados = null;
        ResultSet rs = null;
        final String QUERY = "{call " + SUITES_PKG + ".SUITE_USUARIO_PRC(?,?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioReg);//1493
            objlStmnt.setInt(2, usuarioid);//1513
            objlStmnt.setInt(3, recintoId);//0
            objlStmnt.registerOutParameter(4, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(4);
            listaResultados = new ArrayList();
                while (rs.next()) {
                CatalogoEntidad catalogoEntity = new CatalogoEntidad();
                catalogoEntity.setId(rs.getInt("SECCION_ID"));
                catalogoEntity.setNombre(rs.getString("NOMBRE")); 
                catalogoEntity.setValor(rs.getString("SELECCIONADA"));
                catalogoEntity.setClave(rs.getString("SUITE_HABIENTE"));
                catalogoEntity.setNivel_id(rs.getInt("NIVEL_ID"));
                catalogoEntity.setNivel(rs.getString("NIVEL"));
                catalogoEntity.setNombreCompleto(rs.getString("NOMBRE")+" "+rs.getString("SUITE_HABIENTE"));
                
                listaResultados.add(catalogoEntity);
            }
        } catch (Exception e) {
            System.err.println("");
//			this.generarEventoError(new ExceptionCmm("error_catalogos_getCatalogoParametros", e), "getCatalogoParametros", new Object[]{catalogoId, lenguajeId});
        } finally {
            
            /* CatalogoEntidad catalogoEntity_ = new CatalogoEntidad();
             catalogoEntity_.setId(1);
             catalogoEntity_.setNombre(rs.getString("")); 
             catalogoEntity_.setValor("Todos");
             catalogoEntity_.setNivel_id(1);
             catalogoEntity_.setNivel(rs.getString("NIVEL"));
             catalogoEntity_.setNombreCompleto("Todos");
             listaResultados.add(catalogoEntity_);*/
             cleanVariables(rs, conn);
        }
       
        return listaResultados;
    }
    
    public ArrayList<CatalogoEntidad> getSuitesDisponibles(int usuarioid,int recintoId,int suiteId) throws ExceptionCmm {
        ArrayList listaResultados = null;
        ResultSet rs = null;
        final String QUERY = "{call " + SUITES_PKG + ".SECCIONES_SUITE_DISP_PRC(?,?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioid);
            objlStmnt.setInt(2, recintoId);
            objlStmnt.setInt(3, suiteId);
            objlStmnt.registerOutParameter(4, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(4);
            listaResultados = new ArrayList();
            while (rs.next()) {
                CatalogoEntidad catalogoEntity = new CatalogoEntidad();
                catalogoEntity.setId(rs.getInt("SECCION_ID"));
                catalogoEntity.setNombre(rs.getString("NOMBRE")); 
                listaResultados.add(catalogoEntity);
            }
        } catch (Exception e) {
            System.err.println("");
//			this.generarEventoError(new ExceptionCmm("error_catalogos_getCatalogoParametros", e), "getCatalogoParametros", new Object[]{catalogoId, lenguajeId});
        } finally {
            cleanVariables(rs, conn);
        }
        return listaResultados;
    }
    
    public CatalogoEntidad getDatosRepositorio(int repositorioId) throws ExceptionCmm {
		ResultSet rs = null;
		final String QUERY = "{call " + packageOracle + ".REPOSITORIO_CONFIGURACION_PRC(?,?)}";
		Connection conn = getConnectionAdmin();
		CallableStatement objlStmnt;
		CatalogoEntidad datosRepositorio = new CatalogoEntidad();
		try {
			objlStmnt = conn.prepareCall(QUERY);
			objlStmnt.setInt(1, repositorioId);
			objlStmnt.registerOutParameter(2, OracleTypes.CURSOR);
			objlStmnt.execute();
			rs = (ResultSet) objlStmnt.getObject(2);
			while (rs.next()) {
				datosRepositorio.setTextId(rs.getString("URL_ADMINISTRACION"));
				datosRepositorio.setValor(rs.getString("SOFT_LINK"));
			}
		} catch (SQLException e) {
                    System.err.println("");
		} finally {
			cleanVariables(rs, conn);
		}
		return datosRepositorio;
	}
    

}
