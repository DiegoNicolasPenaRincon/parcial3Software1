package co.edu.uniquindio.alquiler.model;

import java.util.ArrayList;

public class FactoryEstudiante {

    String Id;
    ArrayList<Estudiante> Estudiantes;

    private static FactoryEstudiante factory;

    private FactoryEstudiante(){
        this.Estudiantes=new ArrayList();
        this.Id="123";
    }

    public static FactoryEstudiante getInstance(){
        if(factory == null){
            factory = new FactoryEstudiante();
        }

        return factory;
    }
}
