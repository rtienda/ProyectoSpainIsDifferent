package clases;

import utils.Globals;

abstract public class ElementoResultado {
	private int puntosCorrupcion;
	private int presupuesto;
	private byte popularidad;
	
	public ElementoResultado(int puntosCorrupcion, int presupuesto, byte popularidad) {
		super();
		this.puntosCorrupcion = puntosCorrupcion;
		this.presupuesto = presupuesto;
		this.popularidad = popularidad;
	}
	public int getPuntosCorrupcion() {
		return puntosCorrupcion;
	}

	public void sumarPuntosCorrupcion(float pc) {
		if(!Globals.cheating) {
			this.puntosCorrupcion+=pc;
		}
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void sumarPresupuesto(float pr) {
		if(!Globals.cheating) {
			this.puntosCorrupcion+=pr;
		}
	}
	public byte getPopularidad() {
		return popularidad;
	}
	public void sumarPopularidad(byte po) {
		if(!Globals.cheating) {
			this.puntosCorrupcion+=po;
		}
	}
	
	
}
