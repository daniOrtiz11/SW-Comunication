package swComunicacion;

import java.util.Vector;

import swComunicacion.Observer;

public class Data {

	private Vector<Observer> observadores;
	
	public Data(){
		this.observadores = new Vector<Observer>();
	}
	public boolean addObserver(Observer po) {
		if (!this.observadores.contains(po)){
			this.observadores.add(po);
			return true;
		}
		return false;
	}

	public boolean removeObserver(Observer o){
		if(this.observadores.contains(o)){
			this.observadores.remove(o);
			return true;
		}
		return false;
	}

	public void notifyCambioOpcion(boolean op) {
		// TODO Auto-generated method stub
		for (Observer o : observadores){
			o.onCambioOpcion(op);
		}
	}

}
