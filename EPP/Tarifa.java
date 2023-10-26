public class Tarifa {
  public String turno;
  public double costo;

  public Tarifa(String p_turno, double p_costo) {
    this.turno = p_turno;
    this.costo = p_costo;
  }

  private double porcentajeTurno() {
    double porcentaje = 0;
    if (this.turno.equals("vespertino")) {
      porcentaje = 5;
    } else if (this.turno.equals("nocturno")) {
      porcentaje = 10;
    }
    return porcentaje;
  }

  public double importe() {
    return this.costo + (this.costo * this.porcentajeTurno() / 100);
  }

  public String mostrar() {
    return String.format("Tarifa: %.2f en horario: %s - Importe: %.2f con %s de incremento: %.1f", this.costo,
        this.turno,
        this.importe(), "%", this.porcentajeTurno());
  }
}
