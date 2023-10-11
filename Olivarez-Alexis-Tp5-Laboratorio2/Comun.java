public class Comun extends Etiqueta {
  private double plus;

  public Comun(double p_costo, double p_plus) {
    super(p_costo);
    this.setPlus(p_plus);
  }

  private void setPlus(double p_plus) {
    this.plus = p_plus;
  }

  public double getPlus() {
    return this.plus;
  }

  @Override
  public double precio(int q) {
    return (super.getCosto() * q) - this.descuento(q) + this.getPlus();
  }

  @Override
  protected String tipo() {
    return "Común";
  }

  @Override
  public String toString() {
    return super.toString() + "- Diseño: $" + this.getPlus();
  }

  private double descuento(int q) {
    if (q <= 10) {
      return 0;
    } else if (q <= 51) {
      return super.getCosto() * q * 0.02;
    } else if (q <= 100) {
      return super.getCosto() * q * 0.05;
    }
    return super.getCosto() * q * 0.01 * (int) (q / 10);
  }
}
