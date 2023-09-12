import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class TomaPedido {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    Calendar fecha = Calendar.getInstance();
    Cliente cliente = new Cliente(44542230, "Alexis", "Olivarez", 10000);
    Laboratorio laboratorio = new Laboratorio("Colgate S.A.", "9 de Julio 9348", "0800-1131-2343");
    Producto[] miPedido = new Producto[2];
    ArrayList<Producto> productos = new ArrayList<>();
    Pedido pedido = new Pedido(fecha, cliente, productos);

    for (int i = 0; i < miPedido.length; i++) {
      System.out.format("Ingrese los datos del producto %s para el pedido.\n", i + 1);
      System.out.print("Ingrese el nombre del producto: ");
      String description = teclado.nextLine();
      System.out.print("Ingrese el rubro del producto: ");
      String rubro = teclado.nextLine();
      System.out.print("Ingrese el precio unitario del producto: ");
      double precioUnitario = teclado.nextDouble();
      teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
      miPedido[i] = new Producto(i + 1, rubro, description, precioUnitario, laboratorio);
    }

    for (Producto producto : miPedido) {
      pedido.agregarProducto(producto);
    }

    pedido.mostrarPedido();
    pedido.quitarProducto(miPedido[1]);
    System.out.println("");
    pedido.mostrarPedido();
    teclado.close();
  }
}
