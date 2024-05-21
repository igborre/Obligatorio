package uy.edu.um.prog2.tad.Arboles;

import uy.edu.um.prog2.tad.linkedlist.MyList;

public interface Tree<K, T> {

    NodoArbol<K, T> getRoot();

    void setRoot(NodoArbol<K,T> raiz);

    T find(K key);

    void insert(K key, T data, K parentKey);

    int size(NodoArbol<K,T> raiz);

    int contarHojas(NodoArbol<K,T> root);

    int countCompleteElements(NodoArbol<K,T> root);

    MyList<K> inOrder(NodoArbol<K, T> root);

    MyList<K> preOrder(NodoArbol<K, T> root);

    public MyList<K> postOrder(NodoArbol<K, T> root);
}





