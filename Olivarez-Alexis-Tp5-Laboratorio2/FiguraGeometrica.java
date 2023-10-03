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

  public String nombreFigura() {
    return "";
  }

  public double superficie() {
    return 1.1;
  }
}
