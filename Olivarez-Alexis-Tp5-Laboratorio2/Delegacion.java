import java.util.ArrayList;
import java.util.Calendar;

public class Delegacion extends Visitante {
  private ArrayList<Individuo> integrantes;

  public Delegacion(String p_nombre, Calendar p_fechaVisita, Individuo p_integrante) {
    super(p_nombre, p_fechaVisita);
    this.setIntegrantes(new ArrayList<Individuo>());
    this.inscribirIndividuo(p_integrante);
  }

  public Delegacion(String p_nombre, Calendar p_fechaVisita, ArrayList<Individuo> p_integrantes) {
    super(p_nombre, p_fechaVisita);
    this.setIntegrantes(p_integrantes);
  }

  private void setIntegrantes(ArrayList<Individuo> p_integrantes) {
    this.integrantes = p_integrantes;
  }

  public ArrayList<Individuo> getIntegrantes() {
    return this.integrantes;
  }

  @Override
  public double entrada() {
    double entradaCosto = this.cantidadDeIntegrantes() * 10;
    return entradaCosto -= entradaCosto * 0.10;
  }

  public void inscribirIndividuo(Individuo p_individuo) {
    this.getIntegrantes().add(p_individuo);
  }

  public void eliminarIndividuo(Individuo p_individuo) {
    if (this.cantidadDeIntegrantes() == 1) {
      System.out.println("No se puede eliminar, porque tiene que quedar un Individuo.");
    }
    this.getIntegrantes().remove(p_individuo);
  }

  public int cantidadDeIntegrantes() {
    return this.getIntegrantes().size();
  }

  @Override
  public void mostrar() {
    System.out.format("Delegacion: %s\n", this.getNombre());
    System.out.println("Integrantes");
    for (Individuo integrante : this.getIntegrantes()) {
      integrante.mostrar();
    }
    System.out.format("Cantidad de Integrantes: %s\n\n", this.cantidadDeIntegrantes());
  }

  @Override
  public void listarPorFecha(Calendar p_fecha, String p_visitante) {
    if (this.getFechaVisita().equals(p_fecha) && p_visitante == this.tipoVisitante()) {
      this.mostrar();
    }
  }

  @Override
  public String tipoVisitante() {
    return "Delegacion";
  }
}
