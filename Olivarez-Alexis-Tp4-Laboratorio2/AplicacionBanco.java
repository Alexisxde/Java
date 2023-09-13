import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AplicacionBanco {
  public static void main(String[] args) {
    Calendar fecha = new GregorianCalendar(1998, 9, 1);
    Localidad localidad = new Localidad("Corrientes", "Corrientes");
    Empleado[] empleados = new Empleado[2];
    ArrayList<Empleado> arrayEmpleados = new ArrayList<>();
    Banco banco = new Banco("Santander Rio", localidad, 3, arrayEmpleados);
    empleados[0] = new Empleado(267504235, "Perez", "Lorena", 120000, fecha);
    empleados[1] = new Empleado(159462638, "Dominguez", "Pedro", 260000, fecha);

    for (Empleado empleado : empleados) {
      banco.agregarEmpleado(empleado);
    }
    banco.listarSueldos();
  }
}
