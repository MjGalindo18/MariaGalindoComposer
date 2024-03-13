package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {
	
	
	private ActionListener listener;
	private Botones botones;
	private JMenu menu;
	private MenuItem item1, item2, item3;

	public VentanaPrincipal(ActionListener listener) {
		this.listener = listener;
		this.setSize(500, 100);
		this.setTitle("REGUETON COMPOSER");
		this.setResizable(false);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         inicializar();
		this.setVisible(true);

	}

	public void inicializar() {
		this.setJMenuBar(mostrarMenu());
		this.setLayout(new BorderLayout());

		botones = new Botones(listener);
		add(botones, BorderLayout.CENTER);
	}

	private JMenuBar mostrarMenu() {
		JMenuBar barra = new JMenuBar();
		JMenu menuArchivo = new JMenu("Da click aqui para volverte compositor!");

		JMenuItem item1 = new JMenuItem("Crear una nueva canción => ");
		item1.setActionCommand("Definir");
		item1.addActionListener(listener);

		JMenuItem item2 = new JMenuItem("Visualizar y guardar una cancion =>");
		item2.setActionCommand("Crear");
		item2.addActionListener(listener);

		JMenuItem item3 = new JMenuItem("Seleccionar una canción anterior => ");
		item3.setActionCommand("Seleccionar");
		item3.addActionListener(listener);

		menuArchivo.add(item1);
		menuArchivo.add(item2);
		menuArchivo.add(item3);

		barra.add(menuArchivo);
		barra.setVisible(true);
		return barra;

	}

	public ActionListener getListener() {
		return listener;
	}

	public void setListener(ActionListener listener) {
		this.listener = listener;
	}

	public Botones getBotones() {
		return botones;
	}

	public void setBotones(Botones botones) {
		this.botones = botones;
	}

	public JMenu getMenu() {
		return menu;
	}

	public void setMenu(JMenu menu) {
		this.menu = menu;
	}

	public MenuItem getItem1() {
		return item1;
	}

	public void setItem1(MenuItem item1) {
		this.item1 = item1;
	}

	public MenuItem getItem2() {
		return item2;
	}

	public void setItem2(MenuItem item2) {
		this.item2 = item2;
	}

	public MenuItem getItem3() {
		return item3;
	}

	public void setItem3(MenuItem item3) {
		this.item3 = item3;
	}

}
