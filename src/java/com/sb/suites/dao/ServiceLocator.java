/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author fabiam molar
 */
public class ServiceLocator {

    /** The logging facility */
    private static final Log log = LogFactory.getLog(ServiceLocator.class);

    /* used to hold references to Resources for re-use */
    private Map<String, DataSource> cache;

    //Jboss
    private InitialContext ic;
    //Tomcat
    //private Context ic;
    private Context ec;

    private static ServiceLocator locator;

    static {
        try {
            locator = new ServiceLocator();
        } catch (ServiceLocatorException se) {
            log.error(se);
            se.printStackTrace(System.err);
        }
    }

    private ServiceLocator() throws ServiceLocatorException {
        try {
            ic = new InitialContext();
            //ec = (Context) ic.lookup("java:/comp/env");
            cache = Collections.synchronizedMap(new HashMap<String, DataSource>());
        } catch (NamingException ne) {
            throw new ServiceLocatorException(ne);
        } catch (Exception e) {
            throw new ServiceLocatorException(e);
        }
    }

    static public ServiceLocator getInstance() {
        return locator;
    }

    /**
     * @param dataSourceName the data source to look up.
     * @return the DataSource corresponding to the provided name.
     */
    public DataSource getDataSource(String dataSourceName) throws ServiceLocatorException {
        DataSource dataSource = null;
        try {
            if (cache.containsKey(dataSourceName)) {
                dataSource = (DataSource) cache.get(dataSourceName);
            } else {
                //Jboss
                dataSource = (DataSource) ic.lookup(dataSourceName);
                //Tomcat
//                dataSource = (DataSource) ec.lookup(dataSourceName);

                cache.put(dataSourceName, dataSource);
            }
        } catch (NamingException ne) {
            throw new ServiceLocatorException(ne);
        } catch (Exception e) {
            throw new ServiceLocatorException(e);
        }
        return dataSource;
    }
}
