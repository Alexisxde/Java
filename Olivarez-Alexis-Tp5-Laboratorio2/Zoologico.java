import java.util.ArrayList;
import java.util.Calendar;

public class Zoologico {
  private String nombre;
  private ArrayList<Visitante> visitantes;

  public Zoologico(String p_nombre) {
    this.setNombre(p_nombre);
    this.setVisitantes(new ArrayList<Visitante>());
  }

  public Zoologico(String p_nombre, ArrayList<Visitante> p_visitantes) {
    this.setNombre(p_nombre);
    this.setVisitantes(p_visitantes);
  }

  private void setNombre(String p_nombre) {
    this.nombre = p_nombre;
  }

  private void setVisitantes(ArrayList<Visitante> p_visitantes) {
    this.visitantes = p_visitantes;
  }

  public String getNombre() {
    return this.nombre;
  }

  public ArrayList<Visitante> getVisitantes() {
    return this.visitantes;
  }

  public void nuevoVisitante(Visitante p_visitante) {
    this.getVisitantes().add(p_visitante);
  }

  public void listaTipoVisitante(Calendar p_fecha, String p_tipoVisitante) {
    for (Visitante visitante : this.getVisitantes()) {
      int posteriorFecha = visitante.getFechaVisita().compareTo(p_fecha);
      if (visitante.tipoVisitante() == p_tipoVisitante && posteriorFecha > 0) {
        visitante.mostrar();
      }
    }
  }

  public void listaVisitante(Calendar p_fecha) {
    for (Visitante visitante : this.getVisitantes()) {
      int posteriorFecha = visitante.getFechaVisita().compareTo(p_fecha);
      if (posteriorFecha >= 0) {
        visitante.mostrar();
      }
    }
  }

  public double recaudacion(Calendar p_fechaDesde, Calendar p_fechaHasta) {
    double recaudacion = 0;
    for (Visitante visitante : this.getVisitantes()) {
      int posteriorFecha = visitante.getFechaVisita().compareTo(p_fechaDesde);
      int anteriorFecha = visitante.getFechaVisita().compareTo(p_fechaHasta);
      if (posteriorFecha >= 0 && anteriorFecha <= 0) {
        if (visitante instanceof Delegacion) {
          Delegacion Delegacion = (Delegacion) visitante;
          recaudacion += Delegacion.entrada();
        } else {
          recaudacion += visitante.entrada();
        }
      }
    }
    return recaudacion;
  }
}