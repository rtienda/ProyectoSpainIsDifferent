package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ConexionBD;

/**
 * Clase Decision donde se crearan las decisiones.
 * @author Rafa
 *
 */
public class Decision extends ElementoConAtributosPorcentuales{
	/**
	 * Variable pregunta de tipo String
	 */
	private String pregunta;
	/**
	 * Variable respuestas de tipo ArrayList<Respuesta> inicializada vacia
	 */
	ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
	/**
	 * Variable idPregunta de tipo short
	 */
	private short idPregunta;
	
	/**
	 * Constructor Decision vacio
	 */
	public Decision() {
		super();
	}
	
	/**
	 * Constructor Decision
	 * @param idPregunta de tipo short
	 * @param puntosCorrupcion de tipo float
	 * @param presupuesto de tipo float
	 * @param popularidad de tipo byte
	 * @param modificadorPresupuesto de tipo float
	 * @param modificadorPopularidad de tipo float
	 * @param modificadorCorrupcion de tipo float
	 * @param pregunta de tipo String
	 * @param respuestas de tipo ArrayList<Respuesta>
	 */
	public Decision(short idPregunta,float puntosCorrupcion, float presupuesto, byte popularidad, float modificadorPresupuesto,
			float modificadorPopularidad, float modificadorCorrupcion, String pregunta,
			ArrayList<Respuesta> respuestas/*, String textoEvento*/) {
		super(puntosCorrupcion, presupuesto, popularidad, modificadorPresupuesto, modificadorPopularidad,
				modificadorCorrupcion);
		this.idPregunta= idPregunta;
		this.pregunta = pregunta;
		this.respuestas = respuestas;

	}
	/**
	 * Funcion getPregunta que devuelve la pregunta
	 * @return pregunta de tipo String
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * Funcion getRespuestas que devuelve el ArrayList de respuestas de la decision
	 * @return respuesta de tipo ArrayList<Respuesta>
	 */
	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}

	/**
	 * Funcion getIdPregunta que devuelve el id de la pregunta
	 * @return idPregunta de tipo short
	 */
	public short getIdPregunta() {
		return idPregunta;
	}

	/**
	 * Funcion decisionesListado, se encarga de recoger las preguntas y las respuestas de cada decision para poder crear un arrayList de decisiones completo para el programa
	 * @return p.getDecision() que devolvera todo el listado de Decisiones.
	 */
	public  ArrayList<Decision> decisionesListado(){
		ResultSet cursor = null;
		Statement smt = ConexionBD.conectar();
		Partida p = new Partida();
		
		try {
			cursor = smt.executeQuery("Select * FROM decision");
			while (cursor.next()) {
				this.idPregunta=cursor.getShort("id");
				this.pregunta=cursor.getString("texto");
				/*
				this.sumarPresupuesto(cursor.getFloat("presupuesto"));
				this.sumarPopularidad(cursor.getByte("popularidad"));
				this.sumarPuntosCorrupcion(cursor.getFloat("puntosCorrupcion"));
				System.out.println(cursor.getFloat("presupuesto"));
				*/

				Statement query2 = ConexionBD.conectar();
				
				ResultSet cursor2 = query2
						.executeQuery("SELECT * FROM respuesta WHERE decision_id =" + this.idPregunta + ";");
				//System.out.println("id: "+idPregunta);
				respuestas = new ArrayList<Respuesta>();
				while(cursor2.next()) {
						
						Respuesta respuesta = new Respuesta(cursor2.getInt("puntosCorrupcion"),
								cursor2.getInt("presupuesto"), cursor2.getByte("popularidad"), 
								cursor2.getString("texto"), cursor2.getString("modificadorCodigo"));
						respuestas.add(respuesta);
						//System.out.println(respuesta);
						
						//System.out.println(respuestas);
						//System.out.println("tamaño: "+respuestas.size());

				}
				Decision decision1= new Decision(this.idPregunta,cursor.getFloat("puntosCorrupcion"),cursor.getFloat("presupuesto"),cursor.getByte("popularidad"),
						getModificadorPresupuesto(),getModificadorPopularidad(),getModificadorCorrupcion(),this.pregunta,respuestas);
				p.getDecision().add(decision1);
				//System.out.println("el tamaño es: "+respuestas.size()+ " -------");
				respuestas=null;
				//System.out.println(p.getDecision());
				cursor2.close();

			}
			cursor.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			ConexionBD.desconectar();
		}
		return p.getDecision();
	}
	/**
	 * Funcion toString que imprimira todos los valores de la decision.
	 */
	public String toString() {
		return "Decision [pregunta=" + pregunta + ", respuestas=" + respuestas
				+ ", idPregunta=" + idPregunta + "]"+super.toString();
	}
	
}
