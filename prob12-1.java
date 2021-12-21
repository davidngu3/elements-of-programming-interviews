import java.util.*;

// naive strategy:
// binary search until key is found
// scan left until first occurrence found

class Problem12_1 {    
    public static void main(String[] args) {
        System.out.println(searchFirstOccurrence(Arrays.asList(1, 2, 5, 5, 5, 9, 10), 5));
    }

    public static int searchFirstOccurrence(List<Integer> arr, int key) {
        // binary search
        int pos = binarySearch(arr, key);

        // doesnt exist in array
        if (pos == -1) {
            return -1;
        }

        while (pos > 0 && arr.get(pos-1) == arr.get(pos)) {
            pos--;
        }

        return pos;
    }

    public static int binarySearch(List<Integer> arr, int k) {
        int L = 0;
        int R = arr.size() - 1;

        while (L <= R) {
            int M = L + (R - L) / 2;

            if (arr.get(M) < k) {
                L = M + 1;
            }
            else if (arr.get(M) == k) {
                return M;
            }
            else {
                R = M - 1;
            }
        }

        return -1;
    }
}
