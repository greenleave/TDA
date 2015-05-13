package tda;

public interface Pila<T> {
	public boolean empty();// es vacía
	public void push( T obj ); //apilar
	public T pop();//seapilar
	public T peek( );//devuelve una referencia al elemento de la cima
	public void vaciar();

}
