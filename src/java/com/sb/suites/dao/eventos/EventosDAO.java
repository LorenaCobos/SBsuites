package com.sb.suites.dao.eventos;

import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.BaseDAO;
import com.sb.suites.entidades.eventos.DetalleImpresion;
import com.sb.suites.entidades.eventos.ResumenDetalleImpresion;
import com.sb.suites.entidades.suite.SuiteEntidad;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Fabian Molar
 */
public class EventosDAO extends BaseDAO {

    public static String SUITES_PKG = "SUITES_PKG";
    public static String XXSB_SUITES_PKG = "XXSB_SUITES_PKG";

    public ArrayList<SuiteEntidad> getSuitesPresentaciones(int recintoId, String evento, String estatus, String fechaInicio, String fechaFin, String secciones) throws ExceptionCmm {
        ArrayList<SuiteEntidad> listaResultados = new ArrayList<SuiteEntidad>();
        ResultSet rs = null;
        final String QUERY = "{call " + SUITES_PKG + ".GET_EVENTOS_PRC("
                + "?," + // i_RecintoId
                "?," + // i_evento
                "?," + // i_Estatus
                "?," + // i_FechaInicio
                "?," + // i_FechaFin
                "?," + // i_Secciones
                "?" + // c_Cursor
                ")}";
        Connection conn = getConnectionVentas();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, recintoId);//411
            objlStmnt.setString(2, evento);//""
            objlStmnt.setString(3, estatus);//0
            objlStmnt.setString(4, fechaInicio);//""
            objlStmnt.setString(5, fechaFin);//""
            objlStmnt.setString(6, secciones);//3569,5470,5656,3746,3567,5439,3744,5346,3299,3440,4959,3987,5599,5653,4577,3581,3737,3219,3989,4716,5699,5454,5469,5554,5676,3297,3438,4260,4059,4258,5148,5299,4961,5700,5440,5664,5672,3259,3277,4575,5539,4009,5540,4007,5347,3583,3279,4058,3739,3751,3195,5455,5662,3257,5147,4714,5600,5555,5303,3747
            objlStmnt.registerOutParameter(7, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(7);
            while (rs.next()) {
                SuiteEntidad suiteEntity = new SuiteEntidad();
                suiteEntity.setPresentacionId(rs.getInt("PRESENTACION_ID"));
                suiteEntity.setPresentacion(rs.getString("PRESENTACION"));
                suiteEntity.setFechaPresentacion(rs.getString("FECHA_PRESENTACION"));
                suiteEntity.setEventoId(rs.getInt("EVENTO_ID"));
                suiteEntity.setEvento(rs.getString("EVENTO"));
                suiteEntity.setEstatusId(rs.getInt("ESTATUS_ID"));
                suiteEntity.setRuta(rs.getString("IMG_EST")); 
                listaResultados.add(suiteEntity);
            }
        } catch (SQLException e) {
            System.err.println("");
//            this.generarEventoError(new ExceptionCmm("error_eventos_getEventos", e), "getSuitesPresentacionesGrid", new Object[]{pagina, filas, secciones, anioImpresionId, mesImpresionId, eventoId, campoOrden, orden});
        } finally {
            cleanVariables(rs, conn);
        }
        return listaResultados;
    }

    public ArrayList<SuiteEntidad> getSuitesPresentacionesUsuario(int recintoId, String evento, String fechaInicio, String fechaFin, int secciones) throws ExceptionCmm {
        ArrayList<SuiteEntidad> listaResultados = new ArrayList<SuiteEntidad>();
        ResultSet rs = null;
        final String QUERY = "{call " + SUITES_PKG + ".GET_EVENTOS_USU_PRC("
                + "?," + // i_RecintoId
                "?," + // i_evento
                "?," + // i_FechaInicio
                "?," + // i_FechaFin
                "?," + // i_SeccionId8325
                "?" + // c_Cursor 
                ")}";

        Connection conn = getConnectionVentas();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, recintoId);
            objlStmnt.setString(2, evento);
            objlStmnt.setString(3, fechaInicio);
            objlStmnt.setString(4, fechaFin);
            objlStmnt.setInt(5, secciones);
            objlStmnt.registerOutParameter(6, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(6);
            while (rs.next()) {
                SuiteEntidad suiteEntity = new SuiteEntidad();
                suiteEntity.setPresentacionId(rs.getInt("PRESENTACION_ID"));
                suiteEntity.setPresentacion(rs.getString("PRESENTACION"));
                suiteEntity.setFechaPresentacion(rs.getString("FECHA_PRESENTACION"));
                suiteEntity.setEventoId(rs.getInt("EVENTO_ID"));
                suiteEntity.setEvento(rs.getString("EVENTO"));
                suiteEntity.setLugaresDisponibles(rs.getInt("LUGARES_DISPONIBLES"));
                suiteEntity.setInvitaciones(rs.getInt("INVITACIONES"));
                suiteEntity.setRecinto(rs.getString("RECINTO"));
                suiteEntity.setRecintoId(rs.getInt("RECINTO_ID"));
                suiteEntity.setCantidadEstacionamiento(rs.getInt("EST_DISPONIBLES"));
                suiteEntity.setEstacionamientoId(rs.getInt("ESTACIONAMIENTO_ID"));
                suiteEntity.setNombreSuite(rs.getString("SUITE"));
                listaResultados.add(suiteEntity);
            }
        } catch (SQLException e) {
            System.err.println("");
//            this.generarEventoError(new ExceptionCmm("error_eventos_getEventos", e), "getSuitesPresentacionesGrid", new Object[]{pagina, filas, secciones, anioImpresionId, mesImpresionId, eventoId, campoOrden, orden});
        } finally {
            cleanVariables(rs, conn);
        }
        return listaResultados;
    }

    public String getTipoSeccionParaVenta(int tipoSuite, int reintoId) throws ExceptionCmm {
        String resultado = "";
        ResultSet rs = null;
        final String QUERY = "{call " + XXSB_SUITES_PKG + ".SUI_OBTEN_TSEC_VENTA_PRC("
                + "?," + // i_tipoSuite
                "?," + // i_RecintoId            
                "?" + // o_Cursor
                ")}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, tipoSuite);
            objlStmnt.setInt(2, reintoId);
            objlStmnt.registerOutParameter(3, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(3);
            while (rs.next()) {
                resultado += String.valueOf(rs.getInt("PLANTILLA_NIVEL_ID")) + ",";
            }
            //Quitamos la ',' que tiene al final.
            if (resultado.length() > 0) {
                if (resultado.substring(resultado.length() - 1).equalsIgnoreCase(",") == true) {
                    resultado = resultado.substring(0, resultado.length() - 1);
                }
            }
        } catch (SQLException e) {
            System.err.println("");
//            this.generarEventoError(new ExceptionCmm("error_impresionSuites_getSeccionParaVenta", e), "getSeccionParaVenta", new Object[]{tipoSuite});
        } finally {
            cleanVariables(rs, conn);
        }
        return resultado;
    }

    public int cambiarEstatusPresentacion(int usuarioId, int presentacionId, int estatus) throws ExceptionCmm {
        int resp = 0;
        ResultSet rs = null;
        final String QUERY = "{call " + SUITES_PKG + ".ESTATUS_PRESENTACION_PRC (?," //i_Usuarioid
                + "?," //i_PresentacionId
                + "?)}";//i_EstatusId
        Connection conn = getConnectionVentas();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setInt(2, presentacionId);
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
    
    public ResumenDetalleImpresion resumenImpresos(int usuarioId,int eventoId,int presentacionId,int seccionId, int lenguajeId) throws ExceptionCmm{
        ResumenDetalleImpresion detalle = new ResumenDetalleImpresion();
	ArrayList<DetalleImpresion> resultado = new ArrayList<DetalleImpresion>();
	ResultSet rs = null;
        int disponibles = 0;
        int estacionamientos = 0;
        final String QUERY = "{call "+SUITES_PKG+".DETALLE_IMPRESIONES_PRC( ?,"+ // usuarioId 
                                                                            "?," +// eventoId
                                                                            "?," +// presentacionId
                                                                            "?," +// seccionId
                                                                            "?," +// lenguajeId
                                                                            "?," +// o_Cursor
                                                                            "?," +// o_LugaresDiponibles
                                                                            "?)}";// o_EstacionamienosDiponibles
        
        Connection conn = getConnectionVentas();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);//1493
            objlStmnt.setInt(2, eventoId);//11563
            objlStmnt.setInt(3, presentacionId);//17260
            objlStmnt.setInt(4, seccionId);//8325
            objlStmnt.setInt(5, lenguajeId);//1
            objlStmnt.registerOutParameter(6, OracleTypes.CURSOR);
            objlStmnt.registerOutParameter(7, OracleTypes.INTEGER);//4
            objlStmnt.registerOutParameter(8, OracleTypes.INTEGER);//4
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(6);
            disponibles = objlStmnt.getInt(7);
            estacionamientos = objlStmnt.getInt(8);
            DetalleImpresion detalleImpresion;
            while (rs.next()) {
            	detalleImpresion = new DetalleImpresion();
            	
            	detalleImpresion.setCantidad(rs.getInt("CANTIDAD"));
            	detalleImpresion.setCantidadEstacionamientos(rs.getInt("CANTIDAD_ESTACIONAMIENTOS"));
            	detalleImpresion.setClaveTipoBoleto(rs.getString("CLAVE_TIPO_BOLETO"));
            	detalleImpresion.setFechaCreacion(rs.getString("CREACION_FECHA"));
                detalleImpresion.setFechaactualizacion(rs.getString("FECHA_MOFI"));
            	detalleImpresion.setNombrePresentacion(rs.getString("PRESENTACION_NOMBRE"));
            	detalleImpresion.setNombreSeccion(rs.getString("SECCION"));
            	detalleImpresion.setNombreUsusario(rs.getString("USUARIO"));
            	detalleImpresion.setNombreZonaPrecio(rs.getString("ZONA_PRECIO"));
            	detalleImpresion.setPrecio(rs.getDouble("PRECIO"));
            	detalleImpresion.setPresentacionId(rs.getInt("PRESENTACION_ID"));
            	detalleImpresion.setSeccionId(rs.getInt("SECCION_ID"));
            	detalleImpresion.setTipoBoleto(rs.getString("TIPO_BOLETO"));
            	detalleImpresion.setTransaccionId(rs.getInt("TRANSACCION_ID"));
            	detalleImpresion.setZonaPrecioId(rs.getInt("ZONA_PRECIO_ID"));
            	detalleImpresion.setRegionId(rs.getInt("REGION_ID"));
            	detalleImpresion.setAsignacionNombre(rs.getString("NOMBRE_ASIGNACION"));
            	detalleImpresion.setAsignacionTipo(rs.getString("TIPO_ASIGNACION"));
            	detalleImpresion.setAsignacionNombreId(rs.getInt("ASIGNACION_NOMBRE_ID"));
            	detalleImpresion.setAsignacionTipoId(rs.getInt("ASIGNACION_TIPO_ID"));
            	detalleImpresion.setCreacionUsuario(rs.getInt("CREACION_USUARIO"));
            	detalleImpresion.setCantidadCancelados(rs.getInt("CANTIDAD_CANCELADOS"));
            	detalleImpresion.setCantidadImpresos(rs.getInt("CANTIDAD_IMPRESOS"));
            	detalleImpresion.setCorreo(rs.getString("CORREO"));
            	detalleImpresion.setClaveEstatus(rs.getString("CLAVE_ESTATUS_BOLETO"));
            	resultado.add(detalleImpresion);
            }
            detalle.setDetalle(resultado);
            detalle.setLugaresDisponibles(disponibles);
            detalle.setEstacionamientosDisponibles(estacionamientos);
        }catch (SQLException e){
            System.err.println(e.getMessage());
//            this.generarEventoError(new ExceptionCmm("Error al obtener resumenImpresos", e));
        }finally{
            cleanVariables(rs, conn);
        }
        return detalle;
	}
    
    public int saveArchivo(int archivoId, int repossitorio, String nombre, int entidadId, int usuarioId) throws ExceptionCmm {
        ResultSet rs = null;
        int resultado = 0;
        final String QUERY = "{call " + XXSB_SUITES_PKG + ".ARCHIVO_SAVE_PRC("
                + "?," //i_ArchivoId
                + "?," //i_RepositorioId
                + "?," //i_Nombre
                + "?," //i_EntidadId 
                + "?," //i_UsuarioId
                + "?"  //o_Retorno
                + ")}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, archivoId);//0
            objlStmnt.setInt(2, repossitorio);//56
            objlStmnt.setString(3, nombre);//Evento_11563
            objlStmnt.setInt(4, entidadId);//11563
            objlStmnt.setInt(5, usuarioId);//1493
            objlStmnt.registerOutParameter(6, OracleTypes.INTEGER);
            objlStmnt.execute();
            resultado = objlStmnt.getInt(6);
        } catch (Exception e) {
             System.err.println(e.getMessage());
        } finally {
            cleanVariables(rs, conn);
        }
        return resultado;
    }

}
