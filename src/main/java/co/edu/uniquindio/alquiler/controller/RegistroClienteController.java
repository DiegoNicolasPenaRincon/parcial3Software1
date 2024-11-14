package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquiler.exceptions.InformacionRepetidaException;
import co.edu.uniquindio.alquiler.model.AlquilaFacil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class RegistroClienteController {

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtTelefono;

    private final AlquilaFacil alquilaFacil = AlquilaFacil.getInstance();

    public void registrarCliente(ActionEvent actionEvent){

        try {
            Cliente cliente = alquilaFacil.registrarCliente(
                    txtCedula.getText(),
                    txtNombre.getText(),
                    txtCorreo.getText(),
                    txtDireccion.getText(),
                    txtCiudad.getText(),
                    txtTelefono.getText());

            mostrarMensaje(Alert.AlertType.INFORMATION, "Se ha registrado correctamente el cliente: "+cliente.getNombreCompleto());

        } catch (AtributoVacioException | InformacionRepetidaException e) {
            mostrarMensaje(Alert.AlertType.ERROR, e.getMessage());
        }

    }

    public void mostrarMensaje(Alert.AlertType tipo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }

}
