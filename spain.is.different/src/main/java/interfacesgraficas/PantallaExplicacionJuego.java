package interfacesgraficas;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import clases.DecisionTomada;
import clases.Evento;
import clases.MegaProyectos;
import clases.Partida;
import exceptions.TextoVacioException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PantallaExplicacionJuego extends JPanel{

	private Ventana ventana;
	private JTextField textField;
	private String explicacion="<html><p align=\"center\">Spain is different es un juego de toma de decisiones y gestion de recursos,"
			+ " jugaras en el papel de presidente o del propio gobierno y tendras que evitar que España "
			+ "se vaya a la quiebra(evitando que el presupuesto llegue a 0) y evitando que te echen del poder"
			+ "(tu popularidad llega a 0).</p></br></br>"
			+ "<p align=\"center\">Ademas tendras que conseguir puntos de Corrupcion que cuantos mas ganes mas alto sera"
			+ " tu puntuacion.</p></br></br>"
			+ "<p align=\"center\">Tu partida se vera afectada por eventos que tendran efectos en tu presupuesto, popularidad"
			+ " y puntos de corrupcion asi que tenlo en cuenta en tus decisiones!!!</p></br></br>"
			+ "<p align=\"center\">Tendras tambien la oportunidad de construir megaproyectos que se desbloquearan segun tus"
			+ " decisiones y que tienen un coste inicial monetario y tendran efectos positivos en tu puntuacion.</p></br></br>"
			+ "<p align=\"center\">¡Sin mas dilacion, a jugar!</p></html>";
	
	
	public PantallaExplicacionJuego (Ventana v) {
		this.ventana=v;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 129, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 40, 16, 0, 189, 0, 0, 16, 0, 0, 34, 38, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("\u00BFComo se juega?");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 36));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 7;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(explicacion);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.gridwidth = 13;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dale un nombre a tu partida");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 7;
		gbc_lblNewLabel_2.gridy = 8;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 7;
		gbc_textField.gridy = 9;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Iniciar Partida");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				String nombrePartida=textField.getText();
				
				//Crear nueva partida aqui
				//iniciar array list
				ArrayList<DecisionTomada> decisionYaTomadas = new ArrayList<DecisionTomada>();
				ArrayList<MegaProyectos> megaProyectosConstruidos = new ArrayList<MegaProyectos>();
				ArrayList<Evento> eventosSurgidos = new ArrayList<Evento>();
				//---------------------------------------------------------------------------------------
				//Añadir nombrePartida
				
				
				Partida p=new Partida(0,10000,(byte)60,ventana.usuarioLogado,nombrePartida,decisionYaTomadas,megaProyectosConstruidos,eventosSurgidos);
				System.out.println("esta?");
				ventana.irAPantalla("nuevaPartida",p);
				p.ronda();
				}catch(TextoVacioException e22) {
					JOptionPane.showMessageDialog(ventana, e22.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 10;
		add(btnNewButton, gbc_btnNewButton);
		
	}
}
