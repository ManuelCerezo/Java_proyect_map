
public class Objeto {

		public String nombre;
		public String localizacion;
		int IDObj; //numero de identificacion del objeto

		public Objeto(String nombre, String localizacion, int IDObj) {
			this.nombre = nombre;
			this.localizacion = localizacion;
			this.IDObj = IDObj;
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

		@Override
		public String toString() {
			return "Objeto [nombre=" + nombre + ", localizacion=" + localizacion + ", IDObj=" + IDObj + "]";
		}
		
}
