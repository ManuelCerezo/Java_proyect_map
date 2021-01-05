import java.util.ArrayList;
import java.util.Scanner;

//Definicion de clase unicamente para las comunicaciones entre clases de manera estable.

public class Clase_Compartida { //DEfiniciones de almacenamientos de los objetos
	public static ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	public static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	public static ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	public static JugadorPrincipal jugador;
	
	
	public static void crearjugadorprinipal() {
		
		String nombre;
		String Localizacion;
		String ObjetivoO= "";
		String ObjetivoL = "";
		try (Scanner entradaa = new Scanner(System.in)) {
			int i = 0;
			
			System.out.println("Introduce el nombre del jugador principal");
			nombre = entradaa.nextLine();
			
			System.out.println("Introduce la localizacion deseada:");
			for(i=0;i<lugares.size();i++) {
				System.out.println(lugares.get(i).getNombre());
			}
			do {
			System.out.print("Introduce la localizacion: ");
			Localizacion = entradaa.nextLine();
			}while(compLoc(Localizacion) == 1);
			//Hacer funcion del sistema para que no admita localizaciones erroneas.
			
			//Los objetivos Lugar y Objeto se los debemos preguntar al profesor:
			ObjetivoO = "Ordenador";
			ObjetivoL = "Cocina";
			jugador = new JugadorPrincipal(nombre,Localizacion,ObjetivoO,ObjetivoL);
			//System.out.println("---> "+Localizacion);
		
		entradaa.close();
			}
		}
	
	private static int compLoc(String Localizacion){
		int i = 0;
		int flag = 0;
		
		for (i=0;i<lugares.size();i++) {
			if(Localizacion.equals(lugares.get(i).getNombre())) {
			flag = 1;	
			}
		}
		
		if(flag != 0) {
			return 0;
		}else{
			return 1;	
		}
	}
	
	public static int gettamanioper(){
		return personajes.size();
	}
	public static int gettamaniolugares(){
		return lugares.size();
	}
	public static int gettamaniobjetos(){
		return objetos.size();
	}
	
	

}
