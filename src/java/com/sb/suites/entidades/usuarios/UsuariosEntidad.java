package com.sb.suites.entidades.usuarios;

import com.sb.suites.entidades.BaseEntidad;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author rmunoz
 */
public class UsuariosEntidad extends BaseEntidad implements Serializable{
    
    private int usuarioId;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String extencion;
    private String celular;
    private String email;
    private String emailAlterno;
    private int regionUbicacionId;
    private String regiones = "";
    private int paisUbicacionId;
    private String paises = "";
    private int estadoUbicacionId;
    private String estados = "";
    private int ciudadUbicacionId;
    private String ciudades = "";
    private int perfilId;
    private String perfilNombre;
    private String perfilDescripcion;
    private int puestoId;
    private String puestoDescripcion;
    private int preguntaSecretaId;
    private String respuesta;
    private String descripcion;
    private String login;
    private String contrasena;
    private int estatusId = 5;
    private int eliminadoId;   
    private int aplicacionId = 0;
    private String aplicacionDescripcion = "";
    private String recintos = "";
    private int recintoUbicacionId;
    private int validaMac = 5;
    private String fechaVigencia = "";
    private String fechaUltimaSesion = "";
    private int zonaId = 0;
    private String suiteNombre = "";
    private String tipo = "";
    private int tipoId = 0;
    
    
    
    /**
     * @return the usuarioId
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the extencion
     */
    public String getExtencion() {
        return extencion;
    }

    /**
     * @param extencion the extencion to set
     */
    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the emailAlterno
     */
    public String getEmailAlterno() {
        return emailAlterno;
    }

    /**
     * @param emailAlterno the emailAlterno to set
     */
    public void setEmailAlterno(String emailAlterno) {
        this.emailAlterno = emailAlterno;
    }

    /**
     * @return the regionUbicacionId
     */
    public int getRegionUbicacionId() {
        return regionUbicacionId;
    }

    /**
     * @param regionUbicacionId the regionUbicacionId to set
     */
    public void setRegionUbicacionId(int regionUbicacionId) {
        this.regionUbicacionId = regionUbicacionId;
    }

    /**
     * @return the regiones
     */
    public String getRegiones() {
        return regiones;
    }

    /**
     * @param regiones the regiones to set
     */
    public void setRegiones(String regiones) {
        this.regiones = regiones;
    }

    /**
     * @return the paisUbicacionId
     */
    public int getPaisUbicacionId() {
        return paisUbicacionId;
    }

    /**
     * @param paisUbicacionId the paisUbicacionId to set
     */
    public void setPaisUbicacionId(int paisUbicacionId) {
        this.paisUbicacionId = paisUbicacionId;
    }

    /**
     * @return the paises
     */
    public String getPaises() {
        return paises;
    }

    /**
     * @param paises the paises to set
     */
    public void setPaises(String paises) {
        this.paises = paises;
    }

    /**
     * @return the estadoUbicacionId
     */
    public int getEstadoUbicacionId() {
        return estadoUbicacionId;
    }

    /**
     * @param estadoUbicacionId the estadoUbicacionId to set
     */
    public void setEstadoUbicacionId(int estadoUbicacionId) {
        this.estadoUbicacionId = estadoUbicacionId;
    }

    /**
     * @return the estados
     */
    public String getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(String estados) {
        this.estados = estados;
    }

    /**
     * @return the ciudadUbicacionId
     */
    public int getCiudadUbicacionId() {
        return ciudadUbicacionId;
    }

    /**
     * @param ciudadUbicacionId the ciudadUbicacionId to set
     */
    public void setCiudadUbicacionId(int ciudadUbicacionId) {
        this.ciudadUbicacionId = ciudadUbicacionId;
    }

    /**
     * @return the ciudades
     */
    public String getCiudades() {
        return ciudades;
    }

    /**
     * @param ciudades the ciudades to set
     */
    public void setCiudades(String ciudades) {
        this.ciudades = ciudades;
    }

    /**
     * @return the perfilId
     */
    public int getPerfilId() {
        return perfilId;
    }

    /**
     * @param perfilId the perfilId to set
     */
    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }

    /**
     * @return the perfilDescripcion
     */
    public String getPerfilDescripcion() {
        return perfilDescripcion;
    }

    /**
     * @param perfilDescripcion the perfilDescripcion to set
     */
    public void setPerfilDescripcion(String perfilDescripcion) {
        this.perfilDescripcion = perfilDescripcion;
    }

    /**
     * @return the puestoId
     */
    public int getPuestoId() {
        return puestoId;
    }

    /**
     * @param puestoId the puestoId to set
     */
    public void setPuestoId(int puestoId) {
        this.puestoId = puestoId;
    }

    /**
     * @return the puestoDescripcion
     */
    public String getPuestoDescripcion() {
        return puestoDescripcion;
    }

    /**
     * @param puestoDescripcion the puestoDescripcion to set
     */
    public void setPuestoDescripcion(String puestoDescripcion) {
        this.puestoDescripcion = puestoDescripcion;
    }

    /**
     * @return the preguntaSecretaId
     */
    public int getPreguntaSecretaId() {
        return preguntaSecretaId;
    }

    /**
     * @param preguntaSecretaId the preguntaSecretaId to set
     */
    public void setPreguntaSecretaId(int preguntaSecretaId) {
        this.preguntaSecretaId = preguntaSecretaId;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the estatusId
     */
    public int getEstatusId() {
        return estatusId;
    }

    /**
     * @param estatusId the estatusId to set
     */
    public void setEstatusId(int estatusId) {
        this.estatusId = estatusId;
    }

    /**
     * @return the eliminadoId
     */
    public int getEliminadoId() {
        return eliminadoId;
    }

    /**
     * @param eliminadoId the eliminadoId to set
     */
    public void setEliminadoId(int eliminadoId) {
        this.eliminadoId = eliminadoId;
    }

    /**
     * @return the aplicacionId
     */
    public int getAplicacionId() {
        return aplicacionId;
    }

    /**
     * @param aplicacionId the aplicacionId to set
     */
    public void setAplicacionId(int aplicacionId) {
        this.aplicacionId = aplicacionId;
    }

    /**
     * @return the aplicacionDescripcion
     */
    public String getAplicacionDescripcion() {
        return aplicacionDescripcion;
    }

    /**
     * @param aplicacionDescripcion the aplicacionDescripcion to set
     */
    public void setAplicacionDescripcion(String aplicacionDescripcion) {
        this.aplicacionDescripcion = aplicacionDescripcion;
    }

    /**
     * @return the recintos
     */
    public String getRecintos() {
        return recintos;
    }

    /**
     * @param recintos the recintos to set
     */
    public void setRecintos(String recintos) {
        this.recintos = recintos;
    }

    /**
     * @return the recintoUbicacionId
     */
    public int getRecintoUbicacionId() {
        return recintoUbicacionId;
    }

    /**
     * @param recintoUbicacionId the recintoUbicacionId to set
     */
    public void setRecintoUbicacionId(int recintoUbicacionId) {
        this.recintoUbicacionId = recintoUbicacionId;
    }

    /**
     * @return the validaMac
     */
    public int getValidaMac() {
        return validaMac;
    }

    /**
     * @param validaMac the validaMac to set
     */
    public void setValidaMac(int validaMac) {
        this.validaMac = validaMac;
    }

    /**
     * @return the fechaVigencia
     */
    public String getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * @param fechaVigencia the fechaVigencia to set
     */
    public void setFechaVigencia(String fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    /**
     * @return the fechaUltimaSesion
     */
    public String getFechaUltimaSesion() {
        return fechaUltimaSesion;
    }

    /**
     * @param fechaUltimaSesion the fechaUltimaSesion to set
     */
    public void setFechaUltimaSesion(String fechaUltimaSesion) {
        this.fechaUltimaSesion = fechaUltimaSesion;
    }

    /**
     * @return the zonaId
     */
    public int getZonaId() {
        return zonaId;
    }

    /**
     * @param zonaId the zonaId to set
     */
    public void setZonaId(int zonaId) {
        this.zonaId = zonaId;
    }

    /**
     * @return the perfilNombre
     */
    public String getPerfilNombre() {
        return perfilNombre;
    }

    /**
     * @param perfilNombre the perfilNombre to set
     */
    public void setPerfilNombre(String perfilNombre) {
        this.perfilNombre = perfilNombre;
    }


    /**
     * @return the suiteNombre
     */
    public String getSuiteNombre() {
        return suiteNombre;
    }

    /**
     * @param suiteNombre
     */
    public void setSuiteNombre(String suiteNombre) {
        this.suiteNombre = suiteNombre;
    }
    
    
    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
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
    
}
