package swComunicacion;


import swComunicacion.views.PrincipalView;

public class Main {

	public static void main(String[] args) {
		
		Data d = new Data(true, 1000);
	   	Controller c = new Controller(d);
	   	@SuppressWarnings("unused")
	   	PrincipalView vista = new PrincipalView(c);
	}
	
	}


