import java.text.DecimalFormat;

public class Elipse {
  private double sEjeMayor;
  private double sEjeMenor;
  private Punto centro;

  public Elipse(double p_sEjeMayor, double p_sEjeMenor, Punto p_centro) {
    this.setsEjeMayor(p_sEjeMayor);
    this.setsEjeMenor(p_sEjeMenor);
    this.setCentro(p_centro);
  }

  private void setsEjeMayor(double p_sEjeMayor) {
    this.sEjeMayor = p_sEjeMayor;
  }

  private void setsEjeMenor(double p_sEjeMenor) {
    this.sEjeMenor = p_sEjeMenor;
  }

  /**
   * El método establece del atributo "centro" proporcionado del
   * valor "p_centro".
   *
   * @param p_centro Es un valor Objeto Punto que representa el nuevo valor del
   *                 atributo "centro".
   */
  private void setCentro(Punto p_centro) {
    this.centro = p_centro;
  }

  /**
   * Obtiene el valor del eje mayor de la elipse.
   *
   * @return El valor del eje mayor de la elipse (double).
   */
  public double getsEjeMayor() {
    return this.sEjeMayor;
  }

  /**
   * Obtiene el valor del eje menor de la elipse.
   *
   * @return El valor del eje menor de la elipse (double).
   */
  public double getsEjeMenor() {
    return this.sEjeMenor;
  }

  /**
   * Obtiene el centro del círculo.
   *
   * @return El centro del círculo (Punto).
   */
  public Punto getCentro() {
    return this.centro;
  }

  /**
   * @return Un String del nombre de la figura "Elipse" (String).
   */
  public String nombreFigura() {
    return "****** Elipse ******";
  }

  /**
   * Muestra las características del rectangulo, incluyendo su centro, semieje
   * mayor, semieje menor y superficie.
   */
  public void caracteristicas() {
    DecimalFormat df = new DecimalFormat("#.##");
    System.out.format("%s\n", this.nombreFigura());
    System.out.format("Centro: %s - Semieje Mayor: %s - Semieje Menor: %s\n", this.getCentro().coordenadas(),
        df.format(this.getsEjeMayor()),
        df.format(this.getsEjeMenor()));
    System.out.format("Superficie: %s", df.format(this.superficie()));
  }

  /**
   * Calcula la superficie del círculo.
   * Superficie = PI * EjeMayor * EjerMenor
   *
   * @return La superficie de una Elipse (double).
   */
  public double superficie() {
    return Math.PI * this.getsEjeMayor() * this.getsEjeMenor();
  }

  /**
   * El método desplaza la Elipse en los valores pasados como parámetros.
   *
   * @param p_x La cantidad en la que el objeto debe moverse horizontalmente.
   * @param p_y La cantidad en la que el objeto debe moverse verticalmente.
   */
  public void desplazar(double p_dx, double p_dy) {
    this.getCentro().desplazar(p_dx, p_dy);
  }

  /**
   * Calcula la distancia entre el centro de este elipse y el centro de otro
   * elipse dado.
   * Distancia = √(x1 - x2)² + (y1 - y2)²
   *
   * @param p_otroCirculo El otro elipse con el que se calculará la distancia.
   * @return La distancia entre los centros de los elipses (double).
   */
  public double distanciaA(Elipse p_otraElipse) {
    double dx = this.getCentro().getX() - p_otraElipse.getCentro().getX();
    double dy = this.getCentro().getY() - p_otraElipse.getCentro().getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

  /**
   * Determina cuál de las dos elipses tiene una superficie mayor.
   *
   * @param p_otraElipse La otra Elipse con el que se comparará la superficie.
   * @return La elipse con la mayor superficie (Elipse).
   */
  public Elipse elMayor(Elipse p_otraElipse) {
    return this.superficie() > p_otraElipse.superficie() ? this : p_otraElipse;
  }
}
