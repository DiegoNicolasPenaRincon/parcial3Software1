package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.enums.EstadoRecibo;
import co.edu.uniquindio.alquiler.exceptions.PromedioBajoException;
import co.edu.uniquindio.alquiler.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class SACController {

    @FXML
    TableView<ReciboPago> recibosPagoTable;
    @FXML
    TableColumn<ReciboPago,String> nombreEstColumn;
    @FXML
    TableColumn<ReciboPago,String> estadoReciboColumn;
    @FXML
    TableColumn<ReciboPago, String> valorReciboColumn;
    @FXML
    TableColumn<ReciboPago, String> numeroReferenciaColumn;
    @FXML
    Label otrosDerechosLabel;
    @FXML
    Button solicitarPermisoButton;
    @FXML
    Label solicitudNovedadesLbl;
    @FXML
    Button novedadesButton;
    @FXML
    Button otrosDerechosButton;
    @FXML
    Button pagosButton;
    @FXML
    ImageView logoImgView;
    @FXML
    Circle circulo1;
    @FXML
    Circle circulo2;
    @FXML
    Line barra2;
    @FXML
    Line barra1;
    @FXML
    Circle circulo3;
    @FXML
    TableView<Materia> materiasTable;
    @FXML
    TableColumn<Materia,String> nombreMateriaColumn;
    @FXML
    TableColumn<Materia,String> codigoMateriaColumn;
    @FXML
    TableColumn<Materia,String> definitivaColumn;

    DatosSesion datos=DatosSesion.getInstance();

    public Estudiante estudianteSesionIniciada=datos.getEstudianteSeleccionado();

    public Domain domain= Domain.getInstance();


    public void initialize() {
        materiasTable.setVisible(false);
        solicitudNovedadesLbl.setVisible(false);
        solicitarPermisoButton.setVisible(false);
        recibosPagoTable.setVisible(false);
        otrosDerechosLabel.setVisible(false);

        nombreMateriaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombre()));
        codigoMateriaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getCodigo()));
        definitivaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getNotaDefinitiva()) ) );

        nombreEstColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombreEstudiante()));
        estadoReciboColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getEstadoRecibo()) ) );
        valorReciboColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getValorPagar()+""));;
        numeroReferenciaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNumeroReferencia()+""));


        this.materiasTable.setItems(FXCollections.observableList(estudianteSesionIniciada.getListaMaterias()));
        this.recibosPagoTable.setItems(FXCollections.observableList(estudianteSesionIniciada.getListaRecibosPago()));

    }

    public void aparecerNotasAction(ActionEvent actionEvent) {
        materiasTable.setVisible(true);
        solicitudNovedadesLbl.setVisible(true);
        solicitarPermisoButton.setVisible(true);
        recibosPagoTable.setVisible(false);
        otrosDerechosLabel.setVisible(false);
    }

    public void otrosDerechosAction(ActionEvent actionEvent) {
        materiasTable.setVisible(false);
        solicitudNovedadesLbl.setVisible(false);
        solicitarPermisoButton.setVisible(false);
        recibosPagoTable.setVisible(true);
        otrosDerechosLabel.setVisible(true);
    }



    public void solicitarPermisoAction(ActionEvent actionEvent) {
        Materia materiaSeleccionada=materiasTable.getSelectionModel().getSelectedItem();

        if(materiaSeleccionada!=null)
        {
            LocalDate fecha=LocalDate.now();
            ReciboPago reciboPago=new ReciboPago(estudianteSesionIniciada.getNombre(), EstadoRecibo.GENERADO, fecha,null,fecha.plusDays(10),materiaSeleccionada.getNombre(), (int) (Math.random() * 900) + 100);
            try
            {
                domain.agregarRecibodePago(estudianteSesionIniciada,reciboPago,materiaSeleccionada);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Alerta");
                alert.setContentText("Su recibo acaba de ser generado");
                alert.show();
            }
            catch (PromedioBajoException e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Alerta");
                alert.setContentText(e.getMessage());
                alert.show();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText("No ha seleccionado ninguna materia");
            alert.show();
        }
    }

    public void pagosEnLineaAction(ActionEvent actionEvent) {
        try
        {
            inicializarPagosEnLineaInterfaz();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void inicializarPagosEnLineaInterfaz() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/pagosEnLinea.fxml"));
        Parent root = loader.load();

        pagosEnLineaController pagosEnLineaController =loader.getController();

        // Mostramos la nueva ventana
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


}
