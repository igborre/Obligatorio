package uy.edu.um.prog2.tad;
import uy.edu.um.prog2.tad.Arboles.*;
import uy.edu.um.prog2.tad.linkedlist.*;
import org.junit.*;


public class Main {
    public static void main(String[] args) {
        MyList<Integer> lista = new MyLinkedListImpl<Integer>();
        lista.add(2);
        lista.add(1);
        lista.add(3);
        System.out.println(lista.size());
        lista.remove(1);
        System.out.println(lista.size());
        System.out.println(lista.get(1));
        System.out.println(lista.get(2));
        lista.addToTheBeginning(1);
        System.out.println(lista.get(1));
        System.out.println(lista.contains(3));
        System.out.println(lista.contains(4));

        // Test arboles
        Tree<Integer, String> base = new TreeImpl<>();
        base.insert(3,"Uruguay",null);
        base.insert(1,"Argentina",3);
        base.insert(2,"Brazil",3);
        base.insert(4,"Chile",2);
        base.insert(5,"Peru",1);
        base.insert(6,"Ecuador",1);
        base.insert(7,"Colombia",5);

        System.out.println(base.size(base.getRoot()));

        System.out.println(base.contarHojas(base.getRoot()));

        System.out.println(base.find(5));

        System.out.println(base.countCompleteElements(base.getRoot()));


        Tree<Integer, Integer> base1 = new TreeImpl<>();
        base1.insert(2,2,null);
        base1.insert(2,2,2);
        System.out.println(base1.size(base1.getRoot()));
    }
}