import java.util.*;

class Problem11_5 {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<Integer>(Arrays.asList(1, 0, 3, 5, 2, 0, 1));
        findMedian(data.iterator());
    }

    public static void findMedian(Iterator<Integer> data) {
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap, for elements left of median
        PriorityQueue<Integer> right = new PriorityQueue<Integer>(); // min heap, for larger elements
        
        while (data.hasNext()) {
            Integer curr = data.next();
            // heap selection based on value
            if (left.isEmpty()) { // no values processed yet
                left.add(curr);
            }
            else if (curr > left.peek())  { // element belongs in right heap
                right.add(curr);
            }
            else { // element belongs in left heap
                left.add(curr);
            }

            // rebalance heaps
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            }
            else if (right.size() > left.size() + 1) {
                left.add(right.poll());
            }
            
            // extract median
            if (right.size() == left.size()) {
                System.out.println((double) (left.peek() + right.peek()) / 2);
            }
            else if (right.size() == left.size() + 1) {
                System.out.println(right.peek());
            }
            else if (left.size() == right.size() + 1) {
                System.out.println(left.peek());
            }
        }
    }
}
