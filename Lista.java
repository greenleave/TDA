package tda;

public class Lista<T> {
	private Nodo<T> primerNodo;
	private Nodo<T> ultimoNodo;
	private int cantidadElementos;

	public Lista() {
		this.primerNodo = this.ultimoNodo = null;
		this.cantidadElementos = 0;
	}

	protected boolean pushBack(T obj) {
		Nodo<T> nuevoNodo = new Nodo<T>(obj, null);
		if (this.cantidadElementos == 0) {
			this.primerNodo = nuevoNodo;
		} else {
			this.ultimoNodo.setSig(nuevoNodo);
		}
		this.ultimoNodo = nuevoNodo;
		this.cantidadElementos++;
		return true;
	}

	protected boolean pushFront(T obj) {
		Nodo<T> nuevoNodo = new Nodo<T>(obj, this.primerNodo);
		if (this.cantidadElementos == 0) {
			this.ultimoNodo = nuevoNodo;
		}
		this.primerNodo = nuevoNodo;
		this.cantidadElementos++;
		return true;
	}

	protected T popBack() {
		if (this.cantidadElementos == 0)
			return null;
		Nodo<T> lectura = this.primerNodo;
		while (lectura.getSig() != this.ultimoNodo) {
			// ESTOY RECORRIENDO LOS NODOS
			lectura.setSig(lectura.getSig());
		}
		if (this.cantidadElementos == 1) {
			this.primerNodo = this.ultimoNodo = null;
			this.cantidadElementos--;
			return lectura.getInfo();
		} else {
			T auxiliar = lectura.getSig().getInfo();
			lectura.setSig(null);
			this.ultimoNodo = lectura;
			this.cantidadElementos--;
			return auxiliar;
		}
	}

	protected T popFront() {
		if (cantidadElementos == 0)
			return null;
		T auxiliar = this.primerNodo.getInfo();
		this.primerNodo = this.primerNodo.getSig();
		if (this.cantidadElementos == 1)
			this.ultimoNodo = this.primerNodo;
		this.cantidadElementos--;
		return auxiliar;
	}

	protected T erase(int posicion) {
		if (this.cantidadElementos <= posicion || posicion < 0)
			return null;
		T auxiliar;
		if (posicion == 0) {
			auxiliar = this.primerNodo.getInfo();
			this.primerNodo = this.primerNodo.getSig();
		} else {
			Nodo<T> lectura = this.primerNodo;
			for (int i = 0; i < posicion - 1; i++) {
				lectura = lectura.getSig();
			}
			auxiliar = lectura.getSig().getInfo();
			lectura.setSig(lectura.getSig().getSig());
			if (this.cantidadElementos - 1 == posicion) {
				this.ultimoNodo = lectura;
			}
		}
		this.cantidadElementos--;
		return auxiliar;
	}

	protected T buscar(T dato) {
		Nodo<T> lectura = this.primerNodo;
		while (lectura != null && !lectura.compararInformacion(dato))
			lectura = lectura.getSig();
		return lectura == null ? null : lectura.getInfo();
	}

	protected T buscar(int posicion) {
		if (this.cantidadElementos <= posicion || posicion < 0) {
			return null;
		}
		Nodo<T> auxiliar = this.primerNodo;
		for (int i = 0; i < posicion; i++) {
			auxiliar = auxiliar.getSig();
		}
		return auxiliar.getInfo();
	}

	public void vaciar() {
		this.primerNodo = this.ultimoNodo = null;
		this.cantidadElementos = 0;
	}

	// vacia
	public boolean empty() {
		return this.cantidadElementos == 0;
	}

	protected void reverse() {
		Nodo<T> lectura = this.primerNodo;
		while (lectura != null && lectura.getSig() != null) {
			Nodo<T> aux = lectura.getSig();
			lectura.setSig(aux.getSig());
			aux.setSig(this.primerNodo);
			this.primerNodo = aux;
		}
	}
	
	protected int getCantidadElementos(){
		return this.cantidadElementos;
	}


}
