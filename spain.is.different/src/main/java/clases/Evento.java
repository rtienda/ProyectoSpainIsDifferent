package clases;

import enums.TipoEvento;

public class Evento {
	private String textoEvento;
	private String nombreEvento;
	private TipoEvento tipoEvento;
	
	public Evento(String textoEvento, String nombreEvento, TipoEvento tipoEvento) {
		super();
		this.textoEvento = textoEvento;
		this.nombreEvento = nombreEvento;
		this.tipoEvento = tipoEvento;
	}

	public String getTextoEvento() {
		return textoEvento;
	}

	public void setTextoEvento(String textoEvento) {
		this.textoEvento = textoEvento;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	
	
}
