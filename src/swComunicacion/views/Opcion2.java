package swComunicacion.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;
import swComunicacion.Voz;

public class Opcion2 extends JFrame implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private LinkedList<Boolean> bBotones;
	private LinkedList<Boolean> bBotones2;
	private LinkedList<JButton> botones;
	private LinkedList<Boolean> bColumnas;
	private LinkedList<Boolean> bFilas;
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
	private ToolbarSup t;
	private Controller c;
	private int it;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private int act;
	//private int colAct;
	private MouseListener mGeneral;
	private KeyAdapter ka;
	private JPanel Letras;
	private JPanel panel;
	private int keyBoardType = 0;
	private Boolean fila = false;
	//private int a = 0;
	private int b = 0;
	private int d = 0;
	
	public Opcion2(Controller controlador) {
		this.c = controlador;
		setTitle("Opcion 2");
		act = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 70, 670, 413);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		botones = new LinkedList<JButton>();
		bBotones = new LinkedList<Boolean>();
		bBotones2 = new LinkedList<Boolean>();
		bColumnas = new LinkedList<Boolean>();
		bFilas = new LinkedList<Boolean>();
		panel = new JPanel();
		//panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		t = new ToolbarSup(c, 2,null);
		contentPane.add(t, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);
		
		bBotones.add(true);
		
		for(int i=1; i<33;i++){		
			bBotones.add(false);
		}
		
		bColumnas.add(false);
		for(int i=1; i<6;i++){		
			bColumnas.add(false);
		}
		bFilas.add(true);
		for(int i=1; i<5;i++){		
			bFilas.add(false);
		}
		panel.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setRows(2);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 50));
		textArea.setEditable(true);
		textArea.setFocusable(false);
		panel.add(textArea, BorderLayout.NORTH);
		
		
		ka = new KeyAdapter() {
			public void keyPressed(KeyEvent e) { 
				timer.stop();
				accionTeclado();	
				timer.restart();
			}		
		};
		
		mGeneral = new MouseAdapter(){
			public void mouseClicked (MouseEvent e){
				timer.stop();
				mouseNiño();
				timer.restart();
			}
		};
		
		Letras = new JPanel();
		Letras.setBorder(new EmptyBorder(0, 0, 0, 0));
		intelliKeyBoard(ka, Letras);
		panel.add(Letras, BorderLayout.CENTER);
			
		if(c.getModo() == true) {
			timer.start();
			btnE.requestFocus();
		}
		else {
			textArea.setFocusable(true);
			textArea.requestFocus();
		}
		
		contentPane.addMouseListener(mGeneral);
		textArea.addMouseListener(mGeneral);
		this.setVisible(true);
		this.c.addObserver(this);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);	
	}

	private void mostUsedLetters(KeyAdapter ka, JPanel Letras) {
		Letras.setLayout(new GridLayout(3, 9));
		bBotones.add(true);		
		for(int i=1; i<30;i++){		
			bBotones.add(false);
		}
		keyBoardType = 1;
		
		btnE = new JButton("E");
		Letras.add(btnE);
		btnE.setFont(new Font("arial",Font.PLAIN,70)); 
		btnE.addKeyListener(ka);
		btnE.addMouseListener(mGeneral);
		botones.add(btnE);
		
		btnA = new JButton("A");
		Letras.add(btnA);
		btnA.setFont(new Font("arial",Font.PLAIN,70)); 
		btnA.addKeyListener(ka);
		btnA.addMouseListener(mGeneral);
		botones.add(btnA);
		
		btnO = new JButton("O");
		Letras.add(btnO);
		btnO.setFont(new Font("arial",Font.PLAIN,70)); 
		btnO.addKeyListener(ka);
		btnO.addMouseListener(mGeneral);
		botones.add(btnO);
				
		btnS = new JButton("S");
		Letras.add(btnS);
		btnS.setFont(new Font("arial",Font.PLAIN,70)); 
		btnS.addKeyListener(ka);
		btnS.addMouseListener(mGeneral);
		botones.add(btnS);
		
		btnR = new JButton("R");
		Letras.add(btnR);
		btnR.setFont(new Font("arial",Font.PLAIN,70)); 
		btnR.addKeyListener(ka);
		btnR.addMouseListener(mGeneral);
		botones.add(btnR);
		
		btnN = new JButton("N");
		Letras.add(btnN);
		btnN.setFont(new Font("arial",Font.PLAIN,70)); 
		btnN.addKeyListener(ka);
		btnN.addMouseListener(mGeneral);
		botones.add(btnN);
		
		btnI = new JButton("I");
		Letras.add(btnI);
		btnI.setFont(new Font("arial",Font.PLAIN,70)); 
		btnI.addKeyListener(ka);
		btnI.addMouseListener(mGeneral);
		botones.add(btnI);
			
		btnD = new JButton("D");
		Letras.add(btnD);
		btnD.setFont(new Font("arial",Font.PLAIN,70)); 
		btnD.addKeyListener(ka);
		btnD.addMouseListener(mGeneral);
		botones.add(btnD);
		
		btnL = new JButton("L");
		Letras.add(btnL);
		btnL.setFont(new Font("arial",Font.PLAIN,70)); 
		btnL.addKeyListener(ka);
		btnL.addMouseListener(mGeneral);
		botones.add(btnL);
			
		btnC = new JButton("C");
		Letras.add(btnC);
		btnC.setFont(new Font("arial",Font.PLAIN,70)); 
		btnC.addKeyListener(ka);
		btnC.addMouseListener(mGeneral);
		botones.add(btnC);
			
		btnT = new JButton("T");
		Letras.add(btnT);
		btnT.setFont(new Font("arial",Font.PLAIN,70)); 
		btnT.addKeyListener(ka);
		btnT.addMouseListener(mGeneral);
		botones.add(btnT);
		
		btnU = new JButton("U");
		Letras.add(btnU);
		btnU.setFont(new Font("arial",Font.PLAIN,70)); 
		btnU.addKeyListener(ka);
		btnU.addMouseListener(mGeneral);
		botones.add(btnU);
		
		btnM = new JButton("M");
		Letras.add(btnM);
		btnM.setFont(new Font("arial",Font.PLAIN,70)); 
		btnM.addKeyListener(ka);
		btnM.addMouseListener(mGeneral);
		botones.add(btnM);
		
		btnP = new JButton("P");
		Letras.add(btnP);
		btnP.setFont(new Font("arial",Font.PLAIN,70)); 
		btnP.addKeyListener(ka);
		btnP.addMouseListener(mGeneral);
		botones.add(btnP);
		
		btnB = new JButton("B");
		Letras.add(btnB);
		btnB.setFont(new Font("arial",Font.PLAIN,70)); 
		btnB.addKeyListener(ka);
		btnB.addMouseListener(mGeneral);
		botones.add(btnB);
		
		btnG = new JButton("G");
		Letras.add(btnG);
		btnG.setFont(new Font("arial",Font.PLAIN,70)); 
		btnG.addKeyListener(ka);
		btnG.addMouseListener(mGeneral);
		botones.add(btnG);
		
		btnV = new JButton("V");
		Letras.add(btnV);
		btnV.setFont(new Font("arial",Font.PLAIN,70)); 
		btnV.addKeyListener(ka);
		btnV.addMouseListener(mGeneral);
		botones.add(btnV);
		
		btnY = new JButton("Y");
		Letras.add(btnY);
		btnY.setFont(new Font("arial",Font.PLAIN,70)); 
		btnY.addKeyListener(ka);
		btnY.addMouseListener(mGeneral);
		botones.add(btnY);
			
		btnQ = new JButton("Q");
		Letras.add(btnQ);
		btnQ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnQ.addKeyListener(ka);
		btnQ.addMouseListener(mGeneral);
		botones.add(btnQ);
			
		btnH = new JButton("H");
		Letras.add(btnH);
		btnH.setFont(new Font("arial",Font.PLAIN,70)); 
		btnH.addKeyListener(ka);
		btnH.addMouseListener(mGeneral);
		botones.add(btnH);

		btnF = new JButton("F");
		Letras.add(btnF);
		btnF.setFont(new Font("arial",Font.PLAIN,70)); 
		btnF.addKeyListener(ka);
		btnF.addMouseListener(mGeneral);
		botones.add(btnF);
		
		btnZ = new JButton("Z");
		Letras.add(btnZ);
		btnZ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnZ.addKeyListener(ka);
		btnZ.addMouseListener(mGeneral);
		botones.add(btnZ);
		
		btnJ = new JButton("J");
		Letras.add(btnJ);
		btnJ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnJ.addKeyListener(ka);
		btnJ.addMouseListener(mGeneral);
		botones.add(btnJ);
		
		btnEnie = new JButton("\u00D1");
		Letras.add(btnEnie);
		btnEnie.setFont(new Font("arial",Font.PLAIN,70)); 
		btnEnie.addKeyListener(ka);
		btnEnie.addMouseListener(mGeneral);
		botones.add(btnEnie);
		
		btnK = new JButton("K");
		Letras.add(btnK);
		btnK.setFont(new Font("arial",Font.PLAIN,70)); 
		btnK.addKeyListener(ka);
		btnK.addMouseListener(mGeneral);
		botones.add(btnK);
		
		btnW = new JButton("W");
		Letras.add(btnW);
		btnW.setFont(new Font("arial",Font.PLAIN,70)); 
		btnW.addKeyListener(ka);
		btnW.addMouseListener(mGeneral);
		botones.add(btnW);
		
		btnX = new JButton("X");
		Letras.add(btnX);
		btnX.setFont(new Font("arial",Font.PLAIN,70)); 
		btnX.addKeyListener(ka);
		btnX.addMouseListener(mGeneral);
		botones.add(btnX);
		this.setVisible(true);
		
		button_3 = new JButton("ESPACIO");
		Letras.add(button_3);
		button_3.addKeyListener(ka);
		button_3.setFont(new Font("arial",Font.PLAIN,20)); 
		button_3.addMouseListener(mGeneral);
		botones.add(button_3);
		
		button_4 = new JButton("ATRAS");
		Letras.add(button_4);
		button_4.addKeyListener(ka);
		button_4.addMouseListener(mGeneral);
		button_4.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_4);
		
		button = new JButton("BORRAR");
		Letras.add(button);
		button.setFont(new Font("arial",Font.PLAIN,20)); 
		button.addKeyListener(ka);
		button.addMouseListener(mGeneral);
		botones.add(button);
		
		
		button_2 = new JButton("<- inicio");
		button_2.addKeyListener(ka);
		button_2.addMouseListener(mGeneral);
		Letras.add(button_2);
		button_2.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_2);
		
		this.setVisible(true);
		temporizador();
		
	}

	private void qwertyLetters(KeyAdapter ka, JPanel Letras) {
		Letras.setLayout(new GridLayout(3, 9));
		bBotones.add(true);
		
		for(int i=1; i<33;i++){		
			bBotones.add(false);
		}
		keyBoardType = 0;
		
		btnQ = new JButton("Q");
		Letras.add(btnQ);
		btnQ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnQ.addKeyListener(ka);
		btnQ.addMouseListener(mGeneral);
		botones.add(btnQ);
		
		btnW = new JButton("W");
		Letras.add(btnW);
		btnW.setFont(new Font("arial",Font.PLAIN,70)); 
		btnW.addKeyListener(ka);
		btnW.addMouseListener(mGeneral);
		botones.add(btnW);
		
		btnE = new JButton("E");
		Letras.add(btnE);
		btnE.setFont(new Font("arial",Font.PLAIN,70)); 
		btnE.addKeyListener(ka);
		btnE.addMouseListener(mGeneral);
		botones.add(btnE);
		
		btnR = new JButton("R");
		Letras.add(btnR);
		btnR.setFont(new Font("arial",Font.PLAIN,70)); 
		btnR.addKeyListener(ka);
		btnR.addMouseListener(mGeneral);
		botones.add(btnR);
				
		btnT = new JButton("T");
		Letras.add(btnT);
		btnT.setFont(new Font("arial",Font.PLAIN,70)); 
		btnT.addKeyListener(ka);
		btnT.addMouseListener(mGeneral);
		botones.add(btnT);
		
		btnY = new JButton("Y");
		Letras.add(btnY);
		btnY.setFont(new Font("arial",Font.PLAIN,70)); 
		btnY.addKeyListener(ka);
		btnY.addMouseListener(mGeneral);
		botones.add(btnY);
		
		btnU = new JButton("U");
		Letras.add(btnU);
		btnU.setFont(new Font("arial",Font.PLAIN,70)); 
		btnU.addKeyListener(ka);
		btnU.addMouseListener(mGeneral);
		botones.add(btnU);
		
		btnI = new JButton("I");
		Letras.add(btnI);
		btnI.setFont(new Font("arial",Font.PLAIN,70)); 
		btnI.addKeyListener(ka);
		btnI.addMouseListener(mGeneral);
		botones.add(btnI);
	
		btnO = new JButton("O");
		Letras.add(btnO);
		btnO.setFont(new Font("arial",Font.PLAIN,70)); 
		btnO.addKeyListener(ka);
		btnO.addMouseListener(mGeneral);
		botones.add(btnO);
		
		btnP = new JButton("P");
		Letras.add(btnP);
		btnP.setFont(new Font("arial",Font.PLAIN,70)); 
		btnP.addKeyListener(ka);
		btnP.addMouseListener(mGeneral);
		botones.add(btnP);
		
		btnA = new JButton("A");
		Letras.add(btnA);
		btnA.setFont(new Font("arial",Font.PLAIN,70)); 
		btnA.addKeyListener(ka);
		btnA.addMouseListener(mGeneral);
		botones.add(btnA);
		
		btnS = new JButton("S");
		Letras.add(btnS);
		btnS.setFont(new Font("arial",Font.PLAIN,70)); 
		btnS.addKeyListener(ka);
		btnS.addMouseListener(mGeneral);
		botones.add(btnS);
		
		btnD = new JButton("D");
		Letras.add(btnD);
		btnD.setFont(new Font("arial",Font.PLAIN,70)); 
		btnD.addKeyListener(ka);
		btnD.addMouseListener(mGeneral);
		botones.add(btnD);
		
		btnF = new JButton("F");
		Letras.add(btnF);
		btnF.setFont(new Font("arial",Font.PLAIN,70)); 
		btnF.addKeyListener(ka);
		btnF.addMouseListener(mGeneral);
		botones.add(btnF);
		
		btnG = new JButton("G");
		Letras.add(btnG);
		btnG.setFont(new Font("arial",Font.PLAIN,70)); 
		btnG.addKeyListener(ka);
		btnG.addMouseListener(mGeneral);
		botones.add(btnG);
		
		btnH = new JButton("H");
		Letras.add(btnH);
		btnH.setFont(new Font("arial",Font.PLAIN,70)); 
		btnH.addKeyListener(ka);
		btnH.addMouseListener(mGeneral);
		botones.add(btnH);
		
		btnJ = new JButton("J");
		Letras.add(btnJ);
		btnJ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnJ.addKeyListener(ka);
		btnJ.addMouseListener(mGeneral);
		botones.add(btnJ);
		
		btnK = new JButton("K");
		Letras.add(btnK);
		btnK.setFont(new Font("arial",Font.PLAIN,70)); 
		btnK.addKeyListener(ka);
		btnK.addMouseListener(mGeneral);
		botones.add(btnK);
		
		btnL = new JButton("L");
		Letras.add(btnL);
		btnL.setFont(new Font("arial",Font.PLAIN,70)); 
		btnL.addKeyListener(ka);
		btnL.addMouseListener(mGeneral);
		botones.add(btnL);
		
		btnEnie = new JButton("\u00D1");
		Letras.add(btnEnie);
		btnEnie.setFont(new Font("arial",Font.PLAIN,70)); 
		btnEnie.addKeyListener(ka);
		btnEnie.addMouseListener(mGeneral);
		botones.add(btnEnie);
		
		btnZ = new JButton("Z");
		Letras.add(btnZ);
		btnZ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnZ.addKeyListener(ka);
		btnZ.addMouseListener(mGeneral);
		botones.add(btnZ);
		
		btnX = new JButton("X");
		Letras.add(btnX);
		btnX.setFont(new Font("arial",Font.PLAIN,70)); 
		btnX.addKeyListener(ka);
		btnX.addMouseListener(mGeneral);
		botones.add(btnX);
		
		btnC = new JButton("C");
		Letras.add(btnC);
		btnC.setFont(new Font("arial",Font.PLAIN,70)); 
		btnC.addKeyListener(ka);
		btnC.addMouseListener(mGeneral);
		botones.add(btnC);
		
		btnV = new JButton("V");
		Letras.add(btnV);
		btnV.setFont(new Font("arial",Font.PLAIN,70)); 
		btnV.addKeyListener(ka);
		btnV.addMouseListener(mGeneral);
		botones.add(btnV);
		
		btnB = new JButton("B");
		Letras.add(btnB);
		btnB.setFont(new Font("arial",Font.PLAIN,70)); 
		btnB.addKeyListener(ka);
		btnB.addMouseListener(mGeneral);
		botones.add(btnB);
		
		btnN = new JButton("N");
		Letras.add(btnN);
		btnN.setFont(new Font("arial",Font.PLAIN,70)); 
		btnN.addKeyListener(ka);
		btnN.addMouseListener(mGeneral);
		botones.add(btnN);
		
		btnM = new JButton("M");
		Letras.add(btnM);
		btnM.setFont(new Font("arial",Font.PLAIN,70)); 
		btnM.addKeyListener(ka);
		btnM.addMouseListener(mGeneral);
		botones.add(btnM);
		
		button_3 = new JButton("ESPACIO");
		button_3.addKeyListener(ka);
		button_3.addMouseListener(mGeneral);
		button_4 = new JButton("ATRAS");
		button_4.addKeyListener(ka);
		button_4.addMouseListener(mGeneral);
		
		button = new JButton("BORRAR");
		Letras.add(button);
		button.setFont(new Font("arial",Font.PLAIN,20)); 
		button.addKeyListener(ka);
		button.addMouseListener(mGeneral);
		botones.add(button);
		Letras.add(button_3);
		Letras.add(button_4);
		button_3.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_3);
		button_4.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_4);	
		
		this.setVisible(true);
		temporizador();
		//timer.start();
	}

	private void intelliKeyBoard(KeyAdapter ka, JPanel Letras) {
		Letras.setLayout(new GridLayout(5, 6));
		//bBotones.add(false);		
		for(int i=0; i<30;i++){		
			bBotones.add(false);
		}
		//bBotones2.add(false);
		for(int i=0; i<30;i++){	
			bBotones2.add(false);
		}
		
		keyBoardType = 2;
		
		btnS = new JButton("S");
		Letras.add(btnS);
		btnS.setFont(new Font("arial",Font.PLAIN,70)); 
		btnS.addKeyListener(ka);
		btnS.addMouseListener(mGeneral);
		botones.add(btnS);
		
		btnR = new JButton("R");
		Letras.add(btnR);
		btnR.setFont(new Font("arial",Font.PLAIN,70)); 
		btnR.addKeyListener(ka);
		btnR.addMouseListener(mGeneral);
		botones.add(btnR);
		
		btnN = new JButton("N");
		Letras.add(btnN);
		btnN.setFont(new Font("arial",Font.PLAIN,70)); 
		btnN.addKeyListener(ka);
		btnN.addMouseListener(mGeneral);
		botones.add(btnN);
		
		btnD = new JButton("D");
		Letras.add(btnD);
		btnD.setFont(new Font("arial",Font.PLAIN,70)); 
		btnD.addKeyListener(ka);
		btnD.addMouseListener(mGeneral);
		botones.add(btnD);
		
		btnL = new JButton("L");
		Letras.add(btnL);
		btnL.setFont(new Font("arial",Font.PLAIN,70)); 
		btnL.addKeyListener(ka);
		btnL.addMouseListener(mGeneral);
		botones.add(btnL);
		
		button_3 = new JButton("ESPACIO");
		Letras.add(button_3);
		button_3.addKeyListener(ka);
		button_3.addMouseListener(mGeneral);
		button_3.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_3);
		
		btnC = new JButton("C");
		Letras.add(btnC);
		btnC.setFont(new Font("arial",Font.PLAIN,70)); 
		btnC.addKeyListener(ka);
		btnC.addMouseListener(mGeneral);
		botones.add(btnC);
		
		btnE = new JButton("E");
		Letras.add(btnE);
		btnE.setFont(new Font("arial",Font.PLAIN,70)); 
		btnE.addKeyListener(ka);
		btnE.addMouseListener(mGeneral);
		botones.add(btnE);
		
		btnA = new JButton("A");
		Letras.add(btnA);
		btnA.setFont(new Font("arial",Font.PLAIN,70)); 
		btnA.addKeyListener(ka);
		btnA.addMouseListener(mGeneral);
		botones.add(btnA);
		
		btnO = new JButton("O");
		Letras.add(btnO);
		btnO.setFont(new Font("arial",Font.PLAIN,70)); 
		btnO.addKeyListener(ka);
		btnO.addMouseListener(mGeneral);
		botones.add(btnO);
		
		btnT = new JButton("T");
		Letras.add(btnT);
		btnT.setFont(new Font("arial",Font.PLAIN,70)); 
		btnT.addKeyListener(ka);
		btnT.addMouseListener(mGeneral);
		botones.add(btnT);
		
		
		btnM = new JButton("M");
		Letras.add(btnM);
		btnM.setFont(new Font("arial",Font.PLAIN,70)); 
		btnM.addKeyListener(ka);
		btnM.addMouseListener(mGeneral);
		botones.add(btnM);
		
		btnP = new JButton("P");
		Letras.add(btnP);
		btnP.setFont(new Font("arial",Font.PLAIN,70)); 
		btnP.addKeyListener(ka);
		btnP.addMouseListener(mGeneral);
		botones.add(btnP);
		
		btnB = new JButton("B");
		Letras.add(btnB);
		btnB.setFont(new Font("arial",Font.PLAIN,70)); 
		btnB.addKeyListener(ka);
		btnB.addMouseListener(mGeneral);
		botones.add(btnB);
		
		btnG = new JButton("G");
		Letras.add(btnG);
		btnG.setFont(new Font("arial",Font.PLAIN,70)); 
		btnG.addKeyListener(ka);
		btnG.addMouseListener(mGeneral);
		botones.add(btnG);
		
		btnV = new JButton("V");
		Letras.add(btnV);
		btnV.setFont(new Font("arial",Font.PLAIN,70)); 
		btnV.addKeyListener(ka);
		btnV.addMouseListener(mGeneral);
		botones.add(btnV);
		
		btnY = new JButton("Y");
		Letras.add(btnY);
		btnY.setFont(new Font("arial",Font.PLAIN,70)); 
		btnY.addKeyListener(ka);
		btnY.addMouseListener(mGeneral);
		botones.add(btnY);
		
		btnU = new JButton("U");
		Letras.add(btnU);
		btnU.setFont(new Font("arial",Font.PLAIN,70)); 
		btnU.addKeyListener(ka);
		btnU.addMouseListener(mGeneral);
		botones.add(btnU);
		
		btnI = new JButton("I");
		Letras.add(btnI);
		btnI.setFont(new Font("arial",Font.PLAIN,70)); 
		btnI.addKeyListener(ka);
		btnI.addMouseListener(mGeneral);
		botones.add(btnI);
		
		btnQ = new JButton("Q");
		Letras.add(btnQ);
		btnQ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnQ.addKeyListener(ka);
		btnQ.addMouseListener(mGeneral);
		botones.add(btnQ);
		
		btnH = new JButton("H");
		Letras.add(btnH);
		btnH.setFont(new Font("arial",Font.PLAIN,70)); 
		btnH.addKeyListener(ka);
		btnH.addMouseListener(mGeneral);
		botones.add(btnH);
		
		btnF = new JButton("F");
		Letras.add(btnF);
		btnF.setFont(new Font("arial",Font.PLAIN,70)); 
		btnF.addKeyListener(ka);
		btnF.addMouseListener(mGeneral);
		botones.add(btnF);
		
		btnZ = new JButton("Z");
		Letras.add(btnZ);
		btnZ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnZ.addKeyListener(ka);
		btnZ.addMouseListener(mGeneral);
		botones.add(btnZ);
		
		btnJ = new JButton("J");
		Letras.add(btnJ);
		btnJ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnJ.addKeyListener(ka);
		btnJ.addMouseListener(mGeneral);
		botones.add(btnJ);
		
		btnEnie = new JButton("\u00D1");
		Letras.add(btnEnie);
		btnEnie.setFont(new Font("arial",Font.PLAIN,70)); 
		btnEnie.addKeyListener(ka);
		btnEnie.addMouseListener(mGeneral);
		botones.add(btnEnie);
		
		btnX = new JButton("X");
		Letras.add(btnX);
		btnX.setFont(new Font("arial",Font.PLAIN,70)); 
		btnX.addKeyListener(ka);
		btnX.addMouseListener(mGeneral);
		botones.add(btnX);
		
		btnW = new JButton("W");
		Letras.add(btnW);
		btnW.setFont(new Font("arial",Font.PLAIN,70)); 
		btnW.addKeyListener(ka);
		btnW.addMouseListener(mGeneral);
		botones.add(btnW);
	
		btnK = new JButton("K");
		Letras.add(btnK);
		btnK.setFont(new Font("arial",Font.PLAIN,70)); 
		btnK.addKeyListener(ka);
		btnK.addMouseListener(mGeneral);
		botones.add(btnK);
			
		button_4 = new JButton("ATRAS");
		Letras.add(button_4);
		button_4.addKeyListener(ka);
		button_4.addMouseListener(mGeneral);
		button_4.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_4);	
		
		button = new JButton("BORRAR");
		Letras.add(button);
		button.setFont(new Font("arial",Font.PLAIN,20)); 
		button.addKeyListener(ka);
		button.addMouseListener(mGeneral);
		botones.add(button);
			
		this.setVisible(true);
		temporizadorVertical();
		timer.start();
	}

	private void numericKeyBoard(KeyAdapter ka, JPanel Letras) {
		Letras.setLayout(new GridLayout(3, 9));
		bBotones.add(true);
		for(int i=1; i<30;i++){		
			bBotones.add(false);
		}
		keyBoardType = 3;
		
		btn1 = new JButton("1");
		Letras.add(btn1);
		btn1.setFont(new Font("arial",Font.PLAIN,70)); 
		btn1.addKeyListener(ka);
		btn1.addMouseListener(mGeneral);
		botones.add(btn1);
		
		btn2 = new JButton("2");
		Letras.add(btn2);
		btn2.setFont(new Font("arial",Font.PLAIN,70)); 
		btn2.addKeyListener(ka);
		btn2.addMouseListener(mGeneral);
		botones.add(btn2);
		
		btn3 = new JButton("3");
		Letras.add(btn3);
		btn3.setFont(new Font("arial",Font.PLAIN,70)); 
		btn3.addKeyListener(ka);
		btn3.addMouseListener(mGeneral);
		botones.add(btn3);
		
		button = new JButton("BORRAR");
		Letras.add(button);
		button.setFont(new Font("arial",Font.PLAIN,20)); 
		button.addKeyListener(ka);
		button.addMouseListener(mGeneral);
		botones.add(button);
		
		btn4 = new JButton("4");
		Letras.add(btn4);
		btn4.setFont(new Font("arial",Font.PLAIN,70)); 
		btn4.addKeyListener(ka);
		btn4.addMouseListener(mGeneral);
		botones.add(btn4);
				
		btn5 = new JButton("5");
		Letras.add(btn5);
		btn5.setFont(new Font("arial",Font.PLAIN,70)); 
		btn5.addKeyListener(ka);
		btn5.addMouseListener(mGeneral);
		botones.add(btn5);
		
		btn6 = new JButton("6");
		Letras.add(btn6);
		btn6.setFont(new Font("arial",Font.PLAIN,70)); 
		btn6.addKeyListener(ka);
		btn6.addMouseListener(mGeneral);
		botones.add(btn6);
		
		button_3 = new JButton("ESPACIO");
		button_3.addKeyListener(ka);
		button_3.addMouseListener(mGeneral);
		Letras.add(button_3);
		button_3.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_3);
		
		btn7 = new JButton("7");
		Letras.add(btn7);
		btn7.setFont(new Font("arial",Font.PLAIN,70)); 
		btn7.addKeyListener(ka);
		btn7.addMouseListener(mGeneral);
		botones.add(btn7);
		
		btn8 = new JButton("8");
		Letras.add(btn8);
		btn8.setFont(new Font("arial",Font.PLAIN,70)); 
		btn8.addKeyListener(ka);
		btn8.addMouseListener(mGeneral);
		botones.add(btn8);
	
		btn9 = new JButton("9");
		Letras.add(btn9);
		btn9.setFont(new Font("arial",Font.PLAIN,70)); 
		btn9.addKeyListener(ka);
		btn9.addMouseListener(mGeneral);
		botones.add(btn9);
			
		button_4 = new JButton("ATRAS");
		button_4.addKeyListener(ka);
		button_4.addMouseListener(mGeneral);
		Letras.add(button_4);
		button_4.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_4);	
		
		this.setVisible(true);
		temporizador();
	}

	private void abcKeyBoard(KeyAdapter ka2, JPanel letras2) {
		Letras.setLayout(new GridLayout(3, 9));		
		bBotones.add(true);		
		for(int i=1; i<30;i++){		
			bBotones.add(false);
		}
		keyBoardType = 4;
		
		btnA = new JButton("A");
		Letras.add(btnA);
		btnA.setFont(new Font("arial",Font.PLAIN,70)); 
		btnA.addKeyListener(ka);
		btnA.addMouseListener(mGeneral);
		botones.add(btnA);
		
		btnB = new JButton("B");
		Letras.add(btnB);
		btnB.setFont(new Font("arial",Font.PLAIN,70)); 
		btnB.addKeyListener(ka);
		btnB.addMouseListener(mGeneral);
		botones.add(btnB);
		
		btnC = new JButton("C");
		Letras.add(btnC);
		btnC.setFont(new Font("arial",Font.PLAIN,70)); 
		btnC.addKeyListener(ka);
		btnC.addMouseListener(mGeneral);
		botones.add(btnC);
		
		btnD = new JButton("D");
		Letras.add(btnD);
		btnD.setFont(new Font("arial",Font.PLAIN,70)); 
		btnD.addKeyListener(ka);
		btnD.addMouseListener(mGeneral);
		botones.add(btnD);
		
		btnE = new JButton("E");
		Letras.add(btnE);
		btnE.setFont(new Font("arial",Font.PLAIN,70)); 
		btnE.addKeyListener(ka);
		btnE.addMouseListener(mGeneral);
		botones.add(btnE);
		
		btnF = new JButton("F");
		Letras.add(btnF);
		btnF.setFont(new Font("arial",Font.PLAIN,70)); 
		btnF.addKeyListener(ka);
		btnF.addMouseListener(mGeneral);
		botones.add(btnF);
		
		btnG = new JButton("G");
		Letras.add(btnG);
		btnG.setFont(new Font("arial",Font.PLAIN,70)); 
		btnG.addKeyListener(ka);
		btnG.addMouseListener(mGeneral);
		botones.add(btnG);
		
		btnH = new JButton("H");
		Letras.add(btnH);
		btnH.setFont(new Font("arial",Font.PLAIN,70)); 
		btnH.addKeyListener(ka);
		btnH.addMouseListener(mGeneral);
		botones.add(btnH);
		
		btnI = new JButton("I");
		Letras.add(btnI);
		btnI.setFont(new Font("arial",Font.PLAIN,70)); 
		btnI.addKeyListener(ka);
		btnI.addMouseListener(mGeneral);
		botones.add(btnI);
		
		btnJ = new JButton("J");
		Letras.add(btnJ);
		btnJ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnJ.addKeyListener(ka);
		btnJ.addMouseListener(mGeneral);
		botones.add(btnJ);
		
		btnK = new JButton("K");
		Letras.add(btnK);
		btnK.setFont(new Font("arial",Font.PLAIN,70)); 
		btnK.addKeyListener(ka);
		btnK.addMouseListener(mGeneral);
		botones.add(btnK);
		
		btnL = new JButton("L");
		Letras.add(btnL);
		btnL.setFont(new Font("arial",Font.PLAIN,70)); 
		btnL.addKeyListener(ka);
		btnL.addMouseListener(mGeneral);
		botones.add(btnL);
		
		btnM = new JButton("M");
		Letras.add(btnM);
		btnM.setFont(new Font("arial",Font.PLAIN,70)); 
		btnM.addKeyListener(ka);
		btnM.addMouseListener(mGeneral);
		botones.add(btnM);
		
		btnN = new JButton("N");
		Letras.add(btnN);
		btnN.setFont(new Font("arial",Font.PLAIN,70)); 
		btnN.addKeyListener(ka);
		btnN.addMouseListener(mGeneral);
		botones.add(btnN);
		
		btnEnie = new JButton("\u00D1");
		Letras.add(btnEnie);
		btnEnie.setFont(new Font("arial",Font.PLAIN,70)); 
		btnEnie.addKeyListener(ka);
		btnEnie.addMouseListener(mGeneral);
		botones.add(btnEnie);
		
		btnO = new JButton("O");
		Letras.add(btnO);
		btnO.setFont(new Font("arial",Font.PLAIN,70)); 
		btnO.addKeyListener(ka);
		btnO.addMouseListener(mGeneral);
		botones.add(btnO);
		
		btnP = new JButton("P");
		Letras.add(btnP);
		btnP.setFont(new Font("arial",Font.PLAIN,70)); 
		btnP.addKeyListener(ka);
		btnP.addMouseListener(mGeneral);
		botones.add(btnP);
		
		btnQ = new JButton("Q");
		Letras.add(btnQ);
		btnQ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnQ.addKeyListener(ka);
		btnQ.addMouseListener(mGeneral);
		botones.add(btnQ);
		
		btnR = new JButton("R");
		Letras.add(btnR);
		btnR.setFont(new Font("arial",Font.PLAIN,70)); 
		btnR.addKeyListener(ka);
		btnR.addMouseListener(mGeneral);
		botones.add(btnR);
		
		btnS = new JButton("S");
		Letras.add(btnS);
		btnS.setFont(new Font("arial",Font.PLAIN,70)); 
		btnS.addKeyListener(ka);
		btnS.addMouseListener(mGeneral);
		botones.add(btnS);
		
		btnT = new JButton("T");
		Letras.add(btnT);
		btnT.setFont(new Font("arial",Font.PLAIN,70)); 
		btnT.addKeyListener(ka);
		btnT.addMouseListener(mGeneral);
		botones.add(btnT);
		
		btnU = new JButton("U");
		Letras.add(btnU);
		btnU.setFont(new Font("arial",Font.PLAIN,70)); 
		btnU.addKeyListener(ka);
		btnU.addMouseListener(mGeneral);
		botones.add(btnU);
		
		btnV = new JButton("V");
		Letras.add(btnV);
		btnV.setFont(new Font("arial",Font.PLAIN,70)); 
		btnV.addKeyListener(ka);
		btnV.addMouseListener(mGeneral);
		botones.add(btnV);
		
		btnW = new JButton("W");
		Letras.add(btnW);
		btnW.setFont(new Font("arial",Font.PLAIN,70)); 
		btnW.addKeyListener(ka);
		btnW.addMouseListener(mGeneral);
		botones.add(btnW);
		
		btnX = new JButton("X");
		Letras.add(btnX);
		btnX.setFont(new Font("arial",Font.PLAIN,70)); 
		btnX.addKeyListener(ka);
		btnX.addMouseListener(mGeneral);
		botones.add(btnX);
		
		btnY = new JButton("Y");
		Letras.add(btnY);
		btnY.setFont(new Font("arial",Font.PLAIN,70)); 
		btnY.addKeyListener(ka);
		btnY.addMouseListener(mGeneral);
		botones.add(btnY);
		
		btnZ = new JButton("Z");
		Letras.add(btnZ);
		btnZ.setFont(new Font("arial",Font.PLAIN,70)); 
		btnZ.addKeyListener(ka);
		btnZ.addMouseListener(mGeneral);
		botones.add(btnZ);
		
		button_3 = new JButton("ESPACIO");
		Letras.add(button_3);
		button_3.addKeyListener(ka);
		button_3.addMouseListener(mGeneral);
		button_3.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_3);
		
		button = new JButton("BORRAR");
		Letras.add(button);
		button.setFont(new Font("arial",Font.PLAIN,20)); 
		button.addKeyListener(ka);
		button.addMouseListener(mGeneral);
		botones.add(button);
			
		button_4 = new JButton("ATRAS");
		Letras.add(button_4);
		button_4.addKeyListener(ka);
		button_4.addMouseListener(mGeneral);
		button_4.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_4);	
		
		this.setVisible(true);
		temporizador();
	}

	private void temporizador(){
		timer = new Timer (c.getFrecuencia(), new ActionListener () 
		{ 
			private Voz voz;
			public void actionPerformed(ActionEvent e) 
			{ 

				for(int i=0; i<30;i++){		    		
					if(bBotones.get(i) == true){
						botones.get(i).setBackground(Color.GREEN);
						try {		    				
							voz = new Voz(botones.get(i).getText());
							voz.Reproducir();

						} catch (Exception e1) {
							e1.printStackTrace();
						}

						act=i;
						it = act;
					}
					else if(bBotones.get(i) == false){
						
							botones.get(i).setBackground(null);	    			
					}

				}


				if (keyBoardType == 0 || keyBoardType == 4){
					bBotones.set(act, false);	
					if (act==29){
						act=-1;	
					}
					bBotones.set((act+1), true);
				}
				if (keyBoardType == 1){
					bBotones.set(act, false);	
					if (act==30){
						act=-1;	
					}
					bBotones.set((act+1), true);
				}
				if (keyBoardType == 3){
					bBotones.set(act, false);	
					if (act==11){
						act=-1;	
					}
					bBotones.set((act+1), true);
				}

				act++;
		    } 
		}); 
	}
	
	public void onCambioModo(boolean mod) {
		
		c.setModo(mod);
		if(mod == false){
			timer.stop();
			botones.get(it).setBackground(null);	 
			textArea.setFocusable(true);
			textArea.requestFocus();
			t.enabledModo();

			bBotones = new LinkedList<Boolean>();
			bBotones2 = new LinkedList<Boolean>();
			Letras.removeAll();
			panel.add(Letras, BorderLayout.CENTER);
			Letras.setLayout(new GridLayout(3, 6));
			botones.removeAll(botones);
			botones = new LinkedList<JButton>();
			
			String[] teclados = {
            "QWERTY",
            "Letras mayor uso",
            "Inteligente",
            "Abecedario",
            "Numérico"};
			
            String resp = (String) JOptionPane.showInputDialog(
            		null, 
            		"Seleccione un teclado", 
            		"Teclado", JOptionPane.DEFAULT_OPTION, 
            		null, 
            		teclados, 
            		teclados[0]);
            
		        if(resp.equalsIgnoreCase("Letras mayor uso")){	
		        	mostUsedLetters(ka, Letras);
		        	
		        }
		        else if (resp.equalsIgnoreCase("QWERTY")){	        	
		        	qwertyLetters(ka, Letras);
		        }
		        else if (resp.equalsIgnoreCase("Inteligente")){	        	
		        	intelliKeyBoard(ka, Letras);
		        }
		        else if (resp.equalsIgnoreCase("Numérico")){	        	
		        	numericKeyBoard(ka, Letras);
		        }
		        else if (resp.equalsIgnoreCase("Abecedario")){	        	
		        	abcKeyBoard(ka, Letras);
		        }

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
	}

	public void onCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		c.setFrecuencia(f);
		temporizador();
	}

	public void mouseNiño() {
		// TODO Auto-generated method stub
		accionTeclado();		
	}
	
	private void escribe(int i){

		if(botones.get(i).getText().equalsIgnoreCase("A"))
			textArea.append("A");
		if(botones.get(i).getText().equalsIgnoreCase("B"))
			textArea.append("B");
		if(botones.get(i).getText().equalsIgnoreCase("C"))
			textArea.append("C");
		if(botones.get(i).getText().equalsIgnoreCase("D"))
			textArea.append("D");
		if(botones.get(i).getText().equalsIgnoreCase("E"))
			textArea.append("E");
		if(botones.get(i).getText().equalsIgnoreCase("F"))
			textArea.append("F");
		if(botones.get(i).getText().equalsIgnoreCase("G"))
			textArea.append("G");
		if(botones.get(i).getText().equalsIgnoreCase("H"))
			textArea.append("H");
		if(botones.get(i).getText().equalsIgnoreCase("I"))
			textArea.append("I");
		if(botones.get(i).getText().equalsIgnoreCase("J"))
			textArea.append("J");
		if(botones.get(i).getText().equalsIgnoreCase("K"))
			textArea.append("K");
		if(botones.get(i).getText().equalsIgnoreCase("L"))
			textArea.append("L");
		if(botones.get(i).getText().equalsIgnoreCase("M"))
			textArea.append("M");
		if(botones.get(i).getText().equalsIgnoreCase("N"))
			textArea.append("N");
		if(botones.get(i).getText().equalsIgnoreCase("Ñ"))
			textArea.append("Ñ");
		if(botones.get(i).getText().equalsIgnoreCase("O"))
			textArea.append("O");
		if(botones.get(i).getText().equalsIgnoreCase("P"))
			textArea.append("P");
		if(botones.get(i).getText().equalsIgnoreCase("Q"))
			textArea.append("Q");
		if(botones.get(i).getText().equalsIgnoreCase("R"))
			textArea.append("R");
		if(botones.get(i).getText().equalsIgnoreCase("S"))
			textArea.append("S");
		if(botones.get(i).getText().equalsIgnoreCase("T"))
			textArea.append("T");
		if(botones.get(i).getText().equalsIgnoreCase("U"))
			textArea.append("U");
		if(botones.get(i).getText().equalsIgnoreCase("V"))
			textArea.append("V");
		if(botones.get(i).getText().equalsIgnoreCase("W"))
			textArea.append("W");
		if(botones.get(i).getText().equalsIgnoreCase("X"))
			textArea.append("X");
		if(botones.get(i).getText().equalsIgnoreCase("Y"))
			textArea.append("Y");
		if(botones.get(i).getText().equalsIgnoreCase("Z"))
			textArea.append("Z");
		if(botones.get(i).getText().equalsIgnoreCase("ATRAS")){
					
			try{
				c.onCambioVentanaAtras();	
				
			} catch (ConcurrentModificationException c){
				//this.setVisible(false);
				//Hacemos el try catch por si algun elemento falta 
				//por actualizar en la vista antes de pulsar atrás.
			}
		}
		if(botones.get(i).getText().equalsIgnoreCase("BORRAR"))
			if (textArea.getText() != null)
				textArea.setText(textArea.getText().substring(0, (textArea.getText().length()-1)));
		if(botones.get(i).getText().equalsIgnoreCase("ESPACIO"))
			textArea.append(" ");
		if(botones.get(i).getText().equalsIgnoreCase("1"))
			textArea.append("1");
		if(botones.get(i).getText().equalsIgnoreCase("2"))
			textArea.append("2");
		if(botones.get(i).getText().equalsIgnoreCase("3"))
			textArea.append("3");
		if(botones.get(i).getText().equalsIgnoreCase("4"))
			textArea.append("4");
		if(botones.get(i).getText().equalsIgnoreCase("5"))
			textArea.append("5");
		if(botones.get(i).getText().equalsIgnoreCase("6"))
			textArea.append("6");
		if(botones.get(i).getText().equalsIgnoreCase("7"))
			textArea.append("7");
		if(botones.get(i).getText().equalsIgnoreCase("8"))
			textArea.append("8");
		if(botones.get(i).getText().equalsIgnoreCase("9"))
			textArea.append("9");
	}
	
	private void accionTeclado() {
		
		if (keyBoardType == 2){
			for (int i = 0; i < 30; i++){
				if( bBotones2.get(i)==true){
					escribe(i);
					bBotones2.set(i,false);
				}
			}

			if (fila == false){
				System.out.println(b);
				System.out.println(d);
				if (d == 0)
					b=5;
				else 
					b = d-1;
			}
			if (fila != true) 
				fila=true;
		}
		else{	
			if(bBotones.get(1)==true )		
				escribe(0);
			if(bBotones.get(2)==true)
				escribe(1);
			if(bBotones.get(3)==true)
				escribe(2);
			if(bBotones.get(4)==true)
				escribe(3);
			if(bBotones.get(5)==true)
				escribe(4);
			if(bBotones.get(6)==true)
				escribe(5);
			if(bBotones.get(7)==true)
				escribe(6);
			if(bBotones.get(8)==true)
				escribe(7);
			if(bBotones.get(9)==true)
				escribe(8);
			if(bBotones.get(10)==true)
				escribe(9);
			if(bBotones.get(11)==true)
				escribe(10);
			if(bBotones.get(12)==true)
				escribe(11);
			if(bBotones.get(13)==true)
				escribe(12);
			if(bBotones.get(14)==true)
				escribe(13);
			if(bBotones.get(15)==true)
				escribe(14);
			if(bBotones.get(16)==true)
				escribe(15);
			if(bBotones.get(17)==true)
				escribe(16);
			if(bBotones.get(18)==true)
				escribe(17);
			if(bBotones.get(19)==true)
				escribe(18);
			if(bBotones.get(20)==true)
				escribe(19);
			if(bBotones.get(21)==true)
				escribe(20);
			if(bBotones.get(22)==true)
				escribe(21);
			if(bBotones.get(23)==true)
				escribe(22);
			if(bBotones.get(24)==true)
				escribe(23);
			if(bBotones.get(25)==true)
				escribe(24);
			if(bBotones.get(26)==true)
				escribe(25);
			if(bBotones.get(27)==true)
				escribe(26);
			if(bBotones.get(28)==true)
				escribe(27);
			if(bBotones.get(29)==true)
				escribe(28);
		}
	}

	public void atras() {
		
		this.c.removeObserver(this);
		this.setVisible(false);
		
	}		

	private void temporizadorVertical(){
		timer = new Timer (c.getFrecuencia(), new ActionListener () 
		{ 

			public void actionPerformed(ActionEvent e) 
			{ 			
				if (fila == false){
					bBotones.set(d, true);
					bBotones.set(d+6, true);
					bBotones.set(d+12, true);
					bBotones.set(d+18, true);
					bBotones.set(d+24, true);
				}
				else {
					if (b >= 6)
						bBotones2.set(b-6, false);
					if (b < 30 && b >= 0)
						bBotones2.set(b, true);				
				}
				
				for(int i=0; i<6;i++){	
					if(bBotones.get(i) == true){
						botones.get(i).setBackground(Color.GREEN);
					}
					else
						botones.get(i).setBackground(null);
					if(bBotones.get(i+6) == true){
						botones.get(i+6).setBackground(Color.GREEN);
					}
					else
						botones.get(i+6).setBackground(null);
					if(bBotones.get(i+12) == true){
						botones.get(i+12).setBackground(Color.GREEN);
					}
					else
						botones.get(i+12).setBackground(null);
					if(bBotones.get(i+18) == true){
						botones.get(i+18).setBackground(Color.GREEN);
					}
					else
						botones.get(i+18).setBackground(null);
					if(bBotones.get(i+24) == true){
						botones.get(i+24).setBackground(Color.GREEN);
					}
					else
						botones.get(i+24).setBackground(null);
					
					if(bBotones2.get(i) == true){
						botones.get(i).setBackground(Color.BLUE);
					}
					if(bBotones2.get(i+6) == true){
						botones.get(i+6).setBackground(Color.BLUE);
					}
					if(bBotones2.get(i+12) == true){
						botones.get(i+12).setBackground(Color.BLUE);
					}
					if(bBotones2.get(i+18) == true){
						botones.get(i+18).setBackground(Color.BLUE);
					}
					if(bBotones2.get(i+24) == true){
						botones.get(i+24).setBackground(Color.BLUE);
					}
					
				}
				if (fila == false){

					bBotones.set(d, false);
					bBotones.set(d+6, false);
					bBotones.set(d+12, false);
					bBotones.set(d+18, false);
					bBotones.set(d+24, false);

					if (d < 5)
						d++;
					else
						d=0;
				}
				else{
					if (b < 24){
						b+=6;
					}else if (b >= 24 && b <= 29){
						b = 30;
					}
					else{
						if (b != 30)
							bBotones2.set(b, false);
						else {
							bBotones2.set(24, false);
							bBotones2.set(25, false);
							bBotones2.set(26, false);
							bBotones2.set(27, false);
							bBotones2.set(28, false);
							bBotones2.set(29, false);
						}
						fila = false;
						
					}
					
				}
			} 
		}); 
	}

	
}