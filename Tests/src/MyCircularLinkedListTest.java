import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.linkedlist.*;

public class MyCircularLinkedListTest {

    @Test
    public void addRemoveGetTest() {
        MyCircularLinkedList<Integer> lista = new MyLinkedListImpl<>();

        // Se prueba remove y get en la lista vacia
        lista.removeCirc(1);
        lista.getCircularLogic(12);

        // Se anaden nodos y se prueba el get
        lista.addCirc(4);
        lista.addCirc(3);
        lista.addCirc(5);
        Assertions.assertEquals(null, lista.getCircularLogic(0));
        Assertions.assertEquals(3, lista.getCircularLogic(2));
        Assertions.assertEquals(3, lista.getCircularLogic(5));
        Assertions.assertEquals(4, lista.getCircularLogic(4));
        Assertions.assertEquals(5, lista.getCircularLogic(3));

        // Se borran valores y se vuelven a intentar
        lista.removeCirc(4);
        Assertions.assertEquals(3, lista.getCircularLogic(1));
        Assertions.assertEquals(3, lista.getCircularLogic(3));
        Assertions.assertEquals(5, lista.getCircularLogic(4));
        lista.removeCirc(5);
        Assertions.assertEquals(3, lista.getCircularLogic(4));

        // Se vacia la lista y otra vez prueba el get
        lista.removeCirc(3);
        Assertions.assertEquals(null, lista.getCircularLogic(1));
    }

    @Test
    public void containsSizeTest() {
        MyCircularLinkedList<Integer> lista = new MyLinkedListImpl<>();

        // Se anaden elementos y se prueba contener y size
        lista.addCirc(1);
        lista.addCirc(2);
        lista.addCirc(3);
        lista.addCirc(4);
        lista.addCirc(5);
        Assertions.assertTrue(lista.containsCirc(1));
        Assertions.assertFalse(lista.containsCirc(6));
        Assertions.assertEquals(5, lista.sizeCirc());

        // Se eliminan valores y se ve si funciona
        lista.removeCirc(1);
        lista.removeCirc(2);
        lista.removeCirc(3);
        Assertions.assertTrue(lista.containsCirc(4));
        Assertions.assertFalse(lista.containsCirc(1));
        Assertions.assertEquals(2, lista.sizeCirc());

        // Se termina de eliminar la lista y se ve si funciona el lista vacia
        lista.removeCirc(4);
        lista.removeCirc(5);
        Assertions.assertFalse(lista.containsCirc(5));
        Assertions.assertEquals(0,lista.sizeCirc());
    }
}
