import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem9_8 {
    public static void main(String[] args) {
       CircularQueue q = new CircularQueue(5);
       q.enqueue(1);
       q.enqueue(2);
       System.out.println(q.size());
       q.enqueue(3);
       q.enqueue(4);
       q.enqueue(5);
       System.out.println(q.size());
       System.out.println(q.dequeue() + " dequeued");
       System.out.println(q.dequeue() + " dequeued");
       System.out.println(q.dequeue() + " dequeued");
       System.out.println(q.size());
       q.enqueue(6);
       q.enqueue(7);
       q.enqueue(9);
       System.out.println(q.dequeue() + " dequeued");
       System.out.println(q.dequeue() + " dequeued");
       System.out.println(q.dequeue() + " dequeued");
       q.enqueue(10);
       q.enqueue(11);
       q.enqueue(12);
       q.enqueue(13);
       q.enqueue(14);
       q.enqueue(15);
       q.enqueue(16);
       System.out.println(q.dequeue() + " dequeued");
       System.out.println(q.dequeue() + " dequeued");
       System.out.println(q.dequeue() + " dequeued");
    }
}

class CircularQueue {
    private Integer[] q;
    private static final int SCALE_FACTOR = 2;
    private static final double RESIZE_THRESHOLD = 0.75;
    private int headIdx = 0;
    private int tailIdx = 0;
    private int numElements = 0;
    
    public CircularQueue(int capacity) {
        this.q = new Integer[capacity];
    }
    
    public void enqueue(int e) {
        // resize, if necessary
        if (this.size() > (q.length * RESIZE_THRESHOLD)) {
            this.resize();
        }

        q[tailIdx] = e;
        tailIdx = (tailIdx + 1) % q.length;
    
        this.numElements++;
    }

    public int dequeue() {
        Integer e = q[headIdx];
        q[headIdx] = null; // actually not necessary to explicity remove, since enqueue will overwrite the tail

        headIdx = (headIdx + 1) % q.length;
       
        this.numElements--;
        return e;
    }
    
    public int size() {
        return numElements;
    }

    public void resize() {
        // bring head to index 0
        Collections.rotate(Arrays.asList(q), -headIdx);

        headIdx = 0; 
        tailIdx = numElements;
        q = Arrays.copyOf(q, numElements * SCALE_FACTOR);
    }
}