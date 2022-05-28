package clases;

import java.util.ArrayList;

public class Partida extends ElementoResultado{

	private Usuario jugador;
	private String nombrePartida;
	private ArrayList<DecisionTomada> decisionesYaTomadas;
	private ArrayList<MegaProyectos> megaProyectosConstruidos;
	private ArrayList<Evento> eventosSurgidos;
	
	
	public Partida(int puntosCorrupcion, int presupuesto, byte popularidad, Usuario jugador, String nombrePartida,
			ArrayList<DecisionTomada> decisionesYaTomadas, ArrayList<MegaProyectos> megaProyectosConstruidos,
			ArrayList<Evento> eventosSurgidos) {
		super(puntosCorrupcion, presupuesto, popularidad);
		this.jugador = jugador;
		this.nombrePartida = nombrePartida;
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
	
	
}
