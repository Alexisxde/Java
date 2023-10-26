public class Equipo {
  public boolean asociado;
  public Cancha cancha;

  public Equipo(boolean p_asociado, Cancha p_cancha) {
    this.asociado = p_asociado;
    this.cancha = p_cancha;
  }

  public String esAsociado() {
    return this.asociado ? "Si" : "No";
  }

  private double importeFinal() {
    double importeFinal = this.cancha.tarifa.importe();
    if (this.asociado) {
      importeFinal -= importeFinal * 0.20;
    }
    return importeFinal;
  }

  public void mostrar() {
    System.out.println(this.cancha.mostrar());
    System.out.format(" Asociado: %s - Paga $: %.2f\n", this.esAsociado(), this.importeFinal());
  }
}