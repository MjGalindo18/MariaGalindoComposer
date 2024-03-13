package co.edu.unbosque.model;




public class EjercicioEstrofa {
	
	private EjercicioFrase[] frases;

	public EjercicioEstrofa() {
		this.frases = new EjercicioFrase[0];
	}

	public EjercicioEstrofa(EjercicioFrase[] frases) {
		this.frases = frases;
	}

	public EjercicioEstrofa(String linea) {
		agregarFrase(linea);
	}

	public void agregarFrase(EjercicioFrase frase) {
		EjercicioFrase[] nuevoArreglo = new EjercicioFrase[frases.length + 1];
		System.arraycopy(frases, 0, nuevoArreglo, 0, frases.length);
		nuevoArreglo[frases.length] = frase;
		frases = nuevoArreglo;
	}

	public void agregarFrase(String linea) {
		EjercicioFrase nuevaFrase = new EjercicioFrase(linea);
		agregarFrase(nuevaFrase);
	}

	public String generarEstrofa() {
		StringBuilder sb = new StringBuilder();
		for (EjercicioFrase frase : frases) {
			sb.append(frase.getContenido()).append(" ");
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		if (frases == null || frases.length == 0) {
			return "Estrofa vacía";
		}

		StringBuilder sb = new StringBuilder();
		for (EjercicioFrase frase : frases) {
			sb.append(frase).append("\n");
		}
		return sb.toString();
	}

	public EjercicioFrase[] getFrases() {
		return frases;
	}

	public void setFrases(EjercicioFrase[] frases) {
		this.frases = frases;
	}


}
