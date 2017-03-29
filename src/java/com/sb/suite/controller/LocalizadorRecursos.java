/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suite.controller;

import com.sb.suites.dao.ServiceLocatorException;
import com.sb.suites.dao.utils.Resources;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author fabiam molar
 */
public class LocalizadorRecursos {
    private Map cache;
    private static LocalizadorRecursos instancia;
    private String contextoXml = "";

    /** The logging facility */
    private static final Log log = LogFactory.getLog(LocalizadorRecursos.class);

    static{
        try{
            instancia = new LocalizadorRecursos();
        }catch(ServiceLocatorException se){
            log.error(se);
            se.printStackTrace(System.err);
        }
    }

    private LocalizadorRecursos() throws ServiceLocatorException{
        try{
            cache = Collections.synchronizedMap(new HashMap());
        }catch(Exception ex){
            throw new ServiceLocatorException(ex);
        }
    }

    static public LocalizadorRecursos getInstance(){
        return instancia;
    }

    public String getParametro(String parametro) throws ServiceLocatorException{
        String resultado = "";
        try{
            if (!cache.containsKey("parametros")){
                cache.put("parametros", new Resources("com.sb.web.dao.recursos.parametros"));
            }
            resultado = ((Resources) cache.get("parametros")).getString(parametro);
        }catch(Exception ex){
            throw new ServiceLocatorException(ex);
        }
        return resultado;
    }

    /**
     * @return the contextoXml
     */
    public String getContextoXml() {
        return contextoXml;
    }

    /**
     * @param contextoXml the contextoXml to set
     */
    public void setContextoXml(String contextoXml) {
        this.contextoXml = contextoXml;
    }
}
