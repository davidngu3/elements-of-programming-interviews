import java.util.*;

// strategy

class Problem12_4 {    
    public static void main(String[] args) {
        System.out.println(integerSquareRoot(166));
    }

    public static int integerSquareRoot(int k) {
        // binary search algorithm 
        long L = 0;
        long R = k;

        while (L <= R) {
            long M = L + ((R - L) / 2);
            long M2 = M*M;

            if (M2 < k) {
                L = M + 1;
            }
            else if (M2 == k) {
                return (int) M;
            }
            else {
                R = M - 1;
            }
        }

        // result is at R or L-1, since everything less than L has a square less than or equal to k
        return (int) L-1;
    }
}
