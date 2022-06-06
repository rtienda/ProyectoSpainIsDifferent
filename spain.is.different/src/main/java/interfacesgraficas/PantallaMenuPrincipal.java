package interfacesgraficas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import clases.DecisionTomada;
import clases.Evento;
import clases.MegaProyectos;
import clases.Partida;

public class PantallaMenuPrincipal extends JPanel{

	private Ventana ventana;

	public PantallaMenuPrincipal(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 91, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{41, 0, 0, 20, 54, 0, 40, 18, 10, 18, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				//Crear nueva partida aqui
				//iniciar array list
				ArrayList<DecisionTomada> decisionYaTomadas = new ArrayList<DecisionTomada>();
				ArrayList<MegaProyectos> megaProyectosConstruidos = new ArrayList<MegaProyectos>();
				ArrayList<Evento> eventosSurgidos = new ArrayList<Evento>();
				//---------------------------------------------------------------------------------------
				//Añadir nombrePartida
				/*
				String nombrePartida="";
				new Partida(0,10000,(byte)60,ventana.usuarioLogado,nombrePartida,decisionYaTomadas,megaProyectosConstruidos,eventosSurgidos);
				*/
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
