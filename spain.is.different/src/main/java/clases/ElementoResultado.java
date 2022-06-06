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
	public ElementoResultado() {
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
			if(this.presupuesto+pr>=0) {
				this.presupuesto+=pr;
			}else {
				this.presupuesto=0;
			}
		}
	}
	public byte getPopularidad() {
		return popularidad;
	}
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
	@Override
	public String toString() {
		return "ElementoResultado [puntosCorrupcion=" + puntosCorrupcion + ", presupuesto=" + presupuesto
				+ ", popularidad=" + popularidad + "]";
	}
	
	
	
}
