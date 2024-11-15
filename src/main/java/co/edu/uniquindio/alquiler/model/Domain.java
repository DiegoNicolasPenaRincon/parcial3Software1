package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.exceptions.PromedioBajoException;

import java.util.ArrayList;

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

    public Estudiante accederPlataforma(String palabraClave,String identificacion,String iconoClave) {
        ArrayList<Estudiante> listaEstudiantes=factorySAC.sac.factoryEstudiante.getEstudiantes();
        for(int i=0;i<listaEstudiantes.size();i++)
        {
            if(listaEstudiantes.get(i).getPalabraClave().equals(palabraClave)&&listaEstudiantes.get(i).getId().equals(identificacion)&&listaEstudiantes.get(i).getIconoClave().equals(iconoClave))
            {
                return listaEstudiantes.get(i);
            }
        }
        return null;
    }

    public void agregarRecibodePago(Estudiante estudiante,ReciboPago reciboPago,Materia materia) throws PromedioBajoException {
        for(int i=0;i<factorySAC.sac.factoryEstudiante.getEstudiantes().size();i++)
        {
            if(factorySAC.sac.factoryEstudiante.getEstudiantes().get(i).equals(estudiante))
            {
                if(verificarPromedio(materia))
                {
                    factorySAC.sac.factoryEstudiante.getEstudiantes().get(i).listaRecibosPago.add(reciboPago);
                    i=factorySAC.sac.factoryEstudiante.getEstudiantes().size();
                }
                else
                {
                    throw new PromedioBajoException("No puede habilitar esa materia, su promedio es muy bajo");
                }
            }
        }
    }

    public boolean verificarPromedio(Materia materia) {
        if(materia.getNotaDefinitiva()>1.9)
        {
            return true;
        }
        return false;
    }

    public double encontrarReciboPagoValorPagar(Estudiante estudiante,int codigoReferencia) {
        for(int i=0;i<estudiante.listaRecibosPago.size();i++)
        {
            if(estudiante.listaRecibosPago.get(i).numeroReferencia==codigoReferencia)
            {
                return estudiante.listaRecibosPago.get(i).valorPagar;
            }
        }
        return 0;
    }

}