package uy.edu.um.prog2.tad.linkedlist;

public interface MyList<T> {

    void add(T value);

    void addToTheBeginning(T value);

    T get(int position);

    boolean contains(T value);

    void remove(T value);

    int size();

    Node<T> returnFirst();

    MyList<T> listAddToEnd(MyList<T> lista2);

    boolean isEmpty();


}
