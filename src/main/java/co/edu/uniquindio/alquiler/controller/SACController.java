package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.model.Domain;
import co.edu.uniquindio.alquiler.model.FactoryBanco;
import co.edu.uniquindio.alquiler.model.Materia;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class SACController {
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

    public Domain domain= Domain.getInstance();

    public void initialize() {
        materiasTable.setVisible(false);
        solicitudNovedadesLbl.setVisible(false);
        nombreMateriaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombre()));
        codigoMateriaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getCodigo()));
        definitivaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getNotaDefinitiva()) ) );
        this.materiasTable.setItems(FXCollections.observableList(domain.factorySAC.getSac().factoryEstudiante));

    }
}
