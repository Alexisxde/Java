import java.util.ArrayList;

public class Pedido {
  public ArrayList<RenglonPedido> renglones;

  public Pedido(ArrayList<RenglonPedido> p_renglones) {
    this.renglones = p_renglones;
  }

  public Pedido(RenglonPedido p_renglon) {
    this.renglones = new ArrayList<RenglonPedido>();
  }

  public void agregarRenglon(RenglonPedido p_renglon) {
    this.renglones.add(p_renglon);
  }

  public double importe() {
    double total = 0.0;
    for (RenglonPedido renglon : renglones) {
      total += renglon.importe();
    }
    if (total <= 500) {
      total *= 1.10;
    }
    return total;
  }

  public void mostrar() {
    System.out
        .println("----------------------------------------- Detalle Pedido -----------------------------------------");
    int numRenglon = 1;
    for (RenglonPedido renglon : this.renglones) {
      System.out.println(numRenglon + ". " + renglon.toString());
      numRenglon++;
    }
    System.out.println("-----------------------------------------");
    System.out.printf("Sub-Total: %.2f\n", this.importe());
    System.out.printf("Total: %.2f\n", this.importe());
  }
}
