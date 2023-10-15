public abstract class FiguraGeometrica {
  private Punto origen;

  private void setOrigen(Punto p_origen) {
    this.origen = p_origen;
  }

  public Punto getOrigen() {
    return this.origen;
  }

  public FiguraGeometrica(Punto p_origen) {
    this.setOrigen(p_origen);
  }

  public abstract String nombreFigura();

  public abstract double superficie();

  public void mostrarSuperficie() {
    System.out.println("\n" + this.nombreFigura());
    System.out.format("Superficie: %.2f\n", this.superficie());
  }
}
