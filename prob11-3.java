import java.util.*;

class Problem11_3 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(3, -1, 2, 6, 4, 5, 8));
        List<Integer> res = sortApproximateData(arr.iterator(), 2);
        for (Integer i : res) {
            System.out.println(i);
        }
    }

    // data is at most k away from its initial position
    // therefore, after processing i+k+1 elements, we know that the element at index i is the min among those elements.
    public static List<Integer> sortApproximateData(Iterator<Integer> data, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        // add first k elements to min heap
        while (k-- > 0 && data.hasNext()) {
            minHeap.add(data.next());
        }

        // repeatedly: add one element (i+k+1 element processed), then pop (process to output) min element until data empty
        while (data.hasNext()) {
            minHeap.add(data.next());
            res.add(minHeap.poll());
        }
        
        // flush the remainder of the heap to output
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }

        return res;
    }
}
