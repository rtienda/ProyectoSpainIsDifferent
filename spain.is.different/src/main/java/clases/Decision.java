package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ConexionBD;

public class Decision extends ElementoConAtributosPorcentuales{

	private String pregunta;
	ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
	String textoEvento;
	private short idPregunta;
	
	
	public Decision() {
		super();
	}
	
	public Decision(short idPregunta,float puntosCorrupcion, float presupuesto, byte popularidad, float modificadorPresupuesto,
			float modificadorPopularidad, float modificadorCorrupcion, String pregunta,
			ArrayList<Respuesta> respuestas/*, String textoEvento*/) {
		super(puntosCorrupcion, presupuesto, popularidad, modificadorPresupuesto, modificadorPopularidad,
				modificadorCorrupcion);
		this.idPregunta= idPregunta;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.textoEvento = textoEvento;
	}



	public String getPregunta() {
		return pregunta;
	}



	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}



	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}



	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}



	public String getTextoEvento() {
		return textoEvento;
	}



	public void setTextoEvento(String textoEvento) {
		this.textoEvento = textoEvento;
	}
	
	public short getIdPregunta() {
		return idPregunta;
	}



	public void setIdPregunta(short idPregunta) {
		this.idPregunta = idPregunta;
	}

	
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
	@Override
	public String toString() {
		return "Decision [pregunta=" + pregunta + ", respuestas=" + respuestas + ", textoEvento=" + textoEvento
				+ ", idPregunta=" + idPregunta + "]"+super.toString();
	}
	
	
}
