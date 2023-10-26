public class MainCancha {
  public static void main(String[] args) {
    Tarifa tarifaMatutino = new Tarifa("matutino", 80);
    Tarifa tarifaVespertino = new Tarifa("vespertino", 80);
    Tarifa tarifaNocturno = new Tarifa("nocturno", 80);

    Cancha cancha1 = new Cancha(1, tarifaMatutino);
    Cancha cancha2 = new Cancha(2, tarifaVespertino);
    Cancha cancha3 = new Cancha(3, tarifaNocturno);

    Equipo systemUnited = new Equipo(true, cancha1);
    Equipo aplanadora = new Equipo(false, cancha2);
    Equipo dataSystem = new Equipo(true, cancha3);

    systemUnited.mostrar();
    aplanadora.mostrar();
    dataSystem.mostrar();
  }
}
