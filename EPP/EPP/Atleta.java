public abstract class Atleta {
  private int identificador;
  private String nombre;
  private double kilos;

  public int getIdentificador() {
    return identificador;
  }

  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getKilos() {
    return kilos;
  }

  public void setKilos(double kilos) {
    this.kilos = kilos;
  }

  public Atleta(int p_identificador, String p_nombre, double p_kilos) {
    this.setIdentificador(p_identificador);
    this.setNombre(p_nombre);
    this.setKilos(p_kilos);
  }

  public abstract String imprimirTipo();

  public String mostrarDatos() {
    return String.format("Atleta: %d, - %s - Kilos movidos: %.2f", this.getIdentificador(), this.getNombre(),
        this.getKilos());
  }
}