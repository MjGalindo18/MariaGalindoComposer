package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class Interfaz {
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public int pedirEstrofa() {
		int dato = 0;
		try {
			dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de estrofas:"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return dato;
	}

	public String pedirFrase() {
		String frase = "";
		frase = JOptionPane.showInputDialog(null, "Ingrese numero de frases por estrofa");

		return frase;
	}

	public boolean mostrarConfirmacion(String mensaje) {
		int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar", JOptionPane.YES_NO_OPTION);
		return opcion == JOptionPane.YES_OPTION;
	}

	public int pedirNumero(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
