import java.util.HashMap;
import java.util.Map;

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
    Empleado bajaEmpleado = (Empleado) this.buscarEmpleado(p_cuil);
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
    return (Empleado) this.getEmpleados().get(p_cuil);
  }

  public void sueldoNeto(long p_cuil) {
    Empleado empleado = (Empleado) this.buscarEmpleado(p_cuil);
    // if (empleado != null) {
    // System.out.format("El sueldo neto de %s es de %s", empleado.nomYApe(),
    // empleado.sueldoNeto());
    // } else {
    // System.out.format("No se encontró ningún empleado con el cuil %s\n", p_cuil);
    // }
    if (empleado == null) {
      System.out.format("No se encontró ningún empleado con el cuil %s\n", p_cuil);
      return;
    }
    System.out.format("El sueldo neto de %s es de %s", empleado.nomYApe(), empleado.sueldoNeto());
  }

  public void nomina() {
    // if (this.getEmpleados().isEmpty()) {
    // System.out.println("**** Nomina de empleados de Avanti SRL ****");
    // for (Object objeto : this.getEmpleados().values()) {
    // Empleado empleado = (Empleado) objeto;
    // System.out.println(empleado.mostrarLinea());
    // }
    // } else {
    // System.out.println("No hay empleados!");
    // }
    if (this.getEmpleados().isEmpty()) {
      System.out.println("No hay empleados!\n");
      return;
    }
    System.out.println("**** Nomina de empleados de Avanti SRL ****");
    // for (Object objeto : this.getEmpleados().values()) {
    // Empleado empleado = (Empleado) objeto;
    // System.out.println(empleado.mostrarLinea());
    // }
    for (Object entryObj : this.getEmpleados().entrySet()) {
      Map.Entry entry = (Map.Entry) entryObj;
      Empleado empleado = (Empleado) entry.getValue();
      System.out.println(empleado.mostrarLinea());
    }
  }
}
