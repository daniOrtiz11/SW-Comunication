package swComunicacion.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;

public class Opcion2 extends JFrame implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private LinkedList<Boolean> bBotones;
	private LinkedList<JButton> botones;
	private JPanel contentPane;
	private Timer timer;
	private JButton btnQ;
	private JButton btnW;
	private JButton btnE;
	private JButton btnR;
	private JButton btnT;
	private JButton btnY;
	private JButton btnU;
	private JButton btnI;
	private JButton btnO;
	private JButton btnP;
	private JButton btnA;
	private JButton btnS;
	private JButton btnD;
	private JButton btnF;
	private JButton btnG;
	private JButton btnH;
	private JButton btnJ;
	private JButton btnK;
	private JButton btnL;
	private JButton btnEnie;
	private JButton btnZ;
	private JButton btnX;
	private JButton btnC;
	private JButton btnV;
	private JButton btnB;
	private JButton btnN;
	private JButton btnM;
	private JButton btnEspacio;
	private ToolbarSup t;
	private Controller c;
	private int it;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button;
	private int act;
	
	public Opcion2(Controller controlador) {
		this.c = controlador;
		setTitle("Opcion 2");
		act = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		botones = new LinkedList<JButton>();
		bBotones = new LinkedList<Boolean>();
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		t = new ToolbarSup(c, 2);
		contentPane.add(t, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);
		
		bBotones.add(true);
		for(int i=1; i<33;i++){		
			bBotones.add(false);
		}
		panel.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setRows(2);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 24));
		textArea.setEditable(true);
		textArea.setFocusable(false);
		panel.add(textArea, BorderLayout.NORTH);
		
		KeyAdapter ka = new KeyAdapter() {
			public void keyPressed(KeyEvent e) { 
				timer.stop();
				if(bBotones.get(1)==true)
					textArea.append("e");
				if(bBotones.get(2)==true)
					textArea.append("a");
				if(bBotones.get(3)==true)
					textArea.append("o");
				if(bBotones.get(4)==true)
					textArea.append("s");
				if(bBotones.get(5)==true)
					textArea.append("r");
				if(bBotones.get(6)==true)
					textArea.append("n");
				if(bBotones.get(7)==true)
					textArea.append("i");
				if(bBotones.get(8)==true)
					textArea.append("d");
				if(bBotones.get(9)==true)
					textArea.append("l");
				if(bBotones.get(10)==true){
					bBotones.set(10, false);
					bBotones.set(0, true);
				}
				if(bBotones.get(11)==true)
					textArea.append("\u0020");
				if(bBotones.get(12)==true)
					textArea.append("c");
				if(bBotones.get(13)==true)
					textArea.append("t");
				if(bBotones.get(14)==true)
					textArea.append("u");
				if(bBotones.get(15)==true)
					textArea.append("m");
				if(bBotones.get(16)==true)
					textArea.append("p");
				if(bBotones.get(17)==true)
					textArea.append("b");
				if(bBotones.get(18)==true)
					textArea.append("g");
				if(bBotones.get(19)==true)
					textArea.append("v");
				if(bBotones.get(20)==true)
					textArea.append("y");
				if(bBotones.get(21)==true){
					bBotones.set(21, false);
					bBotones.set(11, true);
				}
				if(bBotones.get(22)==true)
					textArea.append("\u0020");
				if(bBotones.get(23)==true)
					textArea.append("q");
				if(bBotones.get(24)==true)
					textArea.append("h");
				if(bBotones.get(25)==true)
					textArea.append("f");
				if(bBotones.get(26)==true)
					textArea.append("z");
				if(bBotones.get(27)==true)
					textArea.append("j");
				if(bBotones.get(28)==true)
					textArea.append("\u00D1");
				if(bBotones.get(29)==true)
					textArea.append("k");
				if(bBotones.get(30)==true)
					textArea.append("w");
				if(bBotones.get(31)==true)
					textArea.append("x");
				if(bBotones.get(32)==true)
					textArea.setText(textArea.getText().substring(0, (textArea.getText().length()-1)));
				if(bBotones.get(0)==true)
					textArea.append("\u0020");
					
				timer.restart();
			}			
		};
		
		JPanel Letras = new JPanel();
		Letras.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(Letras, BorderLayout.CENTER);
		Letras.setLayout(new GridLayout(3, 10, 30, 100));
		
		btnE = new JButton("E");
		Letras.add(btnE);
		btnE.addKeyListener(ka);
		botones.add(btnE);
		
		btnA = new JButton("A");
		Letras.add(btnA);
		btnA.addKeyListener(ka);
		botones.add(btnA);
		
		btnO = new JButton("O");
		Letras.add(btnO);
		btnO.addKeyListener(ka);
		botones.add(btnO);
		
		btnS = new JButton("S");
		Letras.add(btnS);
		btnS.addKeyListener(ka);
		botones.add(btnS);
		
		btnR = new JButton("R");
		Letras.add(btnR);
		btnR.addKeyListener(ka);
		botones.add(btnR);
		
		btnN = new JButton("N");
		Letras.add(btnN);
		btnN.addKeyListener(ka);
		botones.add(btnN);
		
		btnI = new JButton("I");
		Letras.add(btnI);
		btnI.addKeyListener(ka);
		botones.add(btnI);
		
		btnD = new JButton("D");
		Letras.add(btnD);
		btnD.addKeyListener(ka);
		botones.add(btnD);
		
		btnL = new JButton("L");
		Letras.add(btnL);
		btnL.addKeyListener(ka);
		botones.add(btnL);
		
		button_1 = new JButton("<- inicio");
		button_1.addKeyListener(ka);
		Letras.add(button_1);
		botones.add(button_1);
		
		button_3 = new JButton("ESPACIO");
		button_3.addKeyListener(ka);
		Letras.add(button_3);
		botones.add(button_3);
		
		
		btnC = new JButton("C");
		Letras.add(btnC);
		btnC.addKeyListener(ka);
		botones.add(btnC);
		
		btnT = new JButton("T");
		Letras.add(btnT);
		btnT.addKeyListener(ka);
		botones.add(btnT);
		
		btnU = new JButton("U");
		Letras.add(btnU);
		btnU.addKeyListener(ka);
		botones.add(btnU);
		
		btnM = new JButton("M");
		Letras.add(btnM);
		btnM.addKeyListener(ka);
		botones.add(btnM);
		
		btnP = new JButton("P");
		Letras.add(btnP);
		btnP.addKeyListener(ka);
		botones.add(btnP);
		
		btnB = new JButton("B");
		Letras.add(btnB);
		btnB.addKeyListener(ka);
		botones.add(btnB);
		
		btnG = new JButton("G");
		Letras.add(btnG);
		btnG.addKeyListener(ka);
		botones.add(btnG);
		
		btnV = new JButton("V");
		Letras.add(btnV);
		btnV.addKeyListener(ka);
		botones.add(btnV);
		
		btnY = new JButton("Y");
		Letras.add(btnY);
		btnY.addKeyListener(ka);
		botones.add(btnY);
		
		button_2 = new JButton("<- inicio");
		button_2.addKeyListener(ka);
		Letras.add(button_2);
		botones.add(button_2);
		
		button_4 = new JButton("ESPACIO");
		Letras.add(button_4);
		button_4.addKeyListener(ka);
		botones.add(button_4);
		
		btnQ = new JButton("Q");
		Letras.add(btnQ);
		btnQ.addKeyListener(ka);
		botones.add(btnQ);
		
		btnH = new JButton("H");
		Letras.add(btnH);
		btnH.addKeyListener(ka);
		botones.add(btnH);
		
		btnF = new JButton("F");
		Letras.add(btnF);
		btnF.addKeyListener(ka);
		botones.add(btnF);
		
		btnZ = new JButton("Z");
		Letras.add(btnZ);
		btnZ.addKeyListener(ka);
		botones.add(btnZ);
		
		btnJ = new JButton("J");
		Letras.add(btnJ);
		btnJ.addKeyListener(ka);
		botones.add(btnJ);
		
		btnEnie = new JButton("\u00D1");
		Letras.add(btnEnie);
		btnEnie.addKeyListener(ka);
		botones.add(btnEnie);
		
		btnK = new JButton("K");
		Letras.add(btnK);
		btnK.addKeyListener(ka);
		botones.add(btnK);
		
		btnW = new JButton("W");
		Letras.add(btnW);
		btnW.addKeyListener(ka);
		botones.add(btnW);
		
		btnX = new JButton("X");
		Letras.add(btnX);
		btnX.addKeyListener(ka);
		botones.add(btnX);
		this.setVisible(true);
		
		button = new JButton("BORRAR");
		Letras.add(button);
		button.addKeyListener(ka);
		botones.add(button);
		
		btnEspacio = new JButton("ESPACIO");
		Letras.add(btnEspacio);
		btnEspacio.addKeyListener(ka);
		botones.add(btnEspacio);
		
		temporizador();
		
		if(c.getModo() == true) {
			timer.start();
			btnQ.requestFocus();
		}
		else {
			textArea.setFocusable(true);
			textArea.requestFocus();
		}
		this.c.addObserver(this);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);	
	}

	private void temporizador(){
		timer = new Timer (c.getFrecuencia(), new ActionListener () 
		{ 
			
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	
		    	for(int i=0; i<botones.size();i++){		    		
		    		if(bBotones.get(i) == true){
		    			botones.get(i).setBackground(Color.GREEN);		    			
		    			act=i;
		    			it = act;
		    		}
		    		else if(bBotones.get(i) == false){
		    			botones.get(i).setBackground(null);	    			
		    		}
		    		
		    	}
		    	bBotones.set(act, false);		    	
		    	if (act==32)act=-1;		    	
		    	bBotones.set((act+1), true);

		    } 
		}); 
	}
	
	public void onCambioModo(boolean mod) {
		// TODO Auto-generated method stub
		c.setModo(mod);
		if(mod == false){
			timer.stop();
			botones.get(it).setBackground(null);	 
			textArea.setFocusable(true);
			textArea.requestFocus();
			t.enabledModo();
		} else{
			timer.start();
			botones.get(it).requestFocus();
			textArea.setFocusable(false);
			t.disabledModo();
		}
		//DESHABILITAR TECLADO Y QUE ESCRIBA LA PALABRA EN EL JTEXTAREA
	}

	public void onCambioOpcion(int op) {
		// TODO Auto-generated method stub
		if(op ==2){
			this.c.removeObserver(this);
			this.setVisible(false);
			new PrincipalView(c);
		}
	}

	public void onCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		c.setFrecuencia(f);
		temporizador();
	}

	@Override
	public void mouseNiño() {
		// TODO Auto-generated method stub
		
	}
}