import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class TomaPedido {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    Calendar fecha = Calendar.getInstance();
    Cliente cliente = new Cliente(44542230, "Alexis", "Olivarez", 10000);
    Laboratorio laboratorio = new Laboratorio("Colgate S.A.", "9 de Julio 9348", "0800-1131-2343");

    ArrayList<Producto> productos = new ArrayList<>();
    Pedido pedido = new Pedido(fecha, cliente, productos);

    int opcion = 0;
    while (opcion != 4) {
      System.out.println("****** Menú de Pedido ******");
      System.out.println("1. Agregar Producto");
      System.out.println("2. Mostrar Pedido");
      System.out.println("3. Quitar producto");
      System.out.println("4. Salir");
      System.out.print("Seleccione una opción: ");

      opcion = teclado.nextInt();
      teclado.nextLine();
      switch (opcion) {
        case 1:
          System.out.println("Ingrese la cantidad de productos que desea agregar: ");
          int nProductos = teclado.nextInt();
          teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
          for (int i = 0; i < nProductos; i++) {
            System.out.format("Ingrese los datos del producto %s para el pedido.\n", i + 1);
            System.out.print("Ingrese el codigo del producto: ");
            int codigo = teclado.nextInt();
            teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
            System.out.print("Ingrese el nombre del producto: ");
            String description = teclado.nextLine();
            System.out.print("Ingrese el rubro del producto: ");
            String rubro = teclado.nextLine();
            System.out.print("Ingrese el precio unitario del producto: ");
            double precioUnitario = teclado.nextDouble();
            teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
            pedido.agregarProducto(new Producto(codigo, rubro, description, precioUnitario, laboratorio));
          }
          break;
        case 2:
          pedido.mostrarPedido();
          break;
        case 3:
          System.out.format("Ingrese el codigo del producto a eliminar: ");
          int codigo = teclado.nextInt();
          teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
          boolean encontrado = false;
          for (Producto producto : pedido.getProductos()) {
            if (producto.getCodigo() == codigo) {
              System.out.format("Producto eliminado %s\n", producto.getDescripcion());
              encontrado = pedido.quitarProducto(producto);
              break;
            }
          }
          if (!encontrado) {
            System.out.println("Producto no encontrado...");
          }
          break;
        case 4:
          System.out.println("Saliendo del programa.");
          break;
        default:
          System.out.println("Opción inválida.");
      }
    }
    teclado.close();
  }
}
