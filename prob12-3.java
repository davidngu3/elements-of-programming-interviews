import java.util.*;

// strategy
// binary search, using condition that the chosen element must be smaller than the element to its left.

class Problem12_3 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(16, 1, 2, 3));
        System.out.println(searchCyclicSortedArray(arr));
    }

    public static int searchCyclicSortedArray(List<Integer> arr) {
        int L = 0;
        int R = arr.size() - 1;

        while (L <= R) {
            int M = L + (R - L) / 2;
            
            if (arr.get(M) < arr.get(M-1)) { // target
                return arr.get(M);
            }
            else if (arr.get(M) < arr.get(L)) { // take left
                R = M - 1;
            }
            else if (arr.get(R) < arr.get(M)) { // take right
                L = M + 1;
            }
            else { // array must be sorted, so take element 0
                return arr.get(L);
            }
        }

        return -1;
    }
}
