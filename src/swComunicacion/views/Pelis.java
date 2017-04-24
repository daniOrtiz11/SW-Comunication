package swComunicacion.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;

import java.awt.Color;

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
	private JLabel tit = new JLabel ("Titulo");
	private JTextField titF = new JTextField();
	private JLabel img = new JLabel("Imagen");
	private String[] args;
	private JPanel bots;
	private JButton anyadir = new JButton("Añadir películas");
	private JButton listar = new JButton("Listar películas");
	private JButton atras = new JButton("Atrás");
	private boolean batras = false;
	private JPanel dialog;
	private JButton cargarIm = new JButton("Cargar imagen");
	private ImageIcon iconPel;
	private KeyListener[] keyListener = new KeyListener[8];
	private MouseListener[] mouseListener = new MouseListener[8];
	private ImageIcon si;
	private MouseListener mgeneral;
	private JScrollPane scrollpane;
	private JList list;
	private JPanel listado;
	private String[] categories;
	private ImageIcon iconList;
	
	public Pelis(Controller controlador, HashMap<Integer, ArrayList<String>> busqueda) {
		this.setExtendedState(MAXIMIZED_BOTH); //Para que se inicie siempre al tamaï¿½o mï¿½ximo.
		this.c = controlador;
		setTitle("Peliculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.si = new ImageIcon("src/imagenes/si.png");
		temporizador();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		anyadir.setFont(new Font("Roboto", Font.BOLD, 20));
		listar.setFont(new Font("Roboto", Font.BOLD, 20));
		t = new ToolbarSup(c, 3,null);
		contentPane.add(t, BorderLayout.NORTH);
		aux = new JPanel();
		aux.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(aux, BorderLayout.CENTER);
		aux.setLayout(new GridLayout(2, 2, 10, 10));
		pelis = new JPanel();
		pelis.setBackground(Color.WHITE);
		pelis.setLayout(new GridLayout(2,4,10,10));
		Border thickBorder = new LineBorder(Color.RED, 5);
		atras.setBorder(thickBorder);
		results = c.cargarDatos();
		
		if(busqueda == null){ //Se cargan las 8 más actuales
			if(results != null){//Consigo las peliculas que hay en el xml, solo 8.
				for(int i = results.size()-1;i>=0 && i >= (results.size() - 7); i--){
					lista = results.get(i);// Cojo la primera pelicula
					//Solo hay titulo e imagen
					this.pelicula[indp] = new Pelicula(lista.get(0), lista.get(1)); //Peliculas actualmente visibles
					pelis.add(pelicula[indp]);
					indp++;
				}
				
			}
		} else { //Se carga el listado de películas que se pasa.
			for(int j = 0;j <= busqueda.size()-1; j++){
				lista = busqueda.get(j);// Cojo la primera pelicula
				//Solo hay titulo e imagen
				this.pelicula[indp] = new Pelicula(lista.get(0), lista.get(1)); //Peliculas actualmente visibles
				pelis.add(pelicula[indp]);
				indp++;
			}
		}
		atras.setFont(new Font("Roboto", Font.BOLD, 50));
		atras.setBackground(Color.WHITE);
		pelis.add(atras);
		contentPane.add(pelis, BorderLayout.CENTER);
	//AÑADIR NUEVAS PELICULAS (SI NO SE INTRODUCE UNA IMAGEN, HABRIA QUE TENER UNA POR DEFECTO).
	
		bots = new JPanel();
		bots.setLayout(new GridLayout(1,2));
		dialog = new JPanel(new GridLayout(2,2));
		args = new String[4]; // IMPORTANTE INICIALIZAR ESTE ARRAY DE STRINGS. 
		cargarIm.addActionListener(new ActionListener() { 
			
			public void actionPerformed(ActionEvent e)
            {
				JFileChooser fc = new JFileChooser();
		        int respuesta = fc.showOpenDialog(null);
		        
		        //Comprobar si se ha pulsado Aceptar
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            File logo = fc.getSelectedFile();   
		            args[1] = logo.getName();
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
				               "Añadir pelicula ", JOptionPane.OK_CANCEL_OPTION,0,iconPel);
					// Si es 2 o -1 esque ha pulsado a cancelar o cerrar.
					try{
						if(titF.getText().length() != 0){
							ok = true;
							args[0] = titF.getText();
							if(args[1] == null) args[1] = "defecto.jpg";
						} else{
							//Hay que forzar un error para que salte el catch.
							 @SuppressWarnings("unused")
							int n = Integer.parseInt("M");
						}

					}catch(Exception e1){
						UIManager.put("OptionPane.minimumSize",new Dimension(100,100)); 
						if(s != -1 && s != 2){
							JOptionPane.showMessageDialog(dialog, "Algun campo esta incompleto.", "Error", JOptionPane.ERROR_MESSAGE);
							ok = false;
						}
					}
				}while(s!= -1 && s!= 2 && !ok);
				 
				if(s!= -1 && s!= 2){
					if(c.escribirDatos(args)){
						UIManager.put("OptionPane.minimumSize",new Dimension(100,100));
						JOptionPane.showMessageDialog(dialog, "La pelicula ha sido añadida con exito.", "Success", JOptionPane.INFORMATION_MESSAGE);
						cerrarVentana();
						new Pelis(c,null);
					}else{
						UIManager.put("OptionPane.minimumSize",new Dimension(100,100));
						JOptionPane.showMessageDialog(dialog, "La pelicula no se ha añadido con exito.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		atras.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.onCambioVentanaAtras();
			}
			
		});
		atras.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				c.onCambioVentanaAtras();
			}

		});
		listar.addActionListener(new ActionListener(){
			@SuppressWarnings({ "unchecked", "rawtypes"})
			public void actionPerformed(ActionEvent e){
				boolean ok = false;
				int s;
				do{
					categories = new String[results.size()];
					for(int i = 0;i <= (results.size()-1); i++){
						lista = results.get(i);
						categories[i] = lista.get(0);
					}
				    
				    list = new JList(categories);
				    list.setSelectionModel(new DefaultListSelectionModel() {
				        public void setSelectionInterval(int index0, int index1) {
				            if(super.isSelectedIndex(index0)) {
				                super.removeSelectionInterval(index0, index1);
				            }
				            else {
				                super.addSelectionInterval(index0, index1);
				            }
				        }
				    });
				    scrollpane = new JScrollPane(list);
				    listado = new JPanel();
				    listado.add(scrollpane);
				    iconList = new ImageIcon("src/imagenes/peli.png");
					s = JOptionPane.showConfirmDialog(null, listado, 
				               "Listar películas ", JOptionPane.OK_CANCEL_OPTION,0, iconList);
					
					if(s != -1 && s != 2){
						
						if(list.getSelectedValuesList().size() < 1){
							UIManager.put("OptionPane.minimumSize",new Dimension(100,100));
							JOptionPane.showMessageDialog(dialog, "Tienes que elegir al menos una película.", "Error", JOptionPane.ERROR_MESSAGE);
						} else if(list.getSelectedValuesList().size() > 7) {
							UIManager.put("OptionPane.minimumSize",new Dimension(100,100));
							JOptionPane.showMessageDialog(dialog, "Se puede elegir un máximo de 7 películas.", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							ok = true;
							HashMap<Integer, ArrayList<String>> listBusqueda = c.busquedaDatos(list.getSelectedValuesList());
							cerrarVentana();
							new Pelis(c,listBusqueda);
						}
					}
					// Si es 2 o -1 esque ha pulsado a cancelar o cerrar.
				}while(s!= -1 && s!= 2 && !ok);
			}
		});
		
		bots.add(listar);
		bots.add(anyadir);
		contentPane.add(bots, BorderLayout.SOUTH);
		this.setVisible(true);
		this.c.addObserver(this);
		if(c.getModo() == true){
			pelicula[0].activa();
			timer.start();
			listModNiño();
			this.anyadir.setEnabled(false);
			this.listar.setEnabled(false);
			this.atras.setVisible(true);
		} else {
			for(int i = 0; i < pelicula.length; i++){
				if(pelicula[i] != null)
				pelicula[i].activa();
			}
			this.atras.setVisible(false);
			listModMadre();
		}
		this.setExtendedState(MAXIMIZED_BOTH);
	}
	
	private void listModMadre() {
		// TODO Auto-generated method stub
		for(int i = 0; i < pelicula.length; i++){
			if(pelicula[i] != null){
			pelicula[i].removeKeyListener(keyListener[i]);
			}
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
			if(pelicula[indp] != null)
			pelicula[indp].addMouseListener(mouseListener[indp]);
		}
	}

	private void listModNiño() {
		// TODO Auto-generated method stub
		for(int i = 0; i < pelicula.length; i++){
			if(pelicula[i] != null){
			pelicula[i].removeMouseListener(mouseListener[i]);
			}
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
						if(o.getInfo() != "Atrás")
						JOptionPane.showMessageDialog(null,o.getInfo(), "Seleccion", 0, si); 
					}
					timer.restart();
				}
			};
			if(pelicula[indp] != null){
			pelicula[indp].addKeyListener(keyListener[indp]);
			pelicula[indp].addMouseListener(mgeneral);
			}
		}
	}

	private void temporizador() {
		// TODO Auto-generated method stub
		timer = new Timer (c.getFrecuencia(), new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    {
		    	if(batras == true){
		    		batras = false;
		    		Border thickBorder = new LineBorder(Color.RED, 5);
		    		atras.setBorder(thickBorder);
		    		pelicula[0].activa();
		    		pelicula[0].requestFocus();
		    	}
		    	else if(pelicula[0].isActiva() == true){
		    		pelicula[0].desactiva();
		    		if(pelicula[1] != null){
		    		pelicula[1].activa();
		    		pelicula[1].requestFocus();
		    		}
		    		else{
		    			batras = true;
			    		atras.requestFocus();
			    		Border thickBorder = new LineBorder(Color.GREEN, 20);
			    		atras.setBorder(thickBorder);
		    		}
		    	}
		    	else if(pelicula[1].isActiva() == true){
		    		pelicula[1].desactiva();
		    		if(pelicula[2] != null){
		    		pelicula[2].activa();
		    		pelicula[2].requestFocus();
		    		}
		    		else{
		    			batras = true;
			    		atras.requestFocus();
			    		Border thickBorder = new LineBorder(Color.GREEN, 20);
			    		atras.setBorder(thickBorder);
		    		}
		    	}
		    	else if(pelicula[2].isActiva() == true){
		    		pelicula[2].desactiva();
		    		if(pelicula[3] != null){
		    		pelicula[3].activa();
		    		pelicula[3].requestFocus();
		    		}
		    		else{
		    			batras = true;
			    		atras.requestFocus();
			    		Border thickBorder = new LineBorder(Color.GREEN, 20);
			    		atras.setBorder(thickBorder);
		    		}
		    	}
		    	else if(pelicula[3].isActiva() == true){
		    		pelicula[3].desactiva();
		    		if(pelicula[4] != null){
		    		pelicula[4].activa();
		    		pelicula[4].requestFocus();
		    		}
		    		else{
		    			batras = true;
			    		atras.requestFocus();
			    		Border thickBorder = new LineBorder(Color.GREEN, 20);
			    		atras.setBorder(thickBorder);
		    		}
		    	}
		    	else if(pelicula[4].isActiva() == true){
		    		pelicula[4].desactiva();
		    		if(pelicula[5] != null){
		    		pelicula[5].activa();
		    		pelicula[5].requestFocus();
		    		}
		    		else{
		    			batras = true;
			    		atras.requestFocus();
			    		Border thickBorder = new LineBorder(Color.GREEN, 20);
			    		atras.setBorder(thickBorder);
		    		}
		    	}
		    	else if(pelicula[5].isActiva() == true){
		    		pelicula[5].desactiva();
		    		if(pelicula[6] != null){
		    		pelicula[6].activa();
		    		pelicula[6].requestFocus();
		    		}
		    		else{
		    			batras = true;
			    		atras.requestFocus();
			    		Border thickBorder = new LineBorder(Color.GREEN, 20);
			    		atras.setBorder(thickBorder);
		    		}
		    	}
		    	else if(pelicula[6].isActiva() == true){
		    		pelicula[6].desactiva();
		    		batras = true;
		    		atras.requestFocus();
		    		Border thickBorder = new LineBorder(Color.GREEN, 20);
		    		atras.setBorder(thickBorder);
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
			for(int i = 1; i < pelicula.length; i++){
				if(pelicula[i] != null)
				pelicula[i].desactiva();
			}
			timer.start();
			t.disabledModo();
			listModNiño();
			this.anyadir.setEnabled(false);
			this.listar.setEnabled(false);
			this.atras.setVisible(true);
		} else {
			for(int i = 0; i < pelicula.length; i++){
				if(pelicula[i] != null)
				pelicula[i].activa();
			}
			listModMadre();
			t.enabledModo();
			timer.stop();
			this.anyadir.setEnabled(true);
			this.listar.setEnabled(true);
			this.atras.setVisible(false);
		}
	}

	public void onCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		c.setFrecuencia(f);
		temporizador();
	}

	public void mouseNiño() {
		// TODO Auto-generated method stub
		timer.stop();
		if(batras == true){
			c.onCambioVentanaAtras();
		}
		for(indp = 0; indp < pelicula.length; indp++){
			if(pelicula[indp] != null){
			if(pelicula[indp].isActiva()){
				UIManager.put("OptionPane.minimumSize",new Dimension(100,100));
				JOptionPane.showMessageDialog(null,pelicula[indp].getInfo(), "Seleccion", 0, si); 
			}
		}
		}
		timer.restart();
	}

	public void atras() {
		// TODO Auto-generated method stub
		this.c.removeObserver(this);
		this.setVisible(false);
	}
}


