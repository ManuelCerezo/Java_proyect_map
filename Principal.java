import java.util.ArrayList;

public class Principal {
	public static ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	public static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	public static ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	
    public static void main(String args[]){ //Funcion para la lectura del fichero donde se interpretan las acciones
    	
    	leerFichero();
    	rondas();
    	
    }
    //Funciones
    public static void leerFichero() {
    	Fichero fichero = new Fichero();
    	fichero.inicializar();
    	fichero.objetivos();
    	fichero.imprimir();
    }
    //1. Comprobacion de objetivos generales.
    //2. Comprobacion de Localizaciones
    //3. Ejecucion en caso de que no se haya cumplido.
    
    public static void rondas(){
    	
    	comprobaciones();
    	
    }
    public static void comprobaciones(){ //HACER DOBLE FOR EACH
    	int i = 0;
    	int tablaflagsPL[] = new int[personajes.size()];
    	int tablaflagsPO[] = new int[personajes.size()];
    	
    	for(Personaje pepino:personajes){
    		if(pepino.getLocalizacion().equals(pepino.getObjetivoL())) {
				tablaflagsPL[i]= 1;
			}
			else {
				tablaflagsPL[i]= 0;
			}
    		for(Objeto melocoton:objetos){
    			if(pepino.getNombre().equals(melocoton.getLocalizacion())){
    				tablaflagsPO[i]= 1;
    			}
    			else {
    				tablaflagsPO[i]= 0;
    			}
    		}
    	}
    	for(int coco:tablaflagsPL){
    		System.out.println("Tabla de flags PL: "+coco);
			}
    	
    	System.out.println("--------------------");
    	
    	for(int coco:tablaflagsPO){
    		System.out.println("Tabla de flags PO: "+coco);
			}
    	
    }
}
