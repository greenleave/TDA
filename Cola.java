package tda;

public interface Cola <T>{

	public boolean empty( );//vacía
	public void  offer( T obj );//añadir elemento
	public T poll(); //Quitar elemento
	public T peek(); ///una referencia al primer elemento, pero no elimina
	public void vaciar();

}
