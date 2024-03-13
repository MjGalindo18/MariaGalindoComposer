package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.EjercicioEstrofa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import co.edu.unbosque.model.Cancion;


public class Propiedades {
	
	Properties propiedades;

	public Propiedades() {
		propiedades = new Properties();
		try (InputStream in = new FileInputStream("confi.properties")) {
			propiedades.load(in);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void guardarParametros(int numeroEstrofas, int numeroFrasesPorEstrofa) {
		propiedades.setProperty("numeroEstrofas", String.valueOf(numeroEstrofas));
		propiedades.setProperty("numeroFrasesPorEstrofa", String.valueOf(numeroFrasesPorEstrofa));

		try (OutputStream out = new FileOutputStream("confi.properties")) {
			propiedades.store(out, null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public int leerNumeroEstrofas() {
		int numeroEstrofas = 0;

		String valor = propiedades.getProperty("numeroEstrofas");

		if (valor != null) {
			try {
				numeroEstrofas = Integer.parseInt(valor);
			} catch (NumberFormatException ex) {

				ex.printStackTrace();

			}
		}

		return numeroEstrofas;
	}

	public int leerNumeroFrasesPorEstrofa() {
		int numeroFrasesPorEstrofa = 0;
		String valor = propiedades.getProperty("numeroFrasesPorEstrofa");

		if (valor != null) {
			try {
				numeroFrasesPorEstrofa = Integer.parseInt(valor);
			} catch (NumberFormatException ex) {

				ex.printStackTrace();

			}
		}

		return numeroFrasesPorEstrofa;
	}

	public Cancion leerCancionDelArchivo(File archivo) {
		Cancion cancion = new Cancion();
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String titulo = archivo.getName();
			cancion.setTitulo(titulo);

			EjercicioEstrofa estrofa = new EjercicioEstrofa();
			String linea;
			while ((linea = reader.readLine()) != null) {
				if (!linea.isEmpty()) {
					estrofa.agregarFrase(linea);
				} else {
					if (estrofa.getFrases().length != 0) {
						cancion.agregarEstrofa(estrofa);
					}
					estrofa = new EjercicioEstrofa();
				}
			}

			if (estrofa.getFrases().length != 0) {
				cancion.agregarEstrofa(estrofa);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return cancion;
	}
	

}
