package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.EstadoRecibo;
import db.Conexion;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class SAC {

    public FactoryBanco factoryBanco=FactoryBanco.getInstance();
    public FactoryEstudiante factoryEstudiante=FactoryEstudiante.getInstance();
    public FactoryMateria factoryMateria=FactoryMateria.getInstance();
    public FactoryReciboPago factoryReciboPago=FactoryReciboPago.getInstance();
    public Conexion conexionBD=Conexion.getInstance();

    public LocalDate fechaCierrePlataforma=LocalDate.of(2025, 6, 7);

    String remitente="diegon.penar@uqvirtual.edu.co";

    String clave="";

    public SAC() {


        insertarDatos();
        //conexionBD.conectarBDSoftware2();

    }

    public double calcularDefinitiva(ArrayList<Double> listadoNotas) {
        double definitiva=0.0;
        int centinela=0;
        for(int i=0;i<listadoNotas.size();i++)
        {
            definitiva+=listadoNotas.get(i);
            centinela++;
        }
        return definitiva=definitiva/centinela;
    }

    public void insertarDatos() {

        //Se instancian los bancos

        Banco banco1=new Banco("Bancolombia");
        Banco banco2=new Banco("Nequi");

        //Se instancian los estudiantes

        Estudiante estudiante1=new Estudiante("Nicolas","12345678","Hola","☻","diegonicolaspenarincon@gmail.com");
        Estudiante estudiante2=new Estudiante("Diana","12345679","Adios","☻","carlosf.corralesz@uqvirtual.edu.co");

        //Se instancian las materias

        Materia materia1=new Materia("Ingenieria de sistemas","Estructura de datos","123");
        materia1.listaNotas.add(5.0);
        materia1.listaNotas.add(3.0);
        materia1.listaNotas.add(2.0);
        materia1.listaNotas.add(1.5);
        materia1.notaDefinitiva=calcularDefinitiva(materia1.listaNotas);

        Materia materia2=new Materia("Ingenieria de sistemas","Ingenieria de software 2","456");
        materia2.listaNotas.add(5.0);
        materia2.listaNotas.add(1.0);
        materia2.listaNotas.add(0.8);
        materia2.listaNotas.add(0.5);
        materia2.notaDefinitiva=calcularDefinitiva(materia2.listaNotas);

        Materia materia3=new Materia("Ingenieria de sistemas","Calculo vectorial","789");
        materia3.listaNotas.add(4.0);
        materia3.listaNotas.add(3.0);
        materia3.listaNotas.add(1.8);
        materia3.listaNotas.add(3.5);
        materia3.notaDefinitiva=calcularDefinitiva(materia3.listaNotas);

        Materia materia4=new Materia("Ingenieria de sistemas","Matematicas discretas","012");
        materia4.listaNotas.add(5.0);
        materia4.listaNotas.add(2.0);
        materia4.listaNotas.add(4.8);
        materia4.listaNotas.add(2.5);
        materia4.notaDefinitiva=calcularDefinitiva(materia4.listaNotas);

        estudiante1.listaMaterias.add(materia1);
        estudiante1.listaMaterias.add(materia2);

        estudiante2.listaMaterias.add(materia3);
        estudiante2.listaMaterias.add(materia4);

        //Se agregan los datos a los listados de los factorys

        factoryBanco.listaBancos.add(banco1);
        factoryBanco.listaBancos.add(banco2);

        factoryEstudiante.Estudiantes.add(estudiante1);
        factoryEstudiante.Estudiantes.add(estudiante2);

        factoryMateria.listaMaterias.add(materia1);
        factoryMateria.listaMaterias.add(materia2);
        factoryMateria.listaMaterias.add(materia3);
        factoryMateria.listaMaterias.add(materia4);



    }

    public void solicitudGenerada(String destinatario,String asunto) {
        Properties propiedades=System.getProperties();
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.user", remitente);
        propiedades.put("mail.smtp.clave", clave);
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session sesion=Session.getDefaultInstance(propiedades);
        MimeMessage message = new MimeMessage(sesion);

        try
        {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(asunto);
            Transport transport = sesion.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me)
        {
            me.printStackTrace();
        }
    }

    public void importarMaterias() {
        try
        {
            String consulta="SELECT * FROM Materias";
            Statement stmt = conexionBD.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            while(rs.next())
            {
                String nombre = rs.getString("nombre");
                String codigo = rs.getString("codigoMateria");
                float nota1 = rs.getFloat("nota1");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }


}
