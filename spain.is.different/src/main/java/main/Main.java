package main;

import interfacesgraficas.Ventana;
import utils.Globals;

public class Main {
	
	/**
	 * Main del programa principal del juego Spain Is Different
	 * @param args se le pasara un string de ayuda como help, h o ?. Podra quedarse vacio o podra iniciarse con -truco
	 */
	public static void main(String[] args) {
		//Aqui comprobamos si tiene algun valor pasado por argumentos.
		for(byte i=0;i<args.length;i++) {
			if(args[i].equals("-truco")) {
				Globals.cheating=true;
			}
			if(args[i].equals("h")||args[i].equals("help")||args[i].equals("?")) {
				System.out.println("Juego Spain is different \nArgumento posible:");
				System.out.println("\n\t-truco te permite jugar sin poder perder, todas las decisiones no tienen consecuencias negativas ni en presupuesto ni en popularidad");
				//salir del break
				System.exit(0);
			}
		}
		//Llamamos a la funcion Ventana() creandola asi y ejecutando las interfaces graficas
		Ventana ventana=new Ventana();
	}

}
