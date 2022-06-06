package interfacesgraficas;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Usuario;

public class Ventana extends JFrame{

	private JPanel pantallaActual;
	protected Usuario usuarioLogado;
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
		case "nuevaPartida":
			this.pantallaActual=new PantallaNuevaPartida(this);
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}
}
	
	
	

