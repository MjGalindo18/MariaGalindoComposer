package co.edu.unbosque.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import co.edu.unbosque.model.Cancion;
import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.view.Interfaz;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller {
	
	private VentanaPrincipal vista;
	private ActionListener listener;
	private Interfaz in;
	private Propiedades pro;
	private Cancion cancion;

	public Controller() {
		listener = new ListenerUsuario();
		vista = new VentanaPrincipal(listener);
		in = new Interfaz();
		pro = new Propiedades();
		cancion = new Cancion();
	}

	class ListenerUsuario implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();

			switch (comando) {
			case "Definir":
				cancion.pedirEstrofas(in, pro);
				break;
			case "Crear":
				cancion.crearCancion(in, pro);
				break;
			case "Seleccionar":
				cancion.seleccionarCancion(in,pro);
				break;
			case "Cerrar":
				vista.dispose();
				break;

			}
		}
	}
}