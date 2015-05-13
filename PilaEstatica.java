package tda;

import java.lang.reflect.Array;

public class PilaEstatica<T> implements Pila<T> {

	private int cantidadElementos;
	private int ultimoElemento;
	private int capacidad;
	private T[] pila;
	
	 @SuppressWarnings("unchecked")
	public PilaEstatica() {
		this.pila=(T[]) new Object[1];
		this.cantidadElementos=0;
		this.ultimoElemento=-1;
		this.capacidad=1;
	}
	
	 private void duplicarTamanio(){
		 T[] auxiliar= (T[])new Object[this.capacidad*2];
		 for(int i = 0; i < this.capacidad; i++ ){
			 auxiliar[i]= this.pila[(this.ultimoElemento-this.cantidadElementos+i)%this.capacidad];
		 }
		 this.ultimoElemento=this.cantidadElementos;
	 }
	
	@Override public boolean empty() {
		return this.cantidadElementos==0;
	}

	@Override
	public void push(T obj) {
		if( this.cantidadElementos>=this.capacidad*0.75){
			this.duplicarTamanio();
		}
		this.pila[(this.ultimoElemento++%this.capacidad)]=obj;

	}

	@Override
	public T pop() {
		return (this.empty()?null:this.pila[(this.ultimoElemento--)%this.capacidad]);
	}

	@Override
	public T peek() {
		return (this.ultimoElemento < 0?null:this.pila[this.ultimoElemento%this.capacidad]);
	}

	@Override
	public void vaciar() {
		this.cantidadElementos=0;
		this.ultimoElemento=-1;

	}

}
