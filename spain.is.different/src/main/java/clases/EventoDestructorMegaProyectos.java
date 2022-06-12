package clases;

import enums.TipoEvento;
/**
 * Clase EventoDestructorMegaProyectos
 * @author Rafa
 *
 */
public class EventoDestructorMegaProyectos extends Evento{
	/**
	 * Variable megaProyectoQueDestruye de tipo MegaProyectos
	 */
	private MegaProyectos megaProyectoQueDestruye;

	/**
	 * Constructor de la clase EventoDestructorMegaProyectos
	 * @param textoEvento de tipo String
	 * @param nombreEvento de tipo String
	 * @param tipoEvento de tipo enum TipoEvento
	 * @param megaProyectoQueDestruye de tipo MegaProyectos
	 */
	public EventoDestructorMegaProyectos(String textoEvento, String nombreEvento, TipoEvento tipoEvento,MegaProyectos megaProyectoQueDestruye) {
		super(textoEvento, nombreEvento, tipoEvento);
		this.megaProyectoQueDestruye=megaProyectoQueDestruye;
	}

}
