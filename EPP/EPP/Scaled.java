public class Scaled extends Atleta {
  private int pullUps;

  public int getPullUps() {
    return pullUps;
  }

  public void setPullUps(int pullUps) {
    this.pullUps = pullUps;
  }

  public Scaled(int p_identificador, String p_nombre, double p_kilos, int p_pullUps) {
    super(p_identificador, p_nombre, p_kilos);
    this.setPullUps(p_pullUps);
  }

  @Override
  public String imprimirTipo() {
    return "(Scaled)";
  }

  @Override
  public String mostrarDatos() {
    return String.format("%s ** Pullups realizados: %d %s", super.mostrarDatos(), this.getPullUps(),
        this.imprimirTipo());
  }
}
