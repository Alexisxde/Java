public class Heladera extends ArtefactoHogar {
  private int pies;
  private int puertas;
  private boolean compresor;

  public Heladera(String p_marca, float p_precio, int p_stock, int p_pies, int p_puertas, boolean p_compresor) {
    super(p_marca, p_precio, p_stock);
    this.setPies(p_pies);
    this.setPuertas(p_puertas);
    this.setCompresor(p_compresor);
  }

  /**
   * Establece los pies de la heladera.
   *
   * @param p_pies Los pies de la heladera (int).
   */
  private void setPies(int p_pies) {
    this.pies = p_pies;
  }

  /**
   * Establece las puerta de la heladera.
   *
   * @param p_puertas Las puertas de la heladera (int).
   */
  private void setPuertas(int p_puertas) {
    this.puertas = p_puertas;
  }

  /**
   * Establece si tiene compresor o no la heladera.
   *
   * @param p_compresor Tiene compresor si o no (boolean).
   */
  private void setCompresor(boolean p_compresor) {
    this.compresor = p_compresor;
  }

  /**
   * Obtiene los pies de la heladera.
   *
   * @return Los pies de la heladera (int).
   */
  public int getPies() {
    return this.pies;
  }

  /**
   * Obtiene las puertas de la heladera.
   *
   * @return Las puertas de la heladera (int).
   */
  public int getPuertas() {
    return this.puertas;
  }

  /**
   * Obtiene si tiene compresor o no la heladera.
   *
   * @return Si tiene compresor o no la heladera (boolean).
   */
  public boolean isCompresor() {
    return this.compresor;
  }

  /**
   * Imprime por pantalla el nombre, la marca, el precio y el stock de un
   * electrodoméstico y sus caracteristicas (pies, puertas y si tiene compresor).
   */
  @Override
  public void imprimir() {
    System.out.println("**** Heladera ****");
    super.imprimir();
    System.out.format("Pies: %s\n", this.getPies());
    System.out.format("Puertas: %s\n", this.getPuertas());
    System.out.format("Compresor: %s\n", this.isCompresor() ? "Si" : "No");
  }

  /**
   * Calcula la cuota mensual de un crédito para un electrodoméstico.
   *
   * @param p_cuotas  El número de cuotas en las que se dividirá el crédito (int).
   * @param p_interes El interés aplicado al crédito (float).
   * @return Devuelve la cuota mensual a pagar del crédito (float).
   */
  @Override
  public float creditoConAdicional(int p_cuotas, float p_interes) {
    float valorCuota = super.cuotaCredito(p_cuotas, p_interes);
    if (this.isCompresor()) {
      valorCuota += 50;
    }
    return valorCuota;
  }

}