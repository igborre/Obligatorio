package uy.edu.um.prog2.tad.Hash;

public interface HashTable<K, V> {
    HashNode[] getTable();
    int getSize();
    void put(K key, V value);
    boolean contains(K key);
    void remove(K key);
    HashNode<K, V> get(K key);
    int filledPlaces();
}
