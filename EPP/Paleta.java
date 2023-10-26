public class Paleta extends Congelado {
  public int tipo;

  public Paleta(String p_descripcion, int p_tipo) {
    super(p_descripcion, p_tipo == 0 ? 10.0 : 20.0);
    this.tipo = p_tipo;
  }

  @Override
  public double precio(int p_cantidad) {
    double precioU = super.precioUnitario;
    if (p_cantidad > 20) {
      precioU -= precioU * 0.20;
    }
    return precioU;
  }

  @Override
  public String toString() {
    return String.format("Paleta %sPU: %.2f", this.tipo == 0 ? "(Agua)\t" : "(Crema)\t", super.precioUnitario);
  }
}
