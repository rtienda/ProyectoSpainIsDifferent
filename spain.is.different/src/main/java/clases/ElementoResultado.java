package clases;

abstract class ElementoResultado {
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
	public void setPuntosCorrupcion(int puntosCorrupcion) {
		this.puntosCorrupcion = puntosCorrupcion;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	public byte getPopularidad() {
		return popularidad;
	}
	public void setPopularidad(byte popularidad) {
		this.popularidad = popularidad;
	}
	
	
}
