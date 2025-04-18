package db;

import co.edu.uniquindio.alquiler.model.Domain;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection conexionT=null;

    String usuario="NicolasPena";
    String contrasenia="nicolas";
    String bd="Software2";
    String Ip="localhost";
    String puerto="1433";

    private static Conexion conexion;

    private Conexion(){

    }

    public static Conexion getInstance(){
        if(conexion == null){
            conexion = new Conexion();
        }

        return conexion;
    }


    String cadenaJDBC="jdbc:sqlserver://"+Ip+":"+puerto+"/"+bd;

    public Connection conectarBDSoftware2(){
        try
        {
            String cadena="jdbc:sqlserver://localhost:"+puerto+";"+"DatabaseName="+bd+";"+"encrypt=true;trustServerCertificate=true;";
            conexionT= DriverManager.getConnection(cadena,usuario,contrasenia);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Informacion");
            alert.setContentText("Se realizo la conexion de manera exitosa");
            alert.show();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
        }
        return conexionT;
    }
}
