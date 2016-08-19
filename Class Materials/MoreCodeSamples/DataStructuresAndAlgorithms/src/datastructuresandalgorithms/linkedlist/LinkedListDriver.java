/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms.linkedlist;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class LinkedListDriver {

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedListNodeImpl<>();
        System.out.println(ll.size());
        String one = "one";
        String two = "two";
        String three = "three";
        String four = "four";
        String five = "five";

        ll.prepend(one);

        System.out.println(ll.size());
        System.out.println(ll.get(0));

        ll.remove(0);

        System.out.println(ll.size());

        ll.prepend(one);
        ll.prepend(two);
        ll.append(three);

        System.out.println(ll.size());
        System.out.println("++++++++++++++++++++++++++++");
        for (Object o : ll) {
            System.out.println(o);
        }

        ll.remove(1);
        System.out.println("++++++++++++++++++++++++++++");
        for (Object o : ll) {
            System.out.println(o);
        }

        ll.append(four);
        ll.append(five);
        System.out.println("++++++++++++++++++++++++++++");
        for (Object o : ll) {
            System.out.println(o);
        }

        ll.remove(3);
        System.out.println("++++++++++++++++++++++++++++");
        for (Object o : ll) {
            System.out.println(o);
        }

        ll.remove(2);
        System.out.println("++++++++++++++++++++++++++++");
        for (Object o : ll) {
            System.out.println(o);
        }

        ll.insert(0, five);
        System.out.println("++++++++++++++++++++++++++++");
        for (Object o : ll) {
            System.out.println(o);
        }

        ll.insert(2, four);
        System.out.println("++++++++++++++++++++++++++++");
        for (Object o : ll) {
            System.out.println(o);
        }
        
        Iterator iter = ll.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

}
