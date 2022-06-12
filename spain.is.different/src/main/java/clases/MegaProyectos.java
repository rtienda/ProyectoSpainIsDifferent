package clases;

import java.util.ArrayList;

import enums.TipoMegaProyecto;

/**
 * Clase MegaProyectos se encargara de crear los proyectos relacionados a la partida
 * @author Rafa
 *
 */
public class MegaProyectos extends ElementoResultado{
	/**
	 * Variable modificadoresNecesarios de tipo ArrayList<String> Se encargara de almacenar los modificadores necesarios de cada megaProyecto
	 */
	private ArrayList<String> modificadoresNecesarios;
	/**
	 * Variable nombre de tipo String que almacenara el nombre de cada proyecto
	 */
	private String nombre;
	/**
	 * Variable tipo de enum TipoMegaProyecto que guarda el tipo de cada proyecto
	 */
	private TipoMegaProyecto tipo;
	
	/**
	 * Constructor de MegaProyectos
	 * @param puntosCorrupcion de tipo float
	 * @param presupuesto de tipo float
	 * @param popularidad de tipo byte
	 * @param modificadoresNecesarios de tipo ArrayList<String>
	 * @param nombre de tipo String
	 * @param tipo de tipo enum de TipoMegaProyecto
	 */
	public MegaProyectos(float puntosCorrupcion, float presupuesto, byte popularidad,
			ArrayList<String> modificadoresNecesarios, String nombre, TipoMegaProyecto tipo) {
		super(puntosCorrupcion, presupuesto, popularidad);
		this.modificadoresNecesarios = modificadoresNecesarios;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	/**
	 * Funcion getModificadoresNecesarios que devolvera los modificadores necesarios para realizar el proyecto
	 * @return ArrayList modificadoresNecesarios de tipo String
	 */
	public ArrayList<String> getModificadoresNecesarios() {
		return modificadoresNecesarios;
	}
	/**
	 * Funcion getNombre devuelve el nombre del MegaProyecto
	 * @return nombre de tipo String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Funcion getTipo que devuelve de que tipo es el megaProyecto
	 * @return tipo de tipo Enum TipoMegaProyecto
	 */
	public TipoMegaProyecto getTipo() {
		return tipo;
	}	
}
