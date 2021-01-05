
public class JugadorPrincipal extends Clase_Compartida { // Atributos personaje principal
	public String nombre;
	public String  bolsillo = "";
	public String localizacion;
	public String ObjetivoO="";
	public String ObjetivoL="";
	
	int Id = personajes.size();
	
	
	public void movJug(Lugar loc,int opcion){
		//Actualizar la localizacion del jugador:
		this.setLocalizacion(loc.adyaciencias[opcion]);
		
	}
	
	public void dejarob(Objeto obj){
		this.setBolsillo("");
		obj.setLocalizacion(this.getLocalizacion());
	}
	public void cogerob(Objeto[] canobj,int op){        //IMPLEMENTAR FUNCION EN COGER SI LLEVA OTRO OBJETO
		int i = 0;
		
		for(i=0;i<objetos.size();i++){ //Actualizamos la localizacion del objeto antiguo
			if(objetos.get(i).getNombre().equals(this.getBolsillo())){
				objetos.get(i).setLocalizacion(this.getLocalizacion());
			}
		}
		
		this.setBolsillo(canobj[op].getNombre()); //Cogemos el objeto nuevo
		
		//Actualizacion de la localizacion del objeto nuevo
		for(i=0;i<objetos.size();i++){
			if(objetos.get(i).getNombre().equals(canobj[op].getNombre())){
				objetos.get(i).setLocalizacion(this.getNombre());
			}
		}
	}
	public void intercambiarJugBot(Personaje bot){
		String aux;
		int i = 0;
		aux = bot.getBolsillo();
		bot.setBolsillo(this.getBolsillo());
		this.setBolsillo(aux);
		
		//Actualizar arrayList de las localizaciones de los objetos.
		for (i=0;i<objetos.size();i++){
			if(objetos.get(i).getNombre().equals(this.getBolsillo())){
				objetos.get(i).setLocalizacion(this.getNombre());
			}
			if(objetos.get(i).getNombre().equals(bot.getBolsillo())){
				objetos.get(i).setLocalizacion(bot.getNombre());
			}
		}
		
	}
	
	public JugadorPrincipal(String nombre, String localizacion, String objetivoO, String objetivoL) { //Constructor de personaje principal
		super();
		this.nombre = nombre;
		this.localizacion = localizacion;
		ObjetivoO = objetivoO;
		ObjetivoL = objetivoL;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getBolsillo() {
		return bolsillo;
	}
	public void setBolsillo(String bolsillo) {
		this.bolsillo = bolsillo;
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
		ObjetivoO = objetivoO;
	}
	public String getObjetivoL() {
		return ObjetivoL;
	}
	public void setObjetivoL(String objetivoL) {
		ObjetivoL = objetivoL;
	}
	@Override
	public String toString() {
		return "JugadorPrincipal [nombre=" + nombre + ", bolsillo=" + bolsillo + ", localizacion=" + localizacion
				+ ", ObjetivoO=" + ObjetivoO + ", ObjetivoL=" + ObjetivoL + "]";
	}
	
	
}


