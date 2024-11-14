package co.edu.uniquindio.alquiler.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Estudiante {

    String nombre;
    String Id;
    String palabraClave;
    String iconoClave;
    Set<ReciboPago> listaRecibosPago;
    Set<Materia> listaMaterias;

    public Estudiante(String nombre, String id, String palabraClave, String iconoClave) {
        this.nombre = nombre;
        Id = id;
        this.palabraClave = palabraClave;
        this.iconoClave = iconoClave;
        this.listaRecibosPago = new HashSet<>();
        this.listaMaterias = new HashSet<>();
    }
}
