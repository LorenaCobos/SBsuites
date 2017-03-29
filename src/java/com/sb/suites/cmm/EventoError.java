/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.cmm;

import java.util.EventObject;

/**
 *
 * @author fabiam molar
 */
public class EventoError extends EventObject {
    private String id;
    private Exception currentException;
    private int auditoriaDaoId;
    private int auditoriaBssId;

    // Constructor parametrizado
    public EventoError( Object obj, String id, Exception e) {
        // Se le pasa el objeto como parametro a la superclase
        super( obj );
        // Se guardan los Parametros en la Clase
        this.id = id;
        this.currentException = e;
        }

    // Metodo para recuperar el identificador del objeto
    public String getEventoId() {
        return (id );
    }

    public Exception getException(){
        return (currentException);
    }

    /**
     * @return the auditoriaDaoId
     */
    public int getAuditoriaDaoId() {
        return auditoriaDaoId;
    }

    /**
     * @param auditoriaDaoId the auditoriaDaoId to set
     */
    public void setAuditoriaDaoId(int auditoriaDaoId) {
        this.auditoriaDaoId = auditoriaDaoId;
    }

    /**
     * @return the auditoriaBssId
     */
    public int getAuditoriaBssId() {
        return auditoriaBssId;
    }

    /**
     * @param auditoriaBssId the auditoriaBssId to set
     */
    public void setAuditoriaBssId(int auditoriaBssId) {
        this.auditoriaBssId = auditoriaBssId;
    }
}
