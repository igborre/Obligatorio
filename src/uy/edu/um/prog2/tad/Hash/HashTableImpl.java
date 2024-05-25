package uy.edu.um.prog2.tad.Hash;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    public int size;
    public HashNode[] table;

    @Override
    public HashNode[] getTable(){
        return table;
    }

    @Override
    public int getSize(){
        return size;
    }

    public HashTableImpl(int size){
        this.size = size;
        this.table = new HashNode[size];
    }

    public int hash(K key){
        return key.hashCode();
    }

    // Falta 4.1 b
    @Override
    public void put(K key, V value) {
        HashNode<K,V> node = new HashNode(key, value);
        int clave = hash(key);
        int tries = 0;
        while(table[clave] != null && tries < size){
            if (table[clave].getKey().equals(key)){
                // Si ya existe la key se ignora, se evalua la key y no su valor despues del hash
                return;
            }
            clave = linealCollidesWith(key, tries);
            tries++;
            // Para no salirse del array se hace el mod
            clave = clave % size;
        }
        // Si el espacio esta vacio, se almacena, si no significa que la tabla esta llena, hay que usar el algoritmo de agrandado.
        if(table[clave] == null){
            table[clave] = node;
            return;
        }
        if (tries == size) {
            this.table = this.Expand().getTable();
            this.size = this.Expand().getSize();
        }
    }

    @Override
    public boolean contains(K key) {
        int clave = hash(key);
        // Va a la posicion del hash
        int tries = 0;
        // En caso de que no sea la key correcta, por colicion se intenta recorrer
        // Como es lineal el algoritmo de colicion, si se llega a un valor nulo o si termina de recorrer el hash no esta presente la key
        while (table[clave] != null && tries < size){
            if (table[clave].getKey().equals(key)) {
                // Si sus keys son iguales, devuelve true
                return true;
            }
            clave = linealCollidesWith(key, tries);
            tries++;
            // Para no salirse del array se hace el mod
            clave = clave % size;
        }
        return false;
    }

    //Expandir
    @Override
    public void remove(K key) {
        int clave = hash(key);
        //Misma implementacion que la funcion contains
        int tries = 0;
        while (table[clave] != null && tries < size){
            if (table[clave].getKey().equals(key)) {
                table[clave] = null;
                return;
            }
            clave = linealCollidesWith(key, tries);
            tries++;
            clave = clave % size;
        }
        //Si llega aca, es que no existe la key en la HashTable
    }

    public int linealCollidesWith(K key, int times){
        int clave = hash(key);
        return (clave + times + 1);
    }

    public int squareCollidesWith(K key, int tries){
        int clave = hash(key);
        return (clave + tries^2);
    }

    public HashTable<K,V> Expand(){
        HashTable<K, V> newTable = new HashTableImpl<>(2*this.size);
        for(int i = 0; i < size; i++){
            HashNode<K, V> newNode = this.table[i];
            newTable.put(newNode.getKey(), newNode.getValue());
        }
        return newTable;
    }
}
