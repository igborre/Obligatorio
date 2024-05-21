package uy.edu.um.prog2.tad.linkedlist;

public interface MyCircularLinkedList<T> {
        void addCirc(T value);

        T getCircularLogic(int position);

        boolean containsCirc(T value);

        void removeCirc(T value);

        int sizeCirc();
}

