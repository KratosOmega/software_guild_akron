/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms.stack;

/**
 *
 * @author apprentice
 */
public class GenArrayStackDriver {

    public static void main(String[] args) {
//        GenStack<String> st = new GenArrayStack<>();
        GenStack<String> st = new GenLinkedListStack<>();
        st.push("Joe");
        st.push("Steve");
        st.push("Sally");
        
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }

}
