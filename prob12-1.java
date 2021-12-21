import java.util.*;

// naive strategy:
// binary search until key is found
// scan left until first occurrence found

// better stragey:
// binary serach until key is found, store as candidate
// continue binary search to the left until better candidate found; 

class Problem12_1 {    
    public static void main(String[] args) {
        System.out.println(searchFirstOccurrence(Arrays.asList(1, 2, 5, 5, 5, 9, 10), 5));
    }

    public static int searchFirstOccurrence(List<Integer> arr, int key) {
        // binary search
        return binarySearch(arr, key);
    }

    public static int binarySearch(List<Integer> arr, int k) {
        int L = 0;
        int R = arr.size() - 1;
        int candidate = arr.size();

        while (L <= R) {
            int M = L + ((R - L) / 2);

            if (arr.get(M) < k) {
                L = M + 1;
            }
            else if (arr.get(M) == k) {
                candidate = Math.min(M, candidate); // update candidate
                R = M - 1;
            }
            else {
                R = M - 1;
            }
        }

        return candidate == arr.size() ? -1 : candidate;
    }
}
