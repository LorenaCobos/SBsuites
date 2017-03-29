/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.dao.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author fabiam molar
 */
public class Resources {

    /**
     *     Descripcion : Constructor por omision de la clase
     *
     *     Historico   : 13-feb-2009 - Jorge J Leon A - creacion de metodo
     *
     *     @param
     *     @return
     *     @throws
     */
    private ResourceBundle resource;
    private String bundle;

    private Resources() {
    }

    public Resources(String bundle) {
        this.bundle = bundle;
        resource = ResourceBundle.getBundle(bundle, Locale.getDefault());

    }

    public String getString(String s) {
        updateLocale();
        return resource.getString(s);
    }

    public void updateLocale() {
        Locale l = Locale.getDefault();
//        if (BaseDAO.locale != l) {
//            BaseDAO.locale = l;
//            ResourceBundle.clearCache();
//            this.resource = ResourceBundle.getBundle(bundle, l);
//        }
    }
}
