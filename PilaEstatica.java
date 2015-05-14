package tda;

public class PilaEstatica<T> implements Pila<T> {

	private int cantidadElementos;
	private int ultimoElemento;
	private int capacidad;
	private T[] pila;

	@SuppressWarnings("unchecked")
	public PilaEstatica() {
		this.pila = (T[]) new Object[1];
		this.ultimoElemento = -1;
		this.cantidadElementos = 0;
		this.capacidad = 1;
	}

	@SuppressWarnings("unchecked")
	private void duplicarTamanio() {
		T[] auxiliar = (T[]) new Object[this.capacidad * 2];
		for (int i = 0; i < this.cantidadElementos; i++) {
			auxiliar[i] = this.pila[i];
		}
		this.capacidad*=2;
		this.ultimoElemento=this.cantidadElementos-1;
		this.pila=auxiliar;
	}

	@Override
	public boolean empty() {
		return this.cantidadElementos == 0;
	}

	// PONER EN PILA

	@Override
	public void push(T obj) {
		if (this.cantidadElementos >= this.capacidad * 0.75) {
			this.duplicarTamanio();
		}
		this.cantidadElementos++;
		this.pila[(++this.ultimoElemento) % this.capacidad] = obj;
	}

	// SACAR DE PILA
	@Override
	public T pop() {
		if (this.ultimoElemento < 0) {
			return null;
		}
		this.cantidadElementos--;
		this.ultimoElemento--;
		return this.pila[(this.ultimoElemento + 1) % this.capacidad];
	}

	@Override
	public T peek() {
		return this.pila[this.ultimoElemento];
	}

	@Override
	public void vaciar() {
		this.cantidadElementos = 0;
		this.ultimoElemento = -1;

	}

}
