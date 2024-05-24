import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.linkedlist.*;

public class MyDoubleLinkedListTest {

    @Test
    public void addRemoveGetTests() {
        MyDoubleLinkedList<Integer> lista = new MyLinkedListImpl<>();

        // Test de remove a lista vacia
        lista.removeDouble(1);

        // Se anaden valores y se prueba el get en lista y fuera de la misma
        lista.addDouble(1);
        lista.addDouble(2);
        Assertions.assertEquals(1,lista.get(1));
        lista.addToTheBegineingDouble(3);
        Assertions.assertEquals(3,lista.get(1));
        Assertions.assertEquals(null,lista.get(5));

        // Se intenta borrar un elemento
        lista.removeDouble(1);
        Assertions.assertEquals(1,lista.get(1));

        // Se borran todos los elementos y se prueba el get en una lista vacia
        lista.removeDouble(1);
        Assertions.assertEquals(2,lista.get(1));
        lista.removeDouble(1);
        Assertions.assertEquals(null,lista.get(1));
    }

    @Test
    public void sizeTest() {
        MyDoubleLinkedList<Integer> lista = new MyLinkedListImpl<>();

        // Se prueba en una lista vacia
        Assertions.assertEquals(0,lista.size());

        // Se añaden elementos y se vuelve a probar
        lista.addDouble(1);
        lista.addDouble(2);
        lista.addDouble(3);
        Assertions.assertEquals(3,lista.size());

        // Se eliminan y se vuelve a probar
        lista.removeDouble(1);
        Assertions.assertEquals(2,lista.size());
        lista.removeDouble(1);
        lista.removeDouble(1);
        Assertions.assertEquals(0,lista.size());
    }

    @Test
    public void containsTest() {
        MyDoubleLinkedList<Integer> lista = new MyLinkedListImpl<>();

        // Test en lista vacia
        Assertions.assertFalse(lista.contains(1));

        // Se añaden valores y se prueba
        lista.addDouble(1);
        lista.addDouble(2);
        Assertions.assertTrue(lista.contains(2));
        Assertions.assertFalse(lista.contains(4));

        // Se eliminan valores y se prueba
        lista.removeDouble(2);
        Assertions.assertFalse(lista.contains(2));
        lista.removeDouble(1);
        Assertions.assertFalse(lista.contains(1));
    }

}
