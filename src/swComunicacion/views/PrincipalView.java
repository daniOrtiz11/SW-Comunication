package swComunicacion.views;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PrincipalView extends JFrame implements Observer {

	private JPanel contentPane;
	private Controller c;
	//private boolean vs1 = true;
	private boolean vs1;
	private boolean vs2;
	private boolean vs3;
	private JButton btnOpcion_1;
	private JButton btnOpcion_2;
	private JButton btnOpcion_3;
	private Timer timer;
	private int frecuencia = 1000;
	private ToolbarSup t;
	private JPanel panel;
	private JPanel panelOp;
	
	@SuppressWarnings("deprecation")
	public PrincipalView(Controller c2) {
		c = c2;
		setTitle("SW Comunicacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel text = new JLabel("Bienvenido a SWComunicacion");
		text.setBackground(Color.WHITE);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		contentPane.add(text, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		

		t = new ToolbarSup(c);
		
		panelOp = new JPanel();
		panelOp.setBackground(Color.WHITE);
		panelOp.setLayout(new GridLayout(1, 3, 10, 20));
		
		btnOpcion_1 = new JButton("Opcion 1");
		btnOpcion_1.setBackground(Color.GREEN);
		panelOp.add(btnOpcion_1);
		btnOpcion_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		vs1 = true;
		
		btnOpcion_2 = new JButton("Opcion 2");
		btnOpcion_2.setBackground(Color.RED);
		panelOp.add(btnOpcion_2);
		btnOpcion_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		vs2 = false;
		
		btnOpcion_3 = new JButton("Opcion 3");
		btnOpcion_3.setBackground(Color.RED);
		panelOp.add(btnOpcion_3);
		btnOpcion_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		vs3 = false;
		
		panel.add(panelOp, BorderLayout.CENTER);
		btnOpcion_1.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) { //al pulsar cualquier tecla
				if(vs1 == true){
					timer.stop();
					cerrarVentana();
					Opcion1 v = new Opcion1(c);
					c.onCambioOpcion(true);
				}
			}
			});
		

		btnOpcion_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(vs1 == true){
					timer.stop();
					cerrarVentana();
					Opcion1 v = new Opcion1(c);
					c.onCambioOpcion(true);
				}
			}
			});
		
		btnOpcion_2.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) { //al pulsar cualquier tecla
				// TODO Auto-generated method stub
				
				if(vs2 == true){
					timer.stop();
					cerrarVentana();
					Opcion2 v = new Opcion2(c);
					c.onCambioOpcion(true);
				}
			}
			});
		
		btnOpcion_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(vs2 == true){
					timer.stop();
					cerrarVentana();
					Opcion2 v = new Opcion2(c);
					c.onCambioOpcion(true);
				}
			
			}
			});
		
		btnOpcion_3.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) { //al pulsar cualquier tecla
				
				if(vs3 == true){
					// TODO Auto-generated method stub
					timer.stop();
					cerrarVentana();
					Opcion3 v = new Opcion3(c);
					c.onCambioOpcion(true);
				}
			}
			});
		

		btnOpcion_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(vs3 == true){
					timer.stop();
					cerrarVentana();
					Opcion3 v = new Opcion3(c);
					c.onCambioOpcion(true);
				}
			}
			});
		
		
		setVisible(true);
		this.c.addObserver(this);
			
		// la frecuencia hace referencia al intervalo con que se realizará la función (en milisegundos)
		timer = new Timer (frecuencia, new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	if(vs1 == true){
		    		btnOpcion_2.requestFocus();
		    		btnOpcion_1.setBackground(Color.RED);
		    		btnOpcion_2.setBackground(Color.GREEN);
		    		vs1 = false;
		    		vs2 = true;
		    	}
		    	else if(vs2 == true){
		    		btnOpcion_3.requestFocus();
		    		btnOpcion_2.setBackground(Color.RED);
		    		btnOpcion_3.setBackground(Color.GREEN);
		    		vs2 = false;
		    		vs3 = true;
		    	}
		    	else if(vs3 == true){
		    		btnOpcion_1.requestFocus();
		    		btnOpcion_3.setBackground(Color.RED);
		    		btnOpcion_1.setBackground(Color.GREEN);
		    		vs3 = false;
		    		vs1 = true;
		    	}
		    	
		     } 
		}); 

		btnOpcion_1.requestFocus();
		this.setExtendedState(MAXIMIZED_BOTH);
		
		timer.start();
		
	}
	private void cerrarVentana() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
	
	public void onCambioOpcion(boolean opc) {
		// TODO Auto-generated method stub
	
	}
}
