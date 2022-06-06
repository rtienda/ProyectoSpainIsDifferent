package clases;

abstract public class ElementoConAtributosPorcentuales extends ElementoResultado{


	private float modificadorPresupuesto;
	private float modificadorPopularidad;
	private float modificadorCorrupcion;
	
	public ElementoConAtributosPorcentuales(int puntosCorrupcion, int presupuesto, byte popularidad,
			float modificadorPresupuesto, float modificadorPopularidad, float modificadorCourrupcion) {
		super(puntosCorrupcion, presupuesto, popularidad);
		this.modificadorPresupuesto = modificadorPresupuesto;
		this.modificadorPopularidad = modificadorPopularidad;
		this.modificadorCorrupcion = modificadorCourrupcion;
	}

	public ElementoConAtributosPorcentuales() {
		super();
	}

	public float getModificadorPresupuesto() {
		return modificadorPresupuesto;
	}

	public void setModificadorPresupuesto(float modificadorPresupuesto) {
		this.modificadorPresupuesto = modificadorPresupuesto;
	}

	public float getModificadorPopularidad() {
		return modificadorPopularidad;
	}

	public void setModificadorPopularidad(float modificadorPopularidad) {
		this.modificadorPopularidad = modificadorPopularidad;
	}

	public float getModificadorCorrupcion() {
		return modificadorCorrupcion;
	}

	public void setModificadorCorrupcion(float modificadorCourrupcion) {
		this.modificadorCorrupcion = modificadorCourrupcion;
	}
	
	
}
