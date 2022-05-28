package clases;

import java.util.ArrayList;

import enums.TipoMegaProyecto;

public class MegaProyectos extends ElementoResultado{

	private ArrayList<String> modificadoresNecesarios;
	private String nombre;
	private TipoMegaProyecto tipo;
	
	public MegaProyectos(int puntosCorrupcion, int presupuesto, byte popularidad,
			ArrayList<String> modificadoresNecesarios, String nombre, TipoMegaProyecto tipo) {
		super(puntosCorrupcion, presupuesto, popularidad);
		this.modificadoresNecesarios = modificadoresNecesarios;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public ArrayList<String> getModificadoresNecesarios() {
		return modificadoresNecesarios;
	}

	public void setModificadoresNecesarios(ArrayList<String> modificadoresNecesarios) {
		this.modificadoresNecesarios = modificadoresNecesarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoMegaProyecto getTipo() {
		return tipo;
	}

	public void setTipo(TipoMegaProyecto tipo) {
		this.tipo = tipo;
	}
	
	
	
}
