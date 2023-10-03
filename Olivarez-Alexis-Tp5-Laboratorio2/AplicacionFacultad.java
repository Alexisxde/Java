public class AplicacionFacultad {
  public static void main(String[] args) {
    Cargo cargo1 = new Exclusivo("Taller de Programación II", 800.0, 2013, 10, 15, 10);
    Cargo cargo2 = new Cargo("Salud Publica", 1400.0, 2011, 20);
    Cargo cargo3 = new SemiExclusivo("Programación Orientada a Objetos", 800.0, 2003, 10, 5);

    Profesor alexis = new Profesor("Analista Programador", 44542230, "Alexis", "Olivarez", 2002, cargo1);
    Profesor leo = new Profesor("Licenciatura en Enfermeria", 44684162, "Leo", "De León", 2003, cargo2);
    Profesor ariel = new Profesor("Licenciatura en Sistemas de Información", 44123456, "Ariel", "Gonxalez", 2001,
        cargo3);
    Facultad UNNE = new Facultad("FaCENA", alexis);
    alexis.agregarCargo(cargo3);
    UNNE.agregarProfesor(leo);
    UNNE.agregarProfesor(ariel);
    UNNE.listarProfesorCargos();
  }
}