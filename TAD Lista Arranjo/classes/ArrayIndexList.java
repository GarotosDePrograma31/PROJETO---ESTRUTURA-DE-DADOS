package tad_ListaArranjos.classes;

import tad_ListaArranjos.interfaces.IndexList;

public class ArrayIndexList<E> implements IndexList<E> {

	private E arranjo[];
	private int capacity = 16;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayIndexList() {
		arranjo = (E[]) new Object[capacity];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void add(E element, int indice) throws IndexOutOfBoundsException {
		checkIndex(indice, size + 1);
		
		if (this.size == this.capacity) {
			capacity *= 2;
			
			@SuppressWarnings("unchecked")
			E arranjo_2[] = (E[]) new Object[capacity];
			
			for (int i=0; i < size; i++)
				arranjo_2[i] = arranjo[i];
			
			arranjo = arranjo_2;
		}
		
		for (int i=size - 1; i >= indice; i--) {
			arranjo[i + 1] = arranjo[i];
		}
		
		arranjo[indice] = element;
		size++;
	}
	
	public E get(int indice) throws IndexOutOfBoundsException {
		checkIndex(indice, size);
		return arranjo[indice];
	}
	
	public E remove(int indice) throws IndexOutOfBoundsException {
		checkIndex(indice, size);
		
		E removido = arranjo[indice];
		
		for (int i=indice; i < size - 1; i++)
			arranjo[i] = arranjo[i + 1];
		
		size--;
		return removido;
	}
	
	public E set(E newElement, int indice) throws IndexOutOfBoundsException {
		checkIndex(indice, size);
		
		E elemento_trocado = arranjo[indice];
		arranjo[indice] = newElement;
		
		return elemento_trocado;
	}
	
	protected void checkIndex(int indice, int tamanhoN) {
		if (indice < 0 || indice >= tamanhoN)
			throw new IndexOutOfBoundsException("Indice invalido: " + indice);
	}
	
	public String toString() {
		if (size == 0)
			return "()";
		
		String lista_arranjo = "(";
		
		for (int i=0; i < size; i++)
			lista_arranjo += arranjo[i] + ", ";
		
		lista_arranjo = lista_arranjo.substring(0, lista_arranjo.length() - 2);
		
		return lista_arranjo + ")";
	}
}