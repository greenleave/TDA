package tda;

public class ColaEstatica<T> implements Cola<T> {

	private T[] cola;
	private int capacidad;
	private int primerElemento;
	private int cantidadElementos;

	@SuppressWarnings("unchecked")
	public ColaEstatica() {
		this.cola = (T[]) new Object[1];
		this.capacidad = 1;
		this.cantidadElementos = 0;
		this.primerElemento = 0;
	}

	@SuppressWarnings("unchecked")
	private void cambiarTamanio(){
		T vAuxiliar[]=(T[])new Object[this.capacidad*2];
		for(int i=0; i<this.cantidadElementos;i++){
			vAuxiliar[i] = this.cola[(this.primerElemento+i)%this.capacidad];
		}
		this.primerElemento=0;
		this.capacidad*=2;
		this.cola=vAuxiliar;
	}
	
	@Override
	public boolean empty() {
		return this.cantidadElementos==0;
	}

	@Override
	public void offer(T obj) {
		if(this.capacidad*0.75 < this.cantidadElementos){
			this.cambiarTamanio();
		}
		///System.out.println(((this.primerElemento+this.cantidadElementos)%this.capacidad));
		this.cola[(this.primerElemento+(this.cantidadElementos++)) % this.capacidad]= obj;
	}

	@Override
	public T poll(){
		int elemento=(this.primerElemento++) % this.capacidad;
		this.cantidadElementos--;
		return this.cola[elemento];
	}

	@Override
	public T peek() {
		return (T) this.cola[this.primerElemento%this.capacidad];
	}

	@Override
	public void vaciar() {
		this.cantidadElementos=0;
		this.primerElemento=0;
	}



	
	
	
	

}
