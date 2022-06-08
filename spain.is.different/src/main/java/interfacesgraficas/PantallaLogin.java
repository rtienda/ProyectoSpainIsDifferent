package interfacesgraficas;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Usuario;
import exceptions.ContraseñaIncorrectaException;
import exceptions.EmailYaExisteException;
import exceptions.TextoVacioException;
import exceptions.UsuarioNoExisteException;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

/**
 * Clase PantallaLogin es una clase que extendiende JPanel y es la pantalla inicial del programa que nos permite iniciar sesion
 * @author Rafa
 *
 */
public class PantallaLogin extends JPanel{
	/**
	 * Variable ventana  de tipo Ventana donde se guardará la variable JFrame que vendrá pasado por las funciones.
	 */
	private Ventana ventana;
	/**
	 * Variable campoEmail de tipo JTextField donde se recogerá el dato del email del usuario.
	 */
	private JTextField campoEmail;
	/**
	 * Variable campoContraseña de tipo JPasswordField donde se recogerá el dato de la contraseña del usuario.
	 */
	private JPasswordField campoContraseña;

	
	/**
	 * Constructor PantallaLogin que recibe por parametros la variable de tipo Ventana que es la clase del JFrame.
	 * @param v variable de tipo Ventana que recoge la interfaz grafica de la ventana en la que se situara esta interfaz gráfica.
	 */
		public PantallaLogin(Ventana v) {
			this.ventana=v;
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 114, 126, 144, 123, 0, 0};
			gridBagLayout.rowHeights = new int[]{0, 0, 0, 34, 42, 57, 28, 0, 33, 40, 0, 37, 124, 0};
			gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			JLabel lblNewLabel_2 = new JLabel("Bienvenido a...");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 6;
			gbc_lblNewLabel_2.gridy = 2;
			add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Spain is different");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 34));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.gridwidth = 3;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 5;
			gbc_lblNewLabel_3.gridy = 3;
			add(lblNewLabel_3, gbc_lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Inicia sesi\u00F3n o registrate!");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.gridwidth = 3;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 5;
			gbc_lblNewLabel_4.gridy = 5;
			add(lblNewLabel_4, gbc_lblNewLabel_4);
			
			JLabel lblNewLabel = new JLabel("Email");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 5;
			gbc_lblNewLabel.gridy = 6;
			add(lblNewLabel, gbc_lblNewLabel);
			
			campoEmail = new JTextField();
			GridBagConstraints gbc_emailText = new GridBagConstraints();
			gbc_emailText.insets = new Insets(0, 0, 5, 5);
			gbc_emailText.fill = GridBagConstraints.HORIZONTAL;
			gbc_emailText.gridx = 6;
			gbc_emailText.gridy = 6;
			add(campoEmail, gbc_emailText);
			campoEmail.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 5;
			gbc_lblNewLabel_1.gridy = 7;
			add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			campoContraseña = new JPasswordField();
			GridBagConstraints gbc_contraseñaText = new GridBagConstraints();
			gbc_contraseñaText.insets = new Insets(0, 0, 5, 5);
			gbc_contraseñaText.fill = GridBagConstraints.HORIZONTAL;
			gbc_contraseñaText.gridx = 6;
			gbc_contraseñaText.gridy = 7;
			add(campoContraseña, gbc_contraseñaText);
			campoContraseña.setColumns(10);
			
			JButton botonLogin = new JButton("Inicia sesion");
			botonLogin.addMouseListener(new MouseAdapter() {
				
				
				/**
				 * Funcion mouseClicked que se ejecuta cuando recibe el evento del raton en su JButton por su parametro e. Esta funcion inicializa un objeto de clase Usuario en la partida y se lo pasa a la pantalla de menu partida
				 */
				@Override
				public void mouseClicked(MouseEvent e) {
					String email=campoEmail.getText();
					String contraseña=new String(campoContraseña.getPassword());
					try {
						ventana.usuarioLogado=new Usuario(email,contraseña);
						JOptionPane.showMessageDialog(ventana,"Entrando con exito "+ventana.usuarioLogado.getNombreUsuario(),
								"Inicio de sesion con exito",JOptionPane.INFORMATION_MESSAGE);
						ventana.irAPantalla("menuPrincipal");

					} catch (SQLException | ContraseñaIncorrectaException | UsuarioNoExisteException  e1) {
						JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",
								JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
			});
			botonLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_botonLogin = new GridBagConstraints();
			gbc_botonLogin.fill = GridBagConstraints.BOTH;
			gbc_botonLogin.insets = new Insets(0, 0, 5, 5);
			gbc_botonLogin.gridx = 6;
			gbc_botonLogin.gridy = 9;
			add(botonLogin, gbc_botonLogin);
			
			
			JButton botonRegistrar = new JButton("Registrate");
			botonRegistrar.addMouseListener(new MouseAdapter() {
				
				
				
				/**
				 * Funcion mouseClicked que se ejecuta cuando recibe el evento del raton en su JButton por su parametro e. Esta funcion navega al usuario a la pantalla de PantallaRegistro.
				 */
				@Override
				public void mouseClicked(MouseEvent e) {
					ventana.irAPantalla("registro");
				}
			});
			botonRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_botonRegistrar = new GridBagConstraints();
			gbc_botonRegistrar.fill = GridBagConstraints.BOTH;
			gbc_botonRegistrar.insets = new Insets(0, 0, 5, 5);
			gbc_botonRegistrar.gridx = 6;
			gbc_botonRegistrar.gridy = 11;
			add(botonRegistrar, gbc_botonRegistrar);
			
			
			
			
			
		}
	}


