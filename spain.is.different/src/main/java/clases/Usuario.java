package clases;

public class Usuario {
	private String email;
	private String nombreUsuario;
	private String contraseña;
	
	public Usuario(String email, String nombreUsuario, String contraseña) {
		super();
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
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
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
