public class CuentaCorriente extends CuentaBancaria {
  private double limiteDescubierto;

  /**
   * Constructor de la clase CuentaCorriente.
   * 
   * @param p_nroCuenta El número de cuenta de la persona titular de la
   *                    cuenta.
   * @param p_titular   Persona titular de la cuenta.
   */
  public CuentaCorriente(int p_nroCuenta, Persona p_titular) {
    super(p_nroCuenta, p_titular);
    this.setLimiteDescubierto(500);
  }

  /**
   * Constructor de la clase CuentaCorriente.
   * 
   * @param p_nroCuenta El número de cuenta de la persona titular de la
   *                    cuenta.
   * @param p_saldo     Saldo al iniciar la cuenta.
   * @param p_titular   Persona titular de la cuenta.
   */
  public CuentaCorriente(int p_nroCuenta, double p_saldo, Persona p_titular) {
    super(p_nroCuenta, p_titular, p_saldo);
    this.setLimiteDescubierto(500);
  }

  /**
   * El método establece el valor de la variable "limiteDescubierto" proporcionado
   * del valor "p_limiteDescubierto".
   * 
   * @param p_limiteDescubierto Representa la cantidad que te presta la cuenta.
   */
  private void setLimiteDescubierto(double p_limiteDescubierto) {
    this.limiteDescubierto = p_limiteDescubierto;
  }

  /**
   * @return Devuelve el valor de la variable de instancia "limiteDescubierto".
   */
  public double getLimiteDescubierto() {
    return this.limiteDescubierto;
  }

  /**
   * El método "puedeExtraer" verifica si el monto dado se puede retirar de la
   * cuenta sin exceder el límite de saldo.
   *
   * @param p_importe Representa la cantidad de dinero que el usuario desea
   *                  retirar de su cuenta.
   * @return El método devuelve un valor booleano.
   */
  private boolean puedeExtraer(double p_importe) {
    return p_importe <= this.getSaldo() + this.getLimiteDescubierto();
  }

  /**
   * @param p_importe Valor que se extraerá en la cuenta del banco.
   * @return Si se pudo extraer o no (boolean).
   */
  @Override
  public boolean extraer(double p_importe) {
    if (p_importe <= super.getSaldo()) {
      return super.extraer(p_importe);
    } else if (this.puedeExtraer(p_importe)) {
      this.setLimiteDescubierto(this.getLimiteDescubierto() - (p_importe - super.getSaldo()));
      super.setSaldo(0);
      return true;
    }
    return false;
  }

  /**
   * 
   * @param p_importe Nuevo valor que se deposita en la cuenta del banco.
   * @return El nuevo saldo después del deposito en la cuenta del banco.
   */
  @Override
  public double depositar(double p_importe) {
    double debe = 0,
        aux = 0;
    if (this.getLimiteDescubierto() <= 500) {
      debe = 500 - this.getLimiteDescubierto();
      aux = p_importe - aux;
      this.setLimiteDescubierto(this.getLimiteDescubierto() + debe);
      super.depositar(aux);
      return aux;
    }
    return super.depositar(p_importe);
  }

  /**
   * El método "mostrar" imprime el número de cuenta, el saldo, el titular, su
   * descubierto de la cuenta bancaria.
   */
  public void mostrar() {
    System.out.println("- Cuenta Corriente -");
    super.mostrar();
    System.out.println("Descubierto: " + this.getLimiteDescubierto());
  }

  /**
   * @param p_importe Valor que se extraerá en la cuenta del banco.
   * @return Un String que avisa si puede extraer o no.
   */
  public String xQNoPuedoExtraer(double p_importe) {
    return this.puedeExtraer(p_importe) ? "Si puede extraer\n"
        : "El importe de extraccion sobrepasa el limite de descubierto!\n";
  }
}