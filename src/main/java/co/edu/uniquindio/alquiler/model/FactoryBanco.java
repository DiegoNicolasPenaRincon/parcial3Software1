package co.edu.uniquindio.alquiler.model;

import java.util.ArrayList;

public class FactoryBanco {

    ArrayList<Banco> listaBancos;
    String Id;

    private static FactoryBanco factory;

    private FactoryBanco(){
        this.listaBancos=new ArrayList();
        this.Id="12";
    }

    public static FactoryBanco getInstance(){
        if(factory == null){
            factory = new FactoryBanco();
        }

        return factory;
    }
}
