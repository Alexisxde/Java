import java.util.Calendar;

public class Individuo extends Visitante {
  private Persona persona;

  public Individuo(Persona p_persona, Calendar p_fechaVisita) {
    super(p_persona.apeYNom(), p_fechaVisita);
    this.setPersona(p_persona);
  }

  public void setPersona(Persona p_persona) {
    this.persona = p_persona;
  }

  public Persona getPersona() {
    return this.persona;
  }

  @Override
  public double entrada() {
    return 10;
  }

  @Override
  public void mostrar() {
    this.getPersona().mostrar();
  }

  @Override
  public void listarPorFecha(Calendar p_fecha, String p_visitante) {
    throw new UnsupportedOperationException("Unimplemented method 'listarPorFecha'");
  }

  @Override
  public String tipoVisitante() {
    return this.getClass().getName();
  }

}
