package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.Contrase�aIncorrectaException;
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
	 * Variable contrase�a de tipo String que recogera la contrase�a del usuario
	 */
	private String contrase�a;

	/**
	 * Constructor usuario se encargara de crear un objeto usuario e insertarlo en la bbdd.
	 * @param email de tipo String recogera el dato del email usuario
	 * @param nombreUsuario de tipo String recogera el dato del nombre del usuario
	 * @param contrase�a de tipo String recogera el dato de la contrase�a del usuario
	 * @throws SQLException ocurrira si no se puede conectar a la bbdd
	 * @throws EmailYaExisteException ocurrira si el email que se quiere registrar ya existe en la bbdd
	 * @throws TextoVacioException ocurrira si algun texto se queda vacio.
	 */
	public Usuario(String email, String nombreUsuario, String contrase�a) throws SQLException, EmailYaExisteException, TextoVacioException {
		super();

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from usuario where email='" + email + "'");
		if (cursor.next()) {
			this.email = cursor.getString("email");
			if (email.isBlank()||contrase�a.isBlank()||nombreUsuario.isBlank()) {
				ConexionBD.desconectar();
				throw new TextoVacioException("Ningun campo puede estar vacio");
			}
			if (this.email.equals(email)) {
				ConexionBD.desconectar();
				throw new EmailYaExisteException("El email ya existe en la Base de Datos");
			}
			
		}else {
		if (smt.executeUpdate(
				"insert into usuario values('" +email  + "','" + nombreUsuario + "','" + contrase�a + "')") > 0) {
			// Solo si todo ha ido bien insertando, se modifican las variables internas
			this.nombreUsuario = nombreUsuario;
			this.email = email;
			this.contrase�a = contrase�a;

		} else {
			// Si no se ha podido insertar, lanzo un error: Algo ha ido mal.
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido crear un nuevo usuario");
		}
		ConexionBD.desconectar();
		}
	}

	/**
	 * Constructor Usuario que se encargara de comprobar si el usuario y la contrase�a si existen en la bbdd
	 * @param email de tipo String recogera el dato del email usuario
	 * @param contrase�a de tipo String recogera el dato de la contrase�a del usuario
	 * @throws SQLException ocurrira si no se puede conectar a la bbdd
	 * @throws UsuarioNoExisteException ocurrira si el usuario no existe en la bbdd
	 * @throws Contrase�aIncorrectaException ocurrira si la contrase�a no coincide con la que esta en la bbdd
	 */
	public Usuario(String email, String contrase�a) throws SQLException, UsuarioNoExisteException, Contrase�aIncorrectaException{

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from usuario where email='" + email + "'");
		if (cursor.next()) {
			this.contrase�a = cursor.getString("contrase�a");
			if (!this.contrase�a.equals(contrase�a)) {
				ConexionBD.desconectar();
				throw new Contrase�aIncorrectaException("La contrase�a no es correcta");
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
	 * Funcion getContrase�a que devolvera la contrase�a del objeto
	 * @return contrase�a del usuario
	 */
	public String getContrase�a() {
		return contrase�a;
	}
	/**
	 * Funcion setContrase�a que reemplazara el valor de la contrase�a por el nuevo valor que se le pasa por el parametro
	 * @param contrase�a de tipo String
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

}
