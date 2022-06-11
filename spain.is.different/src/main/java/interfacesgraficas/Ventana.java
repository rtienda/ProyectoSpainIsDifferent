package interfacesgraficas;

import java.awt.Cursor;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Partida;
import clases.Usuario;
/**
 * Clase Ventana extiende JFrame, aqui se define los atributos de la ventana base de nuestro proyecto a nivel de interfaces graficas, aqui definiremos que paneles se iran cambiando
 * @author Rafa
 *
 */
public class Ventana extends JFrame{
	/**
	 * Variable pantallaActual de tipo JPanel será la variable que cotendra la pagina actual que muestre en el JFrame
	 */
	private JPanel pantallaActual;
	/**
	 * Variable usuarioLogado de tipo Usuario que es la variable del objeto que se cree cuando un usuario se loguee con exito en nuestro programa
	 */
	protected Usuario usuarioLogado;
	/**
	 * Variable partida de tipo Partida 
	 */
	protected Partida partida;
	/**
	 * Variable clip de tipo Clip que guarda el AudioInputStream con el que empezaremos la cancion de fondo.
	 */
	protected Clip clip;
	/**
	 * Contructor Ventana que se encargara de construir la ventana base que nos servira de fondo
	 */
	public Ventana(){
	
			try {
				 AudioInputStream audio = AudioSystem.getAudioInputStream(new File("../ArchivosUtiles/MusicaFondo.wav"));
				 this.clip = AudioSystem.getClip();
		            clip.open(audio);
		            clip.start();
		            clip.loop(clip.LOOP_CONTINUOUSLY);
			} catch (UnsupportedAudioFileException | IOException  | LineUnavailableException e) {
				e.printStackTrace();
			}
           
		this.setTitle("Spain Is Different");
		this.setIconImage(new ImageIcon("../Imagenes/iconoEspania.png").getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.pantallaActual=new PantallaLogin(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
	}
	
	
	/**
	 * Funcion irApantalla que cambiara el estado de pantallaActual y dependiendo del valor se enviara a una pantalla o a otra al usuario
	 * @param nombrePantalla de tipo String donde se le pasara el nombre de la pantalla que tiene que seleccionar.
	 */
	public void irAPantalla(String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
		switch(nombrePantalla) {
		case "login":
			this.pantallaActual=new PantallaLogin(this);
			break;
		case "registro":
			this.pantallaActual=new PantallaRegistro(this);
			break;
		case "menuPrincipal":
			this.pantallaActual=new PantallaMenuPrincipal(this);
			break;
		case "explicacionJuego":
			this.pantallaActual=new PantallaExplicacionJuego(this);
			break;
		}
		
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}
	/**
	 * Funcion irApantalla que cambiara el estado de pantallaActual y dependiendo del valor se enviara a una pantalla o a otra al usuario, tambien se le pasara la partida actual
	 * @param nombrePantalla de tipo String donde se le pasara el nombre de la pantalla que tiene que seleccionar.
	 * @param p de tipo Partida que es la variable de partida actual que se usara durante la ejecucion del programa.
	 */
	public void irAPantalla(String nombrePantalla,Partida p) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
		
		switch(nombrePantalla) {
		case "nuevaPartida":
			this.pantallaActual=new PantallaNuevaPartida(this,p);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}
}
	
	
	

