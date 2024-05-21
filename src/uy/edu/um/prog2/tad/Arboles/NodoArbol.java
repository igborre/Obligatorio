package uy.edu.um.prog2.tad.Arboles;

public class NodoArbol<K, T> {
    private final K key;
    private final T data;

    private NodoArbol<K, T> leftChild;
    private NodoArbol<K, T> rightChild;

    public NodoArbol(K key, T data) {
        this.key = key;
        this.data = data;
    }

    public K getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public NodoArbol<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodoArbol<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodoArbol<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodoArbol<K, T> rightChild) {
        this.rightChild = rightChild;
    }
}


