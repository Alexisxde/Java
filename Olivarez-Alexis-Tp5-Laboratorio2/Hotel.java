import java.util.ArrayList;

public class Hotel extends Alojamiento {
  private String tipoHabitacion;

  public Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler, String p_tipoHabitacion) {
    super(p_nombre, p_precioBase, p_diasAlquiler);
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
    double costo = super.costo();
    if (this.getTipoHabitacion() == "Single") {
      costo = super.costo() + (20 * super.getDiasAlquiler());
    } else if (this.getTipoHabitacion() == "Doble") {
      costo = super.costo() + (35 * super.getDiasAlquiler());
    }
    return costo;
  }

  /**
   * Cuenta la cantidad de alojamientos de un tipo específico.
   *
   * @param p_alojamiento El tipo de alojamiento que se desea contar (String).
   * @return Devuelve 1 si el tipo de alojamiento es "Hotel" si no 0 (int).
   */
  @Override
  public int contar(String p_alojamiento) {
    return p_alojamiento == "Hotel" ? 1 : 0;
  }

  /**
   * Imprime por pantalla el nombre del alojamiento, el costo por los dias
   * alquilados el tipo de habitación y el total a pagar.
   */
  public void liquidar() {
    super.liquidar();
    System.out.format("Habitacion %s\n", this.getTipoHabitacion());
    System.out.format("Total: ------> $%.2f\n", this.costo() + super.costoServicios());
  }
}
