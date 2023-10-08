public class AdministraciónGerencia {
  public static void main(String[] args) {
    Gerencia gerencia = new Gerencia("Los Arroyos");

    // Crea una cabaña
    Cabaña cabaña = new Cabaña("Cabañas La Alondra", 120.0, 5, 3);
    cabaña.agregarServicio(new Servicio("Alquiler de auto", 100));
    cabaña.agregarServicio(new Servicio("Lavanderia", 20));
    gerencia.agregarAlojamiento(cabaña);

    // Crea un hotel
    Hotel hotel = new Hotel("Hotel Guaraní", 55, 7, "Single");
    hotel.agregarServicio(new Servicio("Internet", 5));
    hotel.agregarServicio(new Servicio("Alquiler de auto", 100));
    gerencia.agregarAlojamiento(hotel);

    // Crea una cabaña
    Cabaña cabaña2 = new Cabaña("Cabañas La Alondra 2", 120.0, 5, 3);
    cabaña2.agregarServicio(new Servicio("Alquiler de auto", 100));
    cabaña2.agregarServicio(new Servicio("Lavanderia", 20));
    gerencia.agregarAlojamiento(cabaña2);

    // Realizar la liquidación de la estadía
    gerencia.mostrarLiquidacion();

    // Contar alojamientos
    System.out.println("Alojamiento tipo Cabaña: " + gerencia.contarAlojamientos("Cabaña"));
    System.out.println("Alojamiento tipo Hotel: " + gerencia.contarAlojamientos("Hotel"));
  }
}
