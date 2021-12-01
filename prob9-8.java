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
        // copy existing data into new array
        int newLength = q.length * 2;
        int[] newArr = new int[newLength];
        int prevSize = this.size();

        int i = 0;
        while (i < prevSize) {
            newArr[i] = q[headIdx % q.length];
            headIdx++;
            i++;
        }

        q = newArr;
        tailIdx = prevSize - 1;
        headIdx = 0;
    }
}