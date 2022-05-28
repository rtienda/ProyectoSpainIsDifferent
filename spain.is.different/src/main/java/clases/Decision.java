package clases;

import java.util.ArrayList;

public class Decision extends ElementoConAtributosPorcentuales{

	private String pregunta;
	ArrayList<Respuesta> respuestas;
	String textoEvento;
	
	

	public Decision(int puntosCorrupcion, int presupuesto, byte popularidad, float modificadorPresupuesto,
			float modificadorPopularidad, float modificadorCourrupcion, String pregunta,
			ArrayList<Respuesta> respuestas, String textoEvento) {
		super(puntosCorrupcion, presupuesto, popularidad, modificadorPresupuesto, modificadorPopularidad,
				modificadorCourrupcion);
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.textoEvento = textoEvento;
	}



	public String getPregunta() {
		return pregunta;
	}



	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}



	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}



	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}



	public String getTextoEvento() {
		return textoEvento;
	}



	public void setTextoEvento(String textoEvento) {
		this.textoEvento = textoEvento;
	}

	
	
	
	
}
