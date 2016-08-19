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
public class GenLinkedListStack<Item> implements GenStack<Item> {
    private Node<Item> first;
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
    public void push(Item item) {
        Node prevFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = prevFirst;
        numItems++;
    }

    @Override
    public Item pop() {
        Item ret = first.item;
        first = first.next;
        numItems--;
        return ret;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }
    
    private class Node<Item> {
        Item item;
        Node next;
    }
    
    private class LinkedListIterator implements Iterator {
        Node<Item> current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                return null;
            }
            
            Item ret = current.item;
            current = current.next;
            return ret;
        }
        
        @Override
        public void remove() {
            
        }
        
    }
}
