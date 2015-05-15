package tda;

public class Lista<T> {
	private Nodo<T> primerNodo;
	private Nodo<T> ultimoNodo;
	private int cantidadElementos;

	public Lista() {
		// this.primerNodo=this.ultimoNodo=null;
		this.primerNodo = null;
		this.cantidadElementos = 0;
	}

	// Inserta un elemento al final
	public void pushBack(T obj) {
		Nodo<T> auxiliar = new Nodo<T>(obj, null);
		if (this.ultimoNodo != null) {
			this.ultimoNodo.setSig(auxiliar);
		} else {
			this.primerNodo = auxiliar;
		}
		this.ultimoNodo = auxiliar;
		this.cantidadElementos++;
	}

	// Borra un elemento al final
	public void popBack() {
		Nodo<T> aux = null;
		if (this.cantidadElementos != 0) {
			aux = this.primerNodo;
			for (int i = 0; i < this.cantidadElementos - 1; i++) {
				aux = aux.getSig();
			}
			if (aux == this.primerNodo) {
				this.ultimoNodo = this.primerNodo = null;
			} else {
				aux.setSig(null);
				this.ultimoNodo = aux;
			}
		}
	}

	// Inserta un elemento al comienzo
	public void pushFront(T obj) {
		if (this.cantidadElementos == 0) {
			this.primerNodo = this.ultimoNodo = new Nodo<T>(obj, null);
			return;
		}
		this.primerNodo = new Nodo<T>(obj, this.primerNodo);
	}

	// Borra un elemento al final
	public void popFront() {
		if (this.primerNodo == null)
			return;
		this.primerNodo = this.primerNodo.getSig();
	}

	// Elimina un elemento de un valor determinado.
	public boolean remove(T obj) {
		Nodo<T> lectura = this.primerNodo;
		while(lectura!=null &&	lectura.getSig()!=null && lectura.getSig().compararInformacion(obj) ){
			lectura=lectura.getSig();
		}
		if(lectura==null || lectura.getSig()==null){
			return false;
		}
		lectura=lectura.getSig().getSig();
		return true;
	}

	// public boolean insert(posición, dato )//insertar

	// Eliminar por posición
	public T erase(int posicion) {
		return null;
	}

	public T buscar(T dato) {
		return null;
	}

	public T buscar(int posición) {
		return null;
	}

	public void vaciar() {

	}

	// vacia
	public boolean empty() {
		return this.cantidadElementos == 0;
	}

	public void reverse() {
		Nodo<T> lectura = this.primerNodo;
		while (lectura != null && lectura.getSig() != null) {
			Nodo<T> aux = lectura.getSig();
			lectura.setSig(aux.getSig());
			aux.setSig(this.primerNodo);
			this.primerNodo = aux;
		}
	}

}
