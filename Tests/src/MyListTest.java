import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import uy.edu.um.prog2.tad.linkedlist.*;


public class MyListTest {

    @Test
    public void testAddAndGet() {
        MyList<Integer> list = new MyLinkedListImpl<Integer>();
        Assertions.assertEquals(null, list.get(1)); // Funciona get sin elementos
        list.add(1);
        list.add(3);
        list.add(2);
        Assertions.assertEquals(1, list.get(1)); // Se añaden en la posicion correcta
        Assertions.assertEquals(2, list.get(3));
        Assertions.assertEquals(null, list.get(5)); // Funciona fuera de la lista
    }

    @Test
    public void testAddBeginning() {
        MyList<Integer> list = new MyLinkedListImpl<Integer>();
        list.add(1);
        list.addToTheBeginning(2);
        Assertions.assertEquals(2, list.get(1)); // Añade al principio
    }

    @Test
    public void testContains() {
        MyList<Integer> list = new MyLinkedListImpl<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(true, list.contains(1)); // Valor en la lista
        Assertions.assertEquals(false, list.contains(4)); // Valor no existente en la misma
    }

    @Test
    public void testRemove() {
        MyList<Integer> list = new MyLinkedListImpl<Integer>();
        list.add(1);
        list.add(2);
        Assertions.assertEquals(true, list.contains(2)); // El valor existe en la lista
        list.remove(2);
        Assertions.assertEquals(false, list.contains(2)); // El valor fue removido
        list.remove(2); // Se intenta eliminar valores que no están en la lista
        list.remove(1);
        list.remove(1); // Se intenta eliminar valores a una lista sin valores
        Assertions.assertEquals(false, list.contains(2));
        Assertions.assertEquals(false, list.contains(1));
    }

    @Test
    public void testSize() {
        MyList<Integer> list = new MyLinkedListImpl<Integer>();
        Assertions.assertEquals(0, list.size()); // Tamaño 0
        list.add(1);
        list.add(2);
        Assertions.assertEquals(2, list.size()); // Tamaño 2
        list.add(2);
        Assertions.assertEquals(3, list.size()); // Se añade un valor que ya existe
        list.remove(2);
        Assertions.assertEquals(2, list.size()); // Se borra un solo valor y funciona medir al eliminar valores
    }

    @Test
    public void testReturnFirst() {
        MyList<Integer> list = new MyLinkedListImpl<Integer>();
        list.add(1);
        list.add(2); // Revisa si el valor del primero es correcto al retornar el primer nodo
        Assertions.assertEquals(1, list.returnFirst().getValue());
    }

    @Test
    public void testAddListToEnd(){
        MyList<Integer> list1 = new MyLinkedListImpl<Integer>();
        MyList<Integer> list2 = new MyLinkedListImpl<Integer>();
        list1.add(1);
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list1 = list1.listAddToEnd(list2);
        Assertions.assertEquals(4, list1.size()); // Revisa que el tamaño sea correcto
        Assertions.assertEquals(3, list1.get(3)); // Revisa que las posiciones sean correctas
    }

    @Test
    public void testIsEmpty(){
        MyList<Integer> list = new MyLinkedListImpl<Integer>();
        Assertions.assertEquals(true, list.isEmpty());
        list.add(2);
        Assertions.assertEquals(false, list.isEmpty());

    }


}
