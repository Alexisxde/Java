public class Administración {
  public static void main(String[] args) {
    Jardin jardin = new Jardin("Bichito de Luz");
    Cuadrado cuadrado = new Cuadrado(new Punto(), 5);
    Triangulo triangulo = new Triangulo(new Punto(), 4, 0.64);
    Circulo circulo = new Circulo(2, new Punto());
    Elipse elipse = new Elipse(5, 3, new Punto());
    jardin.agregarFigura(cuadrado);
    jardin.agregarFigura(triangulo);
    jardin.agregarFigura(circulo);
    jardin.agregarFigura(elipse);
    jardin.detalleFiguras();
  }
}
