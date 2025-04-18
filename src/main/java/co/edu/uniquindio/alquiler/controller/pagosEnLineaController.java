package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.model.DatosSesion;
import co.edu.uniquindio.alquiler.model.Domain;
import co.edu.uniquindio.alquiler.model.Estudiante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class pagosEnLineaController {
    @FXML
    Label pagosEnLineaLbl;
    @FXML
    Label identificacionLbl;
    @FXML
    TextField identificacionTxtField;
    @FXML
    ImageView logoImgView;
    @FXML
    Button consultarButton;
    @FXML
    Label codigoLbl;
    @FXML
    TextField codigoTextField;
    @FXML
    Label valorAPagarLbl;
    @FXML
    TextField valorAPagarTextField;
    @FXML
    Label nombreEstudianteLbl;
    @FXML
    TextField nombreEstudianteTextField;
    @FXML
    ImageView logimgView;
    @FXML
    Button pagarButton;

    public Domain domain= Domain.getInstance();

    DatosSesion datos=DatosSesion.getInstance();


    public void initialize() {

    }


    public void mostrarDatosAction(ActionEvent actionEvent) {
        nombreEstudianteTextField.setText("");
        identificacionTxtField.setText("");
        if(domain.encontrarReciboPagar(datos.getEstudianteSeleccionado(),Integer.parseInt(codigoTextField.getText()))!=null)
        {

        }
        if(valorAPagarTextField!=null&&!valorAPagarTextField.equals(""))
        {
            nombreEstudianteTextField.setText(datos.getEstudianteSeleccionado().getNombre());
            codigoTextField.setText(datos.getEstudianteSeleccionado().getId());
        }
    }


    public void pagarOnAction(ActionEvent actionEvent) {

    }
}
