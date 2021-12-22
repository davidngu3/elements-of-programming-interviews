import java.util.*;

// strategy
// the kth largest element has exactly k-1 elements greater than it
// choose a random pivot, partition into elements less than it, and elements greater than it
    // if there are more than k-1 elements greater than it, we can discard all elements less than or equal to the pivot
    // if there are less than k-1 elements greater than it, we can discard all elements greater than or equal to the pivot
// repeat until we find element with exactly k-1 elements greater than it (the target)

class Problem12_8 {    
    static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println(kthLargestElement(new ArrayList<Integer>(Arrays.asList(1, 6, 2, 5, 2, 10)), 3));
    }

    public static int kthLargestElement(List<Integer> arr, int k) {
        // repeat until found:W

        // choose random index [0,k)    
        int randIdx = rand.nextInt(k);

        // partition into < and >

        // update selection


       return 0;
    }
}
