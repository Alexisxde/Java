public class GestionEvento {
  public static void main(String[] args) {
    Atleta pedroFuerza = new Scaled(123, "Pedro Juarez", 100.0, 12);
    Atleta victorFuerza = new Advanced(145, "Victor López", 200.0, 25);
    Atleta lucasFuerza = new Rx(157, "Lucas Vargas", 270, 20);

    Equipo fuerzaBruta = new Equipo("Fuerza Bruta", "Corrientes", pedroFuerza);
    fuerzaBruta.agregarAtleta(victorFuerza);
    fuerzaBruta.agregarAtleta(lucasFuerza);

    Campeonato torneo = new Campeonato("XV Torneo Nacional de Crossfit", fuerzaBruta);

    fuerzaBruta.mostrar();
    torneo.determinarGanador();
  }
}
