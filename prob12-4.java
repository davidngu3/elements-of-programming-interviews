import java.util.*;

// strategy

class Problem12_4 {    
    public static void main(String[] args) {
        System.out.println(integerSquareRoot(1));
    }

    public static int integerSquareRoot(int k) {
        // initialize array from 0..k 
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i <= k; i++) {
            arr.add(i);
        }

        // binary search algorithm 
        int L = 0;
        int R = arr.size() - 1;

        while (L <= R) {
            int M = L + ((R - L) / 2);

            if (Math.pow(arr.get(M), 2) < k) {
                L = M + 1;
            }
            else if (Math.pow(arr.get(M), 2) == k) {
                return M;
            }
            else {
                R = M - 1;
            }
        }

        // result is at R or L-1
        return R;
    }
}
