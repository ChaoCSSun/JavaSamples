package algoforur;

import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by Tikitoo on 2015/12/13.
 */
public class Topic13 {
    // queue
    public static int[] readInts(Scanner name) {
        In in = new In(name);
        Queue<Integer> queue = new Queue<Integer>();
        while (!in.isEmpty()) {
            queue.enqueue(in.readInt());
        }

        int N = queue.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = queue.dequeue();
        }
        return a;
    }

    public static void readStack() {
        Stack<Integer> stack = new Stack<Integer>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readInt());
        }

        for(Integer str : stack) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        readStack();
        /*int[] a = readInts(new Scanner(System.in));
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }*/
    }

}
