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
public class ArrayStackDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack st = new LinkedListStack();
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";

        System.out.println("Pushing " + a);
        st.push(a);
        System.out.println("Pushing " + b);
        st.push(b);
        System.out.println("Pushing " + c);
        st.push(c);
        System.out.println("Pushing " + d);
        st.push(d);

//        System.out.println("Popping...");
//        System.out.println((String) st.pop());
//        System.out.println("Popping...");
//        System.out.println((String) st.pop());
//        System.out.println("Popping...");
//        System.out.println((String) st.pop());
//        System.out.println("Popping...");
//        System.out.println((String) st.pop());
//        System.out.println("Popping...");
//        System.out.println((String) st.pop());
        
        for (Object o : st) {
            System.out.println((String) o);
        }

    }

}
