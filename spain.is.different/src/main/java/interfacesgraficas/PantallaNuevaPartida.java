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
	private JLabel preguntaLabel = new JLabel();
	private JButton respuesta1Label = new JButton();
	private JButton respuesta2Label = new JButton();
	private JButton respuesta3Label = new JButton();
	private JLabel presupuesto = new JLabel();
	private JLabel popularidad = new JLabel();
	private JLabel corrupcion = new JLabel();

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
		
		popularidad = new JLabel(String.valueOf(p.getPopularidad())+" %");
		GridBagConstraints gbc_popularidad = new GridBagConstraints();
		gbc_popularidad.insets = new Insets(0, 0, 5, 5);
		gbc_popularidad.gridx = 6;
		gbc_popularidad.gridy = 1;
		add(popularidad, gbc_popularidad);
		
		JLabel lblNewLabel_3 = new JLabel("Corrupcion");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 8;
		gbc_lblNewLabel_3.gridy = 1;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		corrupcion = new JLabel(String.valueOf(p.getPuntosCorrupcion()));
		GridBagConstraints gbc_corrupcion = new GridBagConstraints();
		gbc_corrupcion.insets = new Insets(0, 0, 5, 5);
		gbc_corrupcion.gridx = 9;
		gbc_corrupcion.gridy = 1;
		add(corrupcion, gbc_corrupcion);
		
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
		gbc_respuesta1Label.gridwidth = 20;
		gbc_respuesta1Label.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta1Label.gridx = 1;
		gbc_respuesta1Label.gridy = 5;
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
		gbc_respuesta2Label.gridwidth = 20;
		gbc_respuesta2Label.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta2Label.gridx = 1;
		gbc_respuesta2Label.gridy = 7;
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
		gbc_respuesta3Label.gridwidth = 20;
		gbc_respuesta3Label.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta3Label.gridx = 1;
		gbc_respuesta3Label.gridy = 9;
		add(respuesta3Label, gbc_respuesta3Label);

	}

	
	/**
	 * Funcion siguientePaso en la que se comprueba si se ha perdido o ganado la partida en cada click sobre una respuesta, ademas se reestablecen las siguientes respuestas y decisiones.
	 * @param p de tipo Partida, se le pasara la variable de la partida actual.
	 */
	public void siguientePaso(Partida p) {
	
		if(p.getPresupuesto()<=0||p.getPopularidad()<=0) {
			JOptionPane.showMessageDialog(ventana,"Has Perdido la partida",
					"Haber estudiao",JOptionPane.INFORMATION_MESSAGE);
			ventana.irAPantalla("menuPrincipal");
		
		}else if(decisiones.isEmpty()){
			JOptionPane.showMessageDialog(ventana,"Juego Terminado "+ventana.usuarioLogado.getNombreUsuario(),
				"Finalizando",JOptionPane.INFORMATION_MESSAGE);
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
		p.sumarPresupuesto(decisiones.get(0).getPresupuesto());
		p.sumarPopularidad(decisiones.get(0).getPopularidad());
		p.sumarPuntosCorrupcion(decisiones.get(0).getModificadorCorrupcion());
		this.presupuesto.setText(p.getPresupuesto()+" MM€");
		this.popularidad.setText(p.getPopularidad()+" %");
		this.corrupcion.setText(String.valueOf(p.getPuntosCorrupcion()));
		
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
}
