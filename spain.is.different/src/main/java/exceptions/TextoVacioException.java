package exceptions;

/**
 * Clase de excepcion TextoVacioException, servira para cuando queramos acceder a alguna parte del programa pero que necesite tener minimo un caracter en el JTextField.
 * @author Rafa
 *
 */
public class TextoVacioException extends Exception{
	
	/**
	 * Constructor TextoVacioException que devolvera un mensaje que se le pase por parametro
	 * @param m de tipo String recibira un texto y lo imprimira cuando se construya 
	 */
	public TextoVacioException(String m) {
		super(m);
	}
}
