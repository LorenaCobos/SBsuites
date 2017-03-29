/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.bss;

import com.sb.suites.cmm.EventoError;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suites.cmm.IEventoErrorDAOListener;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Fabian Molar
 */
public class BaseBss implements IEventoErrorDAOListener{

    protected static Resources codigos;
    protected static Resources errors;
    private static Locale locale = Locale.getDefault();
    private String lenguajeId;
    protected int AuditoriaBssId;

    public BaseBss() {
        inicializarRecursos();
    }
    public BaseBss(String lenguajeId) {
        this.lenguajeId = lenguajeId;
        inicializarRecursos();
    }

    private void inicializarRecursos() {
        codigos = new Resources("com.sb.suites.bss.recursos.CodesBss");
        errors = new Resources("com.sb.suites.bss.recursos.ErrorsBss");
    }

    /**
     * @return the lenguajeId
     */
    public String getLenguajeId() {
        return lenguajeId;
    }

    /**
     * @param lenguajeId the lenguajeId to set
     */
    public void setLenguajeId(String lenguajeId) {
        this.lenguajeId = lenguajeId;
    }

    /**
     * @return the AuditoriaBssId
     */
    public int getAuditoriaBssId() {
        return AuditoriaBssId;
    }

    /**
     * @param AuditoriaBssId the AuditoriaBssId to set
     */
    public void setAuditoriaBssId(int AuditoriaBssId) {
        if(this.AuditoriaBssId == 0)
            this.AuditoriaBssId = AuditoriaBssId;
    }

    protected class Resources {

        private ResourceBundle resource;
        private String bundle;

        public Resources(String bundle) {
            this.bundle = bundle;
            resource = ResourceBundle.getBundle(bundle, Locale.getDefault());

        }

        public String getString(String s) {
            if (BaseBss.locale != Locale.getDefault()) {
                resource = ResourceBundle.getBundle(bundle, Locale.getDefault());
            }
            return resource.getString(s);
        }
    }

    public void capturarEventoErrorDAO(EventoError evt) throws ExceptionCmm {
        // TODO Auto-generated method stub
        
    }
}