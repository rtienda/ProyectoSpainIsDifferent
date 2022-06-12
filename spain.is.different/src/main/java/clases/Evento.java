package clases;

import enums.TipoEvento;
/**
 * Clase Evento donde se crearan los eventos en la partida
 * @author Rafa
 *
 */
public class Evento {
	/**
	 * Variable textoEvento de tipo String
	 */
	private String textoEvento;
	/**
	 * Variable nombreEvento de tipo String
	 */
	private String nombreEvento;
	/**
	 * Variable tipoEvento de enum TipoEvento
	 */
	private TipoEvento tipoEvento;
	/**
	 * Constructor Evento
	 * @param textoEvento de tipo String
	 * @param nombreEvento de tipo String
	 * @param tipoEvento de tipo TipoEvento enum
	 */
	public Evento(String textoEvento, String nombreEvento, TipoEvento tipoEvento) {
		super();
		this.textoEvento = textoEvento;
		this.nombreEvento = nombreEvento;
		this.tipoEvento = tipoEvento;
	}
	/**
	 * Funcion getTextoEvento que devuelve textoEvento
	 * @return textoEvento de tipo String
	 */
	public String getTextoEvento() {
		return textoEvento;
	}
	/**
	 * Funcion setTextoEvento cambia la variable por el nuevo parametro
	 * @param textoEvento de tipo String
	 */
	public void setTextoEvento(String textoEvento) {
		this.textoEvento = textoEvento;
	}
	/**
	 * Funcion getNombreEvento que devuelve nombreEvento
	 * @return nombreEvento de tipo String
	 */
	public String getNombreEvento() {
		return nombreEvento;
	}
	/**
	 * Funcion setNombreEvento cambia la variable por el nuevo parametro
	 * @param nombreEvento de tipo String
	 */
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	/**
	 * Funcion getTipoEvento que devuelve tipoEvento
	 * @return tipoEvento de tipo TipoEvento
	 */
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}
	/**
	 * Funcion setTipoEvento cambia la variable por el nuevo parametro
	 * @param tipoEvento de tipo TipoEvento
	 */
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	
	
}
