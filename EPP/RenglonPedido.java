public class RenglonPedido {
  public int cantidad;
  public Congelado item;

  public RenglonPedido(int p_cantidad, Congelado p_item) {
    this.cantidad = p_cantidad;
    this.item = p_item;
  }

  public double importe() {
    return this.item.precio(this.cantidad) * this.cantidad;
  }

  public String toString() {
    return String.format("%s Cantidad: %d Precio: %.2f Subtotal: %.2f", this.item.toString(), this.cantidad,
        this.item.precio(this.cantidad), this.importe());
  }
}