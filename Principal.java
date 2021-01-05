

public class Principal {
	 static Clase_Compartida clase = new Clase_Compartida();
    public static void main(String args[]){ 
    	
	//Primero tenemos que inicialiar el juego con los archivos:
    	inicializar();
    	Clase_Compartida.crearjugadorprinipal();
    	juego();
    }
    
    public static void inicializar() {
    	Fichero fichero = new Fichero();
    	
		Fichero.inicializar();
		fichero.objetivos();
		//Fichero.imprimir();
    	}
    
    public static void juego() { //Creacion de la clase ronda aqui debe estar el bucle infinito
    	Ronda.iniciarronda();
    	
    }
}