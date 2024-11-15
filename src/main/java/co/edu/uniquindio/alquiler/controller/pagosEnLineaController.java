package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.model.DatosSesion;
import co.edu.uniquindio.alquiler.model.Domain;
import co.edu.uniquindio.alquiler.model.Estudiante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
        valorAPagarTextField.setText(""+domain.encontrarReciboPagoValorPagar(datos.getEstudianteSeleccionado(),Integer.parseInt(identificacionTxtField.getText())));
        nombreEstudianteTextField.setText(datos.getEstudianteSeleccionado().getNombre());
        codigoTextField.setText(datos.getEstudianteSeleccionado().getId());
    }

}
