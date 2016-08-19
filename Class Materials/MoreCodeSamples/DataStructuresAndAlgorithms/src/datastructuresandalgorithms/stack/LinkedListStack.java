/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuresandalgorithms.stack;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class LinkedListStack implements Stack {
    private Node first;
    private int numItems;

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public void push(Object item) {
        Node prevFirst = first;
        first = new Node();
        first.item = item;
        first.next = prevFirst;
        numItems++;
    }

    @Override
    public Object pop() {
        Object ret = first.item;
        first = first.next;
        numItems--;
        return ret;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }
    
    private class Node {
        Object item;
        Node next;
    }
    
    private class LinkedListIterator implements Iterator {
        Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            if (current == null) {
                return null;
            }
            
            Object ret = current.item;
            current = current.next;
            return ret;
        }
        
        @Override
        public void remove() {
            
        }
        
    }
    
}
