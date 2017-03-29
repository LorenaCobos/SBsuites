package com.sb.suites.dao.login;

import com.sb.suites.cmm.AnotacionMetodoAuditoria;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.BaseDAO;
import com.sb.suites.entidades.reporte.PresentacionEntidad;
import com.sb.suites.entidades.reporte.TerminalEntidad;
import com.sb.suites.entidades.usuarios.CatalogoEntidad;
import com.sb.suites.entidades.usuarios.FuncionalidadOperacion;
import com.sb.suites.entidades.usuarios.OpcionMenuLateralEntidad;
import com.sb.suites.entidades.usuarios.OpcionMenuPrincipalEntidad;
import com.sb.suites.entidades.usuarios.UsuariosEntidad;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;

/**
 *
 * @author fabiam molar
 */
public class LoginDAO extends BaseDAO {

    public static Logger logger = Logger.getLogger(LoginDAO.class);

    public static String XXSB_SUITES_PKG = "XXSB_SUITES_PKG";

    public LoginDAO() {
    }

    public UsuariosEntidad validaUsuario(String usuario, String pwd, int lenguajeId) throws ExceptionCmm {
        ResultSet rs = null;
        UsuariosEntidad usr = new UsuariosEntidad();
        final String QUERY = "{call " + XXSB_SUITES_PKG + ".LOGIN_USUARIO_PRC(?," +// i_Usuario 
                "?," +// i_contrasena
                "?," +// i_LengujeId
                "?," +// o_Integer
                "?" +// c_cursor
                ")}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setString(1, usuario);
            objlStmnt.setString(2, pwd);
            objlStmnt.setInt(3, lenguajeId);
            objlStmnt.registerOutParameter(4, OracleTypes.INTEGER);
            objlStmnt.registerOutParameter(5, OracleTypes.CURSOR);
            objlStmnt.execute();
            usr.setUsuarioId(objlStmnt.getInt(4));
            if (usr.getUsuarioId() != 0) {
                rs = (ResultSet) objlStmnt.getObject(5);
                while (rs.next()) {
                    usr.setUsuarioId(rs.getInt("USUARIO_ID"));
                    usr.setLogin(rs.getString("LOGIN"));
                    usr.setNombres(rs.getString("NOMBRE"));
                    usr.setPerfilId(rs.getInt("PERFIL_ID"));
                    usr.setPerfilNombre(rs.getString("NOMBRE"));
                    usr.setPerfilDescripcion(rs.getString("DESCRIPCION"));
                    usr.setAplicacionId(rs.getInt("APLICACION_ID"));
                    usr.setRecintos(rs.getString("RECINTO"));
                    usr.setRecintoUbicacionId(rs.getInt("RECINTO_ID"));
                }
            } else {
                usr.setUsuarioId(-2);
            }
        } catch (SQLException e) {
            usr.setUsuarioId(-1);
            logger.error(new ExceptionCmm("Error al obtener validaUsuario", e));
        } finally {
            cleanVariables(conn);
        }
        return usr;
    }

    public CatalogoEntidad recuperarUsuario(String correo, String constrasena, int tipo) throws ExceptionCmm {
        final String QUERY = "{call " + XXSB_SUITES_PKG + ".OBTENER_CONTRASENA_USUARIO_PRC(?," +// i_CorreoElectronico 
                "?," +// i_contrasena                                                                               
                "?," +// i_Tipo                                                                               
                "?," +// o_Resultado                                                                               
                "?" +// o_Login
                ")}";
        Connection conn = getConnectionAdmin();
        CatalogoEntidad resp = new CatalogoEntidad();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setString(1, correo);
            objlStmnt.setString(2, constrasena);
            objlStmnt.setInt(3, tipo);
            objlStmnt.registerOutParameter(4, OracleTypes.INTEGER);
            objlStmnt.registerOutParameter(5, OracleTypes.VARCHAR);
            objlStmnt.execute();
            resp.setId(objlStmnt.getInt(4));
            resp.setClave(objlStmnt.getString(5));
        } catch (SQLException e) {
            resp.setId(-1);
            logger.error(new ExceptionCmm("Error al obtener recuperarUsuario", e));
        } finally {
            cleanVariables(conn);
        }
        return resp;
    }

    @AnotacionMetodoAuditoria(Value = "public ArrayList<OpcionMenuPrincipalEntidad> getMenuModulosUsuario(int usuarioId,String lenguajeId)")
    public ArrayList<OpcionMenuPrincipalEntidad> getMenuModulosUsuario(int usuarioId, int aplicacionId, String lenguajeId) throws ExceptionCmm {
        ArrayList<OpcionMenuPrincipalEntidad> opcionesMenu = new ArrayList<OpcionMenuPrincipalEntidad>();
        OpcionMenuPrincipalEntidad opcionMenu = null;
        ResultSet rs = null;
        final String QUERY = "{call " + XXSB_SUITES_PKG + ".MENU_MODULOS_PRC(?,?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setInt(2, aplicacionId);
            objlStmnt.setString(3, lenguajeId);
            objlStmnt.registerOutParameter(4, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(4);
            while (rs.next()) {
                opcionMenu = new OpcionMenuPrincipalEntidad();
                opcionMenu.setAccionMenuPrincipal(rs.getString("NOMBRE_ACCION"));
                opcionMenu.setIdentificadorMenuPrincipal(rs.getInt("MODULO_ID"));
                opcionMenu.setOrdenMenuPrincipal(rs.getString("ORDEN"));
                opcionMenu.setUrlMenuPrincipal(rs.getString("URL"));
                opcionMenu.setNombreMenuPrincipal(rs.getString("NOMBRE"));
                opcionMenu.setHtmlIdMenuPrincipal(rs.getString("HTML_ID"));
                opcionMenu.setNombreObjetoMenuPrincipal(rs.getString("NOMBRE_OBJETO"));
                opcionesMenu.add(opcionMenu);
            }
        } catch (SQLException e) {
//            this.generarEventoError(new ExceptionCmm("error_seguridad_cargar_menu_modulos", e), "getMenuModulosUsuario", new Object[]{usuarioId, lenguajeId});
        } finally {
            cleanVariables(rs, conn);
        }
        return opcionesMenu;
    }

    @AnotacionMetodoAuditoria(Value = "public ArrayList<OpcionMenuLateral> getOperacionesUsuarioModulo(int usuarioId, int moduloId, String lenguajeId)")
    public ArrayList<OpcionMenuLateralEntidad> getOperacionesUsuarioModulo(int usuarioId, int aplicacionId, int moduloId, String lenguajeId) throws ExceptionCmm {
        ArrayList<OpcionMenuLateralEntidad> opcionesMenu = new ArrayList<OpcionMenuLateralEntidad>();
        OpcionMenuLateralEntidad opcionMenu = null;
        ResultSet rs = null;
        final String QUERY = "{call " + XXSB_SUITES_PKG + ".OPERACIONES_PRC(?,?,?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setInt(2, aplicacionId);
            objlStmnt.setString(3, lenguajeId);
            objlStmnt.setInt(4, moduloId);
            objlStmnt.registerOutParameter(5, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(5);
            while (rs.next()) {
                opcionMenu = new OpcionMenuLateralEntidad();
                opcionMenu.setAccionMenuLateral(rs.getString("NOMBRE_ACCION"));
                opcionMenu.setIdentificadorMenuLateral(rs.getInt("OPERACION_ID"));
                opcionMenu.setUrlMenuLateral(rs.getString("URL"));
                opcionMenu.setNombreMenuLateral(rs.getString("NOMBRE"));
                opcionMenu.setHtmlIdMenuLateral(rs.getString("HTML_ID"));
                opcionesMenu.add(opcionMenu);
            }
        } catch (SQLException e) {
//            this.generarEventoError(new ExceptionCmm("error_seguridad_cargar_menu_operaciones", e), "getOperacionesUsuarioModulo", new Object[]{usuarioId, moduloId, lenguajeId});
        } finally {
            cleanVariables(rs, conn);
        }
        return opcionesMenu;
    }

    @AnotacionMetodoAuditoria(Value = "public OpcionMenuLateralEntidad getModuloOperInicial(int usuarioId)")
    public OpcionMenuLateralEntidad getModuloOperInicial(int usuarioId) throws ExceptionCmm {
        OpcionMenuLateralEntidad opcionesMenu = new OpcionMenuLateralEntidad();
        ResultSet rs = null;
        final String QUERY = "{call " + XXSB_SUITES_PKG + ".OBTENER_MODULO_PRG(?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.registerOutParameter(2, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(2);
            while (rs.next()) {
                opcionesMenu.setAccionMenuLateral(rs.getString("NOMBRE_ACCION"));
                opcionesMenu.setIdentificadorMenuLateral(rs.getInt("OPERACION_ID"));
                opcionesMenu.setUrlMenuLateral(rs.getString("URL"));
                opcionesMenu.setHtmlIdMenuLateral(rs.getString("HTML_ID"));
            }
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
//            this.generarEventoError(new ExceptionCmm("error_seguridad_cargar_menu_operaciones", e), "getOperacionesUsuarioModulo", new Object[]{});
        } finally {
            cleanVariables(rs, conn);
        }
        return opcionesMenu;
    }

    public UsuariosEntidad logoutUsuario() throws ExceptionCmm {

        UsuariosEntidad usr = new UsuariosEntidad();

        usr.setUsuarioId(-1);
        usr.setLogin("");
        usr.setNombres("");
        usr.setPerfilId(0);
        usr.setPerfilNombre("");
        usr.setPerfilDescripcion("");
        usr.setAplicacionId(0);
        usr.setRecintos("");
        usr.setRecintoUbicacionId(0);

        //cleanVariables(conn);
        return usr;
    }
    
     public ArrayList<FuncionalidadOperacion> getFuncionalidadesOperacionesUsuario(int usuarioId) throws ExceptionCmm {
        ArrayList<FuncionalidadOperacion> opcionesFuncionalidad = new ArrayList<FuncionalidadOperacion>();
        FuncionalidadOperacion opcionFuncionalidad = null;
        ResultSet rs = null;
        final String QUERY = "{call " + XXSB_SUITES_PKG + ".FUNCIONALIDADES_PRC(?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.registerOutParameter(2, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(2);
            while (rs.next()) {
                opcionFuncionalidad = new FuncionalidadOperacion();

                opcionFuncionalidad.setHabilitado(false);
                if(rs.getInt("ACTIVO") == 1){
                
                     opcionFuncionalidad.setHabilitado(true);
                }
                opcionFuncionalidad.setNombreAccion(rs.getString("NOMBRE_ACCION"));
                opcionFuncionalidad.setHtmlId(rs.getString("HTML_ID"));
                opcionFuncionalidad.setTipoId(rs.getInt("TIPO_FUNCIONALIDAD_ID"));
                opcionesFuncionalidad.add(opcionFuncionalidad);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
//            this.generarEventoError(new ExceptionCmm("error_seguridad_cargar_menu_operaciones", e), "getFuncionalidadesOperacionesUsuario", new Object[]{usuarioId});
        } finally {
            cleanVariables(rs, conn);
        }
        return opcionesFuncionalidad;
    }

}
