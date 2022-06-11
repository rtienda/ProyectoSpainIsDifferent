package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.ContraseñaIncorrectaException;
import exceptions.EmailYaExisteException;
import exceptions.TextoVacioException;
import exceptions.UsuarioNoExisteException;
import utils.ConexionBD;
/**
 * Clase Usuario que se encargara de crear el usuario que se loguee o se registre en nuestro programa en la base de datos
 * @author Rafa
 *
 */
public class Usuario {
	/**
	 * Variable email de tipo String que recogera el email del usuario
	 */
	private String email;
	/**
	 * Variable nombreUsuario de tipo String que recogera el nombre del usuario
	 */
	private String nombreUsuario;
	/**
	 * Variable contraseña de tipo String que recogera la contraseña del usuario
	 */
	private String contraseña;

	/**
	 * Constructor usuario se encargara de crear un objeto usuario e insertarlo en la bbdd.
	 * @param email de tipo String recogera el dato del email usuario
	 * @param nombreUsuario de tipo String recogera el dato del nombre del usuario
	 * @param contraseña de tipo String recogera el dato de la contraseña del usuario
	 * @throws SQLException ocurrira si no se puede conectar a la bbdd
	 * @throws EmailYaExisteException ocurrira si el email que se quiere registrar ya existe en la bbdd
	 * @throws TextoVacioException ocurrira si algun texto se queda vacio.
	 */
	public Usuario(String email, String nombreUsuario, String contraseña) throws SQLException, EmailYaExisteException, TextoVacioException {
		super();

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from usuario where email='" + email + "'");
		if (cursor.next()) {
			this.email = cursor.getString("email");
			if (email.isBlank()||contraseña.isBlank()||nombreUsuario.isBlank()) {
				ConexionBD.desconectar();
				throw new TextoVacioException("Ningun campo puede estar vacio");
			}
			if (this.email.equals(email)) {
				ConexionBD.desconectar();
				throw new EmailYaExisteException("El email ya existe en la Base de Datos");
			}
			
		}else {
		if (smt.executeUpdate(
				"insert into usuario values('" +email  + "','" + nombreUsuario + "','" + contraseña + "')") > 0) {
			// Solo si todo ha ido bien insertando, se modifican las variables internas
			this.nombreUsuario = nombreUsuario;
			this.email = email;
			this.contraseña = contraseña;

		} else {
			// Si no se ha podido insertar, lanzo un error: Algo ha ido mal.
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido crear un nuevo usuario");
		}
		ConexionBD.desconectar();
		}
	}

	/**
	 * Constructor Usuario que se encargara de comprobar si el usuario y la contraseña si existen en la bbdd
	 * @param email de tipo String recogera el dato del email usuario
	 * @param contraseña de tipo String recogera el dato de la contraseña del usuario
	 * @throws SQLException ocurrira si no se puede conectar a la bbdd
	 * @throws UsuarioNoExisteException ocurrira si el usuario no existe en la bbdd
	 * @throws ContraseñaIncorrectaException ocurrira si la contraseña no coincide con la que esta en la bbdd
	 */
	public Usuario(String email, String contraseña) throws SQLException, UsuarioNoExisteException, ContraseñaIncorrectaException{

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from usuario where email='" + email + "'");
		if (cursor.next()) {
			this.contraseña = cursor.getString("contraseña");
			if (!this.contraseña.equals(contraseña)) {
				ConexionBD.desconectar();
				throw new ContraseñaIncorrectaException("La contraseña no es correcta");
			}
			this.email = cursor.getString("email");
			this.nombreUsuario = cursor.getString("nombreUsuario");
		} else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException("No existe ese email en la BD");
		}
		ConexionBD.desconectar();
	}
	
	
	
	
	/**
	 * Funcion getEmail que devolvera el email del objeto
	 * @return email del usuario
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Funcion setEmail que reemplazara el valor del email por el nuevo valor que se le pasa por el parametro
	 * @param email de tipo String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Funcion getNombreUsuario que devolvera el nombre del usuario del objeto
	 * @return nombre del usuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * Funcion setNombreUsuario que reemplazara el valor del nombre del usuario por el nuevo valor que se le pasa por el parametro
	 * @param nombreUsuario de tipo String
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Funcion getContraseña que devolvera la contraseña del objeto
	 * @return contraseña del usuario
	 */
	public String getContraseña() {
		return contraseña;
	}
	/**
	 * Funcion setContraseña que reemplazara el valor de la contraseña por el nuevo valor que se le pasa por el parametro
	 * @param contraseña de tipo String
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
