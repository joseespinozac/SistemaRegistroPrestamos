package dao;

import java.util.List;
import domain.Licencia;

public interface ILicenciaDAO {

  List<Licencia> obtenerLicencias();

  Licencia obtenerLicencia(String id);

  boolean agregarLicencia(Licencia licencia);

  boolean modficarLicencia(Licencia licencia);

  boolean eliminarLicencia(String id);

}
