import java.util.HashMap;

public class Curso {
  private String nombre;
  private HashMap<Integer, Alumno> alumnos;

  public Curso(String p_nombre) {
    this.setNombre(p_nombre);
    this.setAlumnos(new HashMap<Integer, Alumno>());
  }

  public Curso(String p_nombre, HashMap<Integer, Alumno> p_alumnos) {
    this.setNombre(p_nombre);
    this.setAlumnos(p_alumnos);
  }

  private void setNombre(String p_nombre) {
    this.nombre = p_nombre;
  }

  private void setAlumnos(HashMap<Integer, Alumno> p_alumnos) {
    this.alumnos = p_alumnos;
  }

  public String getNombre() {
    return this.nombre;
  }

  public HashMap<Integer, Alumno> getAlumnos() {
    return this.alumnos;
  }

  public void agregarAlumno(Alumno p_alumno) {
    this.getAlumnos().put(p_alumno.getLu(), p_alumno);
  }

  public Alumno quitarAlumno(int p_lu) {
    Alumno alumno = this.buscarAlumno(p_lu);
    this.getAlumnos().remove(p_lu);
    return alumno;
  }

  public int cantidadDeAlumnos() {
    return this.getAlumnos().size();
  }

  public boolean estaInscripto(int p_lu) {
    return this.getAlumnos().containsKey(p_lu);
  }

  public boolean estaInscripto(Alumno p_alumno) {
    return this.getAlumnos().containsValue(p_alumno);
  }

  public Alumno buscarAlumno(int p_lu) {
    return this.getAlumnos().get(p_lu);
  }

  public void imprimirPromedioDelAlumno(int p_lu) {
    Alumno alumno = buscarAlumno(p_lu);
    if (alumno != null) {
      System.out.format("Promedio: %s\n", alumno.promedio());
    } else {
      System.out.format("****-- Alumno %s no encontrado --****\n", p_lu);
    }
  }

  public void mostrarInscriptos() {
    if (this.getAlumnos() != null) {
      for (Alumno alumno : this.getAlumnos().values()) {
        System.out.format("%s %s\n", alumno.getLu(), alumno.nomYApe());
      }
    } else {
      System.out.println("No hay alumnos inscriptos a este curso!");
    }
  }
}