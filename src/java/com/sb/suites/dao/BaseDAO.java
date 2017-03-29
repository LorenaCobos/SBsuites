/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.dao;

import java.sql.PreparedStatement;
import java.util.Locale;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.cmm.IEventoErrorDAOListener;
import java.util.ResourceBundle;
import java.sql.DriverManager;
import oracle.jdbc.OracleDriver;
/**
 * @author  Fabian Molar
 */
public class BaseDAO {

    protected static ResourceBundle codigos;
    protected static ResourceBundle errors;
    protected IEventoErrorDAOListener objErrorReceptor;
    protected static Locale locale=Locale.getDefault();

    {
        codigos = ResourceBundle.getBundle("com.sb.suites.dao.recursos.CodesDAO", Locale.getDefault());
        errors = ResourceBundle.getBundle("com.sb.suites.dao.recursos.ErrorsDAO", Locale.getDefault());  
    }  

    public BaseDAO(){
    }

    
    protected Connection getConnectionVentas() throws ExceptionCmm {
        try {
            
	    //desarrollo
            DriverManager.registerDriver(new OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@" + codigos.getString("key_sources_url_ventas") + ":" + codigos.getString("key_sources_port_ventas") + ":" + codigos.getString("key_sources_instacia_ventas") + "", codigos.getString("key_sources_user_ventas"), codigos.getString("key_sources_password_ventas"));
//	    //Produccion
//            Connection con = ServiceLocator.getInstance().getDataSource(codigos.getString("ds.jndiName")).getConnection();
            //Produccion Nuevo
//            Connection con = ServiceLocatorWL.getInstance().getDataSource(codigos.getString("ds.jndiName")).getConnection();
	    //Produccion local
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.19.0.113)(PORT=1521))(CONNECT_DATA=(SID=xxsbprod2)))", "sb_ventasqa", "ventas");
	    //QA
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.10.2.108)(PORT=1521))(CONNECT_DATA=(SID=XXSBQA)))", "SB_VENTASQA", "ventas");
            return con;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new ExceptionCmm(errors.getString("error_coneccion_abrir"));
        }
    }

    protected Connection getConnectionAdmin() throws ExceptionCmm {
        try {
          
//	    Desarrollo
            DriverManager.registerDriver(new OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@" + codigos.getString("key_sources_url") + ":" + codigos.getString("key_sources_port") + ":" + codigos.getString("key_sources_instacia") + "", codigos.getString("key_sources_user"), codigos.getString("key_sources_password"));
//	    Produccion
//            Connection con = ServiceLocator.getInstance().getDataSource(codigos.getString("ds.admin.jndiName")).getConnection();
//            Produccion Nuevo
//            Connection con = ServiceLocatorWL.getInstance().getDataSource(codigos.getString("ds.jndiName")).getConnection();
	    //Produccion local
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.19.0.113)(PORT=1521))(CONNECT_DATA=(SID=xxsbprod2)))", "xxsbqa", "xxsbqa");
	    //QA
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.10.2.108)(PORT=1521))(CONNECT_DATA=(SID=XXSBQA)))", "XXSBQA", "xxsbqa");
            return con;
        } catch (SQLException sqle) { 
           sqle.printStackTrace();
            throw new ExceptionCmm(errors.getString("error_coneccion_abrir"));
        }
    }

    /**
     * M�todo en el cual se cierran ResultSet, PreparedStatement y la conexión, dependiendo su status.
     *
     * @param rs ResultSet
     * @param ps PreparedStatement
     * @param con Coneccion
     * @throws ExceptionCmm
     */
    protected void cleanVariables(ResultSet rs, PreparedStatement ps, Connection con) throws ExceptionCmm {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new ExceptionCmm(errors.getString("error_coneccion_cerrar"));
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new ExceptionCmm(errors.getString("error_coneccion_cerrar"));
            }
        }
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            throw new ExceptionCmm(errors.getString("error_coneccion_cerrar"));
        }
    }

    /**
     * M�todo que envia a cerrar el PreparedStatement y la connection
     *
     * @param ps PreparedStatement
     * @param con Connection
     * @throws ExceptionCmm
     */
    protected void cleanVariables(PreparedStatement ps, Connection con) throws ExceptionCmm {
        cleanVariables(null, ps, con);
    }

    /**
     * M�todo que envia a cerrar el ResultSet y la Connection
     *
     * @param rs ResultSet
     * @param con Connection
     * @throws ExceptionCmm
     */
    protected void cleanVariables(ResultSet rs, Connection con) throws ExceptionCmm {
        cleanVariables(rs, null, con);
    }

    /**
     * M�todo que envia a cerrar la connection
     *
     * @param con Connection
     * @throws ExceptionCmm
     */
    protected void cleanVariables(Connection con) throws ExceptionCmm {
        cleanVariables(null, null, con);
    }

    /**
     * M�todo que envia a cerrar el ResultSet
     *
     * @param rs ResultSet
     * @throws ExceptionCmm
     */
    protected void cleanVariables(ResultSet rs) throws ExceptionCmm {
        cleanVariables(rs, null, null);
    }

    protected String getFileName(String filePath)
    {
        return filePath;
    }
}
