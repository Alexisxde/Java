import java.util.HashMap;

public class Comercio {
  private String nombre;
  private HashMap<Long, Empleado> empleados;

  public Comercio(String p_nombre) {
    this.setNombre(p_nombre);
    this.setEmpleados(new HashMap<Long, Empleado>());
  }

  public Comercio(String p_nombre, HashMap<Long, Empleado> p_empleados) {
    this.setNombre(p_nombre);
    this.setEmpleados(p_empleados);
  }

  private void setNombre(String p_nombre) {
    this.nombre = p_nombre;
  }

  private void setEmpleados(HashMap<Long, Empleado> p_empleados) {
    this.empleados = p_empleados;
  }

  public String getNombre() {
    return this.nombre;
  }

  public HashMap<Long, Empleado> getEmpleados() {
    return this.empleados;
  }

  public void altaEmpleado(Empleado p_empleado) {
    this.getEmpleados().put(p_empleado.getCuil(), p_empleado);
  }

  public Empleado bajaEmpleado(long p_cuil) {
    Empleado bajaEmpleado = this.buscarEmpleado(p_cuil);
    this.getEmpleados().remove(p_cuil);
    return bajaEmpleado;
  }

  public int cantidadDeEmpleados() {
    return this.getEmpleados().size();
  }

  public boolean esEmpleado(long p_cuil) {
    return this.getEmpleados().containsKey(p_cuil);
  }

  public Empleado buscarEmpleado(long p_cuil) {
    return this.getEmpleados().get(p_cuil);
  }

  public void sueldoNeto(long p_cuil) {
    Empleado empleado = this.buscarEmpleado(p_cuil);
    if (empleado != null) {
      System.out.format("El sueldo neto de %s es de %s", empleado.nomYApe(), empleado.sueldoNeto());
    } else {
      System.out.println("El empleado no existe");
    }
  }

  public void nomina() {
    if (this.getEmpleados() != null) {
      System.out.println("**** Nomina de empleados de Avanti SRL ****");
      for (Empleado empleado : this.getEmpleados().values()) {
        System.out.println(empleado.mostrarLinea());
      }
    } else {
      System.out.println("No hay empleados!");
    }
  }
}