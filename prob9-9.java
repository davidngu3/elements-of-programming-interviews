import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem9_9 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(3);
        q.enqueue(9);
        q.enqueue(4);
        q.enqueue(15);
        q.dequeue();
        q.dequeue();
    }
}

class Queue {
    private Deque<Integer> pushStack;
    private Deque<Integer> popStack;

    public Queue() {
        this.pushStack = new LinkedList<Integer>();
        this.popStack = new LinkedList<Integer>();
    }

    public void enqueue(int e) {
        this.pushStack.addFirst(e);
    }

    public int dequeue() {
        if (this.popStack.isEmpty()) {
            if (this.pushStack.isEmpty()) {
                throw new IllegalStateException("No elements to dequeue");
            }
            // migrate pushStack to popStack
            while (!pushStack.isEmpty()) {
                this.popStack.addFirst(pushStack.removeFirst());
            }
        }
        return this.popStack.removeFirst();
    }
}