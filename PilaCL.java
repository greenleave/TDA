package tda;

public class PilaCL<T> implements Pila<T> {
	private Lista<T> pila;
	
	public PilaCL(){
		this.pila=new Lista<T>();
	}

	public void push(T obj) {
		this.pila.pushFront(obj);
	}

	public T pop() {
		return this.pila.popFront();
	}

	public T peek() {
		return this.pila.buscar(0);
	}

	@Override
	public boolean empty() {
		return this.pila.empty();
	}

	@Override
	public void vaciar() {
		this.pila.vaciar();
	}
	
}
