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
import exceptions.EmailYaExisteException;
import exceptions.TextoVacioException;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
//spain
public class PantallaRegistro extends JPanel{
	private Ventana ventana;
	private JTextField campoEmail;
	private JPasswordField campoContraseña;
	private JTextField campoUsuario;

	public PantallaRegistro(Ventana v) {
		

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel tituloRegistro = new JLabel("Registro");
		tituloRegistro.setFont(new Font("Arial Black", Font.PLAIN, 37));
		GridBagConstraints gbc_tituloRegistro = new GridBagConstraints();
		gbc_tituloRegistro.gridwidth = 3;
		gbc_tituloRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_tituloRegistro.gridx = 1;
		gbc_tituloRegistro.gridy = 1;
		add(tituloRegistro, gbc_tituloRegistro);
		
		JLabel etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setVerticalAlignment(SwingConstants.TOP);
		etiquetaEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_etiquetaEmail = new GridBagConstraints();
		gbc_etiquetaEmail.anchor = GridBagConstraints.EAST;
		gbc_etiquetaEmail.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaEmail.gridx = 1;
		gbc_etiquetaEmail.gridy = 3;
		add(etiquetaEmail, gbc_etiquetaEmail);
		
		campoEmail = new JTextField();
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.gridwidth = 2;
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.gridx = 2;
		gbc_campoEmail.gridy = 3;
		add(campoEmail, gbc_campoEmail);
		campoEmail.setColumns(10);
		
		
		JLabel labelContraseña = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_labelContraseña = new GridBagConstraints();
		gbc_labelContraseña.anchor = GridBagConstraints.EAST;
		gbc_labelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseña.gridx = 1;
		gbc_labelContraseña.gridy = 5;
		add(labelContraseña, gbc_labelContraseña);
		
		campoContraseña = new JPasswordField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.gridwidth = 2;
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContraseña.gridx = 2;
		gbc_campoContraseña.gridy = 5;
		add(campoContraseña, gbc_campoContraseña);
		

		//JButton botonRegistrarse = new JButton("Registrarse");
		
		JButton botonAtras = new JButton("Atr\u00E1s");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.insets = new Insets(0, 0, 5, 5);
		gbc_botonAtras.gridx = 3;
	 	gbc_botonAtras.gridy = 10;
		add(botonAtras, gbc_botonAtras);
		ventana=v;
		
		JLabel labelUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.anchor = GridBagConstraints.EAST;
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 4;
		add(labelUsuario, gbc_labelUsuario);
		
		campoUsuario = new JTextField();
		GridBagConstraints gbc_campoUsuario = new GridBagConstraints();
		gbc_campoUsuario.gridwidth = 2;
		gbc_campoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_campoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoUsuario.gridx = 2;
		gbc_campoUsuario.gridy = 4;
		add(campoUsuario, gbc_campoUsuario);
		campoUsuario.setColumns(10);
		
		JButton botonRegistrarse = new JButton("Registrarse");
		GridBagConstraints gbc_botonRegistrarse = new GridBagConstraints();
		gbc_botonRegistrarse.fill = GridBagConstraints.BOTH;
		gbc_botonRegistrarse.gridwidth = 3;
		gbc_botonRegistrarse.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistrarse.gridx = 1;
		gbc_botonRegistrarse.gridy = 8;
		add(botonRegistrarse, gbc_botonRegistrarse);
		
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreUsuario=campoUsuario.getText();
				String contraseña=new String(campoContraseña.getPassword());
				String email=campoEmail.getText();
				try {
					new Usuario(email,nombreUsuario,contraseña);
					JOptionPane.showMessageDialog(ventana,"Registrado con éxito",
							"Registro Completado",JOptionPane.PLAIN_MESSAGE);
					ventana.irAPantalla("login");
				} catch (SQLException | EmailYaExisteException | TextoVacioException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				//TODO MENSAJE PERSONALIZADO PARA SQLERROR  Y MIRAR MAS ERRORES POSIBLES
			}
		});
	
		
	}
}
