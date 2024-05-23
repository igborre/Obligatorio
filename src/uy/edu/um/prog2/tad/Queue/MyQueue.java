package uy.edu.um.prog2.tad.Queue;

public interface MyQueue<T> {

	void enqueue(T value);
	
	T dequeue() throws EmptyQueueException;
	
	boolean contains(T value);
	
	int size();

	T get(int i);

	boolean isEmpty();
	
}
