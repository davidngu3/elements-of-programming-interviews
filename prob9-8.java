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
    }
}

class CircularQueue {
    private int[] q;
    private int headIdx;
    private int tailIdx;
    
    public CircularQueue(int capacity) {
        this.q = new int[capacity];
        Arrays.fill(q, 0);
        headIdx = -1;
        tailIdx = -1;
    }
    
    public void enqueue(int e) {
        if (headIdx < 0) { // no elements in queue
            q[0] = e;
            headIdx = 0;
            tailIdx = 0;
        }
        else {
            tailIdx = (tailIdx + 1) % q.length;
            q[tailIdx] = e;

            // resize, if necessary
            if (this.size() > (q.length * 3/4)) {
                this.resize();
            }
        }
    }

    public int dequeue() {
        int e = q[headIdx];
        q[headIdx] = 0;

        if (headIdx == tailIdx) { // this was last element in q
            headIdx = -1;
            tailIdx = -1;
        }
        else {
            headIdx = headIdx + 1;
        }
       
        return e;
    }
    
    public int size() {
        if (tailIdx >= headIdx) {
            return tailIdx - headIdx + 1;
        }
        return q.length - headIdx + tailIdx + 1;
    }

    public void resize() {
        int newLength = q.length * 2;
        this.q = Arrays.copyOf(q, newLength);
    }
}