package clases;
/**
 * Clase DecisionTomada que servira para construir un objeto por cada decision y respuesta tomada por el usuario
 * @author Rafa
 *
 */
public class DecisionTomada {

	/**
	 * Variable decision de tipo Decision que guarda la decision.
	 */
	private Decision decision;
	/**
	 * Variable respuestaElegida de tipo Respuesta que guarda la respuesta seleccionada
	 */
	private Respuesta respuestaElegida;
	/**
	 * Constructor DecisionTomada que construira el objeto
	 * @param decision la Decision que se le pasara por parametros
	 * @param respuestaElegida la Respuesta elegida que se mostrara por parametros
	 */
	public DecisionTomada(Decision decision, Respuesta respuestaElegida) {
		super();
		this.decision = decision;
		this.respuestaElegida = respuestaElegida;
	}
	/**
	 * Funcion getDecision que devolvera la decision
	 * @return decision el objeto
	 */
	public Decision getDecision() {
		return decision;
	}
	/**
	 * Funcion setDecision que setteara la nueva decision elegida para la decisionTomada
	 * @param decision de tipo Decision que setteara la nueva decision para la decisionTomada
	 */
	public void setDecision(Decision decision) {
		this.decision = decision;
	}
	/**
	 * Funcion getRespuesta que devolvera la respuesta
	 * @return respuesta el objeto
	 */
	public Respuesta getRespuestaElegida() {
		return respuestaElegida;
	}
	/**
	 * Funcion setRespuestaElegida que seteara la nueva respuesta elegida para la decision
	 * @param respuestaElegida de tipo Respuesta que setteara la nueva respuestaElegida para la decision
	 */
	public void setRespuestaElegida(Respuesta respuestaElegida) {
		this.respuestaElegida = respuestaElegida;
	}
	
	
}
