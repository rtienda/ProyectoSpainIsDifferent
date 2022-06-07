package clases;

import utils.Globals;

abstract public class ElementoResultado {
	private float puntosCorrupcion;
	private float presupuesto;
	private byte popularidad;
	
	public ElementoResultado(float puntosCorrupcion, float presupuesto, byte popularidad) {
		super();
		this.puntosCorrupcion = puntosCorrupcion;
		this.presupuesto = presupuesto;
		this.popularidad = popularidad;
	}
	public ElementoResultado() {
	}
	public float getPuntosCorrupcion() {
		return puntosCorrupcion;
	}

	public void sumarPuntosCorrupcion(float pc) {
		if(!Globals.cheating) {
			this.puntosCorrupcion+=pc;
			
		}
	}
	public float getPresupuesto() {
		return presupuesto;
	}
	public void sumarPresupuesto(float pr) {
		
		if(this.presupuesto+pr>=0) {
			this.presupuesto+=pr;
			System.out.println("Esta sumando");
		}else {
			this.presupuesto=0;
		}
		if(!Globals.cheating) {
		
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
