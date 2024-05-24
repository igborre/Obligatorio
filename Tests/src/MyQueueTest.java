import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.Queue.*;
import uy.edu.um.prog2.tad.Stack.EmptyStackException;
import uy.edu.um.prog2.tad.linkedlist.MyLinkedListImpl;

public class MyQueueTest {

    @Test
    public void enqueueDequeueSizeTest() {
        MyQueue<String> queue = new MyLinkedListImpl<String>();

        // Se ve Que lanze las excepciones y valor correcto de tamano
        Assertions.assertThrows(EmptyQueueException.class, () -> queue.dequeue());
        Assertions.assertEquals(0,queue.size());

        // Se ve que funcione bien el enqueue y se usa el dequeue para confirmar En cada momento se ve el size
        queue.enqueue("A");
        Assertions.assertEquals(1,queue.size());
        queue.enqueue("B");
        Assertions.assertEquals(2,queue.size());
        queue.enqueue("C");
        Assertions.assertEquals(3,queue.size());

        // Dado que throws exceptions, se hace un try catch al definir la variable y se ve que funciona, se ve el size final
        String testsVar = null;
        try {
            testsVar = queue.dequeue();
        } catch (EmptyQueueException e) {}
        Assertions.assertEquals("A",testsVar);
        try {
            testsVar = queue.dequeue();
        } catch (EmptyQueueException e) {}
        Assertions.assertEquals("B",testsVar);
        Assertions.assertEquals(1,queue.size());
    }

    @Test
    public void containsTest() {
        // Se prueba en una queue vacia
        MyQueue<String> queue = new MyLinkedListImpl<String>();
        Assertions.assertFalse(queue.contains("A"));

        // Se anade un valor y se prueba en uno que este y uno que no
        queue.enqueue("A");
        queue.enqueue("C");
        Assertions.assertTrue(queue.contains("A"));
        Assertions.assertFalse(queue.contains("B"));

        // Se elimina un valor y se prueba que funcione
        try {
            queue.dequeue();
        } catch (EmptyQueueException e) {}
        Assertions.assertFalse(queue.contains("A"));
        Assertions.assertTrue(queue.contains("C"));
    }

    @Test
    public void getTest() {
        // Se crea y intenta conseguir valores de la queue vacia
        MyQueue<String> queue = new MyLinkedListImpl<String>();
        Assertions.assertEquals(null,queue.get(2));

        // Se anade valores y se prueba que funcione aunque se salga de la queue
        queue.enqueue("A");
        queue.enqueue("B");
        Assertions.assertEquals("A",queue.get(2));
        Assertions.assertEquals("B",queue.get(1));
        Assertions.assertEquals(null,queue.get(0));
        Assertions.assertEquals(null,queue.get(4));
    }

    @Test
    public void isEmptyTest() {
        MyQueue<String> queue = new MyLinkedListImpl<String>();
        // Checkeo inicial
        Assertions.assertTrue(queue.isEmpty());

        // Se anade un valor y se vuelve a probar
        queue.enqueue("A");
        Assertions.assertFalse(queue.isEmpty());

        // Se elimina y testea una ultima vez
        try {
            queue.dequeue();
        } catch (EmptyQueueException e) {}
        Assertions.assertTrue(queue.isEmpty());

    }
}
