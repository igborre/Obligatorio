package uy.edu.um.prog2.tad.linkedlist;

import uy.edu.um.prog2.tad.Queue.*;
import uy.edu.um.prog2.tad.Stack.*;

import javax.print.DocFlavor;

public class MyLinkedListImpl<T> implements MyList<T>, MyQueue<T>, MyStackL<T>, MyStackA<T>, MyDoubleLinkedList<T>, MyCircularLinkedList<T> {

    public Node<T> first;
    public Node<T> last;

    // Para Stack de Array
    public int maxSize;
    public T[] stackArray;
    public int arrayTop;

    public MyLinkedListImpl() {
        this.first = null;
        this.last = null;
        this.maxSize = 0;
        this.stackArray = null;
        this.arrayTop = 0;
    }
    //Funciones Lista enlazada

    //Se fija si un elemente es parte de una lista
    @Override
    public boolean contains(T value) {
        Node<T> temp = this.first;
        //Recorre la lista y se fija por el valor
        while (temp != null) {
            if (temp.getValue().equals(value)) {
                return true;
            }
            temp = temp.getNext();
        }
        //Si llego al final de la lista y no esta, devuelve falso
        return false;
    }

    private void addToTheEnd(T value) {
        if (value != null) {
            Node<T> nuevoNodo = new Node<>(value);
            //Si la lista es vacía lo agrega al inicio
            if (this.first == null) {
                this.first = nuevoNodo;
                this.last = nuevoNodo;
            } //Si no va hasta el final y lo agrega ahi
            else {
                this.last.setNext(nuevoNodo);
                this.last = nuevoNodo;
            }
        }
    }

    @Override //Lo agrega al final
    public void add(T value) {
        addToTheEnd(value);
    }

    @Override //Lo agrega al inicio
    public void addToTheBeginning(T value) {
        if (value != null) {
            Node<T> nuevoNodo = new Node<>(value);
            //Si la lista es vacía lo crea en el inicio
            if (this.first == null) {
                this.first = nuevoNodo;
                this.last = nuevoNodo;
            } //En caso de no ser vacía, lo agrega al comienzo
            else {
                nuevoNodo.setNext(this.first);
                this.first = nuevoNodo;
            }
        }
    }

    @Override
    public T get(int i){
        if (i > this.size()){ // Se asegura que exista el valor
            return null;
        }
        Node<T> temp = this.first;
        int position = 1;
        while (position < i) { // Recorre la lista hasta llegar a el
            temp = temp.getNext();
            position++;
        }
        return temp.getValue();
    }

    @Override
    public void remove(T value) {
        if (first != null) {
            Node<T> temp = first;
            Node<T> tempPosCheck = first;
            int position = 0;
            while (tempPosCheck.getValue() != value) {
                if (tempPosCheck.getNext() == null) {
                    return; //Si no esta se cancela
                }
                tempPosCheck = tempPosCheck.getNext();
                position++;
            }
            // Se revisa si se quiere editar el primero
            if (position == 0) {
                // Si hay siguiente lo remplaza al primero
                if (temp.getNext() != null) {
                    first = temp.getNext();
                } // Si no existe siguiente lo convierte en un null
                else {
                    first = null;
                }
            } else {
                // si se quiere la posicion n, se va a la n-1
                for (int i = 1; i < position; ) {
                    temp = temp.getNext();
                    i++;
                }
                // Revisa si existe nodo en la posicion n+1
                if ((temp.getNext()).getNext() != null) {
                    // Si existe el de la posicion n+1 remplaza al de la n
                    temp.setNext((temp.getNext()).getNext());
                } else {
                    // Si no, el de la posicion n se vuelve null
                    temp.setNext(null);
                    last = temp;
                }

            }
        }
    }

    @Override
    public int size() {
        int size = 0;
        Node<T> temp = this.first;
        while (temp != null) {
            temp = temp.getNext();
            size++;
        }
        return size;
    }

    @Override
    public Node<T> returnFirst(){
        return this.first;
    }

    @Override
    public MyList<T> listAddToEnd(MyList<T> lista2) {
        Node<T> lista1 = this.first;
        if (lista1.getNext() == null) {
            return lista2;
        }
        while (lista1.getNext() != null) {
            lista1 = lista1.getNext();
        }
        lista1.setNext(lista2.returnFirst());
        return this;
    }

    //Funciones lista doblemente enlazada

    @Override
    public void addDouble(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.first == null) {
            this.first = newNode;
            this.last = this.first;
        }
        Node<T> temp = first;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        newNode.setPrevious(temp);
        temp.setNext(newNode);
        this.last = newNode;
    }

    @Override
    public void addToTheBegineingDouble(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.first == null) {
            this.first = newNode;
            this.last = this.first;
        }
        Node<T> temp = first;
        first = newNode;
        temp.setPrevious(newNode);
        first.setNext(temp);
    }

    @Override
    public void removeDouble(int position) {
        //Si es la primera posicion
        if (position == 1) {
            //Si es la unica vacia la lista
            if (this.first.getNext() == null) {
                this.first = null;
                this.last = null;
            }
            //Si no la siguiente se vuelve la primera
            Node<T> temp = this.first.getNext();
            temp.setNext(null);
            this.first = temp;
        }
        //Si es la ultima
        else if (position == this.size() && position > 1) {
            Node<T> temp = this.last.getPrevious();
            temp.setNext(null);
            this.last = temp;
        }
        //Si es una posicion media
        else if (position < this.size()) {
            Node<T> temp = this.first;
            int pos = 1;
            //Va a la posicion que se quiere borrar
            while (pos < position) {
                temp = temp.getNext();
                pos++;
            }
            //Remplaza los next y next de los que estan relacionadoes con el.
            Node<T> last = temp.getPrevious();
            Node<T> next = temp.getNext();
            next.setPrevious(last);
            last.setNext(next);
        }
        //Si no esta en la lista
        return;
    }

    //Funciones de lista Circular
    @Override
    public void addCirc(T value){
        Node<T> newNode = new Node<>(value);
        if (this.first == null) {
            this.first = newNode;
            this.last = this.first;
            newNode.setNext(this.first);
        }
        Node<T> temp = this.first;
        //Se llega al ultimo
        while (temp.getNext() != null && temp != this.last) {
            temp = temp.getNext();
        }
        //El ultimo se vuelve el nuevo y su siguiente el primero
        temp.setNext(newNode);
        newNode.setNext(this.first);
    }

    @Override
    public T getCircularLogic(int position){
        //Si la lista no esta vacia
        if (sizeCirc() != 0) {
            //Se hace mod para no tener que recorer varias veces
            position = position % this.sizeCirc();
            Node<T> temp = this.first;
            int i = 1;
            //Se llega a la posicion
            while (i < position){
                temp = temp.getNext();
                i++;
            }
            //Se hace return del valor
            return temp.getValue();
        }
        //Si la lista no existe devuelve nulo
        return null;
    }

    @Override
    public boolean containsCirc(T value){
        //Para saber el largo de la comparación
        int listLength = this.sizeCirc();
        Node<T> temp = this.first;
        //Se va a bajar el valor de listLength hasta que se comparen todas las posiciones de lista 1 vez
        while (listLength > 0) {
            if (temp.getValue().equals(value)) {
                return true;
            }
            temp = temp.getNext();
            listLength = (listLength - 1) ;
        }
        //Si no se encontró al recorrer la lista no esta en la misma
        return false;
    }

    @Override
    public void removeCirc(T value){
        //Se recorre de la misma forma que contains y se encuentra el nodo.
        int listLength = this.sizeCirc();
        Node<T> temp = this.first;
        //Se va a bajar el valor de listLength hasta que se comparen todas las posiciones de lista 1 vez, para ver si el siguiente es el valor
        while (listLength > 0) {
            if (temp.getNext().getValue().equals(value)) {
                //Si lo es, se borran las referencias a el
                temp.setNext(temp.getNext().getNext());
                return;
                //Si se encuentra se termina
            }
            temp = temp.getNext();
            listLength = (listLength - 1) ;
        }
        //Si no se encuentra, el valor no esta en la lista.
    }

    @Override
    public int sizeCirc() {
        //Si la lista es nula devuelve 0
        if (this.first == null) {
            return 0;
        }
        Node<T> temp = this.first;
        int size = 1;
        //Si no le suma 1 por cada valor hasta llegar al ultimo
        while (temp != this.last) {
            temp = temp.getNext();
            size++;
        }
        return size;
    }

    // Operaciones particulares a Queue

    @Override
    public void enqueue(T value) {
        addToTheBeginning(value);
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (this.last == null) { //Si la queue esta vacia
            throw new EmptyQueueException();
        }
        T value = this.last.getValue();
        this.remove(value);
        return value;
    }

    // Operaciones particulares a Stack

    @Override
    public int lenght(){
        if (first != null){
            int length = 1;
            Node<T> temp = first;
            while(temp.getNext() != null){
            length++;
            temp = temp.getNext();
            }
        return length;
        }
        return 0;
    }

    @Override
    public void push(T value) {
        addToTheEnd(value);
    }

    @Override
    public void pop() throws EmptyStackException{
        if (lenght() > 0) {
            Node<T> temp = first;
            if (temp.getNext() != null) {
                while ((temp.getNext()).getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(null);
                last = temp;
            } else {
                first = null;
            }
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public T peek() throws EmptyStackException{
        if (lenght() > 0) {
            return last.getValue();
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty(){
        if (lenght() > 0) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    public void makeEmpty(){
        first = null;
        last = null;
    }


    // Especificas a Stacks de Arrays
    @Override
    public void stackArray(int size) {
        this.maxSize = size;
        this.stackArray = (T[]) new Object[maxSize];
        this.arrayTop = -1;
    }

    @Override
    public void pushArray(T element) throws StackOverflowException {
        if (arrayTop < maxSize - 1) {
            stackArray[arrayTop + 1] = element;
            arrayTop += 1;
        } else {
            throw new StackOverflowException();
        }
    }

    @Override
    public void popArray() throws EmptyStackException {
        if (arrayTop > -1) {
            stackArray[arrayTop] = null;
            arrayTop -= 1;
        } else {
            throw new EmptyStackException();
        }
    }

    public T topArray() throws EmptyStackException {
        if (arrayTop > -1) {
            return stackArray[arrayTop];
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public boolean isEmptyArray() {
        return (arrayTop == -1);
    }

    @Override
    public void makeEmptyArray() {
        stackArray = (T[]) new Object[maxSize];
        arrayTop = -1;
    }
}