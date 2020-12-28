import java.util.Arrays;

public class Lugar {
	public String nombre;
	public String[] adyaciencias;
	int longitudArray;
	int IDLug; //numero de identificacion del lugar
	
	public Lugar(String nombre, String[] adyaciencias, int IDLug) {
		this.nombre = nombre;
		this.adyaciencias = adyaciencias;
		this.IDLug = IDLug;
	}
	public int calcularLongitud() {
		longitudArray = this.adyaciencias.length;
		return longitudArray;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String[] getAdyaciencias() {
		return adyaciencias;
	}
	public void setAdyaciencias(String[] adyaciencias) {
		this.adyaciencias = adyaciencias;
	}
	
	public String mostrar() {
		return adyaciencias[1];
	}


	@Override
	public String toString() {
		return "Lugar [nombre=" + nombre + ", adyaciencias=" + Arrays.toString(adyaciencias) + ", IDLug=" + IDLug + "]";
	}
	
	


	
	
	
	
}
