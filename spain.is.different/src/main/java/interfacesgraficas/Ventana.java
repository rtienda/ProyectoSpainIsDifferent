package interfacesgraficas;

import java.awt.Cursor;

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
	public Ventana(){
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		
		
		
		this.setTitle("Spain Is Different");
		this.setIconImage(new ImageIcon("../Imagenes/iconoEspania.png").getImage());
		//this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		//this.setAlway	sOnTop(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.pantallaActual=new PantallaLogin(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
		
	}
	
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
	
	
	

