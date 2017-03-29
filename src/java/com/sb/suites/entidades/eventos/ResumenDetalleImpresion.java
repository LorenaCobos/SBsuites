
package com.sb.suites.entidades.eventos;

import java.util.ArrayList;

/**
 *
 * @author Fabian molar
 */
public class ResumenDetalleImpresion {
    
    private int lugaresDisponibles=0;
    private ArrayList<DetalleImpresion> detalle = new ArrayList<DetalleImpresion>();
    private int estacionamientosDisponibles=0;

    /**
     * @return the lugaresDisponibles
     */
    public int getLugaresDisponibles() {
        return lugaresDisponibles;
    }

    /**
     * @param lugaresDisponibles the lugaresDisponibles to set
     */
    public void setLugaresDisponibles(int lugaresDisponibles) {
        this.lugaresDisponibles = lugaresDisponibles;
    }

    /**
     * @return the detalle
     */
    public ArrayList<DetalleImpresion> getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(ArrayList<DetalleImpresion> detalle) {
        this.detalle = detalle;
    }

    /**
     * @return the estacionamientosDisponibles
     */
    public int getEstacionamientosDisponibles() {
        return estacionamientosDisponibles;
    }

    /**
     * @param estacionamientosDisponibles the estacionamientosDisponibles to set
     */
    public void setEstacionamientosDisponibles(int estacionamientosDisponibles) {
        this.estacionamientosDisponibles = estacionamientosDisponibles;
    }
}
