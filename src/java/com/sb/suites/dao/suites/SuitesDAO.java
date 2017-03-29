package com.sb.suites.dao.suites;

import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.BaseDAO;
import com.sb.suites.entidades.suite.SuiteEntidad;
import com.sb.suites.entidades.usuarios.CatalogoEntidad;
import com.sb.suites.entidades.usuarios.UsuariosEntidad;
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
public class SuitesDAO extends BaseDAO {

    private static final String packageOracle = "XXSB_SUITES_PKG";

    public ArrayList<SuiteEntidad> obtenerSuites(int usuarioId, int recintoId, String suite, 
            String vigenciaini, String vigenciaFin, String suiteHabiente, String estatus) throws ExceptionCmm {
        ArrayList<SuiteEntidad> lista = new ArrayList<SuiteEntidad>();
        SuiteEntidad suites;
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".BUSCAR_SUITE_PRC (?," //i_UsuarioId
                + "?," //i_RecintoId
                + "?," //i_Suite
                + "?," //i_VigenciaInicio
                + "?," //i_VigenciaFin
                + "?," //i_SuiteHabiente
                + "?," //i_Estatus
                + "?)}";//c_Cursor
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setInt(2, recintoId);
            objlStmnt.setString(3, suite);
            objlStmnt.setString(4, vigenciaini);
            objlStmnt.setString(5, vigenciaFin);
            objlStmnt.setString(6, suiteHabiente);
            objlStmnt.setString(7, estatus);
            objlStmnt.registerOutParameter(8, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(8);
            while (rs.next()) {
                suites = new SuiteEntidad();
                suites.setSeccionUbicacionId(rs.getInt("SECCION_ID"));
                suites.setNombre(rs.getString("NOMBRE"));
                suites.setSecciones(rs.getString("NUMERO"));
                suites.setTipoSuite(rs.getString("TIPO_SUITE"));
                suites.setAforo(rs.getInt("AFORO"));
                suites.setTelefono(rs.getString("TELEFONO"));
                suites.setSuiteReservadaId(rs.getInt("RESERVADA"));
                suites.setSuiteHabiente(rs.getString("SUITE_HABIENTE"));
                suites.setVigencia(rs.getString("VIGENCIA"));
                suites.setEstatusId(rs.getInt("ESTATUS_ID"));
                lista.add(suites);
            }
        } catch (SQLException e) {
            System.err.println("");
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_getPerfilUsuario", e), "getPerfilUsuario", new Object[]{usuarioId,aplicacionId,perfilId});
        } finally {
            cleanVariables(rs, conn);
        }
        return lista;
    }

    public SuiteEntidad getSuite(int seccionId, String lenguajeId) throws ExceptionCmm {
        ResultSet rs = null;
        SuiteEntidad suiteEntity = new SuiteEntidad();
        final String QUERY = "{call " + packageOracle + ".SUITES_PRC(?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;

        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, seccionId);
            objlStmnt.setString(2, lenguajeId);
            objlStmnt.registerOutParameter(3, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(3);
            while (rs.next()) {
                suiteEntity.setRecintoUbicacionId(rs.getInt("RECINTO_ID"));
                suiteEntity.setRecinto(rs.getString("RECINTO"));
                suiteEntity.setSeccionUbicacionId(rs.getInt("SECCION_ID"));
                suiteEntity.setSecciones(rs.getString("NUMERO"));
                suiteEntity.setTipoId(rs.getInt("TIPO"));
                suiteEntity.setNombre(rs.getString("NOMBRE"));
                suiteEntity.setDireccion(rs.getString("DIRECCION"));
                suiteEntity.setTelefono(rs.getString("TELEFONO"));
                suiteEntity.setCelular(rs.getString("CELULAR"));
                suiteEntity.setEmail(rs.getString("EMAIL"));
                suiteEntity.setVigenciaInicio(rs.getString("VIGENCIA_INICIO"));
                suiteEntity.setVigenciaFin(rs.getString("VIGENCIA_FIN"));
                suiteEntity.setDiaNacimiento(rs.getInt("DIA_NACIMIENTO"));
                suiteEntity.setMesNacimiento(rs.getInt("MES_NACIMIENTO"));
                suiteEntity.setObservaciones(rs.getString("OBSERVACIONES"));
                suiteEntity.setAforo(rs.getInt("AFORO"));
                suiteEntity.setSuiteHabiente(rs.getString("SUITE_HABIENTE"));
                suiteEntity.setEstatusId(rs.getInt("ESTATUS_ID"));
                
                suiteEntity.setTipoContrato(rs.getInt("CONTRATO_TIPO"));
                suiteEntity.setCantidadEventos(rs.getInt("EVENTOS_CANTIDAD"));
                suiteEntity.setTipoEvento(rs.getInt("EVENTO_TIPO"));
                suiteEntity.setAplicaVigencia(rs.getInt("VIGENCIA_APLICA"));
                suiteEntity.setEstacionamientoId(rs.getInt("ESTACIONAMIENTO_ID"));
                suiteEntity.setCantidadEstacionamiento(rs.getInt("CANTIDAD_ESTACIONAMIENTO"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
//            this.generarEventoError(new ExceptionCmm("error_catalogos_getRecintos", e), "getSuite", new Object[]{seccionId, lenguajeId});
        } finally {
            cleanVariables(rs, conn);
        }
        return suiteEntity;
    }

    public int cambiarEstatusSuite(int usuarioId, int suiteId, int estatus) throws ExceptionCmm {
        int resp = 0;
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".CAMBIAR_ESTATUS_SUITE_PRC (?," //i_UsuarioId
                + "?," //i_RecintoId
                + "?)}";//c_Cursor
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setInt(2, suiteId);
            objlStmnt.setInt(3, estatus);
            objlStmnt.execute();
            resp = 1;
        } catch (SQLException e) {
            resp = -1;
            System.err.println(e.getMessage());
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_getPerfilUsuario", e), "getPerfilUsuario", new Object[]{usuarioId,aplicacionId,perfilId});
        } finally {
            cleanVariables(rs, conn);
        }
        return resp;
    }

    public int saveSuite(SuiteEntidad suiteEntity, int usuarioId) throws ExceptionCmm {
        int resp = 0;
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".SUITES_GUARDAR_PRC(?,"//i_UsuarioId
                + "?,"//i_SeccionId 
                + "?,"//i_Nombre
                + "?,"//i_Direccion
                + "?,"//i_Telefono
                + "?,"//i_Email
                + "?,"//i_VigenciaInicio
                + "?,"//i_VigenciaFin
                + "?,"//i_Observaciones
                + "?,"//i_EstatusId
                + "?,"//i_SuiteHabiente
                + "?,"//i_TipoContrato
                + "?,"//i_CantidadEventos
                + "?,"//i_TipoEvento
                + "?,"//i_AplicaVigencia
                + "?,"//i_EstacionamientoId
                + "?,"//i_CantidadEst
                + "?)}";//o_SeccionId
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setInt(2, suiteEntity.getSeccionUbicacionId());
            objlStmnt.setString(3, suiteEntity.getNombre());
            objlStmnt.setString(4, suiteEntity.getDireccion());
            objlStmnt.setString(5, suiteEntity.getTelefono());
            objlStmnt.setString(6, suiteEntity.getEmail());
            objlStmnt.setString(7, suiteEntity.getVigenciaInicio());
            objlStmnt.setString(8, suiteEntity.getVigenciaFin());
            objlStmnt.setString(9, suiteEntity.getObservaciones());
            objlStmnt.setInt(10, suiteEntity.getEstatusId());
            objlStmnt.setString(11, suiteEntity.getSuiteHabiente());            
            objlStmnt.setInt(12, suiteEntity.getTipoContrato());
            objlStmnt.setInt(13, suiteEntity.getCantidadEventos());
            objlStmnt.setInt(14, suiteEntity.getTipoEvento());
            objlStmnt.setInt(15, suiteEntity.getAplicaVigencia());
            objlStmnt.setInt(16, suiteEntity.getEstacionamientoId());
            objlStmnt.setInt(17, suiteEntity.getCantidadEstacionamiento());
            
            objlStmnt.registerOutParameter(18, OracleTypes.INTEGER);
            objlStmnt.execute();            
            resp = objlStmnt.getInt(18);
        } catch (Exception e) {
            resp = -1;
            System.out.print(e.getMessage());
//            this.generarEventoError(new ExceptionCmm("error_eventos_saveGeneralEventos", e));
        } finally {
            cleanVariables(rs, conn);
        }
        return resp;
    }
    
    public ArrayList<CatalogoEntidad> getEstacionaminetos(int seccionId, int usuarioId) throws ExceptionCmm {
        ResultSet rs = null;
        ArrayList<CatalogoEntidad> estacionamientos = new ArrayList<CatalogoEntidad>();
        final String QUERY = "{call " + packageOracle + ".ESTACIONA_SUITE_DISP_PRC(?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;

        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setInt(2, seccionId);
            objlStmnt.registerOutParameter(3, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(3);
            while (rs.next()) {
                CatalogoEntidad estacionamiento = new CatalogoEntidad();
                estacionamiento.setId(rs.getInt("ID"));
                estacionamiento.setValor(rs.getString("CAPACIDAD"));
                estacionamiento.setNombre(rs.getString("NOMBRE"));
                estacionamiento.setNombreCompleto(rs.getString("NOMBRE") + "("+ rs.getString("CAPACIDAD") +")"); 
                estacionamientos.add(estacionamiento);
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        } finally {
            cleanVariables(rs, conn);
        }
        return estacionamientos;
    }

}
