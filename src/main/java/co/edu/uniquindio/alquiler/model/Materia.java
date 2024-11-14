package co.edu.uniquindio.alquiler.model;

import java.util.ArrayList;

public class Materia {

    String programaPerteneciente;
    ArrayList<Double> listaNotas;
    String nombre;
    String codigo;

    public Materia(String programaPerteneciente, String nombre, String codigo) {
        this.programaPerteneciente = programaPerteneciente;
        this.listaNotas = new ArrayList<>();
        this.nombre = nombre;
        this.codigo = codigo;
    }
}
