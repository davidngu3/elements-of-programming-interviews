import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

class Prob6_8 {
    public static void main(String[] args) {
        enumerate_primes(20);
    }

    /*
        Description:
            Sieve of eratosthenes:
                Observe that all integers are some multiple of primes
                So maintain a cache of all integers 0 to n, marking all valid multiples in range and use it to quickly rule out non-primes

        Complexity: 
            Time: O(n log log n)
            Space: O(n)
           
        
    */
    public static List<Integer> enumerate_primes(int n) {
        List<Integer> cache = new ArrayList<Integer>(Collections.nCopies(n+1, 1)); // array of n+1 ones. zero indicates not prime
        cache.set(0, 0);
        cache.set(1, 0);

        List<Integer> primes = new ArrayList<Integer>(); 

        for (int i = 2; i <= n; i++) {

            if (cache.get(i) == 1) {
                // prime candidate added to result
                primes.add(i);
                
                // sift out multiples
                for (int j = i+i; j <= n; j += i) {
                    cache.set(j, 0);
                }
            }
        }

        for (int x : primes) {
            System.out.println(x);
        }

        return primes;
    }

}