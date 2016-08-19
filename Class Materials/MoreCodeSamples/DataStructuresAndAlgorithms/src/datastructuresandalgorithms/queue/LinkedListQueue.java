/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuresandalgorithms.queue;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class LinkedListQueue implements Queue {
    private Node first;
    private Node last;
    private int numItems;

    @Override
    public void enqueue(Object item) {
        // add to the end of the list
        Node prevLast = last;
        last = new Node();
        last.item = item;
        // if this is the first node in the list set first equal to last
        if (isEmpty()) {
            first = last;
        } else {
            // set the next pointer on prevLast to point to the new last
            prevLast.next = last;
        }
        numItems++;
    }

    @Override
    public Object dequeue() {
        // remove from the front of the list
        Object ret = first.item;
        first = first.next;
        numItems--;
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
