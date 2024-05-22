package uy.edu.um.prog2.tad.Arboles;
import uy.edu.um.prog2.tad.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.tad.linkedlist.MyList;


public class TreeImpl<K extends Comparable<K>,T> implements Tree<K,T>, BinaryTree<K, T>{

    //Funciones para arbol
    private NodoArbol<K, T> root;
    private NodeBST<K, T> binaryRoot;

    @Override
    public NodoArbol<K, T> getRoot(){
        return root;
    }
    @Override
    public void setRoot(NodoArbol<K,T> raiz){
        this.root = raiz;
    }

    public TreeImpl(){
        setRoot(null);
    }

    public NodoArbol<K, T> findNodo(K nodoKey, NodoArbol<K, T> raiz) {
        if (raiz.getKey() == null) {
            return null;
        }
        // Si es el valor, hace return del nodo
        if (raiz.getKey() == nodoKey) {
            return raiz;
        }
        // Revisa por los sub arboles izquierdos
        if (raiz.getLeftChild() != null) {
            NodoArbol<K, T> nodoTempl = findNodo(nodoKey, raiz.getLeftChild());
            if (nodoTempl != null) {
                return nodoTempl;
            }
        }
        // Revisa por los sub arboles derechos
        if (raiz.getRightChild() != null) {
            NodoArbol<K, T> nodoTempr = findNodo(nodoKey, raiz.getRightChild());
            if (nodoTempr != null) {
                return nodoTempr;
            }
        }
        return null;
    }

    @Override
    public T find(K key) {
        return findNodo(key, root).getData();
    }


    @Override
    public void insert(K key, T data, K parentKey) {
        // Si no hay raíz y parent key, esta se vuelve la raíz
        if (root == null && parentKey == null) {
            root = new NodoArbol<K, T>(key, data);
            return;
        }
        // Se busca al nodo padre
        NodoArbol<K, T> temp = findNodo(parentKey, root);
        NodoArbol<K,T> hijo = new NodoArbol<K, T>(key, data);
        // Revisa que no se pueda repetir la key
        if (hijo.getKey() == temp.getKey()) {
            return;
        }
        // Ve si puede ser el subárbol izquierdo
        if (temp.getLeftChild() == null) {
            temp.setLeftChild(hijo);
            return;
        }
        // Ve si puede ser el arbor derecho
        if (temp.getRightChild() == null) {
            temp.setRightChild(hijo);
            return;
        }
        // Si los subárboles están llenos ignora el insert
    }

    @Override
    public int size(NodoArbol<K,T> root) {
        if (root != null) {
            // Si es completo revisa los dos subárboles
            if (root.getLeftChild() != null && root.getRightChild() != null) {
                return 1 + size(root.getLeftChild()) + size(root.getRightChild());
            } // Si solo tiene un subárbol revisa ese
            else if (root.getLeftChild() != null) {
                return 1 + size(root.getLeftChild());
            }
            else if (root.getRightChild() != null) {
                return 1 + size(root.getRightChild());
            } // Si es una hoja devuelve 1
            return 1;
        }
        // Si no hay árbol el resultado es 0
        return 0;
    }

    @Override
    public int contarHojas(NodoArbol<K,T> root) {
        // Guarda los valores
        int valores = 0;
        // Cuenta en los subárboles derechos y lo suma
        if (root.getRightChild() != null){
            valores += contarHojas(root.getRightChild());
        }
        // Idem con los izquierdos
        if (root.getLeftChild() != null){
            valores += contarHojas(root.getLeftChild());
        }
        // Si llega una hoja se suma su valor a la suma actual de valores
        if (root.getLeftChild()== null && root.getRightChild() == null){
            return (1 + valores);
        }
        // La final devuelve el valor total
        return valores;
    }

    @Override
    public int countCompleteElements(NodoArbol<K,T> root){
        // Inicializa cuenta
        int valores = 0;
        // Si solo tiene un subárbol se suma el resultado de la function en el mismo
        if (root.getRightChild() != null){
            valores += countCompleteElements(root.getRightChild());
        }
        if (root.getLeftChild() != null){
            valores += countCompleteElements(root.getLeftChild());
        }
        if (root.getLeftChild()!= null && root.getRightChild() != null){
            // Si tiene los dos se suma uno al valor, no se vuelve a contar porque ya se hizo antes
            return 1 + valores;
        }
        return valores;
    }

    //Funciones para árbol binario

    @Override
    public NodeBST<K,T> getBinaryRoot(){
        return binaryRoot;
    }

    @Override
    public void setBinaryRoot(NodeBST<K,T> raiz){
        this.binaryRoot = raiz;
    }

    public NodeBST<K,T> binaryFind(K key, NodeBST<K, T> root){
        int comparacion = key.compareTo(root.getKey());
        switch (comparacion){
            case 0: // Si es el valor lo retorna
                return root;
            case -1:  // Si es menor, si tiene subárbol izquierdo va por el, si no devuelve nulo (No existe)
                if (root.getLeftChild() != null) {
                    return binaryFind(key, root.getLeftChild());
                }
                return null;
            case 1 : // Si es mayor, si tiene subárbol derecho va por el, si no devuelve nulo (No existe)
                if (root.getRightChild() != null) {
                    return binaryFind(key, root.getRightChild());
                }
                return null;
        }
        return null;
    }

    @Override
    public T binaryFindData(K key, NodeBST<K, T> root){
        // Se usa la función binaryFind para encontrar al nodo y se devuelve su valor siempre que no sea nulo
        NodeBST<K, T> temp = binaryFind(key, root);
        if (temp != null){
            return temp.getData();
        }
        return null;
    }

    //Aca falta
    @Override
    public void binaryInsert (K key, T data, NodeBST<K, T> root){
        NodeBST<K, T> child = new NodeBST<>(key, data);
        if (root == null){
            this.setBinaryRoot(child);
        }
        int comparison = key.compareTo(root.getKey());
        switch (comparison){
            case 0:
                return; // Ya esta el valor en el árbol
        case -1:
            if (root.getLeftChild() == null) { // Si no tiene se vuelve el hijo
                root.setLeftChild(child);
                return;
            }
            binaryInsert(key, data, root.getLeftChild()); // Si no se sigue buscando por el árbol
            return;
        case 1:
            if (root.getRightChild() == null) { // Si no tiene se vuelve el hijo
                root.setRightChild(child);
                return;
            }
            binaryInsert(key, data, root.getRightChild()); // Si no se sigue buscando por el árbol
            return;
        }
    }


    @Override
    public void binaryDelete (K key, NodeBST<K, T> root){
        // Si no existe arbor se ignora
        if (root == null) {
            return;
        }
        switch (key.compareTo(root.getKey())){
            case -1: // La key es menor que la de root
                // Si la key es menor se va al por el subárbol izquierdo, si no tiene hijo izquierdo hace return
                if (root.getLeftChild() == null) {
                    return;
                }
                // Se fija si el hijo izquierdo lo es
                if (root.getLeftChild().getKey().equals(key)) {
                    // Si lo es
                    // Se fija si el hijo que se va a borrar tiene subárbol derecho (Mayor)
                    if (root.getLeftChild().getRightChild() == null) {
                        // Si no tiene reviza el izquierdo
                        if (root.getLeftChild().getLeftChild() != null) {
                            root.setLeftChild(root.getLeftChild().getLeftChild());
                            // Si tiene lo sustituye
                        }
                        // Si no tiene ninguno lo borra de una
                        root.setLeftChild(null);
                    }
                    // Si lo tiene se vuelve el nuevo hijo, cuidando de no borrar al hijo izquierdo
                    // Se guarda el hijo izquierdo del que se va a borrar
                    NodeBST<K, T> leftTree = root.getLeftChild().getLeftChild();
                    // Remplaza el nodo con el subárbol derecho
                    root.setLeftChild(root.getLeftChild().getRightChild());
                    NodeBST<K, T> rightTree = root.getLeftChild();
                    // Lo guardo como variable para empezar a operar
                    // Va hasta el primer espacio nulo a la izquierda del subárbol derecho
                    while (rightTree.getLeftChild() != null) {
                        rightTree = rightTree.getLeftChild();
                    }
                    // Cuando sea nulo guarda el subárbol izquierdo (ya que es menor a cualquier valor en el subárbol derecho)
                    rightTree.setLeftChild(leftTree);
                }
                // Si no es igual, al ser menor revisa dentro el subárbol izquierdo
                binaryDelete(key, root.getLeftChild());
                break;
            case 1:// Idem con el subárbol derecho
                // Va al por el subárbol derecho, si no tiene hijo derecho hace return
                if (root.getRightChild() == null) {
                    return;
                }
                // Se fija si el hijo derecho lo es
                if (root.getRightChild().getKey().equals(key)) {
                    // Si lo es
                    // Se fija si el hijo que se va a borrar tiene subárbol izquierdo (Menor)
                    if (root.getRightChild().getLeftChild() == null) {
                        // Si no tiene reviza el derecho
                        if (root.getRightChild().getRightChild() != null) {
                            root.setRightChild(root.getRightChild().getRightChild());
                            // Si tiene lo sustituye
                        }
                        // Si no tiene ninguno lo borra de una
                        root.setRightChild(null);
                    }
                    // Si lo tiene se vuelve el nuevo hijo, cuidando de no borrar al hijo derecho
                    // Se guarda el hijo derecho del que se va a borrar
                    NodeBST<K, T> rightTree = root.getRightChild().getRightChild();
                    // Remplaza el nodo con el subárbol izquierdo
                    root.setRightChild(root.getRightChild().getLeftChild());
                    NodeBST<K, T> leftTree = root.getLeftChild();
                    // Lo guardo como variable para empezar a operar
                    // Va hasta el primer espacio nulo a la derecha del subárbol izquierdo
                    while (rightTree.getRightChild() != null) {
                        rightTree = rightTree.getRightChild();
                    }
                    //C uando sea nulo guarda el subárbol derecho (ya que es mayor a cualquier valor en el subárbol izquierdo)
                    rightTree.setRightChild(rightTree);
                }
                // Si no es igual, al ser menor revisa dentro el subárbol izquierdo
                binaryDelete(key, root.getRightChild());
                break;
            default:
                // El unico caso que lo hace, es si se borra la raiz, ya que si es parte del arbor lo hace en los "case" 1/-1
                // Se guarda el subárbol izquierdo
                NodeBST<K, T> leftTree = root.getLeftChild();
                root = root.getRightChild();
                // Se remplaza con el hijo derecho y el hijo derecho se va al subárbol mas a la izquierda, ya que es menor a todos
                while (root.getLeftChild() != null){
                    root = root.getLeftChild();
                }
                // Despises lo guarda
                root.setLeftChild(leftTree);
        }
    }

    //Métodos de recorrida, se usan distintos por el tipo de nodo

    @Override
    public MyList<K> preOrder(NodoArbol<K, T> root){
        MyList<K> lista = new MyLinkedListImpl<>();
        if (root == null){ // Si no existe el árbol
            return null;
        }
        lista.add(root.getKey()); // Se añade el valor
        if (root.getLeftChild() != null) { // Se recorre el árbol izquierdo, se van añadiendo los valores desde arriba
            lista.listAddToEnd(preOrder(root.getLeftChild()));
        }
        if (root.getRightChild() != null) { // Idem con el árbol derecho
            lista.listAddToEnd(preOrder(root.getRightChild()));
        }
        return lista;
    }

    @Override
    public MyList<K> preOrderBinary(NodeBST<K, T> root){
        MyList<K> lista = new MyLinkedListImpl<>();
        if (root == null){ // Si no existe el árbol
            return null;
        }
        lista.add(root.getKey()); // Se añade el valor
        if (root.getLeftChild() != null) { // Se recorre el árbol izquierdo, se van añadiendo los valores desde arriba
            lista.listAddToEnd(preOrderBinary(root.getLeftChild()));
        }
        if (root.getRightChild() != null) { // Idem con el árbol derecho
            lista.listAddToEnd(preOrderBinary(root.getRightChild()));
        }
        return lista;
    }

    @Override
    public MyList<K> inOrder(NodoArbol<K, T> root){
        MyList<K> lista = new MyLinkedListImpl<>();
        if (root == null){ // Si no existe el árbol
            return null;
        }
        if (root.getLeftChild() != null) { // Se recorre el árbol izquierdo, se van añadiendo los valores desde arriba
            lista.listAddToEnd(inOrder(root.getLeftChild()));
        }
        lista.add(root.getKey()); // Se añade el valor después que el del subárbol izquierdo
        if (root.getRightChild() != null) { // Después el del árbol derecho
            lista.listAddToEnd(inOrder(root.getRightChild()));
        }
        return lista;
    }

    @Override
    public MyList<K> inOrderBinary(NodeBST<K, T> root){
        MyList<K> lista = new MyLinkedListImpl<>();
        if (root == null){ // Si no existe el árbol
            return null;
        }
        if (root.getLeftChild() != null) { // Se recorre el árbol izquierdo, se van añadiendo los valores desde arriba
            lista.listAddToEnd(inOrderBinary(root.getLeftChild()));
        }
        lista.add(root.getKey()); // Se añade el valor después que el del subárbol izquierdo
        if (root.getRightChild() != null) { // Después el del árbol derecho
            lista.listAddToEnd(inOrderBinary(root.getRightChild()));
        }
        return lista;
    }

    @Override
    public MyList<K> postOrder(NodoArbol<K, T> root){
        MyList<K> lista = new MyLinkedListImpl<>();
        if (root == null){ // Si no existe el árbol
            return null;
        }
        if (root.getLeftChild() != null) { // Se recorre el árbol izquierdo, se van añadiendo los valores desde arriba
            lista.listAddToEnd(postOrder(root.getLeftChild()));
        }
        if (root.getRightChild() != null) { // Después el del árbol derecho
            lista.listAddToEnd(postOrder(root.getRightChild()));
        }
        lista.add(root.getKey()); // Se añade el valor al final
        return lista;
    }

    @Override
    public MyList<K> postOrderBinary(NodeBST<K, T> root){
        MyList<K> lista = new MyLinkedListImpl<>();
        if (root == null){ // Si no existe el árbol
            return null;
        }
        if (root.getLeftChild() != null) { // Se recorre el árbol izquierdo, se van añadiendo los valores desde arriba
            lista.listAddToEnd(postOrderBinary(root.getLeftChild()));
        }
        if (root.getRightChild() != null) { // Después el del árbol derecho
            lista.listAddToEnd(postOrderBinary(root.getRightChild()));
        }
        lista.add(root.getKey()); // Se añade el valor al final
        return lista;
    }
}
