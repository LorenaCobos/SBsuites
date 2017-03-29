package com.sb.suites.entidades.usuarios;

import com.sb.suites.entidades.BaseEntidad;
import java.util.ArrayList;



/**
 *
 * @author Fabian molar
 */
public class OpcionMenuPrincipalEntidad extends BaseEntidad {

    private String accionMenuPrincipal;
    private int identificadorMenuPrincipal;
    private String ordenMenuPrincipal;
    private String urlMenuPrincipal;
    private String nombreMenuPrincipal;
    private String htmlIdMenuPrincipal;
    private String nombreObjetoMenuPrincipal;
    private ArrayList<OpcionMenuLateralEntidad> operaciones = new ArrayList<OpcionMenuLateralEntidad>();

    public OpcionMenuPrincipalEntidad(){

    }

    /**
     * @return the accionMenuPrincipal
     */
    public String getAccionMenuPrincipal() {
        return accionMenuPrincipal;
    }

    /**
     * @param accionMenuPrincipal the accionMenuPrincipal to set
     */
    public void setAccionMenuPrincipal(String accionMenuPrincipal) {
        this.accionMenuPrincipal = accionMenuPrincipal;
    }

    /**
     * @return the identificadorMenuPrincipal
     */
    public int getIdentificadorMenuPrincipal() {
        return identificadorMenuPrincipal;
    }

    /**
     * @param identificadorMenuPrincipal the identificadorMenuPrincipal to set
     */
    public void setIdentificadorMenuPrincipal(int identificadorMenuPrincipal) {
        this.identificadorMenuPrincipal = identificadorMenuPrincipal;
    }

    /**
     * @return the ordenMenuPrincipal
     */
    public String getOrdenMenuPrincipal() {
        return ordenMenuPrincipal;
    }

    /**
     * @param ordenMenuPrincipal the ordenMenuPrincipal to set
     */
    public void setOrdenMenuPrincipal(String ordenMenuPrincipal) {
        this.ordenMenuPrincipal = ordenMenuPrincipal;
    }

    /**
     * @return the urlMenuPrincipal
     */
    public String getUrlMenuPrincipal() {
        return urlMenuPrincipal;
    }

    /**
     * @param urlMenuPrincipal the urlMenuPrincipal to set
     */
    public void setUrlMenuPrincipal(String urlMenuPrincipal) {
        this.urlMenuPrincipal = urlMenuPrincipal;
    }

    /**
     * @return the nombreMenuPrincipal
     */
    public String getNombreMenuPrincipal() {
        return nombreMenuPrincipal;
    }

    /**
     * @param nombreMenuPrincipal the nombreMenuPrincipal to set
     */
    public void setNombreMenuPrincipal(String nombreMenuPrincipal) {
        this.nombreMenuPrincipal = nombreMenuPrincipal;
    }

    /**
     * @return the htmlIdMenuPrincipal
     */
    public String getHtmlIdMenuPrincipal() {
        return htmlIdMenuPrincipal;
    }

    /**
     * @param htmlIdMenuPrincipal the htmlIdMenuPrincipal to set
     */
    public void setHtmlIdMenuPrincipal(String htmlIdMenuPrincipal) {
        this.htmlIdMenuPrincipal = htmlIdMenuPrincipal;
    }

    /**
     * @return the nombreObjetoMenuPrincipal
     */
    public String getNombreObjetoMenuPrincipal() {
        return nombreObjetoMenuPrincipal;
    }

    /**
     * @param nombreObjetoMenuPrincipal the nombreObjetoMenuPrincipal to set
     */
    public void setNombreObjetoMenuPrincipal(String nombreObjetoMenuPrincipal) {
        this.nombreObjetoMenuPrincipal = nombreObjetoMenuPrincipal;
    }

    /**
     * @return the operaciones
     */
    public ArrayList<OpcionMenuLateralEntidad> getOperaciones() {
        return operaciones;
    }

    /**
     * @param operaciones the operaciones to set
     */
    public void setOperaciones(ArrayList<OpcionMenuLateralEntidad> operaciones) {
        this.operaciones = operaciones;
    }

}
