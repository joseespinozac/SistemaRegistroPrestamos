package GUI;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.LicenciaDAO;
import domain.Licencia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class pantallaLicenciaEliminarControlador implements Initializable {

  private LicenciaDAO licenciaDao = new LicenciaDAO();

  @FXML
  private TextField txtBuscarId;

  @FXML
  private TextField txtIdLicencia;

  @FXML
  private TextField txtNoLicencia;

  @FXML
  private TextField txtFechaAgregado;

  @FXML
  private TextField txtFechaExpiracion;

  @FXML
  private TextField txtClave;

  @FXML
  private TextField txtProveedor;

  @FXML
  private TextField txtCaracter;

  @FXML
  private TextField txtTipoLicencia;

  @FXML
  private Button bSalir;

  @FXML
  private Button bBuscar;

  @FXML
  private Button bEliminar;

  @FXML
  public void cargarPantallaLicencia() {
    Stage stage = new Stage();
    try {
      Parent root = FXMLLoader.load(getClass().getResource("pantallaLicencia.fxml"));
      Scene scene = new Scene(root);


      stage.setScene(scene);
      stage.show();
      closeButtonAction();

    } catch (IOException ex) {
      Logger.getLogger(pantallaLicenciaEliminarControlador.class.getName()).log(Level.SEVERE, null,
          ex);
    }
  }

  @FXML
  private void closeButtonAction() {

    Stage stage = (Stage) bBuscar.getScene().getWindow();

    stage.close();
  }

  @FXML
  public void BuscarLicencia() {
    String id = txtBuscarId.getText();

    if (!id.equals("")) {
      if (licenciaDao.existe(id) == true) {
        Licencia licencia = licenciaDao.obtenerLicencia(id);

        txtIdLicencia.setText(licencia.getIdLicencia());
        txtNoLicencia.setText(Integer.toString(licencia.getNumeroLicencias()));
        txtFechaAgregado.setText(regresarFecha(licencia.getFechaInicio()));
        txtFechaExpiracion.setText(regresarFecha(licencia.getFechaFin()));
        txtClave.setText(licencia.getClave());
        txtProveedor.setText(licencia.getProveedor());
        txtCaracter.setText(licencia.getCaracter());
        txtTipoLicencia.setText(licencia.getTipoLicenciamiento());


      } else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Sin existencia");
        alert.setContentText("No se cuenta con ningun registro de ese ID: " + id);

        alert.showAndWait();
      }
    } else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Informacion");
      alert.setHeaderText("Campo vacio");
      alert.setContentText("Ingrese un id para buscar y realize la accion buscar");

      alert.showAndWait();
    }

  }

  @FXML
  public void eliminarLicencia() {
    String id = txtIdLicencia.getText();

    if (!id.equals("")) {
      licenciaDao.eliminarLicencia(id);

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Informacion");
      alert.setHeaderText("Licencia Eliminada");
      alert.setContentText("La licencia ha sido eliminada");

      alert.showAndWait();
    } else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Informacion");
      alert.setHeaderText("Campo vacio");
      alert.setContentText("Ingrese un id para buscar");

      alert.showAndWait();
    }

  }


  public String regresarFecha(Date fecha) {

    String fechaR;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    fechaR = format.format(fecha);

    return fechaR;
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {

    txtIdLicencia.setDisable(true);
    txtNoLicencia.setDisable(true);
    txtFechaAgregado.setDisable(true);
    txtFechaExpiracion.setDisable(true);
    txtClave.setDisable(true);
    txtProveedor.setDisable(true);
    txtCaracter.setDisable(true);
    txtTipoLicencia.setDisable(true);

  }

}
