import java.util.ArrayList;

public class Hotel extends Alojamiento {
  private String tipoHabitacion;

  public Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler, String p_tipoHabitacion) {
    super(p_nombre, p_precioBase, p_diasAlquiler);
    this.setTipoHabitacion(p_tipoHabitacion);
  }

  public Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler, Servicio p_servicio, String p_tipoHabitacion) {
    super(p_nombre, p_precioBase, p_diasAlquiler, p_servicio);
    this.setTipoHabitacion(p_tipoHabitacion);
  }

  public Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios,
      String p_tipoHabitacion) {
    super(p_nombre, p_precioBase, p_diasAlquiler, p_servicios);
    this.setTipoHabitacion(p_tipoHabitacion);
  }

  private void setTipoHabitacion(String p_tipoHabitacion) {
    this.tipoHabitacion = p_tipoHabitacion;
  }

  public String getTipoHabitacion() {
    return this.tipoHabitacion;
  }

  @Override
  public double costo() {
    if (this.getTipoHabitacion() == "Simple") {
      return super.costo() + (20 * super.getDiasAlquiler());
    }

    return super.costo() + (35 * super.getDiasAlquiler());
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
    System.out.format("Habitacion %s\n", this.getTipoHabitacion());
    System.out.format("Total: ------> $%.2f\n", this.costo());
  }
}
