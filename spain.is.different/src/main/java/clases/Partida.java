package clases;

import java.util.ArrayList;

import exceptions.TextoVacioException;

public class Partida extends ElementoResultado{

	private Usuario jugador;
	private String nombrePartida;
	private ArrayList<DecisionTomada> decisionesYaTomadas;
	private ArrayList<MegaProyectos> megaProyectosConstruidos;
	private ArrayList<Evento> eventosSurgidos;
	private boolean estado=false;
	private ArrayList<Decision> decision;

	
	public Partida(int puntosCorrupcion, int presupuesto, byte popularidad, Usuario jugador, String nombrePartida,
			ArrayList<DecisionTomada> decisionesYaTomadas, ArrayList<MegaProyectos> megaProyectosConstruidos,
			ArrayList<Evento> eventosSurgidos) throws TextoVacioException {
		super(puntosCorrupcion=0, presupuesto=10000, popularidad=60);
		this.jugador = jugador;
		this.nombrePartida = nombrePartida;
		if(nombrePartida.isBlank()) {
			throw new TextoVacioException("El nombre de la partida no puede estar vacio");
		}
		this.decisionesYaTomadas = decisionesYaTomadas;
		this.megaProyectosConstruidos = megaProyectosConstruidos;
		this.eventosSurgidos = eventosSurgidos;
	}
	
	public Usuario getJugador() {
		return jugador;
	}
	public void setJugador(Usuario jugador) {
		this.jugador = jugador;
	}
	public String getNombrePartida() {
		return nombrePartida;
	}
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	public ArrayList<DecisionTomada> getDecisionesYaTomadas() {
		return decisionesYaTomadas;
	}
	public void setDecisionesYaTomadas(ArrayList<DecisionTomada> decisionesYaTomadas) {
		this.decisionesYaTomadas = decisionesYaTomadas;
	}
	public ArrayList<MegaProyectos> getMegaProyectosConstruidos() {
		return megaProyectosConstruidos;
	}
	public void setMegaProyectosConstruidos(ArrayList<MegaProyectos> megaProyectosConstruidos) {
		this.megaProyectosConstruidos = megaProyectosConstruidos;
	}
	public ArrayList<Evento> getEventosSurgidos() {
		return eventosSurgidos;
	}
	public void setEventosSurgidos(ArrayList<Evento> eventosSurgidos) {
		this.eventosSurgidos = eventosSurgidos;
	}
	
	public void ronda() {
		do {
		
			
		}while(this.estado=false||decision.isEmpty());
		
	}
	
	public boolean hasPerdido() {
		if(getPresupuesto()==0||getPopularidad()==0) {
			this.estado=true;
		}
		return this.estado;
	}
	
	
}
