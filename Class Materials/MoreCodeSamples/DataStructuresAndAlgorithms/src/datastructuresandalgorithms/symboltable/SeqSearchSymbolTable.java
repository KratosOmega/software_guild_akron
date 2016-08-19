/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms.symboltable;

import datastructuresandalgorithms.linkedlist.LinkedList;
import datastructuresandalgorithms.linkedlist.LinkedListNodeImpl;

/**
 *
 * @author warde
 */
public class SeqSearchSymbolTable<Key, Value> implements SymbolTable<Key, Value> {

    private Node first;
    private int numItems = 0;

    @Override
    public Value get(Key key) {
        Value retVal = null;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                retVal = x.value;
            }
        }
        return retVal;
    }

    @Override
    public void put(Key key, Value value) {
        // first look to see if this key/value is in the table
        // if it is, replace the current value
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                // existing key - replace value
                x.value = value;
                return;
            }
        }
        // no existing key - add key/value pair
        first = new Node(key, value, first);
        numItems++;
    }

    @Override
    public void delete(Key key) {
        Node prev = null;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                // search hit - we need to delete node x
                // first fix up the node references
                if (prev == null) {
                    // x must be the first node in the table
                    // set first to x.next
                    first = x.next;
                } else {
                    // x is not the first node
                    // set prev.next to x. next
                    prev.next = x.next;
                }
                // now get rid of x
                x = null;
                // update numItems
                numItems--;
                // we're done - break out of for loop
                break;
            }
        }
    }

    @Override
    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                // found the key - return true
                return true;
            }
        }
        // did not find key - return false
        return false;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public Iterable<Key> keys() {
        LinkedList<Key> keys = new LinkedListNodeImpl<>();
        for (Node x = first; x != null; x = x.next) {
            keys.append(x.key);
        }
        return keys;
    }

    private class Node {

        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
