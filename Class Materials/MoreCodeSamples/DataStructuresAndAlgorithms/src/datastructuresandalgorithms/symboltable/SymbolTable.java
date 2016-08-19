/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms.symboltable;

/**
 *
 * @author warde
 * @param <Key>
 * @param <Value>
 */
public interface SymbolTable<Key, Value> {
    
    public Value get(Key key);
    public void put(Key key, Value value);
    public void delete(Key key);
    public boolean contains(Key key);
    public boolean isEmpty();
    public int size();
    public Iterable<Key> keys();
}
