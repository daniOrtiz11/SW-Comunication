package swComunicacion.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;

@SuppressWarnings("serial")
public class Pelis extends JFrame implements Observer{

	private JPanel contentPane;
	private Controller c;
	private JPanel aux;
	private ToolbarSup t;
	private Pelicula[] pelicula = new Pelicula[8];
	private int indp = 0;
	private Timer timer;
	private HashMap<Integer, ArrayList<String>> results;
	private String informacion;
	private static ArrayList<String> lista;
	private JPanel pelis;
	private JLabel tit = new JLabel ("Título");
	private JTextField titF = new JTextField();
	private JLabel dir = new JLabel("Director");
	private JTextField dirF = new JTextField(15);
	private JLabel gen = new JLabel("Género");
	private JTextField genF = new JTextField(15);
	private JLabel img = new JLabel("Imagen");
	private String[] args;
	private JPanel bots;
	private JButton anyadir = new JButton("Añadir películas");
	private JPanel dialog;
	private JButton cargarIm = new JButton("Cargar imagen");
	private ImageIcon iconPel;
	private KeyListener[] keyListener = new KeyListener[8];
	private MouseListener[] mouseListener = new MouseListener[8];
	private ImageIcon si;
	private MouseListener mgeneral;
	
	public Pelis(Controller controlador) {
		this.c = controlador;
		setTitle("Películas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.si = new ImageIcon("src/imagenes/si.png");
		temporizador();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		t = new ToolbarSup(c, 3);
		contentPane.add(t, BorderLayout.NORTH);
		aux = new JPanel();
		aux.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(aux, BorderLayout.CENTER);
		aux.setLayout(new GridLayout(2, 2, 10, 10));
		pelis = new JPanel();
		pelis.setLayout(new GridLayout(2,4,10,10));
		results = c.cargarDatos(); //Consigo las peliculas que hay en el xml, solo 8.
		for(int i = results.size()-1;i >= (results.size() - 8); i--){
			lista = results.get(i);// Cojo la primera película
			informacion = new String();
			for(int j = 0; j < lista.size(); j++){ //Título, director, genero, imagen.
				if(j == 3){
					this.pelicula[indp] = new Pelicula(informacion, lista.get(j)); //Peliculas actualmente visibles
					pelis.add(pelicula[indp]);
					indp++;
				} else{
					informacion += "\n - " +lista.get(j);
				}
			}
		}
		contentPane.add(pelis, BorderLayout.CENTER);
	//AÑADIR NUEVAS PELICULAS (SI NO SE INTRODUCE UNA IMÁGEN, HABRÍA QUE TENER UNA POR DEFECTO).
	
		bots = new JPanel();
		bots.setLayout(new GridLayout(1,2));
		dialog = new JPanel(new GridLayout(4,2));
		args = new String[4]; // IMPORTANTE INICIALIZAR ESTE ARRAY DE STRINGS. 
		cargarIm.addActionListener(new ActionListener() { 
			
			public void actionPerformed(ActionEvent e)
            {
				JFileChooser fc = new JFileChooser();
		        int respuesta = fc.showOpenDialog(null);
		        
		        //Comprobar si se ha pulsado Aceptar
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            File logo = fc.getSelectedFile();   
		            args[3] = logo.getName();
		            
		            // Ahora guardamos la imagen en la carpeta de imagenes
		            try {
						c.mvImagen(logo);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
            }
        });
		dialog.add(tit);
		dialog.add(titF);
		dialog.add(Box.createHorizontalStrut(15));
		dialog.add(dir);
		dialog.add(dirF);
		dialog.add(Box.createHorizontalStrut(15));
		dialog.add(gen);
		dialog.add(genF);
		dialog.add(Box.createHorizontalStrut(15));
		dialog.add(img);
		dialog.add(cargarIm);
		dialog.add(Box.createHorizontalStrut(15));
		iconPel = new ImageIcon("src/imagenes/pelicula.png");
		anyadir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean ok = false;
				int s;
				do{
					UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
					s = JOptionPane.showConfirmDialog(null, dialog, 
				               "Añadir película ", JOptionPane.OK_CANCEL_OPTION,0,iconPel);
					// Si es 2 o -1 esque ha pulsado a cancelar o cerrar.
					try{
						if(titF.getText().length() != 0 && dirF.getText().length() != 0 && genF.getText().length() != 0){
							ok = true;
							args[0] = titF.getText();
							args[1] = dirF.getText();
							args[2] = genF.getText();
							if(args[3] == null) args[3] = "defecto.jpg";
						} else{
							//Hay que forzar un error para que salte el catch.
							 @SuppressWarnings("unused")
							int n = Integer.parseInt("M");
						}

					}catch(Exception e1){
						UIManager.put("OptionPane.minimumSize",new Dimension(100,100)); 
						if(s != -1 && s != 2){
							JOptionPane.showMessageDialog(dialog, "Algún campo está incompleto.", "Error", JOptionPane.ERROR_MESSAGE);
							ok = false;
						}
					}
				}while(s!= -1 && s!= 2 && !ok);
				 
				if(s!= -1 && s!= 2){
					//if(TratarXML.escribirXML(args)){
					if(c.escribirDatos(args)){
						UIManager.put("OptionPane.minimumSize",new Dimension(100,100));
						JOptionPane.showMessageDialog(dialog, "La película ha sido añadida con éxito.", "Success", JOptionPane.INFORMATION_MESSAGE);
						cerrarVentana();
						new Pelis(c);
					}else{
						UIManager.put("OptionPane.minimumSize",new Dimension(100,100));
						JOptionPane.showMessageDialog(dialog, "La película no se ha añadido con éxito.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		bots.add(anyadir);
		contentPane.add(bots, BorderLayout.SOUTH);
		this.setVisible(true);
		this.c.addObserver(this);
		//Comprobar el modo al entrar
		if(c.getModo() == true){
			pelicula[0].activa();
			timer.start();
			listModNiño();
			this.anyadir.setEnabled(false);
		} else {
			for(int i = 0; i < pelicula.length; i++){
				pelicula[i].activa();
			}
			listModMadre();
		}
		this.setExtendedState(MAXIMIZED_BOTH);
	}
	
	private void listModMadre() {
		// TODO Auto-generated method stub
		for(int i = 0; i < pelicula.length; i++){
			pelicula[i].removeKeyListener(keyListener[i]);
		}
		for(indp = 0; indp < pelicula.length; indp++){
			mouseListener[indp] = new MouseAdapter(){
				@SuppressWarnings("unused")
				public void MouseClicked(MouseEvent e) { //al pulsar con el raton
					Pelicula o = (Pelicula) e.getSource();
					if(o.isActiva() == true){
						JOptionPane.showMessageDialog(null,o.getInfo(), "Seleccion", 0, si); 
					}
				}
			};
			pelicula[indp].addMouseListener(mouseListener[indp]);
		}
	}

	private void listModNiño() {
		// TODO Auto-generated method stub
		for(int i = 0; i < pelicula.length; i++){
			pelicula[i].removeMouseListener(mouseListener[i]);
		}
		mgeneral = new MouseAdapter(){
			public void mouseClicked (MouseEvent e){
					mouseNiño();
			}
		};
		contentPane.addMouseListener(mgeneral);
		for(indp = 0; indp < pelicula.length; indp++){
			keyListener[indp] = new KeyAdapter(){
				public void keyPressed(KeyEvent e) { //al pulsar cualquier tecla
					timer.stop();
					Pelicula o = (Pelicula) e.getSource();
					if(o.isActiva() == true){
						JOptionPane.showMessageDialog(null,o.getInfo(), "Seleccion", 0, si); 
					}
					timer.restart();
				}
			};
			pelicula[indp].addKeyListener(keyListener[indp]);
			pelicula[indp].addMouseListener(mgeneral);
		}
	}

	private void temporizador() {
		// TODO Auto-generated method stub
		timer = new Timer (c.getFrecuencia(), new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	if(pelicula[0].isActiva() == true){
		    		pelicula[0].desactiva();
		    		pelicula[1].activa();
		    		pelicula[1].requestFocus();
		    	}
		    	else if(pelicula[1].isActiva() == true){
		    		pelicula[1].desactiva();
		    		pelicula[2].activa();
		    		pelicula[2].requestFocus();
		    	}
		    	else if(pelicula[2].isActiva() == true){
		    		pelicula[2].desactiva();
		    		pelicula[3].activa();
		    		pelicula[3].requestFocus();
		    	}
		    	else if(pelicula[3].isActiva() == true){
		    		pelicula[3].desactiva();
		    		pelicula[4].activa();
		    		pelicula[4].requestFocus();
		    	}
		    	else if(pelicula[4].isActiva() == true){
		    		pelicula[4].desactiva();
		    		pelicula[5].activa();
		    		pelicula[5].requestFocus();
		    	}
		    	else if(pelicula[5].isActiva() == true){
		    		pelicula[5].desactiva();
		    		pelicula[6].activa();
		    		pelicula[6].requestFocus();
		    	}
		    	else if(pelicula[6].isActiva() == true){
		    		pelicula[6].desactiva();
		    		pelicula[7].activa();
		    		pelicula[7].requestFocus();
		    	}
		    	else if(pelicula[7].isActiva() == true){
		    		pelicula[7].desactiva();
		    		pelicula[0].activa();
		    		pelicula[0].requestFocus();
		    	}
	}
		});
		}
	public void cerrarVentana(){
		this.setVisible(false);
	}

	public void onCambioOpcion(int op) {
		// TODO Auto-generated method stub
		if(op == 1){
			this.c.removeObserver(this);
			this.setVisible(false);
			new PrincipalView(c);
		}
	}

	public void onCambioModo(boolean m) {
		// TODO Auto-generated method stub
		if(c.getModo() == true){
			pelicula[0].activa();
			for(int i = 1; i < pelicula.length; i++)
				pelicula[i].desactiva();
			//temporizador();
			timer.start();
			t.disabledModo();
			listModNiño();
			this.anyadir.setEnabled(false);
		} else {
			for(int i = 0; i < pelicula.length; i++){
				pelicula[i].activa();
			}
			listModMadre();
			t.enabledModo();
			timer.stop();
			this.anyadir.setEnabled(true);
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
		timer.stop();
		for(indp = 0; indp < pelicula.length; indp++){
			if(pelicula[indp].isActiva())
				JOptionPane.showMessageDialog(null,pelicula[indp].getInfo(), "Seleccion", 0, si); 
		}
		timer.restart();
	}
}


