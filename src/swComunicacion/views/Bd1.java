package swComunicacion.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Bd1 extends JFrame implements Observer{

	private JPanel contentPane;
	private Controller c;
	private JPanel aux;
	private boolean vs1;
	private boolean vs2;
	private boolean vs3;
	private boolean vs4;
	private Timer timer;
	private JSplitPane splitPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnVerBd;
	private JButton btnVerMas;
	private JButton btn1;
	private JButton btn3;
	private JButton btn2;
	private JButton btn4;
	
	
	public Bd1(Controller controlador) {
		this.c = controlador;
		setTitle("Bd1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		aux = new JPanel();
		aux.setBackground(Color.WHITE);
		
		getContentPane().add(aux, BorderLayout.CENTER);
		aux.setLayout(new GridLayout(1, 2, 0, 0));
		
		splitPane = new JSplitPane();
		aux.add(splitPane);
		
		panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(2, 1, 10, 200));
		
		btnVerBd = new JButton("Ver galer\u00EDa");
		btnVerBd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				timer.stop();
				onCambioOpcion(4);
				GaleriaBd1 v = new GaleriaBd1(c);
			}
		});
		panel.add(btnVerBd);
		
		btnVerMas = new JButton("Ver m�s");
		panel.add(btnVerMas);
		
		panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 5, 5));
		
		btn1 = new JButton("New button");
		panel_1.add(btn1);
		
		btn2 = new JButton("New button");
		panel_1.add(btn2);
		
		btn3 = new JButton("New button");
		panel_1.add(btn3);
		
		btn4 = new JButton("New button");
		panel_1.add(btn4);
		vs1 = true;
		vs2 = false;
		vs3 = false;
		vs4 = false;
		
		timer = new Timer (c.getFrecuencia(), new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	if(vs1 == true){
		    		btn2.requestFocus();
		    		btn1.setBackground(Color.RED);
		    		btn2.setBackground(Color.GREEN);
		    		vs1 = false;
		    		vs2 = true;
		    	}
		    	else if(vs2 == true){
		    		btn3.requestFocus();
		    		btn2.setBackground(Color.RED);
		    		btn3.setBackground(Color.GREEN);
		    		vs2 = false;
		    		vs3 = true;
		    	}
		    	else if(vs3 == true){
		    		btn4.requestFocus();
		    		btn3.setBackground(Color.RED);
		    		btn4.setBackground(Color.GREEN);
		    		vs3 = false;
		    		vs4 = true;
		    	}
		    	else if(vs4 == true){
		    		btn1.requestFocus();
		    		btn4.setBackground(Color.RED);
		    		btn1.setBackground(Color.GREEN);
		    		vs4 = false;
		    		vs1 = true;
		    	}
		    	
		     } 
		});
		timer.stop();
		this.setVisible(true);
		this.c.addObserver(this);
		this.setExtendedState(MAXIMIZED_BOTH);
	}


	public void onCambioOpcion(int op) {
		// TODO Auto-generated method stub
		if(op ==4){
			this.c.removeObserver(this);
			this.setVisible(false);
		}
	}

	public void onCambioModo(boolean m) {
		// TODO Auto-generated method stub
		
	}


	public void onCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		
	}

}
