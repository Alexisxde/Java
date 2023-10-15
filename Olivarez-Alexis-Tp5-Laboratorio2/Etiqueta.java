public abstract class Etiqueta {
  private double costo;

  public Etiqueta(double p_costo) {
    this.setCosto(p_costo);
  }

  private void setCosto(double p_costo) {
    this.costo = p_costo;
  }

  public double getCosto() {
    return this.costo;
  }

  /**
   * @return Una cadena de caracteres que contiene el tipo de etiqueta y costo por
   *         unidad (String).
   */
  public String toString() {
    return String.format("tipo %s - Costo: $%s ", this.tipo(), this.getCosto());
  }

  public abstract double precio(int q);

  protected abstract String tipo();
}
