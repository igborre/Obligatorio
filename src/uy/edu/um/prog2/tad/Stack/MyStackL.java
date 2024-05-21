package uy.edu.um.prog2.tad.Stack;

public interface MyStackL<T> {
    int lenght();

    public void push(T element);

    public void pop() throws EmptyStackException;

    public T peek() throws EmptyStackException;

    boolean isEmpty();
    public void makeEmpty();
}
