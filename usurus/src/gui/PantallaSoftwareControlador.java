package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.ISoftwareDao;
import dao.SoftwareDao;
import domain.Software;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PantallaSoftwareControlador implements Initializable {

  @FXML
  private TableView<Software> tbSoftware;

  @FXML
  private Button bAgregar;

  @FXML
  private Button bEliminar;

  @FXML
  private Button bModificar;

  @FXML
  private Button bBuscar;

  @FXML
  private Button bSalir;

  /*
   * Metodo para cargar pantalla Agregar Software
   */
  @FXML
  public void cargarPantallaSoftwareAgregar() {
    Stage stage = new Stage();
    try {
      Parent root = FXMLLoader.load(getClass().getResource("PantallaSoftwareAgregar.fxml"));
      Scene scene = new Scene(root);


      stage.setScene(scene);
      stage.show();
      closeButtonAction();

    } catch (IOException ex) {
      Logger.getLogger(PantallaSoftwareControlador.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /*
   * Metodo para cargar pantalla Buscar Software
   */
  @FXML
  public void cargarPantallaLicenciaBuscar() {
    Stage stage = new Stage();
    try {
      Parent root = FXMLLoader.load(getClass().getResource("pantallaLicenciaBuscar.fxml"));
      Scene scene = new Scene(root);


      stage.setScene(scene);
      stage.show();
      closeButtonAction();

    } catch (IOException ex) {
      Logger.getLogger(PantallaSoftwareControlador.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /*
   * Metodo para cargar pantalla Eliminar Software
   */
  @FXML
  public void cargarPantallaSoftwareEliminar() {
    Stage stage = new Stage();
    try {
      Parent root = FXMLLoader.load(getClass().getResource("PantallaSoftwareEliminar.fxml"));
      Scene scene = new Scene(root);


      stage.setScene(scene);
      stage.show();
      closeButtonAction();

    } catch (IOException ex) {
      Logger.getLogger(PantallaSoftwareControlador.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /*
   * Metodo para cargar pantalla Modificar Software
   */
  @FXML
  public void cargarPantallaSoftwareModificar() {
    Stage stage = new Stage();
    try {
      Parent root = FXMLLoader.load(getClass().getResource("PantallaSoftwareModificar.fxml"));
      Scene scene = new Scene(root);


      stage.setScene(scene);
      stage.show();
      closeButtonAction();

    } catch (IOException ex) {
      Logger.getLogger(PantallaSoftwareControlador.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /*
   * Metodo para cerrar Ventana
   */
  @FXML
  private void closeButtonAction() {

    Stage stage = (Stage) bSalir.getScene().getWindow();

    stage.close();

  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {

    ISoftwareDao softwareDao = new SoftwareDao();
    ObservableList<Software> listaObservable =
        FXCollections.observableArrayList(softwareDao.obtenerSoftwares());
    tbSoftware.setItems(listaObservable);
    tbSoftware.setDisable(false);

  }

}
