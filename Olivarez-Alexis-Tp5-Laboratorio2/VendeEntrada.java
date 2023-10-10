import java.util.Calendar;

public class VendeEntrada {
  public static void main(String[] args) {
    Zoologico zoologico = new Zoologico("El Caribú");

    // * Un solo visitante en el zoologico
    Calendar fechaVisitaJuan = Calendar.getInstance();
    fechaVisitaJuan.set(2023, Calendar.SEPTEMBER, 10); // ? 10/09/2023
    Persona Juan = new Persona(43626535, "Juan", "Perez", 2004);
    zoologico.nuevoVisitante(new Individuo(Juan, fechaVisitaJuan));

    // * Una Delegacion con 2 integrantes.
    Calendar fechaDelegacion = Calendar.getInstance();
    fechaDelegacion.set(2023, Calendar.OCTOBER, 9); // ? 09/10/2023
    Persona Alexis = new Persona(44542230, "Alexis", "Olivarez", 2002);
    Persona Axel = new Persona(45436643, "Axel", "Vega", 2003);
    Delegacion PAMI = new Delegacion("PAMI", fechaDelegacion, new Individuo(Alexis, fechaDelegacion));
    PAMI.inscribirIndividuo(new Individuo(Axel, fechaDelegacion));
    zoologico.nuevoVisitante(PAMI); // * Inscribimos una Delegacion al Zoologico...

    System.out.println("Lista de todos los visitantes del zoologico:");
    // * Lista de Visitantes después de una fecha...
    Calendar listarVisitanteFecha = Calendar.getInstance();
    listarVisitanteFecha.set(2022, Calendar.JANUARY, 10);
    zoologico.listaVisitante(listarVisitanteFecha);

    // * Lista de Visitantes de algun tipo después de una fecha...
    System.out.println("Lista de Individuos:");
    zoologico.listaTipoVisitante(listarVisitanteFecha, "Individuo");
    System.out.println("Lista de Delegaciones:");
    zoologico.listaTipoVisitante(listarVisitanteFecha, "Delegacion");

    System.out.println("Recaudación desde 8/10/2023 hasta 12/10/2023");
    // * Fecha Desde para saber lo recaudado...
    Calendar fechaDesde = Calendar.getInstance();
    fechaDesde.set(2023, Calendar.OCTOBER, 8);
    // * Fecha Hasta para saber lo recaudado...
    Calendar fechaHasta = Calendar.getInstance();
    fechaHasta.set(2023, Calendar.OCTOBER, 12);
    double recaudacion = zoologico.recaudacion(fechaDesde, fechaHasta);
    System.out.println("Recaudación: $" + recaudacion);
  }
}
