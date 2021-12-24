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
        System.out.println(kthLargestElement(new ArrayList<Integer>(Arrays.asList(1, 6, 2, 5, 9, 10)), 1));
    }

    public static int kthLargestElement(List<Integer> arr, int k) {
        int targetElement = arr.size() - k;
        int left = 0;
        int right = arr.size()-1;

        while (left <= right) {
             // partition
            int p = partition(arr, left, right); 

            // update selections
            if (p == targetElement) {
                return arr.get(p);
            }        
            if (p > targetElement) { // discard all elements less than or equal to the pivot
                right = p-1;
            }
            else { // discard all elements greater than or equal to the pivot
                left = p+1;
            }
        }

        return -1;
    }

    public static int partition(List<Integer> arr, int left, int right) {
        // choose random index [0,k)    
        int partitionIndex = left + rand.nextInt(right-left+1); // rand int [left, right]
        int partitionVal = arr.get(partitionIndex);

        // partition into < and >
        int p = left;
        while (p <= right) {
            if (arr.get(p) < partitionVal) {
                Collections.swap(arr, left, p);
                left++;
                p++;
            }
            else if (arr.get(p) > partitionVal) {
                Collections.swap(arr, p, right);
                right--;
            }
            else { // equal
                p++;
            }
        }

        return left;
    }
}
