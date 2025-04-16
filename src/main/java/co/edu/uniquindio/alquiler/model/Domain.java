package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.exceptions.PromedioBajoException;
import co.edu.uniquindio.alquiler.exceptions.ReciboExistenteException;

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

    public void agregarRecibodePago(Estudiante estudiante,ReciboPago reciboPago,Materia materia) throws PromedioBajoException, ReciboExistenteException {
        for(int i=0;i<factorySAC.sac.factoryEstudiante.getEstudiantes().size();i++)
        {
            if(!reciboExistente(estudiante,reciboPago))
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
            else
            {
                throw new ReciboExistenteException();
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

    public boolean reciboExistente(Estudiante estudiante,ReciboPago reciboNuevo) {
        for(int i=0;i<factorySAC.sac.factoryEstudiante.Estudiantes.size();i++)
        {
            for(int j=0;j<factorySAC.sac.factoryEstudiante.Estudiantes.get(i).listaRecibosPago.size();j++)
            {
                if(factorySAC.sac.factoryEstudiante.Estudiantes.get(i).listaRecibosPago.get(j).numeroReferencia==reciboNuevo.numeroReferencia)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void eliminarReciboPago(Estudiante estudiante,ReciboPago reciboPagoEliminar) {
        for(int i=0;i<factorySAC.sac.factoryEstudiante.Estudiantes.size();i++)
        {
            if(estudiante.equals(factorySAC.sac.factoryEstudiante.Estudiantes.get(i)))
            {
                factorySAC.sac.factoryEstudiante.getEstudiantes().get(i).listaRecibosPago.remove(reciboPagoEliminar);
            }
        }
    }

    public void pagarRecibo(int numeroReferencia) {
        for(int i=0;i<factorySAC.sac.factoryEstudiante.Estudiantes.size();i++)
        {
            if(factorySAC.sac.factoryEstudiante.Estudiantes.get(i).listaRecibosPago)
            {

            }
        }
    }

}