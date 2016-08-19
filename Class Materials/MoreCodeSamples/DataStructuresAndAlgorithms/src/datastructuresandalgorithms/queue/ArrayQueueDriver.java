/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms.queue;

/**
 *
 * @author apprentice
 */
public class ArrayQueueDriver {

    public static void main(String[] args) {
        Queue q = new LinkedListQueue();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");

        System.out.println(q.dequeue());

        q.enqueue("d");

        System.out.println(q.dequeue());

        q.enqueue("e");

        System.out.println(q.dequeue());
        q.enqueue("f");

        System.out.println(q.dequeue());
        q.enqueue("g");

        System.out.println(q.dequeue());
        q.enqueue("h");

        System.out.println(q.dequeue());
        q.enqueue("i");

    }
}
