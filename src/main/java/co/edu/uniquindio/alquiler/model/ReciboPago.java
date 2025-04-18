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

    public ReciboPago(String IDestudiante, EstadoRecibo estadoRecibo, LocalDate fechaExpedicion, LocalDate fechaPago, LocalDate fechaVencimiento,String nombreMateria,int numeroReferencia) {
        this.IDestudiante = IDestudiante;
        this.estadoRecibo = estadoRecibo;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaPago = fechaPago;
        this.fechaVencimiento = fechaVencimiento;
        this.nombreMateria = nombreMateria;
        this.numeroReferencia = numeroReferencia;
    }


}
