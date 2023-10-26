public class Postre extends Congelado {
  public boolean enCaja;

  public Postre(String p_descripcion, double p_precioUnitario, boolean p_enCaja) {
    super(p_descripcion, p_precioUnitario);
    this.enCaja = p_enCaja;
  }

  @Override
  public double precio(int p_cantidad) {
    double precio = this.enCaja ? super.precioUnitario * 1.05 : super.precioUnitario;
    int docenas = (int) p_cantidad / 12;
    precio -= precio * 0.10 * docenas;
    return precio;
  }

  @Override
  public String toString() {
    return String.format("Postre%sPU: %.2f", this.enCaja ? " (En Caja)\t" : "\t\t", super.precioUnitario);
  }
}
