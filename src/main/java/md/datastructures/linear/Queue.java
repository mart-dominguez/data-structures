package md.datastructures.linear;

import java.util.Optional;

public interface Queue<T> {

	public void enqueue(T i);

	public Optional<T> dequeue();
	
	public Optional<T> peek();
		
	public Boolean isEmpty();
}
