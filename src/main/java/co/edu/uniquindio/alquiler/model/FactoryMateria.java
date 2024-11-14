package co.edu.uniquindio.alquiler.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FactoryMateria {

    String Id;
    Set<Materia> listaMaterias;

    private static FactoryMateria factory;

    private FactoryMateria(){
        this.listaMaterias=new HashSet<>();
        this.Id="123";
    }

    public static FactoryMateria getInstance(){
        if(factory == null){
            factory = new FactoryMateria();
        }

        return factory;
    }
}
