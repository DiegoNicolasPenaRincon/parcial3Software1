package co.edu.uniquindio.alquiler.model;

public class Domain {

    private static Domain domain;

    public FactorySAC factorySAC=FactorySAC.getInstance();


    private Domain(){

    }

    public static Domain getInstance(){
        if(domain == null){
            domain = new Domain();
        }

        return domain;
    }

    //Metodos

    private void accederPlataforma() {}

}