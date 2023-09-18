import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestionComercio {
  public static void main(String[] args) {
    Comercio comercio = new Comercio("Super Chino");
    Calendar fechaIngreso = new GregorianCalendar(1998, 7, 18);
    Empleado juan = new Empleado(30100623, "Gonzalez", "Juan", 120000, fechaIngreso);
    Empleado mercedes = new Empleado(37045987, "Martinez", "Mercedes", 100000, fechaIngreso);
    Empleado virginia = new Empleado(32550096, "Gomez", "Virginia", 150000, fechaIngreso);
    comercio.altaEmpleado(juan);
    comercio.altaEmpleado(mercedes);
    comercio.altaEmpleado(virginia);
    comercio.nomina();
    Empleado alexis = new Empleado(44542230, "Olivarez", "Alexis", 150000, fechaIngreso);
    comercio.altaEmpleado(alexis);
    System.out.println("\n****-- Se da de baja a Mercedes porque abandona el comercio --****");
    comercio.bajaEmpleado(37045987);
    System.out.format("Cantidad de Empleados: %s\n\n", comercio.cantidadDeEmpleados());
    comercio.nomina();
  }
}
