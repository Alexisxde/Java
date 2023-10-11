import java.util.ArrayList;

public class Pedido {
  private ArrayList<Renglon> renglones;

  public Pedido(Renglon p_renglon) {
    this.setRenglones(new ArrayList<Renglon>());
    this.agregarRenglon(p_renglon);
  }

  public Pedido(ArrayList<Renglon> p_renglones) {
    this.setRenglones(p_renglones);
  }

  private void setRenglones(ArrayList<Renglon> p_renglones) {
    this.renglones = p_renglones;
  }

  public ArrayList<Renglon> getRenglones() {
    return this.renglones;
  }

  public boolean agregarRenglon(Renglon p_renglon) {
    return this.getRenglones().add(p_renglon);
  }

  public boolean quitarRenglon(Renglon p_renglon) {
    if (this.getRenglones().size() == 1) {
      System.out.println("Tiene que haber por lo menos un renglon...");
      return false;
    }
    return this.getRenglones().remove(p_renglon);
  }

  public void mostrar() {
    double importeTotal = 0;
    int cantidadTotal = 0;
    System.out.println("Pedido:");
    System.out.format("Cantidad de items: %s\n", this.getRenglones().size());
    for (int i = 0; i < this.getRenglones().size(); i++) {
      System.out.format("Item %s: ", i + 1);
      this.getRenglones().get(i).mostrar();
      System.out.format("Precio: $%s\n", this.getRenglones().get(i).getImporte());
      importeTotal += this.getRenglones().get(i).getImporte();
      cantidadTotal += this.getRenglones().get(i).getCantidad();
    }
    System.out.format("--- Total pedido: %s etiquetas por un importe total de: $%s\n", cantidadTotal, importeTotal);
  }
}
