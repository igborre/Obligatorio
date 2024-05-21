package uy.edu.um.prog2.tad.Hash;

public class HashNode<K, V>{
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}
