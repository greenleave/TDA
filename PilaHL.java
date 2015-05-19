package tda;

public class PilaHL<T>  extends Lista<T>{
	public PilaHL(){
		super();
	}

	public boolean push(T obj) {
		return this.pushFront(obj);
	}

	public T pop() {
		return this.popFront();
	}

	public T peek() {
		return this.buscar(0);
	}
}
