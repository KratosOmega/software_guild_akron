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
public class SepChainingHashSymbolTableDriver {

    public static void main(String[] args) {
        SymbolTable<String, String> st = new SepChainingHashSymbolTable<>();
        st.put("OH", "Cols");
        System.out.println("Table Size: " + st.size());
        st.put("IA", "Des Moines");
        System.out.println("Table Size: " + st.size());
        st.put("CA", "Sacremento");
        System.out.println("Table Size: " + st.size());
        st.put("OK", "OK City");
        System.out.println("Table Size: " + st.size());
        st.put("MN", "St. Paul");
        System.out.println("Table Size: " + st.size());
        st.put("NY", "Albany");
        System.out.println("Table Size: " + st.size());

        st.put("IA", "DM");
        System.out.println("Table Size: " + st.size());

        st.delete("CA");
        System.out.println("Table Size: " + st.size());

        Iterable<String> keys = st.keys();
        for (String s : keys) {
            System.out.println("State = " + s + " Captial = " + st.get(s));
        }

        st.delete("FOO");
        System.out.println("Table Size: " + st.size());

        st.put("AZ", null);
        keys = st.keys();
        for (String s : keys) {
            System.out.println("State = " + s + " Captial = " + st.get(s));
        }

    }

}
