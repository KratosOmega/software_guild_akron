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
public class ArrayQueue implements Queue {

    private static int DEFAULT_INITIAL_SIZE = 4;
    private Object[] items;
    private int numItems = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue() {
        this(DEFAULT_INITIAL_SIZE);
    }

    public ArrayQueue(int size) {
        items = new Object[size];
    }

    @Override
    public void enqueue(Object item) {
        // check to see if this will fill up the array
        items[tail++] = item;
        // check to see if the tail went off the end of the array
        // reset it to 0 if that is the case
        if (tail == items.length) {
            tail = 0;
        }
        if (++numItems == items.length) {
            resize(2 * items.length);
        }
    }

    @Override
    public Object dequeue() {
        if (numItems == 0) {
            return null;
        }
        Object ret = items[head];
        // get rid of our reference
        items[head++] = null;
        // check to see if the head went off the end of the array
        // reset to 0 if that is the case
        if (head == items.length) {
            head = 0;
        }
        // check to see if we should downsize the array
        if (--numItems == items.length / 4) {
            resize(items.length / 2);
        }

        return ret;
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
    public Iterator iterator() {
        return new InOrderArrayIterator();
    }

    private void resize(int newSize) {
        Object[] temp = new Object[newSize];
        // fill the new array from the front and reset the head and tail
        // pointers appropriately
        for (int i = 0, current = head; i < numItems; i++, current++) {
            temp[i] = items[current % items.length];
        }

        head = 0;
        tail = numItems;
        items = temp;
    }

    private class InOrderArrayIterator implements Iterator {

        private int i = numItems;
        private int current = head;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            return items[(current++ % items.length) + 1];
        }

        @Override
        public void remove() {
        }

    }
}
