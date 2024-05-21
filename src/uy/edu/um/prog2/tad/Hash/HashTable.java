package uy.edu.um.prog2.tad.Hash;

public interface HashTable<K, V> {
    void put(K key, V value);
    boolean contains(K key);
    void remove(K key);
}
