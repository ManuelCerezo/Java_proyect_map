import java.util.Scanner;

public class Gestor extends Principal{

	/* Las funciones del gestor han de ser:
	 * 1. Leer la configuracion inicial
	 * 2. Leer los objetivos
	 * 3. Organizar el sistema de rondas 
	 * 4. Finalizar el juego
	 */
	
	public boolean finJuego = false;
	public int accionesRonda;
	public int contadorRonda = 0;
	public int contadorTurno;
	public int i;
	public String lectura;
	
	public void llamadaGestor(Personaje personaje) {
	
	while(finJuego!=true) {
		
		contadorRonda++; //Cuenta el numero de ronda en el que nos encontramos
		accionesRonda=0; //Cuenta el numero de acciones realizado en cada ronda
		contadorTurno=1;
		
		for(i=0; i <= personajes.size(); i++) {
			
			//Se presenta el menu por el que el jugador decidirá qué hacer
			if (contadorTurno==1) { //en caso de que el jugador sea el primero en jugar
				while (lectura != "1" && lectura != "2" && lectura != "3" && lectura != "4" && lectura != "5" ) {
					System.out.println("Es el turno del jugador numero "+i);
					System.out.println("Escoge lo que quieras hacer: ");
					System.out.println("1. Moverme a otra zona");
					System.out.println("2. Coger un objeto");
					System.out.println("3. Dejar un objeto");
					System.out.println("4. Dar un objeto");
					System.out.println("5. Intercambiar con otro jugador");
					System.out.println("6. Nada");
					//Se recoge que quiere hacer el jugador
					
					
					
					Scanner teclado = new Scanner(System.in);
				    lectura = teclado.nextLine();
				    teclado.close();
				 
					}
				//se ejecuta la funcion correspondiente a lo que quiere hacer el jugador
			    switch (lectura) 
		        {
		            case "1":  moverPer(); //cuando creemos al jugador hay que rellenar los argumentos de las funciones
		                     break;
		            case "2":  cogerObj();
		                     break;
		            case "3":  dejarObj();
		            		 break;         
		            case "4":  darObj();
		                     break;
		            case "5":  intercambioPerPer();
		                     break;
		            case "6":  break;
	
		        }
				
				
				contadorTurno++;
			}
			
		}
		
		
		
		
		
		
		if(accionesRonda==0 || comprobaciones()==1)
			finJuego = true;
	}
	
	
	
	
	}
	
	

}