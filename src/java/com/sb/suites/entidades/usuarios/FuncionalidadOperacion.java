package com.sb.suites.entidades.usuarios;

import java.io.Serializable;

public class FuncionalidadOperacion implements Serializable{

    private String nombreAccion;
    private String htmlId;
    private int tipoId;
    private boolean habilitado;

    
    /**
     * @return the tipoId
     */
    public int getTipoId() {
        return tipoId;
    }

    /**
     * @param tipoId the tipoId to set
     */
    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    /**
     * @return the habilitadoId
     */
    public boolean getHabilitado() {
        return habilitado;
    }

    /**
     * @param habilitado the habilitadoId to set
     */
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    /**
     * @return the nombreAccion
     */
    public String getNombreAccion() {
        return nombreAccion;
    }

    /**
     * @param nombreAccion the nombreAccion to set
     */
    public void setNombreAccion(String nombreAccion) {
        this.nombreAccion = nombreAccion;
    }

    /**
     * @return the htmlId
     */
    public String getHtmlId() {
        return htmlId;
    }

    /**
     * @param htmlId the htmlId to set
     */
    public void setHtmlId(String htmlId) {
        this.htmlId = htmlId;
    }
    /**
     *     Descripcion : Constructor por omision de la clase
     *
     *     Historico   : 18-feb-2009 - Jorge J Leon A - creacion de metodo
     *
     *     @param
     *     @return
     *     @throws
     */
}
