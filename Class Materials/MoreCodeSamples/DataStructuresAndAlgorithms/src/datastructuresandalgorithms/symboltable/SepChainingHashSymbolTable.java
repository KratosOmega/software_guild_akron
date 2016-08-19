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
 * @param <Key>
 * @param <Value>
 */
public class SepChainingHashSymbolTable<Key, Value> implements SymbolTable<Key, Value> {

    // size of the symbol table
    private int M;
    // each entry in our table with be a symbol table so we can take care of collisions
    // for this example we'll use a SeqSearchSymbolTable for each entry
    // for our chaining
    private SymbolTable<Key, Value>[] sTable;
    private int numItems;

    public SepChainingHashSymbolTable() {
        this(97);
    }

    public SepChainingHashSymbolTable(int initialSize) {
        this.M = initialSize;
        sTable = (SymbolTable<Key, Value>[]) new SeqSearchSymbolTable[M];
        // initialize each entry in our table
        for (int i = 0; i < sTable.length; i++) {
            sTable[i] = new SeqSearchSymbolTable<Key, Value>();
        }
    }

    @Override
    public Value get(Key key) {
        return sTable[this.hash(key)].get(key);
    }

    @Override
    public void put(Key key, Value value) {
        if (!this.contains(key)) {
            numItems++;
        }
        sTable[this.hash(key)].put(key, value);
    }

    @Override
    public void delete(Key key) {
        if (this.contains(key)) {
            numItems--;
        }
        sTable[this.hash(key)].delete(key);
    }

    @Override
    public boolean contains(Key key) {
        return sTable[this.hash(key)].contains(key);
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
        for (int i = 0; i < sTable.length; i++) {
            Iterable<Key> temp = sTable[i].keys();
            for (Key k : temp) {
                keys.append(k);
            }
        }
        return keys;
    }

    // computes the slot into which the value should be stored
    private int hash(Key key) {
        // make sure hash of key is non negative then use modulus to 
        // map the hash value into our table
        return (key.hashCode() & 0x7fffffff) % M;
    }
}
