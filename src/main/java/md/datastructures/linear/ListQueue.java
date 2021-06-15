package md.datastructures.linear;

import java.util.Optional;

public class ListQueue <T> implements Queue<T> {

	
	private Node<T> head;
	private Node<T> tail;
	
	@Override
	public void enqueue(T i) {
		Node<T> newNode = new Node<T>(i);
		if(this.isEmpty()) { 
			head = newNode; 
			tail = head;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	@Override
	public Optional<T> dequeue() {
		if(this.isEmpty()) return Optional.empty();
		Node<T> result = head;
		head = head.getNext();
		return Optional.of(result.value);
	}

	@Override
	public Optional<T> peek() {
		if(isEmpty()) return Optional.empty();
		return Optional.of(head.value);
	}

	@Override
	public Boolean isEmpty() {
		return this.head == null;
	}
	
//	@Override
//	public Optional<T> pull() {
//		if(this.isEmpty()) return Optional.empty();
//		Node<T> result = head;
//		head = head.getNext();
//		return Optional.of(result.getValue());
//	}
//
//	@Override
//	public Optional<T> peek() {
//		if(this.isEmpty()) return Optional.empty();
//		return Optional.of(head.getValue());
//	}
//
//	@Override
//	public void push(T item) {
//		Node<T> newNode = new Node<>(item);
//		newNode.setNext(head);
//		head = newNode;
//	}
//
//	@Override
//	public Boolean isEmpty() {
//		return head==null;
//	}
	
	public static class Node<T> {
		
		public Node(T val) {
			this.value = val;
		}
		
		private T value;
		private Node<T> next;
		
		public T getValue() {
			return value;
		}

		public T getValueOpt() {
			return value;
		}

		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
		
	}


	

}
