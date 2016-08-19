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
public class LinkedListNodeImpl<Item> implements LinkedList<Item> {

    private Node first;
    private Node last;
    private int numItems = 0;

    @Override
    public void prepend(Item item) {
        // insert at front of list - just like stack
        Node prevFirst = first;
        first = new Node();
        first.item = item;
        first.next = prevFirst;
        numItems++;
        // if numItems is 1 this is the first and last Node
        if (numItems == 1) {
            last = first;
        }
    }

    // adds to end of list
    @Override
    public void append(Item item) {
        // add to end of list - just like queue
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

    // inserts after the given index
    @Override
    public void insert(int index, Item item) {
        // if we're appending to the end just call append so we don't
        // iterate through the list
        if (index == numItems - 1) {
            append(item);
        } else {
            // get node at index
            Node nodeAtIndex = getNode(index);

            // insert new node after node at index
            Node newNode = new Node();
            newNode.item = item;
            newNode.next = nodeAtIndex.next;
            nodeAtIndex.next = newNode;
            numItems++;
        }
    }

    @Override
    public Item get(int index) {
        if (index == 0) {
            return first.item;
        } else if (index == numItems - 1) {
            return last.item;
        } else {
            // find the item in the list
            return getNode(index).item;
        }
    }

    @Override
    public Item remove(int index) {
        Item ret = null;
        if (index == 0) {
            // if index is 0 remove the first Node - just like a Stack pop
            ret = first.item;
            first = first.next;
        } else {
            // find the Node BEFORE the one we want to remove
            Node nodeBefore = getNode(index - 1);
            // get the item from the Node we want to remove
            ret = nodeBefore.next.item;
            // point our next to the node AFTER the one we want to remove
            nodeBefore.next = nodeBefore.next.next;
            // if we removed the last node in the list we need to point last to
            // nodeBefore
            if (index == numItems - 1) {
                last = nodeBefore;
            }
        }
        numItems--;
        return ret;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class Node {

        Item item;
        Node next;
    }

    private class LinkedListIterator implements Iterator {

        Node current = first;

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
    }

    // finds the Node at the given index
    private Node getNode(int index) {
        if (index > numItems - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds.  Must be between 0 and "
                    + (numItems - 1) + " inclusive.");
        }

        Node nodeAtIndex = first;
        for (int i = 0; i < index; i++) {
            nodeAtIndex = nodeAtIndex.next;
        }

        return nodeAtIndex;
    }

}
