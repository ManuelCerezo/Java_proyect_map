
public class Creencia extends Principal{
	
	int IDPer ; //Personaje asociado
	
	
	boolean [][] objetosLoc = new boolean[lugares.size()][objetos.size()] ;
	boolean [][] perLoc = new boolean[lugares.size()][personajes.size()];
	boolean [][] objetosPer = new boolean[personajes.size()][objetos.size()];
	int i = 0;
	int j = 0;
	
	public void objetosLocINI() {
		
		for(i=0; i < lugares.size(); i++) { 
			
			for(j=0; j < objetos.size(); j++) {
				objetosLoc[i][j] = false;
			}
		}
	}
	public void perLoc() {
		
		for(i=0; i < lugares.size(); i++) { 
			
			for(j=0; j < personajes.size(); j++) {
				perLoc[i][j] = false;
			}
		}
	}
	public void objetosPer() {
	
		for(i=0; i < personajes.size(); i++) { 
			
			for(j=0; j < objetos.size(); j++) {
				objetosPer[i][j] = false;
			}
		}
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
}
