package swComunicacion;

public class Controller {

	private Data d;
	public Controller(Data d2) {
		// TODO Auto-generated constructor stub
		d = d2;
	}
	
	public boolean addObserver(Observer po) {
		return d.addObserver(po);
	}
	
	public boolean removeObserver(Observer po){
		return d.removeObserver(po);
	}
	

	public void onCambioOpcion(int op){
		d.notifyCambioOpcion(op);
	}

	public void onCambioModo(boolean m) {
		// TODO Auto-generated method stub
		d.notifyCambioModo(m);
	}

	public void onCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		d.notifyCambioFrecuencia(f);
	}

	public void aumentarFrecuencia() {
		// TODO Auto-generated method stub
		int f = d.getFrecuencia();
		f = f + 300;
		d.setFrecuencia(f);
	}

	public void disminuirFrecuencia() {
		// TODO Auto-generated method stub
		int f = d.getFrecuencia();
		f = f - 300;
		d.setFrecuencia(f);
	}

	public boolean getModo() {
		// TODO Auto-generated method stub
		return this.d.getModo();
	}

	public void setModo(boolean b) {
		// TODO Auto-generated method stub
		d.setModo(b);
	}

	public int getFrecuencia() {
		// TODO Auto-generated method stub
		return d.getFrecuencia();
	}

	public void setFrecuencia(int f) {
		// TODO Auto-generated method stub
		d.setFrecuencia(f);
	}

}
