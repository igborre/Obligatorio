package uy.edu.um.prog2.tad.Arboles;

import uy.edu.um.prog2.tad.linkedlist.MyList;

public interface BinaryTree<K extends Comparable<K>, T> {

    NodeBST<K,T> getBinaryRoot();

    void setBinaryRoot(NodeBST<K,T> root);

    T binaryFindData(K key, NodeBST<K, T> root);

    void binaryInsert (K key, T data, NodeBST<K, T> root);

    void binaryDelete (K key, NodeBST<K, T> root);

    MyList<K> inOrderBinary(NodeBST<K, T> root);

    MyList<K> preOrderBinary(NodeBST<K, T> root);

    MyList<K> postOrderBinary(NodeBST<K, T> root);
}