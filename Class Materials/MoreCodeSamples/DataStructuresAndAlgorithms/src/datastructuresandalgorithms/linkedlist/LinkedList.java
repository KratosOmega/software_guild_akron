/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms.linkedlist;

/**
 *
 * @author apprentice
 * @param <Item>
 */
public interface LinkedList<Item> extends Iterable {

    // adds to end of list
    void append(Item item);

    Item get(int index);

    // inserts after the given index
    void insert(int index, Item item);

    boolean isEmpty();

    void prepend(Item item);

    Item remove(int index);

    int size();
    
}
