package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.EstadoRecibo;

import java.time.LocalDate;

public class SAC {

    public FactoryBanco factoryBanco=FactoryBanco.getInstance();
    public FactoryEstudiante factoryEstudiante=FactoryEstudiante.getInstance();
    public FactoryMateria factoryMateria=FactoryMateria.getInstance();
    public FactoryReciboPago factoryReciboPago=FactoryReciboPago.getInstance();

    public SAC() {

        //Se instancian los bancos

        Banco banco1=new Banco("Bancolombia");
        Banco banco2=new Banco("Nequi");

        //Se instancian los estudiantes

        Estudiante estudiante1=new Estudiante("Nicolas","12345678","Hola","☻");
        //Estudiante estudiante2=new Estudiante("Diana","12345679","Adios","☻");

        //Se instancian las materias

        Materia materia1=new Materia("Ingenieria de sistemas","Estructura de datos","123");
        materia1.listaNotas.add(5.0);
        materia1.listaNotas.add(3.0);
        materia1.listaNotas.add(2.0);
        materia1.listaNotas.add(1.5);
        materia1.notaDefinitiva=2.875;

        estudiante1.listaMaterias.add(materia1);

        //Se agregan los datos a los listados de los factorys

        factoryBanco.listaBancos.add(banco1);
        factoryBanco.listaBancos.add(banco2);

        factoryEstudiante.Estudiantes.add(estudiante1);

        factoryMateria.listaMaterias.add(materia1);

    }


}
