
public class Creencia extends Principal{
	
	int idPer ; //Personaje asociado
	
	
	boolean [][] objetosLoc = new boolean[lugares.size()][objetos.size()] ;
	boolean [][] perLoc = new boolean[lugares.size()][personajes.size()];
	boolean [][] objetosPer = new boolean[personajes.size()][objetos.size()];
	int i = 0;
	int j = 0;
	
	public void matricesINI() {
		
		for(i=0; i < lugares.size(); i++) { 
			
			for(j=0; j < objetos.size(); j++) {
				objetosLoc[i][j] = false;
			}
		}
		
		for(i=0; i < lugares.size(); i++) { 
					
			for(j=0; j < personajes.size(); j++) {
				perLoc[i][j] = false;
			}
		}
		
		for(i=0; i < personajes.size(); i++) { 
					
			for(j=0; j < objetos.size(); j++) {
				objetosPer[i][j] = false;
			}
		}
	}
	
	public int getIdPer() {
		return idPer;
	}


	public void setIdPer(int idPer) {
		this.idPer = idPer;
	}


	public void actualizarObjPer(int idPer,int idPerAntigua, int idObj) {
		objetosPer[idPerAntigua][idObj]= false; //Borramos la localizacion antigua del objeto
		objetosPer[idPer][idObj] = true;		//Actualizamos localizacion del objeto a su posicion actual
		

	}
	public void actualizarObjetosLoc(int idLoc,int idLocAntigua, int idObj) {
		
		objetosLoc[idLocAntigua][idObj] = false;//Borramos la localizacion antigua del objeto
		objetosLoc[idLoc][idObj] = true;		//Actualizamos localizacion del objeto a su posicion actual
		
	}
	
	public void actualizarPerLoc(int idPer, int idPerAntigua, int idLoc) {
		
		perLoc[idPerAntigua][idLoc] = false;//Borramos la localizacion antigua del personaje
		perLoc[idPer][idLoc] = true;		//Actualizamos la localizacion del personaje
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
			for(j=0; j < personajes.size(); j++) {
				System.out.print(perLoc[i][j]);
			}System.out.println("");
		}
		
		System.out.println("\nMatriz de objetosPer\n");
		
		for(i=0; i < personajes.size(); i++) { 
			for(j=0; j < objetos.size(); j++) {
				System.out.print(objetosPer[i][j]);
			}System.out.println("");
		}
	}

	@Override
	public String toString() {
		return "Creencia [idPer=" + idPer + "]";
	}
	
	
	
}
