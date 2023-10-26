public abstract class Congelado {
  public double precioUnitario;
  public String descripcion;

  public abstract double precio(int p_cantidad);

  public Congelado(String p_descripcion, double p_precioUnitario) {
    this.descripcion = p_descripcion;
    this.precioUnitario = p_precioUnitario;
  }

  public abstract String toString();
}
