package exceptions;

/**
 * Clase de excepcion UsuarioNoExisteException, servira para cuando queramos loguearnos y no exista el usuario en la bbdd
 * @author Rafa
 *
 */
public class UsuarioNoExisteException extends Exception{
	/**
	 * Constructor UsuarioNoExisteException que devolvera un mensaje que se le pase por parametro
	 * @param m de tipo String recibira un texto y lo imprimira cuando se construya 
	 */
	public UsuarioNoExisteException(String m) {
		super(m);
	}
}
