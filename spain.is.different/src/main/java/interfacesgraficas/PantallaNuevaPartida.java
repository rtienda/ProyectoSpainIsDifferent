package interfacesgraficas;

import javax.swing.JPanel;

import clases.Decision;
import clases.MegaProyectos;
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

/**
 * Clase PantallaNuevaPartida que extiende JPanel, en esta pantalla se forma el display de la partida con sus variables, preguntas, decisiones, eventos y megaproyectos
 * @author Rafa
 *
 */
public class PantallaNuevaPartida extends JPanel{

	/**
	 * Variable ventana  de tipo Ventana donde se guardará la variable JFrame que vendrá pasado por las funciones.
	 */
	private Ventana ventana;
	
	/**
	 * Variable decisiones de tipo ArrayList<Decisiones> que guardara el listado de decisiones
	 */
	private ArrayList<Decision> decisiones;
	/**
	 * Variable respuestas de tipo ArrayList<Respuesta> que guardara el listado de respuestas
	 */
	protected ArrayList<Respuesta> respuestas;
	/**
	 * Variable pregunta de tipo String que servira para mostrar la pregunta actual en la ventana
	 */
	private String pregunta;
	/**
	 * Variable respuesta1 de tipo String que servira para mostrar la respuesta en la ventana
	 */
	private String respuesta1;
	/**
	 * Variable respuesta2 de tipo String que servira para mostrar la respuesta en la ventana
	 */
	private String respuesta2;
	/**
	 * Variable respuesta3 de tipo String que servira para mostrar la respuesta en la ventana
	 */
	private String respuesta3;
	/**
	 * Variable ArrayList<String> modificadores que servira para almacenar todos los String modificadores de respuesta
	 */
	private ArrayList<String> modificadores = new ArrayList<String>();
	private JLabel preguntaLabel = new JLabel();
	private JButton respuesta1Label = new JButton();
	private JButton respuesta2Label = new JButton();
	private JButton respuesta3Label = new JButton();
	private JLabel presupuesto = new JLabel();
	private JLabel popularidad = new JLabel();
	private JLabel corrupcion = new JLabel();
	private JButton botonAve = new JButton();
	private JButton botonHospital = new JButton();
	private JButton botonMetro = new JButton();
	private JButton botonAeropuerto = new JButton();
	
	
	
	
	/**
	 * Contructor PantallaNuevaPartida donde se creara la pagina de la partida y se haran las decisiones de la partida
	 * @param v de tipo Ventana que pasara la variable de la ventana donde estara el panel
	 * @param p de tipo Partida que pasara la variable de la partida que se ha creado.
	 */
	public PantallaNuevaPartida (Ventana v,Partida p) {
		this.ventana=v;
		p.ronda();
		decisiones=p.getDecisiones();
		

		siguientePaso(p);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{41, 42, 0, 32, 26, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{16, 0, 31, 0, 38, 0, 38, 6, 38, 6, 38, 20, 32, 0, 0, 0, 0, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gobierno de "+p.getNombrePartida());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 17;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Presupuesto");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		presupuesto = new JLabel(String.valueOf(p.getPresupuesto())+" MM€");
		presupuesto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_presupuesto = new GridBagConstraints();
		gbc_presupuesto.anchor = GridBagConstraints.WEST;
		gbc_presupuesto.insets = new Insets(0, 0, 5, 5);
		gbc_presupuesto.gridx = 3;
		gbc_presupuesto.gridy = 2;
		add(presupuesto, gbc_presupuesto);
		
		JLabel lblNewLabel_2 = new JLabel("Popularidad");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		popularidad = new JLabel(String.valueOf(p.getPopularidad())+" %");
		GridBagConstraints gbc_popularidad = new GridBagConstraints();
		gbc_popularidad.insets = new Insets(0, 0, 5, 5);
		gbc_popularidad.gridx = 6;
		gbc_popularidad.gridy = 2;
		add(popularidad, gbc_popularidad);
		
		JLabel lblNewLabel_3 = new JLabel("Corrupcion");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 8;
		gbc_lblNewLabel_3.gridy = 2;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		corrupcion = new JLabel(String.valueOf(p.getPuntosCorrupcion()));
		GridBagConstraints gbc_corrupcion = new GridBagConstraints();
		gbc_corrupcion.insets = new Insets(0, 0, 5, 5);
		gbc_corrupcion.gridx = 9;
		gbc_corrupcion.gridy = 2;
		add(corrupcion, gbc_corrupcion);
		
		preguntaLabel = new JLabel(this.pregunta);
		preguntaLabel.setBackground(Color.GRAY);
		preguntaLabel.setForeground(Color.BLACK);
		preguntaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_preguntaLabel = new GridBagConstraints();
		gbc_preguntaLabel.gridwidth = 19;
		gbc_preguntaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_preguntaLabel.gridx = 1;
		gbc_preguntaLabel.gridy = 4;
		add(preguntaLabel, gbc_preguntaLabel);
		
		respuesta1Label = new JButton(this.respuesta1);
		respuesta1Label.addMouseListener(new MouseAdapter() {
			/**
			 * Funcion mouseClicked en ella se llamaran a las funciones que realizaran todos los eventos al seleccionar la respuesta
			 * @param e de tipo MouseEvent que le pasara el evento de raton
			 */
			public void mouseClicked(MouseEvent e) {
				operaciones(p,(byte) 0);
				limpieza();
				siguientePaso(p);
				decisionOp(p);

			}
		});
		GridBagConstraints gbc_respuesta1Label = new GridBagConstraints();
		gbc_respuesta1Label.fill = GridBagConstraints.BOTH;
		gbc_respuesta1Label.gridwidth = 19;
		gbc_respuesta1Label.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta1Label.gridx = 1;
		gbc_respuesta1Label.gridy = 6;
		add(respuesta1Label, gbc_respuesta1Label);
		
		respuesta2Label = new JButton(respuesta2);
		respuesta2Label.addMouseListener(new MouseAdapter() {
		
			/**
			 * Funcion mouseClicked en ella se llamaran a las funciones que realizaran todos los eventos al seleccionar la respuesta
			 * @param e de tipo MouseEvent que le pasara el evento de raton
			 */
			public void mouseClicked(MouseEvent e) {
				operaciones(p,(byte) 1);
				limpieza();
				siguientePaso(p);
				decisionOp(p);

			}
		});
		GridBagConstraints gbc_respuesta2Label = new GridBagConstraints();
		gbc_respuesta2Label.fill = GridBagConstraints.BOTH;
		gbc_respuesta2Label.gridwidth = 19;
		gbc_respuesta2Label.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta2Label.gridx = 1;
		gbc_respuesta2Label.gridy = 8;
		add(respuesta2Label, gbc_respuesta2Label);
		
		respuesta3Label = new JButton(respuesta3);
		respuesta3Label.addMouseListener(new MouseAdapter() {

			/**
			 * Funcion mouseClicked en ella se llamaran a las funciones que realizaran todos los eventos al seleccionar la respuesta
			 * @param e de tipo MouseEvent que le pasara el evento de raton
			 */
			public void mouseClicked(MouseEvent e) {
				operaciones(p,(byte) 2);
				limpieza();
				siguientePaso(p);
				decisionOp(p);
				
			}
		});
		GridBagConstraints gbc_respuesta3Label = new GridBagConstraints();
		gbc_respuesta3Label.fill = GridBagConstraints.BOTH;
		gbc_respuesta3Label.gridwidth = 19;
		gbc_respuesta3Label.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta3Label.gridx = 1;
		gbc_respuesta3Label.gridy = 10;
		add(respuesta3Label, gbc_respuesta3Label);
		
		JLabel lblNewLabel_4 = new JLabel("MegaProyectos disponibles");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 4;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 12;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		botonAve = new JButton("Nuevo Ave");
		botonAve.setEnabled(false);
		
		botonAve.addMouseListener(new MouseAdapter() {
			/**
			 * Boton en construccion para construir el megaProyecto
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				botonAve.setEnabled(false);
			}
		});
		GridBagConstraints gbc_botonAve = new GridBagConstraints();
		gbc_botonAve.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonAve.insets = new Insets(0, 0, 5, 5);
		gbc_botonAve.gridx = 2;
		gbc_botonAve.gridy = 14;
		add(botonAve, gbc_botonAve);
		
		JLabel textoAve = new JLabel("Te permitira ganar gran popularidad sobre todo de trabajadores de la Meseta!");
		GridBagConstraints gbc_textoAve = new GridBagConstraints();
		gbc_textoAve.anchor = GridBagConstraints.WEST;
		gbc_textoAve.gridwidth = 14;
		gbc_textoAve.insets = new Insets(0, 0, 5, 5);
		gbc_textoAve.gridx = 4;
		gbc_textoAve.gridy = 14;
		add(textoAve, gbc_textoAve);
		
		botonHospital = new JButton("Hospital de pandemia");
		botonHospital.setEnabled(false);
		botonHospital.addMouseListener(new MouseAdapter() {
			/**
			 * Boton en construccion para construir el megaProyecto
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				botonHospital.setEnabled(false);
			}
		});
		GridBagConstraints gbc_botonHospital = new GridBagConstraints();
		gbc_botonHospital.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonHospital.insets = new Insets(0, 0, 5, 5);
		gbc_botonHospital.gridx = 2;
		gbc_botonHospital.gridy = 15;
		add(botonHospital, gbc_botonHospital);
		
		JLabel textoHospital = new JLabel("Dadas las circunstancias, nuevo Hospital mas parecido a un hangar, no tiene ni para hacer cirugia");
		GridBagConstraints gbc_textoHospital = new GridBagConstraints();
		gbc_textoHospital.anchor = GridBagConstraints.WEST;
		gbc_textoHospital.gridwidth = 14;
		gbc_textoHospital.insets = new Insets(0, 0, 5, 5);
		gbc_textoHospital.gridx = 4;
		gbc_textoHospital.gridy = 15;
		add(textoHospital, gbc_textoHospital);
		
		botonMetro = new JButton("Metro que nadie pidio");
		botonMetro.setEnabled(false);
		botonMetro.addMouseListener(new MouseAdapter() {
			/**
			 * Boton en construccion para construir el megaProyecto
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				botonMetro.setEnabled(false);
			}
		});
		GridBagConstraints gbc_botonMetro = new GridBagConstraints();
		gbc_botonMetro.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonMetro.insets = new Insets(0, 0, 5, 5);
		gbc_botonMetro.gridx = 2;
		gbc_botonMetro.gridy = 16;
		add(botonMetro, gbc_botonMetro);
		
		JLabel textoMetro = new JLabel("Metro a medio construir que eventualmente se abandonara e inundara, no es nuestra culpa");
		GridBagConstraints gbc_textoMetro = new GridBagConstraints();
		gbc_textoMetro.anchor = GridBagConstraints.WEST;
		gbc_textoMetro.gridwidth = 14;
		gbc_textoMetro.insets = new Insets(0, 0, 5, 5);
		gbc_textoMetro.gridx = 4;
		gbc_textoMetro.gridy = 16;
		add(textoMetro, gbc_textoMetro);
		
		botonAeropuerto = new JButton("Aeropuerto sin Licencia");
		botonAeropuerto.setEnabled(false);
		botonAeropuerto.addMouseListener(new MouseAdapter() {
			/**
			 * Boton en construccion para construir el megaProyecto
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				botonAeropuerto.setEnabled(false);
			}
		});
		GridBagConstraints gbc_botonAeropuerto = new GridBagConstraints();
		gbc_botonAeropuerto.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonAeropuerto.insets = new Insets(0, 0, 5, 5);
		gbc_botonAeropuerto.gridx = 2;
		gbc_botonAeropuerto.gridy = 17;
		add(botonAeropuerto, gbc_botonAeropuerto);
		
		JLabel textoAeropuerto = new JLabel("Primero construyelo y luego ya veremos y sino pues fue otro");
		GridBagConstraints gbc_textoAeropuerto = new GridBagConstraints();
		gbc_textoAeropuerto.anchor = GridBagConstraints.WEST;
		gbc_textoAeropuerto.gridwidth = 14;
		gbc_textoAeropuerto.insets = new Insets(0, 0, 5, 5);
		gbc_textoAeropuerto.gridx = 4;
		gbc_textoAeropuerto.gridy = 17;
		add(textoAeropuerto, gbc_textoAeropuerto);

	}

	
	/**
	 * Funcion siguientePaso en la que se comprueba si se ha perdido o ganado la partida en cada click sobre una respuesta, ademas se reestablecen las siguientes respuestas y decisiones.
	 * @param p de tipo Partida, se le pasara la variable de la partida actual.
	 */
	public void siguientePaso(Partida p) {
	
		
		if(p.getPresupuesto()<=0||p.getPopularidad()<=0) {
			JOptionPane.showMessageDialog(ventana,"Has Perdido la partida, puedes probar suerte de nuevo",
					"Mala suerte :(",JOptionPane.INFORMATION_MESSAGE);
			ventana.irAPantalla("menuPrincipal");
		
		}else if(decisiones.isEmpty()){
			JOptionPane.showMessageDialog(ventana,"Has ganado con una score de :"+p.getPuntosCorrupcion()+ventana.usuarioLogado.getNombreUsuario(),
					"Juego Terminado",JOptionPane.INFORMATION_MESSAGE);
			ventana.irAPantalla("menuPrincipal");
		}else {
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
		}
	}
	
	/**
	 * Funcion operaciones, realizara las operciones de suma y resta de los valores presupuesto, popularidad y corrupcion
	 * @param p de tipo Partida, se le pasara la variable de la partida actual.
	 * @param num de tipo byte se le pasara el numero de la respuesta 
	 */
	public void operaciones (Partida p, byte num) {
		if(megaProyectoValido(respuestas.get(num).getModificador())) {
			//Pendiente
		}
		if (num>=0&&num<=2) {
			p.sumarPresupuesto(respuestas.get(num).getPresupuesto());
			p.sumarPopularidad(respuestas.get(num).getPopularidad());
			p.sumarPuntosCorrupcion(respuestas.get(num).getPuntosCorrupcion());
		}
		this.presupuesto.setText(p.getPresupuesto()+" MM€");
		this.popularidad.setText(p.getPopularidad()+" %");
		this.corrupcion.setText(String.valueOf(p.getPuntosCorrupcion()));

	}
	
	/**
	 * Funcion decisionOp suma los valores de las decisiones a las variables de la partida y actualiza los textos
	 * @param p de tipo Partida, se le pasara la variable de la partida actual.
	 */
	public void decisionOp (Partida p) {
		try {
		p.sumarPresupuesto(Math.round(decisiones.get(0).getPresupuesto()*decisiones.get(0).getModificadorPresupuesto()));
		p.sumarPopularidad((byte)Math.round(decisiones.get(0).getPopularidad()*decisiones.get(0).getModificadorPopularidad()));
		p.sumarPuntosCorrupcion(Math.round(decisiones.get(0).getModificadorCorrupcion()*decisiones.get(0).getModificadorPresupuesto()));
		this.presupuesto.setText(Math.round(p.getPresupuesto())+" MM€");
		this.popularidad.setText(p.getPopularidad()+" %");
		this.corrupcion.setText(String.valueOf(Math.round((p.getPuntosCorrupcion()))));
		
			if(p.getPresupuesto()<=0||p.getPopularidad()<=0) {
				JOptionPane.showMessageDialog(ventana,"Has Perdido la partida",
					"Haber estudiao",JOptionPane.INFORMATION_MESSAGE);
				ventana.irAPantalla("menuPrincipal");
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Error controlado");
		}
	}
	/**
	 * Funcion limpieza, limpia el array respuestas y quita la primera decision del array decisiones
	 */
	public void limpieza () {
		decisiones.remove(0);
		respuestas=null;
	}
	/**
	 * Funcion megaProyectoValido en construccion se encarga de validar si algun proyecto es valido cogiendo los resultado de las respuestas
	 * @param modificador de tipo String que se le pasara de la respuesta elegida
	 * @return boolean, devuelve si el proyecto es valido o no.
	 */
	public boolean megaProyectoValido(String modificador) {
		modificadores.add(modificador);
		//Pendiente
		return false;
	}
	
}
