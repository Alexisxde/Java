import java.util.ArrayList;

public class Gerencia {
  private String nombre;
  private ArrayList<Alojamiento> alojamientoAlquilados;

  public Gerencia(String p_nombre) {
    this.setNombre(p_nombre);
    this.setAlojamientoAlquilados(new ArrayList<Alojamiento>());
  }

  public Gerencia(String p_nombre, ArrayList<Alojamiento> p_alojamientoAlquilados) {
    this.setNombre(p_nombre);
    this.setAlojamientoAlquilados(p_alojamientoAlquilados);
  }

  private void setNombre(String p_nombre) {
    this.nombre = p_nombre;
  }

  private void setAlojamientoAlquilados(ArrayList<Alojamiento> p_alojamientoAlquilados) {
    this.alojamientoAlquilados = p_alojamientoAlquilados;
  }

  public String getNombre() {
    return this.nombre;
  }

  public ArrayList<Alojamiento> getAlojamientoAlquilados() {
    return this.alojamientoAlquilados;
  }

  public boolean agregarAlojamiento(Alojamiento p_alojamiento) {
    return this.getAlojamientoAlquilados().add(p_alojamiento);
  }

  public boolean quitarAlojamiento(Alojamiento p_alojamiento) {
    return this.getAlojamientoAlquilados().remove(p_alojamiento);
  }

  public int contarAlojamientos(String p_tipoAlojamiento) {
    int contador = 0;
    for (Alojamiento alojamiento : this.getAlojamientoAlquilados()) {
      contador += alojamiento.contar(p_tipoAlojamiento);
    }
    return contador;
  }

  public void liquidar() {
    for (Alojamiento alojamiento : this.getAlojamientoAlquilados()) {
      alojamiento.liquidar();
      System.out.println();
    }
  }

  public void mostrarLiquidacion() {
    System.out.format("Gerencia %s\nLiquidación-------------------\n\n", this.getNombre());
    this.liquidar();
  }
}
