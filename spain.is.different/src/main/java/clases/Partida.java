package clases;

import java.util.ArrayList;

import exceptions.TextoVacioException;
/**
 * Clase Partida donde se creara y guardaran los datos de la partida
 * @author Rafa
 *
 */
public class Partida extends ElementoResultado{
	/**
	 * Variable jugador de tipo Usuario
	 */
	private Usuario jugador;
	/**
	 * Variable nombrePartida de tipo String
	 */
	private String nombrePartida;
	/**
	 * Variable decisionesYaTomadas de tipo ArrayList<DecisionTomada>
	 */
	private ArrayList<DecisionTomada> decisionesYaTomadas;
	/**
	 * Variable megaProyectosConstruidos de tipo ArrayList<MegaProyectos>
	 */
	private ArrayList<MegaProyectos> megaProyectosConstruidos;
	/**
	 * Variable eventosSurgidos de tipo ArrayList<Evento>
	 */
	private ArrayList<Evento> eventosSurgidos;
	/**
	 * Variable estado de tipo boolean iniciada a false
	 */
	private boolean estado=false;
	/**
	 * Variable decision de tipo ArrayList<Decision> inicializada vacia
	 */
	private ArrayList<Decision> decision = new ArrayList<Decision>();
	
	/**
	 * Constructor Partida vacio
	 */
	public Partida() {
		super();
	}
	
	/**
	 * Constructor de Partida
	 * @param puntosCorrupcion de tipo float
	 * @param presupuesto de tipo float
	 * @param popularidad de tipo byte
	 * @param jugador de tipo Usuario
	 * @param nombrePartida de tipo String
	 * @param decisionesYaTomadas de tipo ArrayList<Decision>
	 * @param megaProyectosConstruidos de tipo ArrayList<MegaProyectos>
	 * @param eventosSurgidos de tipo ArrayList<Evento>
	 * @throws TextoVacioException de tipo exception
	 */
	public Partida(float puntosCorrupcion, float presupuesto, byte popularidad, Usuario jugador, String nombrePartida,
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
	/**
	 * Funcion getJugador que devuelve el Usuario
	 * @return jugador de tipo Usuario
	 */
	public Usuario getJugador() {
		return jugador;
	}
	/**
	 * Funcion setJugador que cambia el nuevo Usuario
	 * @param jugador de tipo Usuario
	 */
	public void setJugador(Usuario jugador) {
		this.jugador = jugador;
	}
	/**
	 * Funcion getNombrePartida que devuelve el nombre de la partida 
	 * @return nombrePartida de tipo String
	 */
	public String getNombrePartida() {
		return nombrePartida;
	}
	/**
	 * Funcion setNombrePartida que cambia el nombrePartida por el nuevo por parametro
	 * @param nombrePartida de tipo String
	 */
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	/**
	 * Funcion getDecisionesYaTomdadas que devuelve el ArrayList<DecisionTomada> 
	 * @return decisionesYaTomadas de tipo ArrayList<DecisionTomada> 
	 */
	public ArrayList<DecisionTomada> getDecisionesYaTomadas() {
		return decisionesYaTomadas;
	}
	/**
	 * Funcion setDecisionesYaTomadas que settea el arrayList por el nuevo
	 * @param decisionesYaTomadas de tipo ArrayList<DecisionTomada> 
	 */
	public void setDecisionesYaTomadas(ArrayList<DecisionTomada> decisionesYaTomadas) {
		this.decisionesYaTomadas = decisionesYaTomadas;
	}
	/*
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
	*/
	/**
	 * Funcion ronda que crea la decision y setea la decision en el objeto.
	 */
	public void ronda() {
		Decision decision1 = new Decision();
		setDecision(decision1.decisionesListado());	
	}
	/**
	 * Funcion hasPerdido que si la popularidad o el presupuesto es 0 entonces devuelve true, sino false
	 * @return devuelve estado de tipo boolean
	 */
	public boolean hasPerdido() {
		if(getPresupuesto()==0||getPopularidad()==0) {
			this.estado=true;
		}
		return this.estado;
	}
	/**
	 * Funcion que devuelve el ArrayList de decisiones
	 * @return getDecision()
	 */
	public ArrayList<Decision> getDecisiones() {
		return getDecision();
		
	}
	/**
	 * Funcion que devuelve el ArrayList de decisiones
	 * @return decision
	 */
	public ArrayList<Decision> getDecision() {
		return decision;
	}
	/**
	 * Funcion setDecision que crea una nueva ArrayList<Decicion
	 * @param decision de tipo ArrayList<Decision>
	 */
	public void setDecision(ArrayList<Decision> decision) {
		this.decision = decision;
	}
	
	
}
