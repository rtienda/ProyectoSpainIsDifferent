package clases;

public class Respuesta extends ElementoResultado{
	
	private String respuesta;
	private String modificador;
	
	

	public Respuesta(int puntosCorrupcion, int presupuesto, byte popularidad, String respuesta, String modificador) {
		super(puntosCorrupcion, presupuesto, popularidad);
		this.respuesta = respuesta;
		this.modificador = modificador;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getModificador() {
		return modificador;
	}

	public void setModificador(String modificador) {
		this.modificador = modificador;
	}
	
	
}
