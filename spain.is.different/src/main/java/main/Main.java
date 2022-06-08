package main;

import interfacesgraficas.Ventana;
import utils.Globals;

public class Main {

	public static void main(String[] args) {
		//El for de buscar, si encuentras -cheating, entonces pones esa global a true.
		//A la hora de llamar a los setter de 
		// TODO Auto-generated method stub
		//System.out.println("Todo esta bien");
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
		Ventana ventana=new Ventana();
	}

}
