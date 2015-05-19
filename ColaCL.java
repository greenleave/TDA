package tda;

public class ColaCL<T> {
	private Lista<T> cola;
	
	public ColaCL(){
		this.cola=new Lista<T>();
	}

	public boolean offer(T obj) {
		return this.cola.pushBack(obj);
	}
	public T poll() {
		return this.cola.popFront();
	}
	public T peek() {
		return this.cola.buscar(0);
	}
	public boolean empty(){
		return this.cola.empty();
	}
	public void vaciar(){
		this.cola.vaciar();
	}
	
}
