import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.Stack.*;
import uy.edu.um.prog2.tad.linkedlist.MyLinkedListImpl;

public class StackLTest {

    @Test
    public void pushPullPeekTest() throws EmptyStackException {
        MyStackL<Integer> stack = new MyLinkedListImpl<>();
        Assertions.assertThrows(EmptyStackException.class, () -> stack.peek()); // Prueba las exceptions
        Assertions.assertThrows(EmptyStackException.class, () -> stack.pop());
        stack.push(1);
        Assertions.assertEquals(1,stack.peek()); // Prueba de peek
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3,stack.peek());
        stack.pop(); // Check pop works
        Assertions.assertEquals(2,stack.peek());
    }

    @Test
    public void lenghtTest(){
        MyStackL<Integer> stack = new MyLinkedListImpl<>();
        Assertions.assertEquals(0, stack.lenght()); // Prueba en 0
        stack.push(1);
        Assertions.assertEquals(1, stack.lenght()); // Prueba con items
        stack.push(2);
        Assertions.assertEquals(2, stack.lenght());
        try {
            stack.pop();
        } catch (EmptyStackException e) {}
        try {
            stack.pop();
        } catch (EmptyStackException e) {}
        Assertions.assertEquals(0, stack.lenght()); // Prueba despues de borrar
    }

    @Test
    public void isEmptyTest(){
        MyStackL<Integer> stack = new MyLinkedListImpl<>(); // Un poco obvio lo que es
        Assertions.assertTrue(stack.isEmpty());
        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());

    }

    @Test
    public void makeEmptyTest(){
        MyStackL<Integer> stack = new MyLinkedListImpl<>(); // Este también
        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());
        stack.makeEmpty();
        Assertions.assertTrue(stack.isEmpty());
    }
}
