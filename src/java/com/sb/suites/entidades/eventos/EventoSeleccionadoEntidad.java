/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.entidades.eventos;

import com.sb.suites.entidades.BaseEntidad;
import java.io.Serializable;

/**
 *
 * @author Fabian Molar
 */
public class EventoSeleccionadoEntidad extends BaseEntidad implements Serializable{
    private int eventoId;
    private String evento;
    private String fechaPresentacion;
    private int presentacionId;
    private String recinto;
    private int suiteId;
    private int recintoId;
    private int estacionamientoId;
    private String suite;
    private int numeroBoletos;
    private int numeroEstacionamientos;
    private int numeroInvitaciones;
    
    /**
     * @return the eventoId
     */
    public int getEventoId() {
        return eventoId;
    }

    /**
     * @param eventoId the eventoId to set
     */
    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    /**
     * @return the evento
     */
    public String getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * @return the fechaPresentacion
     */
    public String getFechaPresentacion() {
        return fechaPresentacion;
    }

    /**
     * @param fechaPresentacion the fechaPresentacion to set
     */
    public void setFechaPresentacion(String fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    /**
     * @return the presentacionId
     */
    public int getPresentacionId() {
        return presentacionId;
    }

    /**
     * @param presentacionId the presentacionId to set
     */
    public void setPresentacionId(int presentacionId) {
        this.presentacionId = presentacionId;
    }

    /**
     * @return the recinto
     */
    public String getRecinto() {
        return recinto;
    }

    /**
     * @param recinto the recinto to set
     */
    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }

    /**
     * @return the suiteId
     */
    public int getSuiteId() {
        return suiteId;
    }

    /**
     * @param suiteId the suiteId to set
     */
    public void setSuiteId(int suiteId) {
        this.suiteId = suiteId;
    }

    /**
     * @return the recintoId
     */
    public int getRecintoId() {
        return recintoId;
    }

    /**
     * @param recintoId the recintoId to set
     */
    public void setRecintoId(int recintoId) {
        this.recintoId = recintoId;
    }

    /**
     * @return the estacionamientoId
     */
    public int getEstacionamientoId() {
        return estacionamientoId;
    }

    /**
     * @param estacionamientoId the estacionamientoId to set
     */
    public void setEstacionamientoId(int estacionamientoId) {
        this.estacionamientoId = estacionamientoId;
    }

    /**
     * @return the suite
     */
    public String getSuite() {
        return suite;
    }

    /**
     * @param suite the suite to set
     */
    public void setSuite(String suite) {
        this.suite = suite;
    }

    /**
     * @return the numeroBoletos
     */
    public int getNumeroBoletos() {
        return numeroBoletos;
    }

    /**
     * @param numeroBoletos the numeroBoletos to set
     */
    public void setNumeroBoletos(int numeroBoletos) {
        this.numeroBoletos = numeroBoletos;
    }

    /**
     * @return the numeroEstacionamientos
     */
    public int getNumeroEstacionamientos() {
        return numeroEstacionamientos;
    }

    /**
     * @param numeroEstacionamientos the numeroEstacionamientos to set
     */
    public void setNumeroEstacionamientos(int numeroEstacionamientos) {
        this.numeroEstacionamientos = numeroEstacionamientos;
    }

    /**
     * @return the numeroInvitaciones
     */
    public int getNumeroInvitaciones() {
        return numeroInvitaciones;
    }

    /**
     * @param numeroInvitaciones the numeroInvitaciones to set
     */
    public void setNumeroInvitaciones(int numeroInvitaciones) {
        this.numeroInvitaciones = numeroInvitaciones;
    }
}
