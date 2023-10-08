import java.text.DecimalFormat;

public class Comercio {
  public static void main(String[] args) {
    Cocina cocina = new Cocina("Volcan", 600, 15, 4, 2000, "80*60*60cm");
    Heladera heladera = new Heladera("Gafa", 1200, 8, 11, 2, true);
    Lavarropas lavarropas = new Lavarropas("Samsung", 2000, 10, 10, (float) 6.5, false);
    informeCuotas(cocina, 6, (float) 0.1518);
    informeCuotas(heladera, 6, (float) 0.1518);
    informeCuotas(lavarropas, 6, (float) 0.1518);
  }

  public static void informeCuotas(ArtefactoHogar p_artefactoHogar, int p_cuotas, float p_interes) {
    DecimalFormat df = new DecimalFormat("#.##");
    p_artefactoHogar.imprimir();
    System.out.format("Cuotas: %s - Interés: %s%%\n", p_cuotas, p_interes * 100);
    double valorCuotaHeladera = p_artefactoHogar.cuotaCredito(p_cuotas, p_interes);
    double valorCuotaConAdicionalesHeladera = p_artefactoHogar.creditoConAdicional(p_cuotas, p_interes);
    System.out.format("Valor Cuota: %s\n", df.format(valorCuotaHeladera));
    System.out.format("Valor Cuota Con Adicionales: %s\n\n", df.format(valorCuotaConAdicionalesHeladera));
  }
}
