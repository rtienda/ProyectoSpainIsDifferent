package clases;

public class Usuario {
	private String email;
	private String nombreUsuario;
	private String contrase�a;
	
	public Usuario(String email, String nombreUsuario, String contrase�a) {
		super();
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
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
