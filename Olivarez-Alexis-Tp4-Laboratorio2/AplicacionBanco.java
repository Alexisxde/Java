import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Iterator;

public class AplicacionBanco {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    Calendar fecha = new GregorianCalendar(1998, 9, 1);
    Localidad localidad = new Localidad("Corrientes", "Corrientes");
    ArrayList<Empleado> arrayEmpleados = new ArrayList<>();
    ArrayList<CuentaBancaria> arrayCuentasBasica = new ArrayList<>();
    Banco banco = new Banco("Santander Rio", localidad, 3, arrayEmpleados, arrayCuentasBasica);

    int opcion = 0;
    while (opcion != 7) {
      System.out.println("****** Menú ******");
      System.out.println("1. Agregar empleado");
      System.out.println("2. Mostrar lista de sueldos");
      System.out.println("3. Despedir un empleado");
      System.out.println("4. Agregar cuenta bancaria");
      System.out.println("5. Mostrar resumen");
      System.out.println("6. Quitar una cuenta bancaria");
      System.out.println("7. Salir");
      System.out.print("Seleccione una opción: ");

      opcion = teclado.nextInt();
      teclado.nextLine();
      switch (opcion) {
        case 1:
          System.out.println("Ingrese la cantidad de empleados que desea agregar: ");
          int nEmpleados = teclado.nextInt();
          teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
          for (int i = 0; i < nEmpleados; i++) {
            System.out.format("Ingrese los datos del empleado %s\n", i + 1);
            System.out.print("Ingrese el cuil del empleado: ");
            int cuil = teclado.nextInt();
            teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
            System.out.print("Ingrese el apellido del empleado: ");
            String apellido = teclado.nextLine();
            System.out.print("Ingrese el nombre del empleado: ");
            String nombre = teclado.nextLine();
            System.out.print("Ingrese el sueldo basico del empleado: $");
            double sueldoBasico = teclado.nextDouble();
            teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
            banco.agregarEmpleado(new Empleado(cuil, apellido, nombre, sueldoBasico, fecha));
          }
          break;
        case 2:
          banco.listarSueldos();
          break;
        case 3:
          System.out.format("Ingrese el cuil del empleado a despedir: ");
          long cuil = teclado.nextLong();
          teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
          boolean encontrado = false;
          // Iterator<Empleado> iterator = banco.getEmpleados().iterator();
          // while (iterator.hasNext()) {
          // Empleado empleado = iterator.next();
          // if (empleado.getCuil() == cuil) {
          // System.out.format("Empleado eliminado %s\n", empleado.apeYNom());
          // iterator.remove();
          // encontrado = true;
          // }
          // }
          for (Empleado empleado : banco.getEmpleados()) {
            if (empleado.getCuil() == cuil) {
              System.out.format("Empleado eliminado %s\n", empleado.apeYNom());
              encontrado = banco.quitarEmpleado(empleado);
              break; // Sale del bucle una vez que se encuentra y elimina el empleado
            }
          }
          if (!encontrado) {
            System.out.println("Empleado no encontrado...");
          }
          break;
        case 4:
          System.out.format("Ingrese los datos de la cuenta\n");
          System.out.print("Ingrese su dni: ");
          int dni = teclado.nextInt();
          teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
          System.out.println("Ingrese su fecha de nacimiento: ");
          System.out.print("Ingrese su dia de nacimiento: ");
          int dia = teclado.nextInt();
          teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
          System.out.print("Ingrese su mes de nacimiento (número): ");
          int mes = teclado.nextInt();
          teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
          System.out.print("Ingrese su año de nacimiento: ");
          int anio = teclado.nextInt();
          teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
          Calendar fecha2 = new GregorianCalendar(anio, mes - 1, dia);
          System.out.print("Ingrese su apellido: ");
          String apellido2 = teclado.nextLine();
          System.out.print("Ingrese su nombre: ");
          String nombre2 = teclado.nextLine();
          Persona titular = new Persona(dni, nombre2, apellido2, fecha2);
          Random n = new Random();
          int numCuenta = n.nextInt(1000000000);
          System.out.println(numCuenta);
          banco.agregarCuentaBancaria(new CuentaBancaria(numCuenta, titular, 500));
          break;
        case 5:
          banco.mostrar();
          break;
        case 6:
          System.out.format("Ingrese el N° Cuenta a quitar: ");
          int nCuenta = teclado.nextInt();
          teclado.nextLine(); // Limpia el buffer cuando se haga algo con números.
          boolean encontrado2 = false;
          for (CuentaBancaria cuenta : banco.getCuentaBancaria()) {
            if (cuenta.getNroCuenta() == nCuenta) {
              System.out.format("Cuenta %s eliminada\n", cuenta.getNroCuenta());
              encontrado2 = banco.quitarCuentaBancaria(cuenta);
              break; // Sale del bucle una vez que se encuentra y elimina la cuenta
            }
          }
          if (!encontrado2) {
            System.out.println("Cuenta no encontrada...");
          }
          break;
        case 7:
          System.out.println("Saliendo del programa.");
          break;
        default:
          System.out.println("Opción inválida.");
      }
    }
    teclado.close();
  }
}