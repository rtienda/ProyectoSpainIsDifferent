package clases;

import utils.Globals;
/**
 * Clase abstracta ElementoResultado donde se declaran las variables bases del juego
 * @author Rafa
 *
 */
abstract public class ElementoResultado {
	/**
	 * Variable puntosCorrupcion de tipo float
	 */
	private float puntosCorrupcion;
	/**
	 * Variable presupuesto de tipo float
	 */
	private float presupuesto;
	/**
	 * Variable popularidad de tipo byte
	 */
	private byte popularidad;
	
	/**
	 * Constructor ElementoResultado recoge las variables que se le pasan por parametros
	 * @param puntosCorrupcion de tipo float
	 * @param presupuesto de tipo float
	 * @param popularidad de tipo byte
	 */
	public ElementoResultado(float puntosCorrupcion, float presupuesto, byte popularidad) {
		super();
		this.puntosCorrupcion = puntosCorrupcion;
		this.presupuesto = presupuesto;
		this.popularidad = popularidad;
	}
	/**
	 * Constructor ElementoResultado vacio que nos sirve para iniciarlizarlo en otras clases
	 */
	public ElementoResultado() {
	}
	/**
	 * Funcion getPuntosCorrupcion que devuelve los puntosCorrupcion del objeto
	 * @return puntosCorrupcion como float
	 */
	public float getPuntosCorrupcion() {
		return puntosCorrupcion;
	}

	/**
	 * Funcion sumarPuntosCorrupcion que sumara los puntos que se le pasen por parametro a los puntosCorrupcion del objeto
	 * @param pc como tipo float
	 */
	public void sumarPuntosCorrupcion(float pc) {
		this.puntosCorrupcion+=pc;
	}
	/**
	 * Funcion getPresupuesto que devolvera el presupuesto del objeto de tipo float
	 * @return
	 */
	public float getPresupuesto() {
		return presupuesto;
	}
	/**
	 * Funcion sumarPresupuesto que suma el presupuesto que se pasa por parametro al actual pero si trucos estan activados no lo suma
	 * @param pr de tipo float que sumara al presupuesto
	 */
	public void sumarPresupuesto(float pr) {
		
		
		if(!Globals.cheating) {
			if(this.presupuesto+pr>=0) {
				this.presupuesto+=pr;
			}else {
				this.presupuesto=0;
			}
		}
	}
	/**
	 * Funcion getPopularidad que devuelve la popularidad como byte
	 * @return
	 */
	public byte getPopularidad() {
		return popularidad;
	}
	
	/**
	 * Funcion sumarPopularidad que recoge la popularidad por parametro y la suma a la actual y si los trucos estan activados entonces no cambia
	 * @param po de tipo byte se sumara a la popularidad pero nunca sumando mas de 100 o menos de 0
	 */
	public void sumarPopularidad(byte po) {
		if(!Globals.cheating) {
			if(popularidad+po>=0&&popularidad+po<=100) {
				this.popularidad+=po;
			}else if (popularidad+po<0){
				this.popularidad=0;
			}else {
				this.popularidad=100;
			}
		}
	}

	/**
	 * Funcion toString que devuelve un String con la cadena de caracteres de todos los valores del juego
	 */
	public String toString() {
		return "ElementoResultado [puntosCorrupcion=" + puntosCorrupcion + ", presupuesto=" + presupuesto
				+ ", popularidad=" + popularidad + "]";
	}
	
	
	
}
