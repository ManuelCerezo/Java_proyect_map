import java.util.ArrayList;

public class Principal {
	public static ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	public static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	public static ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	
    public static void main(String args[]){ //Funcion para la lectura del fichero donde se interpretan las acciones
    	
    	leerFichero();
    	
    }
    //Funciones
    public static void leerFichero() {
    	Fichero fichero = new Fichero();
    	fichero.inicializar();
    	fichero.objetivos();
    	fichero.imprimir();
    }
    public static void rondas() {
    	
    }
}
