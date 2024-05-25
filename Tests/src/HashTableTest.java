import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.Hash.*;

public class HashTableTest {

    @Test
    public void testHashTable() {
        HashTable<String,Integer> hashTable = new HashTableImpl<>(3);

        hashTable.put("Hola",1);
        hashTable.put("Adios",2);
        hashTable.put("Nos vemos",3);
        hashTable.put("Hola otra vez",4);

        Assertions.assertTrue(hashTable.contains("Hola"));
        Assertions.assertTrue(hashTable.contains("Adios"));
        Assertions.assertTrue(hashTable.contains("Nos vemos"));
        Assertions.assertTrue(hashTable.contains("Hola otra vez"));

        hashTable.remove("Hola");
        Assertions.assertFalse(hashTable.contains("Hola"));

    }
}
