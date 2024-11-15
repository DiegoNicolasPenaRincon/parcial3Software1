package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.EstadoRecibo;

import java.time.LocalDate;

public class ReciboPago {

    String nombreEstudiante;
    EstadoRecibo estadoRecibo;
    LocalDate fechaExpedicion;
    LocalDate fechaPago;
    final double valorPagar=300;
    LocalDate fechaVencimiento;
    String nombreMateria;
    int numeroReferencia;

    public ReciboPago(String nombreEstudiante, EstadoRecibo estadoRecibo, LocalDate fechaExpedicion, LocalDate fechaPago, LocalDate fechaVencimiento,String nombreMateria,int numeroReferencia) {
        this.nombreEstudiante = nombreEstudiante;
        this.estadoRecibo = estadoRecibo;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaPago = fechaPago;
        this.fechaVencimiento = fechaVencimiento;
        this.nombreMateria = nombreMateria;
        this.numeroReferencia = numeroReferencia;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
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

    public double getValorPagar() {
        return valorPagar;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
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
}
