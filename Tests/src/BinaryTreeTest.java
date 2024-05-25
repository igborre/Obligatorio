import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.Arboles.*;
import uy.edu.um.prog2.tad.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.tad.linkedlist.MyList;

public class BinaryTreeTest {

    @Test
    public void insertTest() {
        // Se crea el arbol
        BinaryTree<Integer,Integer> bt = new TreeImpl<>();

        bt.binaryInsert(4,4,bt.getBinaryRoot());
        bt.binaryInsert(2,2,bt.getBinaryRoot());
        bt.binaryInsert(3,3,bt.getBinaryRoot());
        bt.binaryInsert(1,1,bt.getBinaryRoot());
        bt.binaryInsert(6,6,bt.getBinaryRoot());
        bt.binaryInsert(7,7,bt.getBinaryRoot());
        bt.binaryInsert(5,5,bt.getBinaryRoot());

        // Para ver si se creo bien se usara una recorrida preOrder, ya que la comprobacion del recorrido se hizo en TreeTest y es la misma
        MyList<Integer> preOrder = new MyLinkedListImpl<>();
        preOrder.add(4);
        preOrder.add(2);
        preOrder.add(1);
        preOrder.add(3);
        preOrder.add(6);
        preOrder.add(5);
        preOrder.add(7);
        MyList<Integer> preOrderRes = bt.preOrderBinary(bt.getBinaryRoot());
        Integer[] arrPreOrder = new Integer[7];
        Integer[] arrPreOrderRes = new Integer[7];
        for (int i = 1; i < 8; i++) {
            arrPreOrder[i - 1] = preOrder.get(i);
            arrPreOrderRes[i - 1] = preOrderRes.get(i);
        }
        Assertions.assertArrayEquals(arrPreOrder, arrPreOrderRes)
        ;
    }

    @Test
    public void binarySearchTest() {
        // Se usa el arbol inicial
        BinaryTree<Integer,Integer> bt = new TreeImpl<>();
        bt.binaryInsert(4,4,bt.getBinaryRoot());
        bt.binaryInsert(2,2,bt.getBinaryRoot());
        bt.binaryInsert(3,3,bt.getBinaryRoot());
        bt.binaryInsert(1,1,bt.getBinaryRoot());
        bt.binaryInsert(6,6,bt.getBinaryRoot());
        bt.binaryInsert(7,7,bt.getBinaryRoot());
        bt.binaryInsert(5,5,bt.getBinaryRoot());

        // Se busca un valor que exista y uno que no exista
        Assertions.assertEquals(5,bt.binaryFindData(5,bt.getBinaryRoot()));
        Assertions.assertEquals(null,bt.binaryFindData(9,bt.getBinaryRoot()));
    }

    @Test
    public void binaryDelete1Test() {
        // Se crea un arbol y se borra la raiz, el hijo derecho se vuelve nodo, y el izquierdo se vuelve el ultimo subhijo izquiedo
        BinaryTree<Integer,Integer> bt = new TreeImpl<>();
        bt.binaryInsert(4,4,bt.getBinaryRoot());
        bt.binaryInsert(2,2,bt.getBinaryRoot());
        bt.binaryInsert(3,3,bt.getBinaryRoot());
        bt.binaryInsert(1,1,bt.getBinaryRoot());
        bt.binaryInsert(6,6,bt.getBinaryRoot());
        bt.binaryInsert(7,7,bt.getBinaryRoot());
        bt.binaryInsert(5,5,bt.getBinaryRoot());

        bt.binaryDelete(4,bt.getBinaryRoot());

        // Se comprueba que funciono de la misma forma, con un recorrido preOrder
        MyList<Integer> preOrder = new MyLinkedListImpl<>();
        preOrder.add(6);
        preOrder.add(5);
        preOrder.add(2);
        preOrder.add(1);
        preOrder.add(3);
        preOrder.add(7);
        MyList<Integer> preOrderRes = bt.preOrderBinary(bt.getBinaryRoot());
        Integer[] arrPreOrder = new Integer[6];
        Integer[] arrPreOrderRes = new Integer[6];
        for (int i = 1; i < 7; i++) {
            arrPreOrder[i - 1] = preOrder.get(i);
            arrPreOrderRes[i - 1] = preOrderRes.get(i);
        }
        Assertions.assertArrayEquals(arrPreOrder, arrPreOrderRes);
    }

    @Test
    public void binaryDelete2Test(){
        // Se crea una raiz y se borra ella
        BinaryTree<Integer,Integer> bt = new TreeImpl<>();
        bt.binaryInsert(4,4,bt.getBinaryRoot());
        bt.binaryDelete(4,bt.getBinaryRoot());
        Assertions.assertNull(bt.getBinaryRoot());
    }

    @Test
    public void binaryDelete3Test(){
        // Se borra una raiz con un solo subarbol
        BinaryTree<Integer,Integer> bt = new TreeImpl<>();
        bt.binaryInsert(4,4,bt.getBinaryRoot());
        bt.binaryInsert(2,2,bt.getBinaryRoot());
        bt.binaryInsert(3,3,bt.getBinaryRoot());
        bt.binaryInsert(1,1,bt.getBinaryRoot());

        bt.binaryDelete(4,bt.getBinaryRoot());

        // Se prueba otra vez con un preOrder
        MyList<Integer> preOrder = new MyLinkedListImpl<>();
        preOrder.add(2);
        preOrder.add(1);
        preOrder.add(3);
        MyList<Integer> preOrderRes = bt.preOrderBinary(bt.getBinaryRoot());
        Integer[] arrPreOrder = new Integer[3];
        Integer[] arrPreOrderRes = new Integer[3];
        for (int i = 1; i < 4; i++) {
            arrPreOrder[i - 1] = preOrder.get(i);
            arrPreOrderRes[i - 1] = preOrderRes.get(i);
        }
        Assertions.assertArrayEquals(arrPreOrder, arrPreOrderRes);

    }

}
