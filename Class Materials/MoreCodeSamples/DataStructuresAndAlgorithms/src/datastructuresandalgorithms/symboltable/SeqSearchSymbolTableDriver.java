/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms.symboltable;

/**
 *
 * @author warde
 */
public class SeqSearchSymbolTableDriver {

    public static void main(String[] args) {
        SeqSearchSymbolTable<String, String> st = new SeqSearchSymbolTable<>();

        st.put("OH", "Columbus");
        st.put("IA", "Des Moines");

        System.out.println("Table size = " + st.size());

        Iterable<String> states = st.keys();
        for (String s : states) {
            System.out.println("State = " + s + " Capital = " + st.get(s));
        }

        st.put("IA", "Rockford");
        states = st.keys();
        for (String s : states) {
            System.out.println("State = " + s + " Capital = " + st.get(s));
        }

        st.delete("IA");
        states = st.keys();
        for (String s : states) {
            System.out.println("State = " + s + " Capital = " + st.get(s));
        }
    }

}
