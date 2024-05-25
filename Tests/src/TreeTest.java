import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.Arboles.*;
import uy.edu.um.prog2.tad.linkedlist.*;

public class TreeTest {

    // No se testea el find, es usado al insertar, se prueba en el.

    @Test
    public void insert1Test() {
        Tree<Integer,Integer> tree = new TreeImpl<>();

        //Se crea un subarbol con parentKey nula para ser raiz
        tree.insert(1,1,null);
        Assertions.assertEquals(1,tree.size(tree.getRoot()));
    }

    @Test
    public void insert2Test(){
        Tree<Integer,Integer> tree = new TreeImpl<>();

        // Se intenta crear la raiz, igualmente se da un parent key (se debe ver como nula este caso y volverse raiz)
        tree.insert(1,1,1);

        // Se intenta crear con un parentKey no existente
        tree.insert(2,2,2);

        // Se revisa el size para ver que no se haya insertado
        Assertions.assertEquals(1,tree.size(tree.getRoot()));

        // Se insertan 3 hijos a un mismo padre (Tiene que ignorar al tercero) y se usa size para confirmar resultados
        tree.insert(2,2,1);
        tree.insert(3,3,1);
        tree.insert(4,4,1);
        Assertions.assertEquals(3,tree.size(tree.getRoot()));

        // Se anaden hijos a un subárbol
        tree.insert(4,4,2);
        tree.insert(5,5,2);
        tree.insert(6,6,3);
        Assertions.assertEquals(6,tree.size(tree.getRoot()));

        // Si ya tiene raiz, que al poner parent key nula lo ignore
        tree.insert(1,1,null);
        Assertions.assertEquals(6,tree.size(tree.getRoot()));
    }

    @Test
    public void contarHojasYCompletosTest(){
        Tree<Integer,Integer> tree = new TreeImpl<>();

        //Se prueban en un arbol vacio
        Assertions.assertEquals(0,tree.contarHojas(tree.getRoot()));
        Assertions.assertEquals(0,tree.countCompleteElements(tree.getRoot()));

        // Se crea el arbol y se intentan contar los elementos
        tree.insert(1,1,null); // Raiz, completo
        tree.insert(2,2,1); // Hijo de 1, completo
        tree.insert(3,3,1); // Hijo de 1, hoja
        tree.insert(4,4,2); // Hijo de 2, hoja
        tree.insert(5,5,2); // Hijo de 2, completo
        tree.insert(6,6,5); // Hijo de 5, hoja
        tree.insert(7,7,5); // Hijo de 5, solo un hijo
        tree.insert(8,8,7); // Hijo de 7, hoja
        Assertions.assertEquals(4,tree.contarHojas(tree.getRoot()));
        Assertions.assertEquals(3,tree.countCompleteElements(tree.getRoot()));
    }

    @Test
    public void recorridosTests(){
        // Se crea el mismo arbol que antes
        Tree<Integer,Integer> tree = new TreeImpl<>();
        tree.insert(1,1,null);
        tree.insert(2,2,1);
        tree.insert(3,3,1);
        tree.insert(4,4,2);
        tree.insert(5,5,2);
        tree.insert(6,6,5);
        tree.insert(7,7,5);
        tree.insert(8,8,7);

        // Se crean las listas de resultados esperadas y se comparan los elementos en un array
        MyList<Integer> preOrder = new MyLinkedListImpl<>();
        preOrder.add(1);
        preOrder.add(2);
        preOrder.add(4);
        preOrder.add(5);
        preOrder.add(6);
        preOrder.add(7);
        preOrder.add(8);
        preOrder.add(3);

        MyList<Integer> inOrder = new MyLinkedListImpl<>();
        inOrder.add(4);
        inOrder.add(2);
        inOrder.add(6);
        inOrder.add(5);
        inOrder.add(8);
        inOrder.add(7);
        inOrder.add(1);
        inOrder.add(3);

        MyList<Integer> postOrder = new MyLinkedListImpl<>();
        postOrder.add(4);
        postOrder.add(6);
        postOrder.add(8);
        postOrder.add(7);
        postOrder.add(5);
        postOrder.add(2);
        postOrder.add(3);
        postOrder.add(1);

        MyList<Integer> preOrderRes = tree.preOrder(tree.getRoot());
        MyList<Integer> inOrderRes = tree.inOrder(tree.getRoot());
        MyList<Integer> postOrderRes = tree.postOrder(tree.getRoot());

        // Se crean arrays para los resultados y se ven que sean iguales

        Integer[] arrPreOrder = new Integer[8];
        Integer[] arrPreOrderRes = new Integer[8];
        Integer[] arrInOrder = new Integer[8];
        Integer[] arrInOrderRes = new Integer[8];
        Integer[] arrPostOrder = new Integer[8];
        Integer[] arrPostOrderRes = new Integer[8];

        // Cada elemento se guarda en su posicion correspondiente
        for (int i = 1; i < 9; i++){
            arrPreOrder[i-1] = preOrder.get(i);
            arrPreOrderRes[i-1] = preOrderRes.get(i);
            arrInOrder[i-1] = inOrder.get(i);
            arrInOrderRes[i-1] = inOrderRes.get(i);
            arrPostOrder[i-1] = postOrder.get(i);
            arrPostOrderRes[i-1] = postOrderRes.get(i);
        }

        // Se comparan los arrays entre los esperados y los resultados
        Assertions.assertArrayEquals(arrPreOrder, arrPreOrderRes);
        Assertions.assertArrayEquals(arrInOrder, arrInOrderRes);
        Assertions.assertArrayEquals(arrPostOrder, arrPostOrderRes);

    }
}
