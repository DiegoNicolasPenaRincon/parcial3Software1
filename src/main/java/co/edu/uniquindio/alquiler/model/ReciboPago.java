package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.EstadoRecibo;

import java.time.LocalDate;

public class ReciboPago {

    String nombreEstudiante;
    EstadoRecibo estadoRecibo;
    LocalDate fechaExpedicion;
    LocalDate fechaPago;
    double valorPagar;
    LocalDate fechaVencimiento;
    String nombreBanco;

    public ReciboPago(String nombreEstudiante, EstadoRecibo estadoRecibo, LocalDate fechaExpedicion, LocalDate fechaPago, double valorPagar, LocalDate fechaVencimiento, String nombreBanco) {
        this.nombreEstudiante = nombreEstudiante;
        this.estadoRecibo = estadoRecibo;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaPago = fechaPago;
        this.valorPagar = valorPagar;
        this.fechaVencimiento = fechaVencimiento;
        this.nombreBanco = nombreBanco;
    }
}
