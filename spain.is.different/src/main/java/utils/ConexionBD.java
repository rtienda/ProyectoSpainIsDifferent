package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase ConexionBD nos permite hacer la conexion y desconexion de la base de datos de forma mas sencilla
 * @author Rafa
 *
 */
public abstract class ConexionBD {
	/**
	 * Variable cadenaConexion de tipo String que guarda la ruta de conexion con la BBDD
	 */
	private final static String cadenaConexion = "jdbc:mysql://localhost:3306/spainisdifferent";
	/**
	 * Variable usuarioBD tipo String con la cadena del usuario para conectar la BBDD
	 */
	private final static String usuarioBD = "root";
	/**
	 * Variable passwordBD tipo String con la cadena de la contraseña para conectar la BBDD
	 */
	private final static String passwordBD = "root";
	/**
	 * Variable conexion de tipo Connection
	 */
	private static Connection conexion; // singleton
	
	/**
	 * Funcion conectar que devuelve un valor Statement y crea la conexion con la bbdd
	 * @return
	 */
	public static Statement conectar() {
		try {
			if (conexion == null) {
				conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD);
			}
			return conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Funcion desconectar que no devuelve ningun valor y convierte conexion a null. 
	 */
	public static void desconectar() {
		if(conexion!=null) {
			try {
				conexion.close();
				conexion=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
