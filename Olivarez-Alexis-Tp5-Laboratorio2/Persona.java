import java.util.Calendar;
import java.util.GregorianCalendar;

public class Persona {
  private int nroDni;
  private String nombre;
  private String apellido;
  private Calendar fechaNacimiento;

  /**
   * Constructor de la clase Persona.
   * 
   * @param p_dni            El DNI de la persona.
   * @param p_nombre         El nombre de la persona.
   * @param p_apellido       El apellido de la persona.
   * @param p_anioNacimiento El año de nacimiento de la persona.
   */
  public Persona(int p_dni, String p_nombre, String p_apellido, int p_anioNacimiento) {
    this.setDni(p_dni);
    this.setNombre(p_nombre);
    this.setApellido(p_apellido);
    this.setFechaNacimiento(new GregorianCalendar(p_anioNacimiento, 0, 1));
  }

  /**
   * Constructor de la clase Persona.
   * 
   * @param p_dni             El DNI de la persona.
   * @param p_nombre          El nombre de la persona.
   * @param p_apellido        El apellido de la persona.
   * @param p_fechaNacimiento La fecha de nacimiento de la persona.
   */
  public Persona(int p_dni, String p_nombre, String p_apellido, Calendar p_fechaNacimiento) {
    this.setDni(p_dni);
    this.setNombre(p_nombre);
    this.setApellido(p_apellido);
    this.setFechaNacimiento(p_fechaNacimiento);
  }

  /**
   * El método establece el valor de la variable "nroDni" proporcionado del valor
   * "p_dni".
   * 
   * @param p_dni Es un valor entero que representa el DNI
   *              (Documento Nacional de Número de identidad).
   */
  private void setDni(int p_dni) {
    this.nroDni = p_dni;
  }

  /**
   * El método establece el valor de la variable "nombre" proporcionado del valor
   * "p_nombre".
   *
   * @param p_nombre Es un String que representa el nuevo valor para la variable
   *                 "nombre".
   *                 Debe ser un String no nulo y no vacío.
   */
  private void setNombre(String p_nombre) {
    this.nombre = p_nombre;
  }

  /**
   * El método establece el valor de la variable "apellido" proporcionado del
   * valor "p_apellido".
   *
   * @param p_apellido Es un String que representa el nuevo valor para la variable
   *                   "apellido".
   *                   Debe ser un String no nulo y no vacío.
   */
  private void setApellido(String p_apellido) {
    this.apellido = p_apellido;
  }

  /**
   * El método establece el valor de la variable "fechaNacimiento" proporcionado
   * del valor "p_fechaNacimiento".
   *
   * @param p_fechaNacimiento Es un tipo Calendar que
   *                          representa la fecha de nacimiento.
   */
  private void setFechaNacimiento(Calendar p_fechaNacimiento) {
    this.fechaNacimiento = p_fechaNacimiento;
  }

  /**
   * @return Devuelve el valor de la variable de instancia "nroDni".
   */
  public int getDni() {
    return this.nroDni;
  }

  /**
   * @return Devuelve el valor de la variable de instancia "nombre".
   */
  public String getNombre() {
    return this.nombre;
  }

  /**
   * @return Devuelve el valor de la variable de instancia "apellido".
   */
  public String getApellido() {
    return this.apellido;
  }

  /**
   * @return Devuelve el valor de la variable de instancia "fechaNacimiento" que
   *         es de tipo Calendar.
   */
  public Calendar getFechaNacimiento() {
    return this.fechaNacimiento;
  }

  /**
   * @return Devuelve el valor de la variable de instancia "anioNacimiento" que
   *         es de tipo int. (no esta más este atributo)
   */
  public int getAnioNacimiento() {
    return this.getFechaNacimiento().get(Calendar.YEAR);
  }

  /**
   * El método "edad" Calcula la diferencia entre año actual y año de nacimiento
   * de una persona.
   *
   * @return Devuelve la edad actual de la persona.
   */
  public int edad() {
    Calendar fechaHoy = Calendar.getInstance();
    int anioHoy = fechaHoy.get(Calendar.YEAR);
    return anioHoy - this.getFechaNacimiento().get(Calendar.YEAR);
  }

  /**
   * El método "nomYApe" Concatena el "nombre" y el "apellido".
   *
   * @return Devuelve una cadena de caracteres de las variables
   *         "nombre" y "apellido" con un espacio entremedio.
   */
  public String nomYApe() {
    return String.format("%s %s", this.getNombre(), this.getApellido());
  }

  /**
   * El método "apeYNom" Concatena el "apellido" y el "nombre".
   *
   * @return Devuelve una cadena de caracteres de las variables
   *         "apellido" y "nombre" con un espacio entremedio.
   */
  public String apeYNom() {
    return String.format("%s %s", this.getApellido(), this.getNombre());
  }

  /**
   * El método "mostrar" Muestra información de la persona, nombre y apellido,
   * DNI y la edad.
   */
  public void mostrar() {
    System.out.format("Nombre y Apellido: %s\n", this.nomYApe());
    System.out.format("DNI: %s\tEdad: %s años\n", this.getDni(), this.edad());
  }

  /**
   * El método "esCumpleanios" comprueba si la fecha actual es la misma que la
   * fecha de nacimiento.
   *
   * @return El método devuelve un valor booleano.
   */
  public boolean esCumpleanios() {
    Calendar fechaActual = Calendar.getInstance();
    return this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH) == fechaActual.get(Calendar.DAY_OF_MONTH)
        && this.getFechaNacimiento().get(Calendar.MONTH) == fechaActual.get(Calendar.MONTH);
  }
}