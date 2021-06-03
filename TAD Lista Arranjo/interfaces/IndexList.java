package tad_ListaArranjos.interfaces;

public interface IndexList<Type> {
	
	public int size();
	
	public boolean isEmpty();
	
	public void add(Type element, int i) throws IndexOutOfBoundsException;
	
	public Type get(int i) throws IndexOutOfBoundsException;
	
	public Type remove(int i) throws IndexOutOfBoundsException;
	
	public Type set(Type newElement, int i) throws IndexOutOfBoundsException;
}
