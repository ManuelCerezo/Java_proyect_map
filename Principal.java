import java.util.ArrayList;

public class Principal {
	public static ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	public static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	public static ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	public static ArrayList<Creencia> creencias = new ArrayList<Creencia>();
	//La hacemos estatica para toda la clase
	
    public static void main(String args[]){ //Funcion para la lectura del fichero donde se interpretan las acciones
    	Fichero fichero = new Fichero();
		fichero.inicializar();
		fichero.objetivos();
		fichero.imprimir();
		CreenciasINI();	 
		
	

		//Para imprimir solo los personajes --> fichero.imprimirPer();
    	jugar();
    	
    	
    }
	public static void CreenciasINI() { //Inicializamos las creencias, sus id y las matrices
		int num = 0;
		//Incializamos array de creencias
		for(num = 0 ; num < personajes.size() ; num++) {
			Creencia per = new Creencia();
			per.setIdPer(num);
			creencias.add(per);
		}
		//Inicializamos las matrice de cada objeto dentro del array de creencias
		for(Creencia lali:creencias) {
			//System.out.println(lali.toString());
			lali.matricesINI();
			//lali.imprimir();
			
		}
		
	}
   
    //------------- Funciones -------------------------------
    //Pedir objetos-PENDIENTE DE PROFE
    //mover personaje
    //actualizar creencias (Para cada accion y fuera de estas funciones)
    
    //Intercambiamos el objeto que tiene el personaje por el que se encuentra en el lugar:
    
    public static void moverPer(Personaje personaje) {
    	 int longitud= 0 ;
    	 int numero = 0;
    	 String[] lugar;

    	for(Lugar paco:lugares) {
    		
    		if(paco.getNombre().equals(personaje.getLocalizacion())) {
    			//Este codigo solo funciona para la primera ronda cuando los arrays de creencia estan en false
    			//Hay que implementar el codigo para que se muevan en funcion de las creencias
    			longitud = paco.calcularLongitud();
    			
    			lugar = paco.getAdyaciencias();
    			
    			numero = (int) (Math.random()*longitud);
    			
    			personaje.setLocalizacion(lugar[numero]);
    			
    			
    		}
    	}
    	
    }
    
    
    public static void darObj(Personaje personaje1, Personaje personaje2) {
    	//Suponiendo que es el personaje2 quien da el objeto	
    	int num=0;
    	//String[] nombrePer = new String[personajes.size()];
    	int[] idPer = new int[personajes.size()]; //lista de Id de todos los que haya en la sala
    	int idPerAntigua = personaje2.getIDPer();
    	int idPerNueva = personaje1.getIDPer();
    	int i = 0;
    	int idObj = 0;
    	
		for(Objeto tete:objetos) {		
			//Actualizamos los bolsillos de los personajes	
			
			if (tete.getNombre().equals(personaje2.getBolsillo())) {
				personaje1.setBolsillo(personaje2.getBolsillo());
				tete.setLocalizacion(personaje1.getNombre());
				idObj = tete.getIDObj();
			}
		 }	
			personaje2.setBolsillo(null);
	
			// A C T U A L I Z A R		C R E E N C I A S
			
		for(Personaje teti:personajes) { //Guardamos en un array todos los personajes que hay en la sala
			if(personaje1.getLocalizacion().equals(teti.getLocalizacion())) {
				idPer[num] = teti.getIDPer();
				num++;
			}
		}
		
		for(Creencia apple:creencias) {
			
			for(i=0; i<= idPer.length; i++) {
				if(apple.getIdPer() == idPer[i]) {
					
					apple.actualizarObjPer(idPerNueva,idPerAntigua, idObj);
					
				}
			}
		}
    }			


    
	public static void intercambioPerPer(Personaje personaje1, Personaje personaje2) {		
		String aux;	
		int[] idPer = new int[personajes.size()]; //lista de Id de todos los que haya en la sala
    	int idPerAntigua1 = personaje2.getIDPer();
    	int idPerNueva1 = personaje1.getIDPer();
    	int idPerAntigua2 = personaje1.getIDPer();
    	int idPerNueva2 = personaje2.getIDPer();
    	int i = 0;
    	int num = 0;
    	int idObj1 = 0;
    	int idObj2 = 0;
		
		if(!personaje1.getBolsillo().equals(null)){
    		darObj(personaje1,personaje2);
    	}
		else {
			for(Objeto tete:objetos) {
				aux = personaje1.getBolsillo();
				
				//Actualizamos los bolsillos de los personajes
				
				if (tete.getNombre().equals(personaje2.getBolsillo())) {
					personaje1.setBolsillo(personaje2.getBolsillo());
					idObj1 = tete.getIDObj();
					tete.setLocalizacion(personaje1.getNombre()); // Actualizamos localizacion objeto
				}
				if (tete.getNombre().equals(aux)) {
					personaje2.setBolsillo(aux);
					idObj2 = tete.getIDObj();
					tete.setLocalizacion(personaje2.getNombre());
				}
				
			}
			// A C T U A L I Z A R		C R E E N C I A S
			//Personaje1
			for(Personaje teti:personajes) { 
				if(personaje1.getLocalizacion().equals(teti.getLocalizacion())) { //Guardamos en un array todos los personajes que hay en la sala
					idPer[num] = teti.getIDPer();
					num++;
				}
			}
			for(Creencia apple:creencias) {
				
				for(i=0; i<= idPer.length; i++) {
					if(apple.getIdPer() == idPer[i]) {
						
						apple.actualizarObjPer(idPerNueva1,idPerAntigua1, idObj1);
						apple.actualizarObjPer(idPerNueva2,idPerAntigua2, idObj2);
						
					}
				}
			}
		}
		
	}
    public static void pedirObj() {
    	// SI SE PUEDEN RECHAZAR LOS INTERCAMBIOS ESTA FUNCION HAY QUE HACERLA
    	//SI NO SE PUEDEN RECHAZAR , LA HACEMOS ESTA FUNCION PARA CUANDO PIDAN AL JUGADOR Y PAUSAR EL JUEGO,( estetica )
    }
    
    public static void intercambioPerLug(Personaje personaje) {
    	int aux = 0;
    	for(Objeto i:objetos) {
			if(i.getNombre().equals(personaje.getBolsillo())) {
				i.setLocalizacion(personaje.getLocalizacion());
				aux = i.getIDObj();
			}
				
    		if(i.getLocalizacion().equals(personaje.getLocalizacion()) && i.getIDObj() != aux) {
    			personaje.setBolsillo(i.getNombre()); //Personaje coge el nuevo objeto que habia en el lugar
    			i.setLocalizacion(personaje.getNombre());//La localizacion del nuevo objeto es ahora el bolsillo
    			
    		}
    	}
    }
    public static void cogerObj(Personaje personaje) {
    	
    	
    	if(!personaje.getBolsillo().equals(null)){
    		intercambioPerLug(personaje);
    	}
    	else {
	    	for(Objeto i:objetos) {
	    		if(i.getLocalizacion().equals(personaje.getLocalizacion())) {
	    			personaje.setBolsillo(i.getNombre());
	    			i.setLocalizacion(personaje.getNombre());
	    		}
	    	}
    	}	
    }
    
    public static void dejarObj(Personaje personaje) {
    	
    	for(Objeto i:objetos) {
    		if(i.getNombre().equals(personaje.getBolsillo())) {
    			personaje.setBolsillo(null); //Dejamos a null el bolsillo
    			i.setLocalizacion(personaje.getLocalizacion()); //Localizacion objeto es ahora el lugar donde esta el personaje
    		}
    	}
    }
    
    public static void jugar(){
    	
    	rondas();
    	/*do 
    		rondas();
    	 while ( comprobaciones() != 1);
    	*/
    	 
    	
    }
    public static void rondas() {
    	// VER PDF LA PARTE DE: DINAMICA DEL JUEGO
    	
    	//Realizamos un for each porque cada accion se hara por turnos para cada personaje
		
    	/*for (Personaje papi:personajes) {
    		//cerebro(); ha de ser la funcion que decida que van a hacer los personajes

    	}
		
		Gestor gestores = new Gestor();
		*/

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
