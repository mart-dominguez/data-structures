package md.datastructures.linear;

import java.util.ArrayList;
import java.util.Optional;

public class ArrayStack<T> implements Stack<T> {
	
	private static final Integer INITIAL_SIZE = 32;
	
	private Integer top;
	private Object[] items;
	
	public ArrayStack() {
		this(INITIAL_SIZE);
	}
	
	public ArrayStack(Integer initialSize) {
		
		 items = new Object[initialSize ];
		 top = -1;
	}
	
	@Override
	public Optional<T> pull() {
		if(this.isEmpty()) return Optional.empty();
		return Optional.of((T)items[top--]);
	}

	@Override
	public Optional<T> peek() {
		if(this.isEmpty()) return Optional.empty();
		return Optional.of((T)items[top]);
	}

	@Override
	public void push(T item) {
		if(this.isFull()) scale(2);
		items[++top]= item;
	}

	@Override
	public Boolean isEmpty() {
		return top<0;
	}
	
	private Boolean isFull() {
		return top==items.length-1;
	}

	private void scale(Integer x) {
		int newSize = items.length*x;
		Object[] dest = new Object[newSize];
		System.arraycopy(items, 0, dest, 0,items.length);
		items = dest;
	}
}
