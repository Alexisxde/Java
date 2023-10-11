public class Renglon {
  private int cantidad;
  private double importe;
  private Etiqueta item;

  public Renglon(int p_cantidad, Etiqueta p_item) {
    this.setCantidad(p_cantidad);
    this.setItem(p_item);
    this.setImporte(p_item.precio(p_cantidad));
  }

  private void setCantidad(int p_cantidad) {
    this.cantidad = p_cantidad;
  }

  private void setImporte(double p_importe) {
    this.importe = p_importe;
  }

  private void setItem(Etiqueta p_item) {
    this.item = p_item;
  }

  public int getCantidad() {
    return this.cantidad;
  }

  public double getImporte() {
    return this.importe;
  }

  public Etiqueta getItem() {
    return this.item;
  }

  public void mostrar() {
    System.out.format("%s Etiquetas de %s\n", this.getCantidad(), this.getItem().toString());
  }
}
