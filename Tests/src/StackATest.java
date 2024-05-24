import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.Stack.*;
import uy.edu.um.prog2.tad.linkedlist.*;


public class StackATest {

   @Test
   public void pushPopPeekTest() {
       MyStackA<String> stack = new MyLinkedListImpl<String>();
       stack.stackArray(3); // Se hace el array de tamaño 3
       Assertions.assertThrows(EmptyStackException.class, () -> stack.topArray()); // Prueba las exceptions
       Assertions.assertThrows(EmptyStackException.class, () -> stack.popArray());

       //Prueba anadir
       try {
           stack.pushArray("A");
       } catch (StackOverflowException e) {}
       try {
           stack.pushArray("B");
       } catch (StackOverflowException e) {}
       try {
           stack.pushArray("C");
       } catch (StackOverflowException e) {}

       // Se prueba que top funcione
       String res1 = null;
       try {
           res1 = stack.topArray();
       } catch (EmptyStackException e) {}
       Assertions.assertEquals("C", res1);

       // Se prueba que funcione el overflow
       Assertions.assertThrows(StackOverflowException.class, () -> stack.pushArray("D"));

       // Se prueba que funcione el pop
       try {
           stack.popArray();
       } catch (EmptyStackException e) {}
       try {
           stack.popArray();
       } catch (EmptyStackException e) {}

       // Se confirma con top
       String res2 = null;
       try {
           res2 = stack.topArray();
       } catch (EmptyStackException e) {}
       Assertions.assertEquals("A", res2);

   }

   @Test
    public void isArrayEmptyTest() {
       MyStackA<String> stack = new MyLinkedListImpl<String>();
       stack.stackArray(3);
       // En un inicio esta vacio
       Assertions.assertTrue(stack.isEmptyArray());

       //Se anade un elemento y ahora es falso
       try {
           stack.pushArray("B");
       } catch (StackOverflowException e) {}
       Assertions.assertFalse(stack.isEmptyArray());

       // Se ve que funciona al vaciar el array
       try {
           stack.popArray();
       } catch (EmptyStackException e) {}
       Assertions.assertTrue(stack.isEmptyArray());
   }

   @Test
    public void makeArrayEmptyTest() {
       // Se crea un array y se anade un elemento
       MyStackA<String> stack = new MyLinkedListImpl<String>();
       stack.stackArray(3);
       try {
           stack.pushArray("B");
       } catch (StackOverflowException e) {}

       // Se ve que no esta vacio
       Assertions.assertFalse(stack.isEmptyArray());

       // Se vacia y pruab otra vez
       stack.makeEmptyArray();
       Assertions.assertTrue(stack.isEmptyArray());
   }
}
