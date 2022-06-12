package interfacesgraficas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import clases.DecisionTomada;
import clases.Evento;
import clases.MegaProyectos;
import clases.Partida;

/**
 * Clase PantallaMenuPrincipal clase que extiende JPanel y que consiste en mostrar el menu del programa y sus distintas opciones
 * @author Rafa
 *
 */
public class PantallaMenuPrincipal extends JPanel{
	/**
	 * Variable ventana  de tipo Ventana donde se guardará la variable JFrame que vendrá pasado por las funciones.
	 */
	private Ventana ventana;

	/**
	 * Constructor PantallaMenuPrincipal que recibe por parametros la variable de tipo Ventana que es la clase del JFrame.
	 * @param v variable de tipo Ventana que recoge la interfaz grafica de la ventana en la que se situara esta interfaz gráfica.
	 */
	public PantallaMenuPrincipal(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 91, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{41, 35, 0, 20, 54, 0, 40, 18, 10, 18, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Image imagen=new ImageIcon("../Imagenes/iconoEspania.png").getImage().getScaledInstance(200,175,Image.SCALE_DEFAULT);
		JLabel imageLabel = new JLabel();
		Icon icono = new ImageIcon(imagen);
		imageLabel.setIcon(icono);
		GridBagConstraints gbc_imagen = new GridBagConstraints();
		gbc_imagen.insets = new Insets(0, 0, 5, 5);
		gbc_imagen.gridx = 3;
		gbc_imagen.gridy = 1;
		add(imageLabel, gbc_imagen);
		
		JLabel lblNewLabel = new JLabel("Spain Is Different");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton botonNuevaPartida = new JButton("Nueva Partida");
		botonNuevaPartida.addMouseListener(new MouseAdapter() {
			
			/**
			 * Funcion mouseClicked que se ejecuta cuando recibe el evento del raton en su JButton por su parametro e. Esta funcion lleva al usuario a la pagina previa a la partida, llamada PantallaExplicacionJuego.
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("explicacionJuego");
			}
		});
		
		botonNuevaPartida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_botonNuevaPartida = new GridBagConstraints();
		gbc_botonNuevaPartida.insets = new Insets(0, 0, 5, 5);
		gbc_botonNuevaPartida.gridx = 3;
		gbc_botonNuevaPartida.gridy = 6;
		add(botonNuevaPartida, gbc_botonNuevaPartida);
		
		JButton botonContinuarPartida = new JButton("Continuar Partida");
		botonContinuarPartida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_botonContinuarPartida = new GridBagConstraints();
		gbc_botonContinuarPartida.insets = new Insets(0, 0, 5, 5);
		gbc_botonContinuarPartida.gridx = 3;
		gbc_botonContinuarPartida.gridy = 8;
		add(botonContinuarPartida, gbc_botonContinuarPartida);
		
		JButton botonVerPartidasAnteriores = new JButton("Ver Partidas Anteriores");
		botonVerPartidasAnteriores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_botonVerPartidasAnteriores = new GridBagConstraints();
		gbc_botonVerPartidasAnteriores.insets = new Insets(0, 0, 5, 5);
		gbc_botonVerPartidasAnteriores.gridx = 3;
		gbc_botonVerPartidasAnteriores.gridy = 10;
		add(botonVerPartidasAnteriores, gbc_botonVerPartidasAnteriores);
		
	}
}
