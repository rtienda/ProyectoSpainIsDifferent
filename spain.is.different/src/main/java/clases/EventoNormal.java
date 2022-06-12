package clases;

import enums.TipoEvento;
/**
 * Clase de EventoNormal
 * @author Rafa
 *
 */
public class EventoNormal extends Evento{
	/**
	 * Contructor de EventoNormal
	 * @param textoEvento de tipo String
	 * @param nombreEvento de tipo String
	 * @param tipoEvento de tipo enum TipoEvento
	 */
	public EventoNormal(String textoEvento, String nombreEvento, TipoEvento tipoEvento) {
		super(textoEvento, nombreEvento, tipoEvento);
	}

}
