
public class Personaje {
	public String nombre;
	public String localizacion;
	public String ObjetivoO="";
	public String ObjetivoL="";
	int IDPer; //numero de identificacion del personaje
	
	public Personaje(String nombre, String localizacion, int IDPer) {
		super();
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.IDPer = IDPer;
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
		return "Personaje [nombre=" + nombre + ", localizacion=" + localizacion + ", ObjetivoO=" + ObjetivoO
				+ ", ObjetivoL=" + ObjetivoL + ", IDPer=" + IDPer + "]";
	}
	

	
	
}
