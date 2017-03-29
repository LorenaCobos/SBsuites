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
public class TerminalEntidad extends BaseEntidad
{
    private int puntoVentaTerminalId = 0;
    private String nombreTerminal = "";

    public int getPuntoVentaTerminalId() {
        return puntoVentaTerminalId;
    }

    public void setPuntoVentaTerminalId(int puntoVentaTerminalId) {
        this.puntoVentaTerminalId = puntoVentaTerminalId;
    }

    public String getNombreTerminal() {
        return nombreTerminal;
    }

    public void setNombreTerminal(String nombreTerminal) {
        this.nombreTerminal = nombreTerminal;
    }
    
    
}
