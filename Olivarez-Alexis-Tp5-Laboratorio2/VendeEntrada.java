import java.util.Calendar;

public class VendeEntrada {
  public static void main(String[] args) {
    Zoologico zoologico = new Zoologico("El Caribú");

    // Una Delegacion con 2 integrantes.
    Delegacion PAMI = new Delegacion("PAMI", Calendar.getInstance(),
        new Individuo(new Persona(44542230, "Alexis", "Olivarez", 2002), Calendar.getInstance()));
    PAMI.inscribirIndividuo(new Individuo(new Persona(45760300, "Flor", "Olivarez", 2003), Calendar.getInstance()));
    zoologico.nuevoVisitante(PAMI);

    // Un visitante solo
    zoologico.nuevoVisitante(new Individuo(new Persona(29981013, "Jose", "Olivarez", 1983), Calendar.getInstance()));

    // PAMI.mostrar();
    zoologico.listaVisitante(null);
    // zoologico.listaTipoVisitante(Calendar.getInstance(), "Delegacion ||
    // Individuo");
    double recaudacion = zoologico.recaudacion(Calendar.getInstance(), Calendar.getInstance());
    System.out.println("Recaudación del último mes: $" + recaudacion);
  }
}
