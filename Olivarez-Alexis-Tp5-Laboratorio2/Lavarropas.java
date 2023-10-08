public class Lavarropas extends ArtefactoHogar {
  private int programas;
  private float kilos;
  private boolean automatico;

  public Lavarropas(String p_marca, float p_precio, int p_stock, int p_programas, float p_kilos, boolean p_automatico) {
    super(p_marca, p_precio, p_stock);
    this.setProgramas(p_programas);
    this.setKilos(p_kilos);
    this.setAutomatico(p_automatico);
  }

  private void setProgramas(int p_programas) {
    this.programas = p_programas;
  }

  private void setKilos(float p_kilos) {
    this.kilos = p_kilos;
  }

  private void setAutomatico(boolean p_automatico) {
    this.automatico = p_automatico;
  }

  public int getProgramas() {
    return this.programas;
  }

  public float getKilos() {
    return this.kilos;
  }

  public boolean isAutomatico() {
    return this.automatico;
  }

  @Override
  public void imprimir() {
    System.out.println("**** Lavarropas ****");
    super.imprimir();
    System.out.format("Programas: %s\n", this.getProgramas());
    System.out.format("Kilos: %s\n", this.getKilos());
    System.out.format("Automatico: %s\n", this.isAutomatico() ? "Si" : "No");
  }

  @Override
  public float creditoConAdicional(int p_cuotas, float p_interes) {
    float valorCuota = super.cuotaCredito(p_cuotas, p_interes);
    if (!this.isAutomatico()) {
      valorCuota -= valorCuota * 0.02;
    }
    return valorCuota;
  }
}
