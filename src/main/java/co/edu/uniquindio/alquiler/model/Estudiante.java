package co.edu.uniquindio.alquiler.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Estudiante {

    String nombre;
    String Id;
    String palabraClave;
    String iconoClave;
    ArrayList<ReciboPago> listaRecibosPago;
    ArrayList<Materia> listaMaterias;

    public Estudiante(String nombre, String id, String palabraClave, String iconoClave) {
        this.nombre = nombre;
        Id = id;
        this.palabraClave = palabraClave;
        this.iconoClave = iconoClave;
        this.listaRecibosPago = new ArrayList<>();
        this.listaMaterias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public String getIconoClave() {
        return iconoClave;
    }

    public void setIconoClave(String iconoClave) {
        this.iconoClave = iconoClave;
    }

    public ArrayList<ReciboPago> getListaRecibosPago() {
        return listaRecibosPago;
    }

    public void setListaRecibosPago(ArrayList<ReciboPago> listaRecibosPago) {
        this.listaRecibosPago = listaRecibosPago;
    }

    public ArrayList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }
}
