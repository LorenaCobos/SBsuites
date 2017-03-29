package com.sb.suites.entidades.usuarios;

import com.sb.suites.entidades.BaseEntidad;

/**
 *
 * @author fabian molar
 */
public class CatalogoEntidad extends BaseEntidad{
    
    private int id = 0;
    private String textId = "";
    private String nombre = "";
    private String clave = "";
    private String valor = "";
    private String descripcion= "";
    private int nivel_id = 0;
    private String nivel = "";
    private String nombreCompleto = "";

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the textId
     */
    public String getTextId() {
        return textId;
    }

    /**
     * @param textId the textId to set
     */
    public void setTextId(String textId) {
        this.textId = textId;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the nivel_id
     */
    public int getNivel_id() {
        return nivel_id;
    }

    /**
     * @param nivel_id the nivel_id to set
     */
    public void setNivel_id(int nivel_id) {
        this.nivel_id = nivel_id;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
}
