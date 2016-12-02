package swComunicacion.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import swComunicacion.Controller;
import swComunicacion.Observer;

@SuppressWarnings("serial")
public class ToolbarSup extends JPanel implements Observer{

	private ImageIcon atrasIc;
	private JButton atras;
	private JButton btnHelp;
	private Controller c;
	private boolean opcActual = false; //Ventana principal
	
	public ToolbarSup(Controller controlador){
		this.c = controlador;
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new GridLayout(1,4));
		
		btnHelp = new JButton("Help");
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Para seleccionar una opción debemos pulsar cualquier tecla cuando "
						+ "la opción que queramos esté en verde", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
				btnHelp.transferFocus();
			}
		}
		 );
		this.add(btnHelp);
		
		atras = new JButton("Atrás");
		this.atrasIc = new ImageIcon("imagenes/atras.png");
		atras.setIcon(atrasIc);
		atras.setEnabled(false);
		atras.addMouseListener(new MouseAdapter(){ 
			
			public void mouseClicked(MouseEvent e){
				if(opcActual){
					c.onCambioOpcion(false);
					new PrincipalView(c);
				} 
			}
		});
		this.add(atras);
		this.c.addObserver(this);
	}

	public void setAtras(JButton atras) {
		this.atras = atras;
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void onCambioOpcion(boolean op) {
		if(!opcActual){
			opcActual = true;
			this.atras.setEnabled(true);
			this.add(atras);
		}
	}


}
