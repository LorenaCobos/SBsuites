/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.dao.usuarios;

import com.sb.suites.cmm.AnotacionMetodoAuditoria;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.dao.BaseDAO;
import com.sb.suites.dwr.utils.AesDwr;
import com.sb.suites.entidades.usuarios.CatalogoEntidad;
import com.sb.suites.entidades.usuarios.FuncionalidadOperacion;
import com.sb.suites.entidades.usuarios.OpcionMenuLateralEntidad;
import com.sb.suites.entidades.usuarios.OpcionMenuPrincipalEntidad;
import com.sb.suites.entidades.usuarios.UsuariosEntidad;
import com.tecnet.utils.PasswordHashWeblogic;
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
public class UsuarioDAO extends BaseDAO {

    private static final String packageOracle = "XXSB_SUITES_PKG";

    @AnotacionMetodoAuditoria(Value = "public int saveUsuarioSistema(UsuarioUsuariosSistemaEntity usuarioSistema, int identificadorUsuarioId) throws ExceptionCmm")
    public int saveUsuarioSistema(UsuariosEntidad usuarioSistema, int identificadorUsuarioId) throws ExceptionCmm, Exception {
//        this.RegisterLog("saveUsuarioSistema", new Object[]{usuarioSistema, identificadorUsuarioId});
        int usuarioId = 0;
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".USUARIOS_SISTEMA_PRC(?,"//1 i_UsuarioRegId Usuario de session
                + "?,"//2 i_usuarioid usuario nuevo
                + "?,"//3 i_nombres
                + "?,"//4 i_apellidopaterno
                + "?,"//5 i_apellidomaterno
                + "?,"//6 i_telefono
                + "?,"//7 i_extencion
                + "?," //8  i_celular                                                                        
                + "?,"//9 i_email
                + "?,"//10 i_emailalterno
                + "?,"//11 i_login
                + "?,"//12 i_login
                + "?,"//13 i_estatusid
                + "?,"//14 i_tipoId
                + "?)}";//15 o_retorno id de usuario registrado
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            
            //String contrasenaWL = PasswordHashWeblogic.addHashWeblogicToSHA1(usuarioSistema.getContrasena());

            
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, identificadorUsuarioId);
            objlStmnt.setInt(2, usuarioSistema.getUsuarioId());
            objlStmnt.setString(3, usuarioSistema.getNombres());
            objlStmnt.setString(4, usuarioSistema.getApellidoPaterno());
            objlStmnt.setString(5, usuarioSistema.getApellidoMaterno());
            objlStmnt.setString(6, usuarioSistema.getTelefono());
            objlStmnt.setString(7, usuarioSistema.getExtencion());
            objlStmnt.setString(8, usuarioSistema.getCelular());
            objlStmnt.setString(9, usuarioSistema.getEmail());
            objlStmnt.setString(10, usuarioSistema.getEmailAlterno());
            objlStmnt.setString(11, usuarioSistema.getLogin());
            objlStmnt.setString(12, usuarioSistema.getContrasena()); //AesDwr.decrypt
            objlStmnt.setInt(13, usuarioSistema.getEstatusId());
            objlStmnt.setInt(14, usuarioSistema.getTipoId());
            objlStmnt.registerOutParameter(15, OracleTypes.INTEGER);
            objlStmnt.execute();
            usuarioId = ((Integer) objlStmnt.getObject(15)).intValue();
        } catch (SQLException e) {
            usuarioId = -1;
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_saveUsuario", e));
        } catch (Error ex) {
            usuarioId = -1;
        } finally {
            cleanVariables(rs, conn);
        }
        return usuarioId;
    }

    public int cambiarEstatusUsuario(int usuarioId, int suiteId, int estatus) throws ExceptionCmm {
        int resp = 0;
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".CAMBIAR_ESTATUS_USUARIO_PRC (?," //i_UsuarioidReg
                + "?," //i_UsuarioId
                + "?)}";//i_EstatusId
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

    @AnotacionMetodoAuditoria(Value = "public int saveContrasenaUsuario(String nuevaContrasena, int preguntaSecretaId, String respuesta, int identificadorUsuario) throws ExceptionCmm")
    public int saveContrasenaUsuario(String nuevaContrasena, int preguntaSecretaId, String respuesta, int identificadorUsuario) throws ExceptionCmm {
//        this.RegisterLog("saveContrasenaUsuario", new Object[]{nuevaContrasena, preguntaSecretaId, respuesta, identificadorUsuario});
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".SALVAR_CONTRASENA_USUARIO_PRC(?,?,?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;

        String contrasenaWL = PasswordHashWeblogic.addHashWeblogicToSHA1(nuevaContrasena);

        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, identificadorUsuario);
            objlStmnt.setString(2, nuevaContrasena.toUpperCase());
            objlStmnt.setString(3, contrasenaWL);
            objlStmnt.setInt(4, preguntaSecretaId);
            objlStmnt.setString(5, respuesta);
            objlStmnt.execute();
        } catch (SQLException e) {
            identificadorUsuario = -1;
            System.err.println(e.getMessage());
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_saveContrasenaUsuario", e));
        } finally {
            cleanVariables(rs, conn);
        }

        return identificadorUsuario;
    }

    @AnotacionMetodoAuditoria(Value = "public UsuarioUsuariosSistemaEntity getUsuario(int identificadorUsuario)")
    public UsuariosEntidad getUsuario(int identificadorUsuario) throws ExceptionCmm {
        UsuariosEntidad usuarioUsuariosSistemaEntity = new UsuariosEntidad();
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".USUARIOS_SISTEMA_PRC(?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, identificadorUsuario);
            objlStmnt.registerOutParameter(2, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(2);
            while (rs.next()) {
                usuarioUsuariosSistemaEntity.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                usuarioUsuariosSistemaEntity.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                usuarioUsuariosSistemaEntity.setCelular(rs.getString("CELULAR"));
                usuarioUsuariosSistemaEntity.setDescripcion(rs.getString("DESCRIPCION"));
                usuarioUsuariosSistemaEntity.setEmail(rs.getString("EMAIL"));
                usuarioUsuariosSistemaEntity.setEmailAlterno(rs.getString("EMAIL_ALTERNO"));
                usuarioUsuariosSistemaEntity.setEstatusId(rs.getInt("ESTATUS_ID"));
                usuarioUsuariosSistemaEntity.setExtencion(rs.getString("EXTENCION"));
                usuarioUsuariosSistemaEntity.setLogin(rs.getString("LOGIN"));
                usuarioUsuariosSistemaEntity.setNombres(rs.getString("NOMBRES"));
                usuarioUsuariosSistemaEntity.setPerfilId(rs.getInt("PERFIL_ID"));
                usuarioUsuariosSistemaEntity.setPreguntaSecretaId(rs.getInt("PREGUNTA_ID"));
                usuarioUsuariosSistemaEntity.setPuestoId(rs.getInt("PUESTO_ID"));
                usuarioUsuariosSistemaEntity.setRespuesta(rs.getString("RESPUESTA"));
                usuarioUsuariosSistemaEntity.setTelefono(rs.getString("TELEFONO"));
                usuarioUsuariosSistemaEntity.setUsuarioId(rs.getInt("USUARIO_ID"));
                usuarioUsuariosSistemaEntity.setZonaId(rs.getInt("ZONA_ID"));
                usuarioUsuariosSistemaEntity.setValidaMac(rs.getInt("IGNORA_MAC") == 1 ? 6 : 5);
                usuarioUsuariosSistemaEntity.setFechaVigencia(rs.getString("FECHA_VIGENCIA"));
                usuarioUsuariosSistemaEntity.setFechaUltimaSesion(rs.getString("FECHA_ULTIMA_SESION"));
                usuarioUsuariosSistemaEntity.setEstatusId(rs.getInt("ESTATUS_ID"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_getUsuario", e), "getUsuario", new Object[]{identificadorUsuario});
        } finally {
            cleanVariables(rs, conn);
        }
        return usuarioUsuariosSistemaEntity;
    }

    public UsuariosEntidad getPerfilUsuario(int usuarioId, int aplicacionId, int perfilId) throws ExceptionCmm {
        UsuariosEntidad usuarioUsuariosSistemaEntity = new UsuariosEntidad();
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".GET_PERFIL_USUARIO_PRC (?,?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, aplicacionId);
            objlStmnt.setInt(2, perfilId);
            objlStmnt.setInt(3, usuarioId);
            objlStmnt.registerOutParameter(4, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(4);
            while (rs.next()) {
                usuarioUsuariosSistemaEntity.setPerfilId(rs.getInt("PERFIL_ID"));
                usuarioUsuariosSistemaEntity.setAplicacionId(rs.getInt("APLICACION_ID"));
            }
        } catch (SQLException e) {
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_getPerfilUsuario", e), "getPerfilUsuario", new Object[]{usuarioId,aplicacionId,perfilId});
        } finally {
            cleanVariables(rs, conn);
        }
        return usuarioUsuariosSistemaEntity;
    }

    @AnotacionMetodoAuditoria(Value = "public boolean isValidaContrasenaUsuario(String contrasena, int usuarioId)")
    public boolean isValidaContrasenaUsuario(String contrasena, int usuarioId) throws ExceptionCmm {
        Boolean nombreValido = false;
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".VALIDA_CONTRASENA_USUARIO_PRC(?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setString(2, contrasena);
            objlStmnt.registerOutParameter(3, OracleTypes.VARCHAR);
            objlStmnt.execute();
            String valido = (String) objlStmnt.getObject(3);
            nombreValido = new Boolean(valido);
        } catch (SQLException e) {
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_isValidaContrasenaUsuario", e), "isValidaContrasenaUsuario", new Object[]{contrasena, usuarioId});
        } finally {
            cleanVariables(rs, conn);
        }
        return nombreValido;
    }

    @AnotacionMetodoAuditoria(Value = "public ArrayList<CatalogoEntity> getPerfilesCatalogo()")
    public ArrayList<CatalogoEntidad> getPerfilesCatalogo() throws ExceptionCmm {
        ArrayList<CatalogoEntidad> perfiles = new ArrayList<CatalogoEntidad>();
        CatalogoEntidad perfil = null;
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".PERFILES_SISTEMA_CAT_PRC(?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;

        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.registerOutParameter(1, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs
                    = (ResultSet) objlStmnt.getObject(1);
            while (rs.next()) {

                perfil = new CatalogoEntidad();
                perfil.setId(rs.getInt("PERFIL_ID"));
                perfil.setNombre(rs.getString("NOMBRE"));
                perfiles.add(perfil);
            }

        } catch (SQLException e) {
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_getPerfilesCatalogo", e), "getPerfilesCatalogo", null);
        } finally {
            cleanVariables(rs, conn);
        }
        return perfiles;
    }

    @AnotacionMetodoAuditoria(Value = "public void savePerfilUsuarioSistema(UsuarioUsuariosSistemaEntity usuarioSistema, int identificadorUsuarioId)")
    public void savePerfilUsuarioSistema(UsuariosEntidad usuarioSistema, int identificadorUsuarioId) throws ExceptionCmm {
//        this.RegisterLog("savePerfilUsuarioSistema", new Object[]{usuarioSistema, identificadorUsuarioId});
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".SAVE_PERFIL_USUARIO_PRC(?,?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, identificadorUsuarioId);
            objlStmnt.setInt(2, usuarioSistema.getPerfilId());
            objlStmnt.setInt(3, usuarioSistema.getAplicacionId());
            objlStmnt.setInt(4, usuarioSistema.getUsuarioId());
            objlStmnt.execute();

        } catch (SQLException e) {
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_savePerfilUsuario", e), "savePerfilUsuarioSistema", new Object[]{usuarioSistema, identificadorUsuarioId});
        } finally {
            cleanVariables(rs, conn);
        }
    }

    @AnotacionMetodoAuditoria(Value = "deletePerfilUsuarioSistema(int usuarioId, int aplicacionId, int perfilId) throws ExceptionCmm ")
    public void deletePerfilUsuarioSistema(int usuarioId, int aplicacionId, int perfilId) throws ExceptionCmm {
//        this.RegisterLog("deletePerfilUsuarioSistema", new Object[]{usuarioId, aplicacionId,perfilId});
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".DELETE_PERFIL_USUARIO_PRC(?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, aplicacionId);
            objlStmnt.setInt(2, perfilId);
            objlStmnt.setInt(3, usuarioId);
            objlStmnt.execute();

        } catch (SQLException e) {
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_deletePerfilUsuarioSistema", e));
        } finally {
            cleanVariables(rs, conn);
        }
    }

    @AnotacionMetodoAuditoria(Value = "public ArrayList<OpcionMenuPrincipalEntidad> getMenuModulosUsuario(int usuarioId,String lenguajeId)")
    public ArrayList<OpcionMenuPrincipalEntidad> getMenuModulosUsuario(int usuarioId, int aplicacionId, String lenguajeId) throws ExceptionCmm {
        ArrayList<OpcionMenuPrincipalEntidad> opcionesMenu = new ArrayList<OpcionMenuPrincipalEntidad>();
        OpcionMenuPrincipalEntidad opcionMenu = null;
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".MENU_MODULOS_PRC(?,?,?,?)}";
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
        final String QUERY = "{call " + packageOracle + ".OPERACIONES_PRC(?,?,?,?,?)}";
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

    @AnotacionMetodoAuditoria(Value = "public UsuarioUsuariosSistemaEntity getUsuario(int identificadorUsuario)")
    public ArrayList<UsuariosEntidad> getUsuarios(int usuarioId, String nombre, String correo, int tipo, String estatus, int recinto, int suite, int lenguajeId) throws ExceptionCmm {
        ArrayList<UsuariosEntidad> listado = new ArrayList<UsuariosEntidad>();
        UsuariosEntidad usuarioUsuariosSistemaEntity = new UsuariosEntidad();
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".USUARIOS_SISTEMA_PRC("
                + "?,?,?,"
                + "?,?,?,"
                + "?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setString(2, nombre);
            objlStmnt.setString(3, correo);
            objlStmnt.setInt(4, tipo);
            objlStmnt.setString(5, estatus);
            objlStmnt.setInt(6, recinto);
            objlStmnt.setInt(7, suite);
            objlStmnt.setInt(8, lenguajeId);
            objlStmnt.registerOutParameter(9, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(9);
            while (rs.next()) {
                // nombre, correo, suite, tipo, activo
                usuarioUsuariosSistemaEntity = new UsuariosEntidad();
                usuarioUsuariosSistemaEntity.setNombres(rs.getString("NOMBRES"));
                usuarioUsuariosSistemaEntity.setEmail(rs.getString("EMAIL"));
                usuarioUsuariosSistemaEntity.setSuiteNombre(rs.getString("SUITE"));
                usuarioUsuariosSistemaEntity.setPerfilNombre(rs.getString("TIPO"));
                usuarioUsuariosSistemaEntity.setEstatusId(rs.getInt("ESTATUS_ID"));
                usuarioUsuariosSistemaEntity.setUsuarioId(rs.getInt("USUARIO_ID"));
                listado.add(usuarioUsuariosSistemaEntity);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
//            this.generarEventoError(new ExceptionCmm("error_usuarios_sistema_getUsuario", e), "getUsuario", new Object[]{identificadorUsuario});
        } finally {
            cleanVariables(rs, conn);
        }
        return listado;
    }

    public UsuariosEntidad getUsuario(int usuarioId, String lenguajeId) throws ExceptionCmm {
        ResultSet rs = null;
        //SuiteEntidad suiteEntity = new SuiteEntidad();
        UsuariosEntidad userEntity = new UsuariosEntidad();

        final String QUERY = "{call " + packageOracle + ".USUARIOS_PRC(?,?,?)}";
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;

        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setString(2, lenguajeId);
            objlStmnt.registerOutParameter(3, OracleTypes.CURSOR);
            objlStmnt.execute();
            rs = (ResultSet) objlStmnt.getObject(3);
            while (rs.next()) {

                userEntity.setUsuarioId(rs.getInt("USUARIO_ID"));
                userEntity.setNombres(rs.getString("NOMBRES"));
                userEntity.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                userEntity.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));

                userEntity.setTelefono(rs.getString("TELEFONO"));
                userEntity.setExtencion(rs.getString("EXTENCION"));
                userEntity.setCelular(rs.getString("CELULAR"));

                userEntity.setEmail(rs.getString("EMAIL"));
                userEntity.setEmailAlterno(rs.getString("EMAIL_ALTERNO"));

                userEntity.setLogin(rs.getString("USUARIO"));
                userEntity.setContrasena(rs.getString("CONTRASENA"));

                userEntity.setTipo(rs.getString("TIPO_ID"));
                userEntity.setEstatusId(rs.getInt("ESTATUS_ID"));

            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
//            this.generarEventoError(new ExceptionCmm("error_catalogos_getRecintos", e), "getSuite", new Object[]{seccionId, lenguajeId});
        } finally {
            cleanVariables(rs, conn);
        }
        return userEntity;
    }

    public int cambiarEstatusSuite(int usuarioId, int usuarioRefId, int suiteId, int tipo) throws ExceptionCmm {
        int resp = 0;
        ResultSet rs = null;
        final String QUERY = "{call " + packageOracle + ".MOD_SUITE_USUARIO_PRC (?," //i_UsuarioId
                + "?," //usuarioRefId
                + "?," //suiteId
                + "?)}";//tipo
        Connection conn = getConnectionAdmin();
        CallableStatement objlStmnt;
        try {
            objlStmnt = conn.prepareCall(QUERY);
            objlStmnt.setInt(1, usuarioId);
            objlStmnt.setInt(2, usuarioRefId);
            objlStmnt.setInt(3, suiteId);
            objlStmnt.setInt(4, tipo);
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

}
