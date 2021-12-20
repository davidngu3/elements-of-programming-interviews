import java.util.*;

/* NOTE:
    This solution has very steep time complexity as it doesn't use the fact that the arrays are sorted.
    Instead, insert index 0 of all arrays, pop min, then add to heap the next element that was just popped from. Repeat until heap is empty

*/
class Problem11_1 {
    public static void main(String[] args) {
        ArrayList<Integer> seq1 = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 9));
        ArrayList<Integer> seq2 = new ArrayList<Integer>(Arrays.asList(0, 9, 15, 22));
        ArrayList<Integer> seq3 = new ArrayList<Integer>(Arrays.asList(0, 2, 5));
        
        List<List<Integer>> bigList = new ArrayList<List<Integer>>();
        bigList.add(seq1);
        bigList.add(seq2);
        bigList.add(seq3);

        List<Integer> ret = mergeSortedSequences(bigList);
        for (Integer i : ret) {
            System.out.println(i);
        }
    }

    public static List<Integer> mergeSortedSequences(List<List<Integer>> sequences) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        List<Integer> ret = new ArrayList<Integer>();

        for (List<Integer> sequence : sequences) {
            for (Integer i : sequence) {
                // insert to min heap
                minHeap.add(i);
            }
        }

        // pop from heap, adding to return list until empty
        while (!minHeap.isEmpty()) {
            ret.add(minHeap.poll());
        }

        return ret;
    }
}
