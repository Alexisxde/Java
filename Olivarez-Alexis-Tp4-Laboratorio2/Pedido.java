import java.util.ArrayList;
import java.util.Calendar;

public class Pedido {
  private Calendar fecha;
  private Cliente cliente;
  private ArrayList<Producto> productos;

  /**
   * 
   * Constructor para los pedidos de ArrayList.
   * 
   * @param pFecha     Define la fecha de cuando se insertó los productos de tipo
   *                   Calendar (Objeto).
   * @param pCliente   Define al cliente de tipo Cliente (Objeto).
   * @param pProductos Define una lista de productos de tipo ArrayList<Producto>.
   */
  public Pedido(Calendar pFecha, Cliente pCliente, ArrayList<Producto> pProductos) {
    this.setFecha(pFecha);
    this.setCliente(pCliente);
    this.setProductos(pProductos);
  }

  /**
   * 
   * Constructor para los pedidos de ArrayList.
   * 
   * @param pFecha    Define la fecha de cuando se insertó los productos de tipo
   *                  Calendar (Objeto).
   * @param pCliente  Define al cliente de tipo Cliente (Objeto).
   * @param pProducto Define un producto de tipo Producto (Objeto).
   */
  public Pedido(Calendar pFecha, Cliente pCliente, Producto pProducto) {
    this.setFecha(pFecha);
    this.setCliente(pCliente);
    this.setProductos(new ArrayList<Producto>());
    this.agregarProducto(pProducto);
  }

  /**
   * El método establece el valor del atriburo "fecha" de tipo Calendar
   * proporcionado del valor
   * "pFecha" de tipo Calendar.
   * 
   * @param pFecha Representa el nuevo valor del atributo "fecha" de tipo Calendar
   *               (Objeto).
   * @return No devuelve ningún valor.
   */
  private void setFecha(Calendar pFecha) {
    this.fecha = pFecha;
  }

  /**
   * El método establece el valor del atriburo "cliente" de tipo Cliente
   * proporcionado del valor
   * "pCliente" de tipo Cliente.
   * 
   * @param pCliente Representa el nuevo valor del atributo "cliente" de tipo
   *                 Cliente (Objeto).
   * @return No devuelve ningún valor.
   */
  private void setCliente(Cliente pCliente) {
    this.cliente = pCliente;
  }

  /**
   * El método establece el valor del atriburo "productos" de tipo
   * ArrayList<Producto> proporcionado del valor "pProducto" de tipo
   * ArrayList<Producto>.
   * 
   * @param pProducto Representa el nuevo valor del atributo "productos" de tipo
   *                  ArrayList<Producto>.
   * @return No devuelve ningún valor.
   */
  public void setProductos(ArrayList<Producto> pProductos) {
    this.productos = pProductos;
  }

  /**
   * Devuelve el valor del atributo "fecha".
   * 
   * @return Devuelve un Objeto de tipo Calendar.
   */
  public Calendar getFecha() {
    return this.fecha;
  }

  /**
   * Devuelve el valor del atributo "cliente".
   * 
   * @return Devuelve un Objeto de tipo Cliente.
   */
  public Cliente getCliente() {
    return this.cliente;
  }

  /**
   * Devuelve el valor del atributo "productos".
   * 
   * @return Devuelve un Array de tipo ArrayList<Productos>.
   */
  public ArrayList<Producto> getProductos() {
    return this.productos;
  }

  /**
   * El método acumula los precios al contado del los productos y devuelve el
   * total de la suma de todo los precios de contado de cada producto.
   * 
   * @return Devuelve un valor de tipo double.
   */
  public double totalAlContado() {
    double total = 0;
    for (Producto producto : this.getProductos()) {
      total += producto.precioContado();
    }
    return total;
  }

  /**
   * El método acumula los precios de lista del los productos y devuelve el
   * total de la suma de todo los precios de lista de cada producto.
   * 
   * @return Devuelve un valor de tipo double.
   */
  public double totalFinanciado() {
    double total = 0;
    for (Producto producto : this.getProductos()) {
      total += producto.precioLista();
    }
    return total;
  }

  /**
   * El método agrega productos al array de productos y si lo agrega devuelve
   * true.
   * 
   * @return Devuelve un valor booleano (true o false).
   */
  public boolean agregarProducto(Producto pProducto) {
    return productos.add(pProducto);
  }

  /**
   * El método quita productos al array de productos y si lo agrega devuelve
   * true.
   * 
   * @return Devuelve un valor booleano (true o false).
   */
  public boolean quitarProducto(Producto pProducto) {
    return productos.remove(pProducto);
  }

  /**
   * El método muestra un informe de los productos con su fecha de cuando fue el
   * pedido(dia, mes, año), nombre, precio lista, precio contado, el total
   * financiado y el total al contado.
   */
  public void mostrarPedido() {
    String[] meses = {
        "Enero", "Febrero", "Marzo", "Abril",
        "Mayo", "Junio", "Julio", "Agosto",
        "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    String dia = String.format("%s", this.getFecha().get(Calendar.DAY_OF_MONTH));
    String mes = String.format("%s", meses[this.getFecha().get(Calendar.MONTH)]);
    String anio = String.format("%s", this.getFecha().get(Calendar.YEAR));

    System.out.format("****** Detalle del pedido ****** Fecha: %s de %s de %s.\n", dia, mes, anio);
    System.out.println("Producto\tPrecio Lista\tPrecio Contado");
    System.out.println("-------------------------------------------------");
    for (Producto producto : this.getProductos()) {
      System.out.format("%s\t$%s\t$%s\n", producto.getDescripcion(), producto.precioLista(), producto.precioContado());
    }
    System.out.println("-------------------------------------------------");
    System.out.format("*** Total ------ $%s\t$%s ***\n", this.totalFinanciado(), this.totalAlContado());
  }
}
