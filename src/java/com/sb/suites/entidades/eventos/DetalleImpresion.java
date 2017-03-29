package com.sb.suites.entidades.eventos;

/**
 *
 * @author Fabian Molar
 */
public class DetalleImpresion {

    private String nombreUsusario = "";
    private String fechaCreacion = "";
    private String nombrePresentacion = "";
    private String nombreZonaPrecio = "";
    private String nombreSeccion = "";
    private String claveTipoBoleto = "";
    private String tipoBoleto = "";
    private String codigo = "";
    private String asignacionNombre = "";
    private String asignacionTipo = "";
    private String correo = "";
    private String claveEstatus = "";
    private String fechaactualizacion = "";

    public String getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(String fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }
    
    
    private double precio = 0;
    private int usuarioId = 0;
    private int cantidad = 0;
    private int presentacionId = 0;
    private int zonaPrecioId = 0;
    private int seccionId = 0;
    private int regionId = 0;
    private int transaccionAccionId = 0;
    private int folio = 0;
    private int transaccionId = 0;
    private int numeroTransaccion = 0;
    private int creacionUsuario = 0;
    private int asignacionNombreId = 0;
    private int asignacionTipoId = 0;
    private int cantidadCancelados = 0;
    private int cantidadImpresos = 0;
    private int cantidadEstacionamientos = 0;
    private int lugaresDisponibles = 0;

    /**
     * @return the nombreUsusario
     */
    public String getNombreUsusario() {
        return nombreUsusario;
    }

    /**
     * @param nombreUsusario the nombreUsusario to set
     */
    public void setNombreUsusario(String nombreUsusario) {
        this.nombreUsusario = nombreUsusario;
    }

    /**
     * @return the fechaCreacion
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the nombrePresentacion
     */
    public String getNombrePresentacion() {
        return nombrePresentacion;
    }

    /**
     * @param nombrePresentacion the nombrePresentacion to set
     */
    public void setNombrePresentacion(String nombrePresentacion) {
        this.nombrePresentacion = nombrePresentacion;
    }

    /**
     * @return the nombreZonaPrecio
     */
    public String getNombreZonaPrecio() {
        return nombreZonaPrecio;
    }

    /**
     * @param nombreZonaPrecio the nombreZonaPrecio to set
     */
    public void setNombreZonaPrecio(String nombreZonaPrecio) {
        this.nombreZonaPrecio = nombreZonaPrecio;
    }

    /**
     * @return the nombreSeccion
     */
    public String getNombreSeccion() {
        return nombreSeccion;
    }

    /**
     * @param nombreSeccion the nombreSeccion to set
     */
    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    /**
     * @return the claveTipoBoleto
     */
    public String getClaveTipoBoleto() {
        return claveTipoBoleto;
    }

    /**
     * @param claveTipoBoleto the claveTipoBoleto to set
     */
    public void setClaveTipoBoleto(String claveTipoBoleto) {
        this.claveTipoBoleto = claveTipoBoleto;
    }

    /**
     * @return the tipoBoleto
     */
    public String getTipoBoleto() {
        return tipoBoleto;
    }

    /**
     * @param tipoBoleto the tipoBoleto to set
     */
    public void setTipoBoleto(String tipoBoleto) {
        this.tipoBoleto = tipoBoleto;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the asignacionNombre
     */
    public String getAsignacionNombre() {
        return asignacionNombre;
    }

    /**
     * @param asignacionNombre the asignacionNombre to set
     */
    public void setAsignacionNombre(String asignacionNombre) {
        this.asignacionNombre = asignacionNombre;
    }

    /**
     * @return the asignacionTipo
     */
    public String getAsignacionTipo() {
        return asignacionTipo;
    }

    /**
     * @param asignacionTipo the asignacionTipo to set
     */
    public void setAsignacionTipo(String asignacionTipo) {
        this.asignacionTipo = asignacionTipo;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

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
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
     * @return the zonaPrecioId
     */
    public int getZonaPrecioId() {
        return zonaPrecioId;
    }

    /**
     * @param zonaPrecioId the zonaPrecioId to set
     */
    public void setZonaPrecioId(int zonaPrecioId) {
        this.zonaPrecioId = zonaPrecioId;
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
     * @return the regionId
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    /**
     * @return the transaccionAccionId
     */
    public int getTransaccionAccionId() {
        return transaccionAccionId;
    }

    /**
     * @param transaccionAccionId the transaccionAccionId to set
     */
    public void setTransaccionAccionId(int transaccionAccionId) {
        this.transaccionAccionId = transaccionAccionId;
    }

    /**
     * @return the folio
     */
    public int getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * @return the transaccionId
     */
    public int getTransaccionId() {
        return transaccionId;
    }

    /**
     * @param transaccionId the transaccionId to set
     */
    public void setTransaccionId(int transaccionId) {
        this.transaccionId = transaccionId;
    }

    /**
     * @return the numeroTransaccion
     */
    public int getNumeroTransaccion() {
        return numeroTransaccion;
    }

    /**
     * @param numeroTransaccion the numeroTransaccion to set
     */
    public void setNumeroTransaccion(int numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    /**
     * @return the creacionUsuario
     */
    public int getCreacionUsuario() {
        return creacionUsuario;
    }

    /**
     * @param creacionUsuario the creacionUsuario to set
     */
    public void setCreacionUsuario(int creacionUsuario) {
        this.creacionUsuario = creacionUsuario;
    }

    /**
     * @return the asignacionNombreId
     */
    public int getAsignacionNombreId() {
        return asignacionNombreId;
    }

    /**
     * @param asignacionNombreId the asignacionNombreId to set
     */
    public void setAsignacionNombreId(int asignacionNombreId) {
        this.asignacionNombreId = asignacionNombreId;
    }

    /**
     * @return the asignacionTipoId
     */
    public int getAsignacionTipoId() {
        return asignacionTipoId;
    }

    /**
     * @param asignacionTipoId the asignacionTipoId to set
     */
    public void setAsignacionTipoId(int asignacionTipoId) {
        this.asignacionTipoId = asignacionTipoId;
    }

    /**
     * @return the cantidadCancelados
     */
    public int getCantidadCancelados() {
        return cantidadCancelados;
    }

    /**
     * @param cantidadCancelados the cantidadCancelados to set
     */
    public void setCantidadCancelados(int cantidadCancelados) {
        this.cantidadCancelados = cantidadCancelados;
    }

    /**
     * @return the cantidadImpresos
     */
    public int getCantidadImpresos() {
        return cantidadImpresos;
    }

    /**
     * @param cantidadImpresos the cantidadImpresos to set
     */
    public void setCantidadImpresos(int cantidadImpresos) {
        this.cantidadImpresos = cantidadImpresos;
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
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the claveEstatus
     */
    public String getClaveEstatus() {
        return claveEstatus;
    }

    /**
     * @param claveEstatus the claveEstatus to set
     */
    public void setClaveEstatus(String claveEstatus) {
        this.claveEstatus = claveEstatus;
    }

    /**
     * @return the cantidadEstacionamientos
     */
    public int getCantidadEstacionamientos() {
        return cantidadEstacionamientos;
    }

    /**
     * @param cantidadEstacionamientos the cantidadEstacionamientos to set
     */
    public void setCantidadEstacionamientos(int cantidadEstacionamientos) {
        this.cantidadEstacionamientos = cantidadEstacionamientos;
    }

}
