public class MainPedido {
  public static void main(String[] args) {

    Congelado paletaAgua = new Paleta("Agua", 0);
    Congelado paletaCrema = new Paleta("Crema", 1);
    Congelado postreEnCaja = new Postre("Postre", true);
    Congelado postreSuelto = new Postre("Postre", false);

    RenglonPedido renglon1 = new RenglonPedido(85, postreEnCaja);
    Pedido pedido = new Pedido(renglon1);
    RenglonPedido renglon2 = new RenglonPedido(65, postreSuelto);
    RenglonPedido renglon3 = new RenglonPedido(68, paletaCrema);
    RenglonPedido renglon4 = new RenglonPedido(25, paletaAgua);

    pedido.agregarRenglon(renglon1);
    pedido.agregarRenglon(renglon2);
    pedido.agregarRenglon(renglon3);
    pedido.agregarRenglon(renglon4);

    pedido.mostrar();
  }
}
