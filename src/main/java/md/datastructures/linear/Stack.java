package md.datastructures.linear;

import java.util.Optional;

public interface Stack<T> {
	
	public Optional<T> pull();
	
	public Optional<T> peek();
	
	public void push(T item);
	
	public Boolean isEmpty();

}
