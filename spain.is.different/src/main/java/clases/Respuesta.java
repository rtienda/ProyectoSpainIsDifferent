package clases;

/**
 * Clase Respuesta que contruira un objeto respuesta y delvolvera los valores
 * @author Rafa
 *
 */
public class Respuesta extends ElementoResultado{
	
	/**
	 * Variable respuesta de tipo String que guardara el texto de la respuesta
	 */
	private String respuesta;
	/**
	 * Variable modificador de tipo String que guardara el texto del codigo de modificador que se usara para los megaproyectos
	 */
	private String modificador;
	
	
	/**
	 * Constructor Respuesta se encargara de construir un objeto de tipo respuesta
	 * @param puntosCorrupcion de tipo int
	 * @param presupuesto de tipo int
	 * @param popularidad de tipo byte
	 * @param respuesta de tipo String
	 * @param modificador de tipo String
	 */
	public Respuesta(int puntosCorrupcion, int presupuesto, byte popularidad, String respuesta, String modificador) {
		super(puntosCorrupcion, presupuesto, popularidad);
		this.respuesta = respuesta;
		this.modificador = modificador;
	}

	
	/**
	 * Funcion getRespuesta que devolvera el valor del texto respuesta
	 * @return respuesta de tipo String
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * Funcion setRespuesta que cambiara el nuevo valor de respuesta por el valor que se pase por parametro
	 * @param respuesta de tipo String
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	/**
	 * Funcion getModificador que devolvera el valor del texto modificador
	 * @return modificador de tipo String
	 */
	public String getModificador() {
		return modificador;
	}
	/**
	 * Funcion setModificador que cambiara el nuevo valor de modificador por el valor que se pase por parametro
	 * @param modificador de tipo String
	 */
	public void setModificador(String modificador) {
		this.modificador = modificador;
	}



	/**
	 * Funcion toString que devolvera la cadena de caracteres de todas las variables del objeto
	 */
	public String toString() {
		return "Respuesta [respuesta=" + respuesta + ", modificador=" + modificador + "]"+super.toString();
	}
	
	
}
