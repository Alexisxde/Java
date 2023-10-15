import java.util.ArrayList;

public class Jardin {
  private String nombre;
  private ArrayList<FiguraGeometrica> figuras;

  public Jardin(String p_nombre) {
    this.setNombre(p_nombre);
    this.setFiguras(new ArrayList<FiguraGeometrica>());
  }

  public Jardin(String p_nombre, ArrayList<FiguraGeometrica> p_figuras) {
    this.setNombre(p_nombre);
    this.setFiguras(p_figuras);
  }

  private void setNombre(String p_nombre) {
    this.nombre = p_nombre;
  }

  private void setFiguras(ArrayList<FiguraGeometrica> p_figuras) {
    this.figuras = p_figuras;
  }

  public String getNombre() {
    return this.nombre;
  }

  public ArrayList<FiguraGeometrica> getFiguras() {
    return this.figuras;
  }

  public boolean agregarFigura(FiguraGeometrica p_figura) {
    return this.getFiguras().add(p_figura);
  }

  private double cuantosLitros() {
    return this.cuantosMetros() / 20;
  }

  public int cuantasLatas() {
    return (int) Math.ceil(this.cuantosLitros());
  }

  public double cuantosMetros() {
    double superficieTotal = 0;
    for (FiguraGeometrica figura : this.getFiguras()) {
      superficieTotal += figura.superficie();
    }
    return superficieTotal;
  }

  public void detalleFiguras() {
    System.out.format("Presupuesto: %s\n", this.getNombre());
    for (FiguraGeometrica figura : this.getFiguras()) {
      figura.mostrarSuperficie();
    }
    System.out.println("---------------------------------------------");
    System.out.format("Total a cubrir: %.2f\n", this.cuantosMetros());
    System.out.format("Comprar %s Latas.", this.cuantasLatas());
  }
}
