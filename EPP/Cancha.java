public class Cancha {
  public int numero;
  public Tarifa tarifa;

  public Cancha(int p_numero, Tarifa p_tarifa) {
    this.numero = p_numero;
    this.tarifa = p_tarifa;
  }

  public String mostrar() {
    return String.format("Cancha N° %s \n %s", this.numero, this.tarifa.mostrar());
  }
}
