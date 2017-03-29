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
public class ReporteEntidad extends BaseEntidad
{
    private String presentacionNombre = "";
    private String nombreTerminal = "";
    private int transaccionVentaId = 0;
    private int boletosVendidos = 0;
    private double montoTransaccion = 0.0;
    private double cargoServicio = 0.0;
    private double totalTransaccion = 0.0;
    private String fechaCierre = "";

    public String getPresentacionNombre() {
        return presentacionNombre;
    }

    public void setPresentacionNombre(String presentacionNombre) {
        this.presentacionNombre = presentacionNombre;
    }

    public String getNombreTerminal() {
        return nombreTerminal;
    }

    public void setNombreTerminal(String nombreTerminal) {
        this.nombreTerminal = nombreTerminal;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public void setBoletosVendidos(int boletosVendidos) {
        this.boletosVendidos = boletosVendidos;
    }

    public double getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(double montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public double getCargoServicio() {
        return cargoServicio;
    }

    public void setCargoServicio(double cargoServicio) {
        this.cargoServicio = cargoServicio;
    }

    public double getTotalTransaccion() {
        return totalTransaccion;
    }

    public void setTotalTransaccion(double totalTransaccion) {
        this.totalTransaccion = totalTransaccion;
    }

    public int getTransaccionVentaId() {
        return transaccionVentaId;
    }

    public void setTransaccionVentaId(int transaccionVentaId) {
        this.transaccionVentaId = transaccionVentaId;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    
}
