import java.util.ArrayList;

public class Principal {
	public static ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	public static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	public static ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	public static ArrayList<Creencia> creencias = new ArrayList<Creencia>();
	
    public static void main(String args[]){ //Funcion para la lectura del fichero donde se interpretan las acciones

    	leerFichero();
    	jugar();
    	creencia();
    	
    }
    //------------- Funciones -------------------------------
    
    public static void creencia() {
    	Creencia creencias = new Creencia();
    	creencias.objetosLocINI();
    	creencias.imprimir();
    }
    public static void jugar(){
    	
    	do 
    		rondas();
    	 while ( comprobaciones() != 1);
    	
    	 
    	
    }
    public static void rondas() {
    	// VER PDF LA PARTE DE: DINAMICA DEL JUEGO
    	
    	//actualizaciones(); LLAMAREMOS A TODAS LAS ACTUALIZACIONES(las funciones de actualizar) Y EMPEZAREMOS OTRA VEZ LA RONDA
    }
    
    public static void actualizaciones() {
    	//actualizarcreencia();
    }
    
    public static void leerFichero() {
    	Fichero fichero = new Fichero();
    	fichero.inicializar();
    	fichero.objetivos();
    	//fichero.imprimir(); para debugear
    }
    
   
    public static int comprobaciones(){
    	int i = 0;
    	int chequeo = 0;
    	int chequeo2 = 0;
    	int tablaflagsPL[] = new int[personajes.size()]; // si todo 1: Han completado sus onjetivos
    	int tablaflagsPO[] = new int[personajes.size()]; // si todo 1: Han completado sus onjetivos
    	
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
    	
    	for (int pepito:tablaflagsPL) {
    		if (pepito != 1) {
    			chequeo = 0;
    		}
    		else {
    			chequeo = 1;
    		}
    	}
    	for (int grillo:tablaflagsPO) {
    		if (grillo != 1) {
    			chequeo2 = 0;
    		}
    		else {
    			chequeo2 = 1;
    		}
    	}
    	
    	
    	// IMPRIMIR TABLA DE FLAGS ( para debugear)
    	
    	/*for(int coco:tablaflagsPL){
    		System.out.println("Tabla de flags PL: "+coco);
			}
    	
    	System.out.println("--------------------");
    	
    	for(int coco:tablaflagsPO){
    		System.out.println("Tabla de flags PO: "+coco);
			}*/
    	
    	if(chequeo != 1 && chequeo2 != 1) {
    		return 0;
    	}
    	else {
    		return 1;
    	}
    }
}
