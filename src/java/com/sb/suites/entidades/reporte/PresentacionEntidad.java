/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.entidades.reporte;

import com.sb.suites.entidades.BaseEntidad;

/**
 *
 * @author fabiam molar
 */
public class PresentacionEntidad extends BaseEntidad
{
    private int presentacionId = 0;
    private String nombrePresentacion = "";

    public int getPresentacionId() {
        return presentacionId;
    }

    public void setPresentacionId(int presentacionId) {
        this.presentacionId = presentacionId;
    }

    public String getNombrePresentacion() {
        return nombrePresentacion;
    }

    public void setNombrePresentacion(String nombrePresentacion) {
        this.nombrePresentacion = nombrePresentacion;
    }
    
    
}
