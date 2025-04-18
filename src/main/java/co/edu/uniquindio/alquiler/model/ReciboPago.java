package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.EstadoRecibo;

import java.time.LocalDate;

public class ReciboPago {

    String IDestudiante;
    EstadoRecibo estadoRecibo;
    LocalDate fechaExpedicion;
    LocalDate fechaPago;
    final double valorPagar=300;
    LocalDate fechaVencimiento;
    String nombreMateria;
    int numeroReferencia;
    String idRecibo;

    public ReciboPago(String IDestudiante, EstadoRecibo estadoRecibo, LocalDate fechaExpedicion, LocalDate fechaPago, LocalDate fechaVencimiento,String nombreMateria,int numeroReferencia) {
        this.IDestudiante = IDestudiante;
        this.estadoRecibo = estadoRecibo;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaPago = fechaPago;
        this.fechaVencimiento = fechaVencimiento;
        this.nombreMateria = nombreMateria;
        this.numeroReferencia = numeroReferencia;
    }

    public String getIDestudiante() {
        return IDestudiante;
    }

    public void setIDestudiante(String IDestudiante) {
        this.IDestudiante = IDestudiante;
    }

    public EstadoRecibo getEstadoRecibo() {
        return estadoRecibo;
    }

    public void setEstadoRecibo(EstadoRecibo estadoRecibo) {
        this.estadoRecibo = estadoRecibo;
    }

    public LocalDate getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(LocalDate fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(int numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public String getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(String idRecibo) {
        this.idRecibo = idRecibo;
    }
}
