public class Premium extends Etiqueta {
  private int colores;

  public Premium(double p_costo, int p_colores) {
    super(p_costo);
    this.setColores(p_colores);
  }

  private void setColores(int p_colores) {
    this.colores = p_colores;
  }

  public int getColores() {
    return this.colores;
  }

  @Override
  public double precio(int q) {
    return (this.getCosto() * q) + (this.adicional() * q);
  }

  @Override
  protected String tipo() {
    return "Premium";
  }

  public String toString() {
    return super.toString() + "- Colores: " + this.getColores();
  }

  private double adicional() {
    int cantidadColores = this.getColores();
    if (cantidadColores == 1) {
      return 0;
    } else if (cantidadColores == 2) {
      return super.getCosto() * 0.05;
    } else if (cantidadColores == 3) {
      return super.getCosto() * 0.07;
    }
    return super.getCosto() * 0.03 * cantidadColores;
  }
}