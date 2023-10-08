import java.util.ArrayList;

public abstract class Alojamiento {
  private String nombre;
  private double precioBase;
  private int diasAlquiler;
  private ArrayList<Servicio> servicios;

  public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler) {
    this.setNombre(p_nombre);
    this.setPrecioBase(p_precioBase);
    this.setDiasAlquiler(p_diasAlquiler);
    // this.setServicios(new ArrayList<Servicio>());
  }

  public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler, Servicio p_servicio) {
    this.setNombre(p_nombre);
    this.setPrecioBase(p_precioBase);
    this.setDiasAlquiler(p_diasAlquiler);
    // this.setServicios(new ArrayList<Servicio>());
    this.agregarServicio(p_servicio);
  }

  public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios) {
    this.setNombre(p_nombre);
    this.setPrecioBase(p_precioBase);
    this.setDiasAlquiler(p_diasAlquiler);
    this.setServicios(p_servicios);
  }

  private void setNombre(String p_nombre) {
    this.nombre = p_nombre;
  }

  private void setPrecioBase(double p_precioBase) {
    this.precioBase = p_precioBase;
  }

  private void setDiasAlquiler(int p_diasAlquiler) {
    this.diasAlquiler = p_diasAlquiler;
  }

  private void setServicios(ArrayList<Servicio> p_servicios) {
    this.servicios = p_servicios;
  }

  public String getNombre() {
    return this.nombre;
  }

  public double getPrecioBase() {
    return this.precioBase;
  }

  public int getDiasAlquiler() {
    return this.diasAlquiler;
  }

  public ArrayList<Servicio> getServicios() {
    return this.servicios;
  }

  public boolean agregarServicio(Servicio p_servicio) {
    return this.getServicios().add(p_servicio);
  }

  public boolean quitarServicio(Servicio p_servicio) {
    return this.getServicios().remove(p_servicio);
  }

  public abstract int contar(String p_alojamiento);

  public double costo() {
    return this.getPrecioBase() * this.getDiasAlquiler();
  }

  public double costoServicios() {
    double totalCosto = 0;
    for (Servicio servicio : this.getServicios()) {
      totalCosto += servicio.getPrecio();
    }
    return totalCosto;
  }

  public void listarServicios() {
    for (Servicio servicio : this.getServicios()) {
      System.out.format("%s: $%.2f", servicio.getDescripcion(), servicio.getPrecio());
    }
  }

  public void liquidar() {
    System.out.format("Alojamiento: %s\n", this.getNombre());
    System.out.format("Costo por %s dias: $%.2f\n", this.getDiasAlquiler(), this.costo());
    this.listarServicios();
  }
}