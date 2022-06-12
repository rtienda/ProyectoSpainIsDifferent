package clases;

import java.util.Random;
/**
 * Clase ElementoConAtributosPorcentuales que se encarga de crear los modificadores porcentuales de cada decision
 * @author Rafa
 *
 */
abstract public class ElementoConAtributosPorcentuales extends ElementoResultado{

	/**
	 * Variable modificadorPresupuesto de tipo float
	 */
	private float modificadorPresupuesto;
	/**
	 * Variable modificadorPopularidad de tipo float
	 */
	private float modificadorPopularidad;
	/**
	 * Variable modificadorCorrupcion de tipo float
	 */
	private float modificadorCorrupcion;
	
	/**
	 * Contructor de ElementoConAtributosPorcentuales aunque no se usara
	 * @param puntosCorrupcion de tipo float
	 * @param presupuesto de tipo float
	 * @param popularidad de tipo byte
	 * @param modificadorPresupuesto de tipo float
	 * @param modificadorPopularidad de tipo float
	 * @param modificadorCourrupcion de tipo float
	 */
	public ElementoConAtributosPorcentuales(float puntosCorrupcion, float presupuesto, byte popularidad,
			float modificadorPresupuesto, float modificadorPopularidad, float modificadorCourrupcion) {
		super(puntosCorrupcion, presupuesto, popularidad);
		this.modificadorPresupuesto = modificadorPresupuesto;
		this.modificadorPopularidad = modificadorPopularidad;
		this.modificadorCorrupcion = modificadorCourrupcion;
	}
	/**
	 * Constructor vacio
	 */
	public ElementoConAtributosPorcentuales() {
		super();
	}
	/**
	 * Funcion getModificadorPresupuesto que dara un resultado numerico Random entre 0,7 y 1,3
	 * @return float
	 */
	public float getModificadorPresupuesto() {
		Random r=new Random ();
		return r.nextFloat(0.7f,1.3f);
	}
	/**
	 * Funcion getModificadorPopularidad que dara un resultado numerico Random entre 0,7 y 1,3
	 * @return float
	 */
	public float getModificadorPopularidad() {
		Random r=new Random ();
		return r.nextFloat(0.7f,1.3f);
	}
	/**
	 * Funcion getModificadorCorrupcion que dara un resultado numerico Random entre 0,7 y 1,3
	 * @return float
	 */
	public float getModificadorCorrupcion() {
		Random r=new Random ();
		return r.nextFloat(0.7f,1.3f);
		}



	@Override
	public String toString() {
		return "ElementoConAtributosPorcentuales [modificadorPresupuesto=" + modificadorPresupuesto
				+ ", modificadorPopularidad=" + modificadorPopularidad + ", modificadorCorrupcion="
				+ modificadorCorrupcion + "]"+ super.toString();
	}
	
	
	
}
