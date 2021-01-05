import javax.swing.JOptionPane;

public class Personaje extends Clase_Compartida {
	public String nombre;
	public String bolsillo = ""; //Maria no tiene nada
	public String localizacion;
	public String ObjetivoO="";
	public String ObjetivoL="";
	//Para las creencias, las siguentes matrices: 
	/*
	boolean [][] objetosLoc = new boolean[lugares.size()][objetos.size()] ;
	boolean [][] perLoc = new boolean[lugares.size()][personajes.size()+1]; // Añadimos una posicion para el jugador que no esta contenido en el array de personajes
	boolean [][] objetosPer = new boolean[personajes.size()+1][objetos.size()];
	int i = 0;
	int j = 0;
	*/
	
	int IDPer; //numero de identificacion del personaje
	//private Object memory;
	
	//Memoria memory = new Memoria(); //Cada personaje tiene su propia memoria.
	
	public Personaje(String nombre, String localizacion, int IDPer) { //Constructor
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.IDPer = IDPer;
	}
	
	public void inicmemoria(){
		//((Memoria) this.memory).inicializarmemoria();
	}
	public void mostrarmemoria(){
		//((Memoria) memory).imprimirmemoria();
	}
	
	public void intercamBotJug(JugadorPrincipal jugador){
		int decision = 0;
		String aux;
		
		//Scanner entrada = new Scanner(System.in);
		//System.out.println(this.nombre+"Desea intercambiar su"+this.bolsillo+"por tu "+jugador.getBolsillo()+"\nDesea hacer el intercambio: SI = 1, NO = 0");
		do {
			System.out.println("Desea hacer el intercambio: SI = 1, NO = 0");
			decision = Integer.parseInt(JOptionPane.showInputDialog(null,this.nombre+"Desea intercambiar su"
																					+this.bolsillo+"por tu "
																					+jugador.getBolsillo()+
																					"\nDesea hacer el intercambio: SI = 1, NO = 0"));
		}while(decision  < 0 || decision < 1);
		
		if(decision == 1){ //Realizar el intercambio.
			aux = jugador.getBolsillo();
			jugador.setBolsillo(this.getBolsillo());
			this.setBolsillo(aux);
		}
	}
	
	public void CogerObjeto(Objeto objeto){ //Se le tiene que pasar el objeto que va coger
			this.bolsillo = objeto.nombre;
			for(Objeto ci:objetos) {
				if(ci.getIDObj() == objeto.getIDObj()) {
					ci.localizacion = this.nombre;	
				}
			}
			
	}
	
	public void DejarObjeto(){
		int i = 0;
		for(i=0;i<objetos.size();i++) {
			if(this.bolsillo.equals(objetos.get(i).getNombre())){ //Actualizacion de la localizacion del objeto
				objetos.get(i).setLocalizacion(this.localizacion);
			}
		}
		this.bolsillo = "";
	}

	public void MoverPersonaje(int numero,Lugar lugar){ //Se le tiene que pasar la ubicacion
		this.localizacion = lugar.adyaciencias[numero];
		
	}
	
	public void Intercambiar(Personaje persona){ //Se le tiene que pasar el segundo personaje al que se le va intercambiar el objeto
		//Realizacion del intercambio
		String aux;
		aux = this.getBolsillo();
		this.setBolsillo(persona.getBolsillo());

		for(Personaje ci:personajes) {
			if(ci.getIDPer() == persona.getIDPer() ) {
				ci.setBolsillo(aux);
			}
		}
	}
	
	/*
	//Matrices de creencias 
	//Matrices inicializacion:
	public void matricesINI() {
		
		for(i=0; i < lugares.size(); i++) { 
			
			for(j=0; j < objetos.size(); j++) {
				objetosLoc[i][j] = false;
			}
		}
		
		for(i=0; i < lugares.size(); i++) { 
					
			for(j=0; j < personajes.size()+1; j++) {
				perLoc[i][j] = false;
			}
		}
		
		for(i=0; i < personajes.size()+1; i++) { 
					
			for(j=0; j < objetos.size(); j++) {
				objetosPer[i][j] = false;
			}
		}
	}
	//Actualizacion de matrices: 
	
	public void actualizarObjPer(int idPerAntigua, int idObj) {
		objetosPer[idPerAntigua][idObj]= false; //Borramos la localizacion antigua del objeto
		objetosPer[this.IDPer][idObj] = true;		//Actualizamos localizacion del objeto a su posicion actual
		

	}
	public void actualizarObjetosLoc(int idLoc,int idLocAntigua, int idObj) {
		
		objetosLoc[idLocAntigua][idObj] = false;//Borramos la localizacion antigua del objeto
		objetosLoc[idLoc][idObj] = true;		//Actualizamos localizacion del objeto a su posicion actual
		
	}
	
	public void actualizarPerLoc(int idPerAntigua, int idLoc) {
		
		perLoc[idPerAntigua][idLoc] = false;//Borramos la localizacion antigua del personaje
		perLoc[this.IDPer][idLoc] = true;		//Actualizamos la localizacion del personaje
	}
	
	public void imprimir() {
		
		System.out.println("\nMatriz de objetosLoc\n");
		
		for(i=0; i < lugares.size(); i++) { 
			for(j=0; j < objetos.size(); j++) {
				System.out.print(objetosLoc[i][j]);
			}System.out.println("");
		}
		
		System.out.println("\nMatriz de perLoc\n");
		
		for(i=0; i < lugares.size(); i++) { 
			for(j=0; j < personajes.size()+1; j++) {
				System.out.print(perLoc[i][j]);
			}System.out.println("");
		}
		
		System.out.println("\nMatriz de objetosPer\n");
		
		for(i=0; i < personajes.size()+1; i++) { 
			for(j=0; j < objetos.size(); j++) {
				System.out.print(objetosPer[i][j]);
			}System.out.println("");
		}
	}
	*/
	public int getIDPer() {
		return IDPer;
	}

	public void setIDPer(int iDPer) {
		IDPer = iDPer;
	}

	public String getBolsillo() {
		return bolsillo;
	}

	public void setBolsillo(String bolsillo) {
		this.bolsillo = bolsillo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public String getObjetivoO() {
		return ObjetivoO;
	}
	public void setObjetivoO(String objetivoO) {
		this.ObjetivoO = objetivoO;
	}
	public String getObjetivoL() {
		return ObjetivoL;
	}
	public void setObjetivoL(String objetivoL) {
		this.ObjetivoL = objetivoL;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", bolsillo=" + bolsillo + ", localizacion=" + localizacion
				+ ", ObjetivoO=" + ObjetivoO + ", ObjetivoL=" + ObjetivoL + ", IDPer=" + IDPer + "]";
	}


	
}
