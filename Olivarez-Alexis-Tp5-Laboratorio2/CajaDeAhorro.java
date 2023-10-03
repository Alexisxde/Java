public class CajaDeAhorro extends CuentaBancaria {
  private int extraccionesPosibles;

  /**
   * Constructor de la clase CuentaDeAhorro.
   * 
   * @param p_nroCuenta El número de cuenta de la persona titular de la
   *                    cuenta de ahorro.
   * @param p_titular   Persona titular de la cuenta de ahorro.
   */
  public CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
    super(p_nroCuenta, p_titular);
    this.setSaldo(0);
    this.setExtraccionesPosibles(10);
  }

  /**
   * Constructor de la clase CuentaDeAhorro.
   * 
   * @param p_nroCuenta El número de cuenta de la persona titular de la
   *                    cuenta de ahorro.
   * @param p_saldo     Saldo al iniciar la cuenta de ahorro.
   * @param p_titular   Persona titular de la cuenta de ahorro.
   */
  public CajaDeAhorro(int p_nroCuenta, double p_saldo, Persona p_titular) {
    super(p_nroCuenta, p_titular, p_saldo);
    this.setExtraccionesPosibles(10);
  }

  /**
   * El método establece el valor de la variable "extraccionesPosibles"
   * proporcionado del valor
   * "pExtraccionesPosibles".
   * 
   * @param pExtraccionesPosibles Es un valor doble que representa el nuevo valor
   *                              de la variable "extraccionesPosibles".
   */
  private void setExtraccionesPosibles(int pExtraccionesPosibles) {
    this.extraccionesPosibles = pExtraccionesPosibles;
  }

  /**
   * @return Devuelve el valor de la variable de instancia "extraccionesPosibles".
   */
  public int getExtraccionesPosibles() {
    return this.extraccionesPosibles;
  }

  /**
   * El método "puedeExtraer" verifica si el monto dado se puede retirar de la
   * cuenta sin
   * exceder el límite de saldo.
   *
   * @param p_importe Representa la cantidad de dinero que el usuario desea
   *                  retirar
   *                  de su cuenta.
   * @return El método devuelve un valor booleano.
   */
  private boolean puedeExtraer(double p_importe) {
    return p_importe < this.getSaldo() && this.getExtraccionesPosibles() > 0;
  }

  /**
   * El método "mostrar" imprime el número de cuenta, el saldo, el titular y sus
   * extracciones disponibles de la cuenta bancaria.
   */
  public void mostrar() {
    System.out.println("- Caja de Ahorro -");
    super.mostrar();
    System.out.println("Extracciones Posibles: " + this.getExtraccionesPosibles());
  }

  public String xQNoPuedeExtraer(double p_importe) {
    return this.puedeExtraer(p_importe) ? "Si puede extraer\n"
        : "No tiene habilitadas mas extracciones! o No puede extraer mas que el saldo!";
  }
}
