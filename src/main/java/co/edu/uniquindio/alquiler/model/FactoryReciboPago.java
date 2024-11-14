package co.edu.uniquindio.alquiler.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FactoryReciboPago {

    String Id;
    Set<ReciboPago> listaRecibosPago;

    private static FactoryReciboPago factory;

    private FactoryReciboPago(){
        this.listaRecibosPago=new HashSet<>();
        this.Id="1234";
    }

    public static FactoryReciboPago getInstance(){
        if(factory == null){
            factory = new FactoryReciboPago();
        }

        return factory;
    }
}
