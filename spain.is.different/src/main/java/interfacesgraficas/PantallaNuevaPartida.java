package interfacesgraficas;

import javax.swing.JPanel;

import clases.Decision;
import clases.Partida;
import clases.Respuesta;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaNuevaPartida extends JPanel{

	private Ventana ventana;
	private ArrayList<Decision> decisiones;
	private ArrayList<Respuesta> respuestas;
	private String pregunta;
	private String respuesta1;
	private String respuesta2;
	private String respuesta3;
	private JLabel preguntaLabel = new JLabel();
	private JButton respuesta1Label = new JButton();
	private JButton respuesta2Label = new JButton();
	private JButton respuesta3Label = new JButton();
	private JLabel presupuesto = new JLabel();
	
	public PantallaNuevaPartida (Ventana v,Partida p) {
		this.ventana=v;
		p.ronda();
		decisiones=p.getDecisiones();

		/*
		decisiones=p.getDecisiones();
		pregunta=decisiones.get(0).getPregunta();
		respuestas=decisiones.get(0).getRespuestas();
		respuesta1=respuestas.get(0).getRespuesta();
		respuesta2=respuestas.get(1).getRespuesta();
		respuesta3=respuestas.get(2).getRespuesta();
		*/
		siguientePaso(p,(byte) 3);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 32, 26, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{16, 31, 0, 38, 0, 38, 6, 38, 6, 38, 0, 0, 0, 0, 0, 0, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Presupuesto");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		presupuesto = new JLabel(String.valueOf(p.getPresupuesto())+" MM€");
		presupuesto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_presupuesto = new GridBagConstraints();
		gbc_presupuesto.anchor = GridBagConstraints.WEST;
		gbc_presupuesto.insets = new Insets(0, 0, 5, 5);
		gbc_presupuesto.gridx = 3;
		gbc_presupuesto.gridy = 1;
		add(presupuesto, gbc_presupuesto);
		
		JLabel lblNewLabel_2 = new JLabel("Popularidad");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel(String.valueOf(p.getPopularidad())+" %");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 6;
		gbc_lblNewLabel_5.gridy = 1;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Corrupcion");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 8;
		gbc_lblNewLabel_3.gridy = 1;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel(String.valueOf(p.getPuntosCorrupcion()));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 9;
		gbc_lblNewLabel_6.gridy = 1;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		preguntaLabel = new JLabel(this.pregunta);
		preguntaLabel.setBackground(Color.GRAY);
		preguntaLabel.setForeground(Color.BLACK);
		preguntaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_preguntaLabel = new GridBagConstraints();
		gbc_preguntaLabel.gridwidth = 20;
		gbc_preguntaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_preguntaLabel.gridx = 1;
		gbc_preguntaLabel.gridy = 3;
		add(preguntaLabel, gbc_preguntaLabel);
		
		respuesta1Label = new JButton(this.respuesta1);
		respuesta1Label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				siguientePaso(p,(byte) 0);

			}
		});
		GridBagConstraints gbc_respuesta1Label = new GridBagConstraints();
		gbc_respuesta1Label.fill = GridBagConstraints.BOTH;
		gbc_respuesta1Label.gridwidth = 20;
		gbc_respuesta1Label.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta1Label.gridx = 1;
		gbc_respuesta1Label.gridy = 5;
		add(respuesta1Label, gbc_respuesta1Label);
		
		respuesta2Label = new JButton(respuesta2);
		respuesta2Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				siguientePaso(p,(byte) 1);

			}
		});
		GridBagConstraints gbc_respuesta2Label = new GridBagConstraints();
		gbc_respuesta2Label.fill = GridBagConstraints.BOTH;
		gbc_respuesta2Label.gridwidth = 20;
		gbc_respuesta2Label.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta2Label.gridx = 1;
		gbc_respuesta2Label.gridy = 7;
		add(respuesta2Label, gbc_respuesta2Label);
		
		respuesta3Label = new JButton(respuesta3);
		respuesta3Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				siguientePaso(p,(byte) 2);
				
				
			}
		});
		GridBagConstraints gbc_respuesta3Label = new GridBagConstraints();
		gbc_respuesta3Label.fill = GridBagConstraints.BOTH;
		gbc_respuesta3Label.gridwidth = 20;
		gbc_respuesta3Label.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta3Label.gridx = 1;
		gbc_respuesta3Label.gridy = 9;
		add(respuesta3Label, gbc_respuesta3Label);

		
		
	}
	
	public void siguientePaso(Partida p, byte num) {
		
		if(!decisiones.isEmpty()) {
		this.pregunta=decisiones.get(0).getPregunta();
		respuestas=decisiones.get(0).getRespuestas();
		//System.out.println("Pregunta: "+this.pregunta);
		this.respuesta1=respuestas.get(0).getRespuesta();
		this.respuesta2=respuestas.get(1).getRespuesta();
		this.respuesta3=respuestas.get(2).getRespuesta();
		//System.out.println(respuestas.size());
		//System.out.println("Respuesta: "+respuesta1);
		this.preguntaLabel.setText(this.pregunta);
		this.respuesta1Label.setText(this.respuesta1);
		this.respuesta2Label.setText(this.respuesta2);
		this.respuesta3Label.setText(this.respuesta3);
		
		if(num==0) {
			p.sumarPresupuesto(respuestas.get(0).getPresupuesto());
			System.out.println(respuestas.get(num).getRespuesta());
			System.out.println(respuestas.get(num).getPresupuesto());
			System.out.println(String.valueOf(p.getPresupuesto()));
			System.out.println("res1");
		}else if (num==1) {
			p.sumarPresupuesto(respuestas.get(1).getPresupuesto());
			System.out.println(respuestas.get(num).getRespuesta());
			System.out.println(respuestas.get(num).getPresupuesto());
			System.out.println(String.valueOf(p.getPresupuesto()));

		}else if(num==2) {
			p.sumarPresupuesto(respuestas.get(2).getPresupuesto());
			System.out.println(respuestas.get(num).getRespuesta());
			System.out.println(respuestas.get(num).getPresupuesto());
			System.out.println(String.valueOf(p.getPresupuesto()));
		}
		
		this.presupuesto.setText(p.getPresupuesto()+" MM€");

		decisiones.remove(0);
		respuestas=null;
		}else {
		JOptionPane.showMessageDialog(ventana,"Juego Terminado "+ventana.usuarioLogado.getNombreUsuario(),
				"Finalizando",JOptionPane.INFORMATION_MESSAGE);
		ventana.irAPantalla("menuPrincipal");
		}
	}
}
