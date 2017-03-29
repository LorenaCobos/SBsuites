package com.sb.suites.entidades.suite;

import com.sb.suites.entidades.BaseEntidad;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class SuiteEntidad extends BaseEntidad{
    private int seccionUbicacionId = 0;
    private int tipoId = 0;
    private int nivelId = 0;
    private int diaNacimiento = 0;
    private int mesNacimiento = 0;
    private int estatus;
    private int aforo = 0;
    private int asientosExtraDisponibles = 0;
    private int asientosExtraVendidos = 0;
    private int recintoUbicacionId = 0;
    private int suiteReservadaId = 0;
    private int presentacionId = 0;
    private int eventoId = 0;
    private int lugaresReservados = 0;
    private int lugaresPorImprimir = 0;
    private int lugaresImpresos = 0;
    private int presentacionNivel=0;

    private String recinto = "";
    private int recintoId = 0;
    private String nombre = "";
    private String secciones = "";
    private String tipoSuite = "";
    private String direccion = "";
    private String telefono = "";
    private String celular = "";
    private String email = "";
    private String vigenciaInicio = "";
    private String vigenciaFin = "";
    private String observaciones = "";
    private String numero = "";
    private String presentacion = "";
    private String fechaPresentacion = "";
    private String evento = "";
    private int seccionId = 0;

    private ArrayList tipoSuites;
    private ArrayList anios;
    private ArrayList meses;
    private ArrayList dias;
    private ArrayList niveles;
    
    private String vigencia="";
    private String suiteHabiente="";
    private int estatusId =0;
    
    private int lugaresDisponibles = 0;
    private int invitaciones = 0;
    
    private int tipoContrato = 0;
    private int cantidadEventos=0;
    private int tipoEvento = 0;
    private int aplicaVigencia = 0;
    
    private int estacionamientoId = 0;
    private int cantidadEstacionamiento = 0;
    
    private String ruta="";
    private String nombreSuite="";
    

    /**
     * @return the seccionUbicacionId
     */
    public int getSeccionUbicacionId() {
        return seccionUbicacionId;
    }

    /**
     * @param seccionUbicacionId the seccionUbicacionId to set
     */
    public void setSeccionUbicacionId(int seccionUbicacionId) {
        this.seccionUbicacionId = seccionUbicacionId;
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

    /**
     * @return the diaNacimiento
     */
    public int getDiaNacimiento() {
        return diaNacimiento;
    }

    /**
     * @param diaNacimiento the diaNacimiento to set
     */
    public void setDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    /**
     * @return the mesNacimiento
     */
    public int getMesNacimiento() {
        return mesNacimiento;
    }

    /**
     * @param mesNacimiento the mesNacimiento to set
     */
    public void setMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    /**
     * @return the estatus
     */
    public int getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the aforo
     */
    public int getAforo() {
        return aforo;
    }

    /**
     * @param aforo the aforo to set
     */
    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    /**
     * @return the asientosExtraDisponibles
     */
    public int getAsientosExtraDisponibles() {
        return asientosExtraDisponibles;
    }

    /**
     * @param asientosExtraDisponibles the asientosExtraDisponibles to set
     */
    public void setAsientosExtraDisponibles(int asientosExtraDisponibles) {
        this.asientosExtraDisponibles = asientosExtraDisponibles;
    }

    /**
     * @return the asientosExtraVendidos
     */
    public int getAsientosExtraVendidos() {
        return asientosExtraVendidos;
    }

    /**
     * @param asientosExtraVendidos the asientosExtraVendidos to set
     */
    public void setAsientosExtraVendidos(int asientosExtraVendidos) {
        this.asientosExtraVendidos = asientosExtraVendidos;
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
     * @return the suiteReservadaId
     */
    public int getSuiteReservadaId() {
        return suiteReservadaId;
    }

    /**
     * @param suiteReservadaId the suiteReservadaId to set
     */
    public void setSuiteReservadaId(int suiteReservadaId) {
        this.suiteReservadaId = suiteReservadaId;
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
     * @return the lugaresReservados
     */
    public int getLugaresReservados() {
        return lugaresReservados;
    }

    /**
     * @param lugaresReservados the lugaresReservados to set
     */
    public void setLugaresReservados(int lugaresReservados) {
        this.lugaresReservados = lugaresReservados;
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
     * @return the secciones
     */
    public String getSecciones() {
        return secciones;
    }

    /**
     * @param secciones the secciones to set
     */
    public void setSecciones(String secciones) {
        this.secciones = secciones;
    }

    /**
     * @return the tipoSuite
     */
    public String getTipoSuite() {
        return tipoSuite;
    }

    /**
     * @param tipoSuite the tipoSuite to set
     */
    public void setTipoSuite(String tipoSuite) {
        this.tipoSuite = tipoSuite;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
     * @return the vigenciaInicio
     */
    public String getVigenciaInicio() {
        return vigenciaInicio;
    }

    /**
     * @param vigenciaInicio the vigenciaInicio to set
     */
    public void setVigenciaInicio(String vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    /**
     * @return the vigenciaFin
     */
    public String getVigenciaFin() {
        return vigenciaFin;
    }

    /**
     * @param vigenciaFin the vigenciaFin to set
     */
    public void setVigenciaFin(String vigenciaFin) {
        this.vigenciaFin = vigenciaFin;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the presentacion
     */
    public String getPresentacion() {
        return presentacion;
    }

    /**
     * @param presentacion the presentacion to set
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
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
     * @return the tipoSuites
     */
    public ArrayList getTipoSuites() {
        return tipoSuites;
    }

    /**
     * @param tipoSuites the tipoSuites to set
     */
    public void setTipoSuites(ArrayList tipoSuites) {
        this.tipoSuites = tipoSuites;
    }

    /**
     * @return the meses
     */
    public ArrayList getMeses() {
        return meses;
    }

    /**
     * @param meses the meses to set
     */
    public void setMeses(ArrayList meses) {
        this.meses = meses;
    }

    /**
     * @return the dias
     */
    public ArrayList getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(ArrayList dias) {
        this.dias = dias;
    }

    /**
     * @return the lugaresPorImprimir
     */
    public int getLugaresPorImprimir() {
        return lugaresPorImprimir;
    }

    /**
     * @param lugaresPorImprimir the lugaresPorImprimir to set
     */
    public void setLugaresPorImprimir(int lugaresPorImprimir) {
        this.lugaresPorImprimir = lugaresPorImprimir;
    }

    /**
     * @return the anios
     */
    public ArrayList getAnios() {
        return anios;
    }

    /**
     * @param anios the anios to set
     */
    public void setAnios(ArrayList anios) {
        this.anios = anios;
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
     * @return the niveles
     */
    public ArrayList getNiveles() {
        return niveles;
    }

    /**
     * @param niveles the niveles to set
     */
    public void setNiveles(ArrayList niveles) {
        this.niveles = niveles;
    }

    /**
     * @return the nivelId
     */
    public int getNivelId() {
        return nivelId;
    }

    /**
     * @param nivelId the nivelId to set
     */
    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    /**
     * @return the seccionId
     */
    public int getSeccionId() {
        return seccionId;
    }

    /**
     * @param seccionId the seccionId to set
     */
    public void setSeccionId(int seccionId) {
        this.seccionId = seccionId;
    }

    /**
     * @return the lugaresImpresos
     */
    public int getLugaresImpresos() {
        return lugaresImpresos;
    }

    /**
     * @param lugaresImpresos the lugaresImpresos to set
     */
    public void setLugaresImpresos(int lugaresImpresos) {
        this.lugaresImpresos = lugaresImpresos;
    }

    /**
     * @return the presentacionNivel
     */
    public int getPresentacionNivel() {
        return presentacionNivel;
    }

    /**
     * @param presentacionNivel the presentacionNivel to set
     */
    public void setPresentacionNivel(int presentacionNivel) {
        this.presentacionNivel = presentacionNivel;
    }

    /**
     * @return the vigencia
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * @param vigencia the vigencia to set
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
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
     * @return the suiteHabiente
     */
    public String getSuiteHabiente() {
        return suiteHabiente;
    }

    /**
     * @param suiteHabiente the suiteHabiente to set
     */
    public void setSuiteHabiente(String suiteHabiente) {
        this.suiteHabiente = suiteHabiente;
    }

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
     * @return the invitaciones
     */
    public int getInvitaciones() {
        return invitaciones;
    }

    /**
     * @param invitaciones the invitaciones to set
     */
    public void setInvitaciones(int invitaciones) {
        this.invitaciones = invitaciones;
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
     * @return the TipoContrato
     */
    public int getTipoContrato() {
        return tipoContrato;
    }

    /**
     * @param tipoContrato the tipoContrato to set
     */
    public void setTipoContrato(int tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    /**
     * @return the cantidadEventos
     */
    public int getCantidadEventos() {
        return cantidadEventos;
    }

    /**
     * @param cantidadEventos the cantidadEventos to set
     */
    public void setCantidadEventos(int cantidadEventos) {
        this.cantidadEventos = cantidadEventos;
    }

    /**
     * @return the tipoEvento
     */
    public int getTipoEvento() {
        return tipoEvento;
    }

    /**
     * @param tipoEvento the tipoEvento to set
     */
    public void setTipoEvento(int tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    /**
     * @return the aplicaVigencia
     */
    public int getAplicaVigencia() {
        return aplicaVigencia;
    }

    /**
     * @param aplicaVigencia the aplicaVigencia to set
     */
    public void setAplicaVigencia(int aplicaVigencia) {
        this.aplicaVigencia = aplicaVigencia;
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
     * @return the cantidadEstacionamiento
     */
    public int getCantidadEstacionamiento() {
        return cantidadEstacionamiento;
    }

    /**
     * @param cantidadEstacionamiento the cantidadEstacionamiento to set
     */
    public void setCantidadEstacionamiento(int cantidadEstacionamiento) {
        this.cantidadEstacionamiento = cantidadEstacionamiento;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the nombreSuite
     */
    public String getNombreSuite() {
        return nombreSuite;
    }

    /**
     * @param nombreSuite the nombreSuite to set
     */
    public void setNombreSuite(String nombreSuite) {
        this.nombreSuite = nombreSuite;
    }


   

}
