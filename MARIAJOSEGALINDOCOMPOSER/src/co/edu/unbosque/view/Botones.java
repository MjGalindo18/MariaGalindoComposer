package co.edu.unbosque.view;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Botones extends JPanel {
	
	private JButton cerrar;
	private ActionListener listener;

	public Botones(ActionListener listener) {
		this.listener = listener;
		this.setSize(500, 00);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		inicializar();
		this.setVisible(true);

	}

	private void inicializar() {

		cerrar = new JButton("Cerrar");
		cerrar.setVisible(true);
		cerrar.setActionCommand("Cerrar");
		cerrar.addActionListener(listener);
		add(cerrar);

	}

	public JButton getCerrar() {
		return cerrar;
	}

	public void setCerrar(JButton cerrar) {
		this.cerrar = cerrar;
	}


}
