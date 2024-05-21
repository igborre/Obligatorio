package uy.edu.um.prog2.tad.Stack;
public interface MyStackA<T> {

    void stackArray(int size);

    public void pushArray(T element) throws StackOverflowException;

    public void popArray() throws EmptyStackException;

    public T topArray() throws EmptyStackException;

    public boolean isEmptyArray();
    public void makeEmptyArray();

}
