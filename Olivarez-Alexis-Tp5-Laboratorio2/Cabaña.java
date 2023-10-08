import java.util.ArrayList;

public class Cabaña extends Alojamiento {
  private int nroHabitaciones;

  public Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler, int p_nroHabitaciones) {
    super(p_nombre, p_precioBase, p_diasAlquiler);
    this.setNroHabitaciones(p_nroHabitaciones);
  }

  public Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler, Servicio p_servicio, int p_nroHabitaciones) {
    super(p_nombre, p_precioBase, p_diasAlquiler, p_servicio);
    this.setNroHabitaciones(p_nroHabitaciones);
  }

  public Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios,
      int p_nroHabitaciones) {
    super(p_nombre, p_precioBase, p_diasAlquiler, p_servicios);
    this.setNroHabitaciones(p_nroHabitaciones);
  }

  private void setNroHabitaciones(int p_nroHabitaciones) {
    this.nroHabitaciones = p_nroHabitaciones;
  }

  public int getNroHabitaciones() {
    return this.nroHabitaciones;
  }

  @Override
  public double costo() {
    return super.costo() + ((super.getDiasAlquiler() * 30) * this.getNroHabitaciones());
  }

  @Override
  public int contar(String p_alojamiento) {
    int contador = 0;
    for (Servicio servicio : super.getServicios()) {
      if (servicio.getClass().getName().toLowerCase() == p_alojamiento.toLowerCase()) {
        contador += 1;
      }
    }
    return contador;
  }

  public void liquidar() {
    super.liquidar();
    System.out.format("%s con %s habitaciones\n", this.getClass().getName(), this.getNroHabitaciones());
    System.out.format("Total: ------> $%.2f\n", this.costo());
  }
}