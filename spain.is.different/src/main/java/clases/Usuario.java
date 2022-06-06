package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.Contrase�aIncorrectaException;
import exceptions.EmailYaExisteException;
import exceptions.TextoVacioException;
import exceptions.UsuarioNoExisteException;
import utils.ConexionBD;

public class Usuario {
	private String email;
	private String nombreUsuario;
	private String contrase�a;

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
	
	
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

}
