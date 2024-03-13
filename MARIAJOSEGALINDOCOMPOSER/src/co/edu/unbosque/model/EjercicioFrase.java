package co.edu.unbosque.model;

public class EjercicioFrase {
	
	private String contenido;

	public EjercicioFrase() {
		this.contenido = "";
	}

	public EjercicioFrase(String contenido) {
		this.contenido = contenido;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String toString() {
		return contenido;
	}

}
