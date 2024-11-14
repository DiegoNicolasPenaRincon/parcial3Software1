package co.edu.uniquindio.alquiler.model;

public class FactorySAC {

    String Id;
    SAC sac;
    private static FactorySAC factorySAC;

    private FactorySAC(){
        this.Id = "";
        sac = new SAC();
    }

    public static FactorySAC getInstance(){
        if(factorySAC == null){
            factorySAC = new FactorySAC();
        }

        return factorySAC;
    }
}
