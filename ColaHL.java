package tda;

public class ColaHL<T> extends Lista<T>{
	public ColaHL(){
		super();
	}

	public boolean offer(T obj) {
		return this.pushBack(obj);
	}
	public T poll() {
		return this.popFront();
	}
	public T peek() {
		return this.buscar(0);
	}
	
}
