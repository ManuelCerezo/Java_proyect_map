
import javax.swing.JOptionPane;
public class Ronda extends Clase_Compartida {
	
	//static Ventanas ventana = new Ventanas(); //Creamos una ventana Estatica para todas las rondas
	static int op=0;
	static int FlagGlobal = 0;
	
	public static int getOp() {
		return op;
	}

	public static void setOp(int op) {
		Ronda.op = op;
	}

	public static void iniciarronda(){
		
		int i = 0;
		//SE HA INICIALIZADO LA MEMORIA:
	    //personajes.get(0).inicmemoria();
	    //personajes.get(0).mostrarmemoria();
		
		//Comprobar objetivo de personaje.
		//System.out.println("Hola");
		
		Ventanas vent = new Ventanas();
    	vent.ventanaPrincipal();
    	vent.obmenu();
    	vent.ActBcancelar();
    	vent.setNomb();
    	
    	// Actualizar los bolsillos de los personjes al principio del juego
    	
    	for(Objeto ci:objetos) {
    		for(Personaje ca:personajes) {
    			if(ci.getLocalizacion().equals(ca.getNombre())) {
    				ca.setBolsillo(ci.getNombre());
    			}
    		}
    	}
    	
    	do {
    		vent.setLoc(); //Actualizacion Localizacion ventana
    		vent.setBolsi(); //ACtualizacion Bolsillo ventana
    		Ventanas.borrInfo();
    		motorlogicobots();
    		motorlogicoJug();
    		for(Personaje ci:personajes) {
    			System.out.println(ci.toString());
    		}
    	}while(FlagGlobal == 0);
		
		
	}
	
	public static void motorlogicoJug(){
			
			System.out.println("TURNO JUGADOR: ");
			System.out.println("1. Mover a otra localizacion");
			System.out.println("2. Coger un objeto");
			System.out.println("3. Dejar un objeto");
			System.out.println("4. Intercambiar un objeto");
			System.out.println("-----------------------------");
			//System.out.println("La OP en ventana es: "+op);
			//ventana.obmenu();
			//op=Ventanas.getOpcion();
			do {
				do {
				op=Ventanas.getOpcion();
				//System.out.println("NO");
				//System.out.println("La OP en ventana es: "+op);
				System.out.print("");
			}while(op <1 || op > 4);
				System.out.println("La OP en ventana es: "+op);
			//System.out.println("La OP en ventana es: "+op);
			//}while((op <1 )|| (op > 4));
			//System.out.println("El bolsillo es: "+jugador.getBolsillo());
			//System.out.println("La OP en ventana es: "+op);
		}while(selecjug(op)== 1);
		//System.out.println("El bolsillo es: "+jugador.getBolsillo());
	}
	

	public static int selecjug(int opcion){
		int flag = 0; //Control de flags.
		switch(opcion){
		case 1: 
			//Mover a otra localizacion //FUNCIONA CORRECTAMENTE
			movJugador();
			Ventanas.limpiezaOpcion();
			break;
		case 2:
			//Coger objeto
			flag = cogObjJug(); //FUNCIONA CORRECTAMENTE
			Ventanas.limpiezaOpcion();
			break;
		case 3:
			//Dejar objeto
			flag=dejObjJug();
			Ventanas.limpiezaOpcion();
			break;
		case 4:
			//Intercambiar objeto del jugador con un bot.
			flag=cambiarObj();
			Ventanas.limpiezaOpcion();
			break;
			default:
				flag = 1;
				op = 0;
				break;
		}
		if(flag == 1) {
			return 1;
		}else {
			return 0;	
		}
	}
	
	//Funcion intercambiar objeto -> Filtrado de todos los bots que hay en una misma localizacion: ver el objeto que tienen
	public static int cambiarObj(){
		int i = 0;
		int n = 0;
		int op = 0;
		
		Personaje[] cantPer = new Personaje[personajes.size()];
		
		//Escaneo de los bots que hay en una misma localizacion.
		for(i=0;i<personajes.size();i++) {//Filtrado de los jugadores que estan en la misma localizacion
			if(personajes.get(i).getLocalizacion().equals(jugador.getLocalizacion())){
				cantPer[n]= personajes.get(i);
				n++;
			}
		}
		if(n!= 0) {
			imprjug(cantPer,n); //imprimimos los personajes con sus objetos.
			do {
				op = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce la seleccion 0 - "+(n-1)));
			}while(op < 0 || op >=n);
			jugador.intercambiarJugBot(cantPer[op]);
			return 0;	
		}else {
			Ventanas.borrInfo();
			Ventanas.setInfo("No hay ningun Bot en "+jugador.getLocalizacion()+"\n");
			System.out.println("No hay ningun Bot en "+jugador.getLocalizacion());
			return 1;
		}
	}
	
	private static void imprjug(Personaje[] cantPer,int n){
		int i = 0;
		String palabra = "";
		Ventanas.borrInfo();
		for(i=0;i<n;i++) {
			palabra = palabra +cantPer[i].getNombre()+" Tiene : "+cantPer[i].getBolsillo()+"\n";
			System.out.println(cantPer[i].getNombre()+" Tiene : "+cantPer[i].getBolsillo());
		}
		Ventanas.setInfo(palabra);
	}
	
	public static int dejObjJug(){
		int  i = 0;
		
		if(!jugador.getBolsillo().equals("")){
			for(i=0 ;i <objetos.size();i++){
				if(objetos.get(i).getNombre().equals(jugador.getBolsillo())){ //Filtradod de los objetos:
					jugador.dejarob(objetos.get(i)); //funcion propia del personaje principal para dejar el objeto
				}
			}
			return 0;
		}else { //Condicion de si no tiene ningun objeto:
			Ventanas.borrInfo();
			Ventanas.setInfo("Actualmente no tienes ningun Objeto\n");
			return 1;
		}
	}
	public static int cogObjJug() { //Retorna 0 si no hay ningun objeto.
		int i = 0;
		int n = 0;
		int op = 0;
		String palabra = "";
		
		
		Objeto[] cantobj =  new Objeto[objetos.size()];
		
		//Seleccion de objetos disponibles para coger:
		for(i=0;i<objetos.size();i++){ //Filtrado del lugar donde se encuentra.
			if(objetos.get(i).getLocalizacion().equals(jugador.getLocalizacion())){
				cantobj[n] = objetos.get(i);
				n++;
			}
		}
		if(n!=0){
			Ventanas.borrInfo();
			palabra = "Lista de objetos disponibles: \n";
			System.out.println("Lista de objetos disponibles: ");
			for(i=0;i<n;i++){
				//Ventanas.setInfo(i+": "+cantobj[i].getNombre()+"\n");
				palabra = palabra + i+": "+cantobj[i].getNombre()+"\n";
				
				System.out.println(i+": "+cantobj[i].getNombre());
			}
			//palabra = palabra +"-- Escoge un objeto-- \n";
			Ventanas.setInfo(palabra);
			do{
				System.out.println("Escoge un objeto:");
				op = Integer.parseInt(JOptionPane.showInputDialog(null,"Escoge un objeto"));
			}while(op < 0 || op > n); //Correccion de error :)
			jugador.cogerob(cantobj,op);
			return 0;
		}else { //No hay ningun objeto objeto en la sala
			Ventanas.borrInfo();
			Ventanas.setInfo("No hay ningun Objeto en: "+jugador.getLocalizacion()+"\n");
			System.out.println("No hay ningun Objeto en: "+jugador.getLocalizacion());
			return 1;
		}
	//}
}
	
	//movJugador = Mover jugador -> interactuacion del jugador.
	public static void movJugador(){
		int i = 0;
		int n = 0;
		int aux = 0;
		int op = 0;
		String prueba ="";
		//Scanner entrada = new Scanner(System.in);
		//Seleccion de Adyacencias que puede ir.
		for(i=0;i<lugares.size();i++){ //Filtrado del lugar donde se encuentra.
			if(lugares.get(i).getNombre().equals(jugador.getLocalizacion())){
				aux =  lugares.get(i).adyaciencias.length;
				
				Ventanas.borrInfo();
				prueba = "Selecciona uno de estos lugares: \n";
				System.out.println("Selecciona uno de estos lugares:");
				
				
				for(n=0;n<aux;n++) {
					prueba = prueba + (n+": "+lugares.get(i).adyaciencias[n]+"\n");
					System.out.println(n+": "+lugares.get(i).adyaciencias[n]);
				}
				Ventanas.setInfo(prueba);
				do {
					//System.out.print("Introduce donde quieres ir: ");
					op = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce una opcion"));
				}while(op >=aux || op <0);
			jugador.movJug(lugares.get(i),op);	
			return;
			}
		}
		
		//entrada.close();
	}
	
	//-------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------
	
	public static void motorlogicobots(){
		int i = 0;
		int contador = 0;
		//IMPLEMETAR FOR PARA RECORRER TODOS LOS PERSONAJES
		for(i=0;i<personajes.size();i++) {
		if(!personajes.get(i).getObjetivoO().equals(personajes.get(i).getBolsillo())){
			//No tiene el objeto.
			//Comprobar si esta en la misma localizacion del objeto - objetivo
			System.out.println(personajes.get(i).getNombre()+" ha entrado en loglocper()");
			loglocper(personajes.get(i));
			
			contador = 0;
		}else{ //Una vez tenga el objeto objetivo -> Tendrá que irse a la localizacion objetivo  //OBJETIVO LUGAR
			if(!personajes.get(i).getObjetivoL().equals(personajes.get(i).getLocalizacion())){
				logmovper(personajes.get(i));
				contador = 0;
			}else {
				contador++;
				if(contador == personajes.size()) {
					termiandobots();
				}
				
			}
		}
	}
	}
	
	private static void termiandobots(){
		FlagGlobal = 1;
		Ventanas.setInfo("Todos los bots han cumplido su objetivo");
		//System.out.println("Todos los bots han cumplido su objetivo");
	}
	//logmovper = logica mover personaje ->Objetivo Lugar
	private static void logmovper(Personaje persona){
		int i = 0;
		int numeroAleatorio = 0;// (int) (Math.random()*2+1); //Numero aleatorio para las adyacencias
		
			for(i=0;i<lugares.size();i++){ //Filtrado de la localizacion en la que se encuentra,
				if(persona.localizacion.equals(lugares.get(i).getNombre())){
					numeroAleatorio = (int)(Math.random()*(lugares.get(i).adyaciencias.length)); //Elegimos una adyacencia de ellas
					for(Personaje ca:personajes) {
						if(ca.getIDPer() == persona.getIDPer()) {
							ca.MoverPersonaje(numeroAleatorio,lugares.get(i));
						}	
					}
					return;
					}
				}
	}
	
	
	//loglocper = logica localizacion personaje -> Objetivo objeto
	private static void loglocper(Personaje person){
		int i = 0;
		for(Personaje chi:personajes) {
			if(chi.getIDPer() == person.getIDPer()) {
				for(i=0;i<objetos.size();i++){
					if(chi.getObjetivoO().equals(objetos.get(i).getNombre())){ //Filtrado de objeto - objetivo
						if(chi.getLocalizacion().equals(objetos.get(i).getLocalizacion())){ //Filtrado de localizacion - objeto
							//Coger objeto -> pasamos el objeto por parametro.
							if(chi.getBolsillo() != "") { //Es que el personaje lleva un objeto.
								System.out.println(chi.getNombre()+" ha dejado"+ chi.getBolsillo() +"en: "+ chi.getLocalizacion());
								chi.DejarObjeto();
								System.out.println(chi.getNombre()+" ha cogido"+  objetos.get(i).getNombre() + "en: "+ chi.getLocalizacion());
								chi.CogerObjeto(objetos.get(i));
								
							}
							if(chi.bolsillo == "") { //Es que el personaje no tiene ningun objeto
								System.out.println(chi.getNombre()+" ha cogido ["+  objetos.get(i).getNombre() + "] en: "+ chi.getLocalizacion());
								chi.CogerObjeto(objetos.get(i));
								
							}
						}else if(compPerLoc(chi)== 1){
							System.out.println(chi.getNombre()+" ha entrado en logvaper, (mas personas en la sala)");
							logvarper(chi);
							
							//hay que meter la funcion de logBotJug() dentro de logvaper()
						}else if(compPerJug(chi) == 1){ //Comprobar si el bot esta en la misma localizacion del jugador
							System.out.println(chi.getNombre()+" ha entrado en logBotJug(va a solicitar un intercambio al jugador)");
							logBotJug(chi);	
						}else{						//ELSE IF PARA VER SI ESTA EL JUGADOR PRINCIPAL -> INTERCAMBIAR BOT JUGADOR
							System.out.println(chi.getNombre()+" ha entrado en loglocper2(movimiento del personaje)");
							loglocper2(chi);
						}
					}
				}
			}
			
		}
			
	}
	
	//logBotJug =  Logica bot Jugador -> interactuada por los bots
	private static void logBotJug(Personaje per ){
		for(Personaje ci:personajes) {
			if(ci.getIDPer() == per.getIDPer()) {
				if(jugador.getBolsillo().equals(per.getObjetivoO())){
					ci.intercamBotJug(jugador);
				}
			}
			
		}
		
	}
	
	//compPerLoc = comprobar mas personajes en la misma localizacion -> que no sea el mismo.
	private static int compPerLoc(Personaje p) {
		int i = 0;
		for(i=0;i<personajes.size();i++){
			if(p.getLocalizacion().equals(personajes.get(i).getLocalizacion())){
				if(p.getIDPer() != personajes.get(i).getIDPer()){
					if(p.getObjetivoO().equals(personajes.get(i).getBolsillo())) {
						return 1;
					}
					
				}
			}
		} 
		return 0;
	}
	private static int compPerJug(Personaje p) {
		if(p.getLocalizacion().equals(jugador.getLocalizacion())) {
			if(p.getObjetivoO().equals(jugador.getBolsillo())) {
				return 1;
			}
		} 
		return 0;
	}
	
	//logica localizacion personaje 2 -> Objetivo objeto
	private static void loglocper2(Personaje per){
		int i = 0;
		int numeroAleatorio;
		 //No está en la localizacion del objeto. //Ahora toca moverse 
			//Filtrado del lugar donde estamos.
		for(Personaje ci:personajes) {
			if(ci.getIDPer() == per.getIDPer()) {
				for(i=0;i<lugares.size();i++){
					if(ci.getLocalizacion().equals(lugares.get(i).getNombre())){ //Calculamos las adyacencias que tiene la localizacion en la que se encuenta
						numeroAleatorio = (int)(Math.random()*(lugares.get(i).adyaciencias.length)); //Elegimos una de ellas.
						//System.out.println("proxima localizacion de "+per.getNombre()+" es: "+numeroAleatorio);
						
						ci.MoverPersonaje(numeroAleatorio,lugares.get(i));
						System.out.println(ci.getNombre()+" se ha movido ha: "+ci.getLocalizacion());
						return;
					}
				}
			}	
		}
				
	}
	
	//logvarper = logica varios personajes -> Objetivo Objeto
	private static void logvarper(Personaje persona){ // se le pasa por parametro la persona.
		int i = 0;
		int n = 0;
		Personaje[] cantPer = new Personaje[personajes.size()];
		
		for(i=0;i<personajes.size();i++){
			if(persona.getLocalizacion().equals(personajes.get(i).getLocalizacion())){
				if(persona.IDPer != personajes.get(i).IDPer) {
					cantPer[n] = personajes.get(i);
					n++;
				}
			}
		}

		for(Personaje ci:personajes) {
			if(ci.getIDPer() == persona.getIDPer()) {
				for(i=0;i<n;i++) {
					if(ci.getObjetivoO().equals(cantPer[i].getBolsillo())){
						System.out.println(ci.getNombre()+" ha intercambiado ["+ci.getBolsillo() + "] con el objeto ["+ cantPer[i].getBolsillo()+ "] de "+ cantPer[i].getNombre());
						ci.Intercambiar(cantPer[i]);
					}
				}
			}
		}
		
	}
}