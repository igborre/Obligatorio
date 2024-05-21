package uy.edu.um.prog2.tad.linkedlist;

public interface MyDoubleLinkedList<T> {

    void addDouble(T value);

    void addToTheBegineingDouble(T value);

    void removeDouble(int position);

    T get(int position);

    int size();

    boolean contains(T value);
}
