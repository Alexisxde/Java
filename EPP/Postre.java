public class Postre extends Congelado {
  public boolean enCaja;

  public Postre(String p_descripcion, boolean p_enCaja) {
    super(p_descripcion, 15.0);
    this.enCaja = p_enCaja;
  }

  @Override
  public double precio(int p_cantidad) {
    double precioU = this.enCaja ? super.precioUnitario * 1.05 : super.precioUnitario;
    int docenas = (int) p_cantidad / 12;
    precioU -= precioU * 0.10 * docenas;
    return precioU;
  }

  @Override
  public String toString() {
    return String.format("Postre%sPU: %.2f", this.enCaja ? " (En Caja)\t" : "\t\t", super.precioUnitario);
  }
}