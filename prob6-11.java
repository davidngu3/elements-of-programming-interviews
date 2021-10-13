import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Prob6_11 {
    public static void main(String[] args) {
        generateSubset(new ArrayList<>(List.of(5, 2, 1, 6, 2)), 1);
    }

    /*
        Description:
            Remove a random element arr.length - size times, until we are left with a random subset of length size

            NOTE: A similar strategy, used by textbook soln is to send a chosen random element to the front of array

        Complexity: 
            O(N-k), n is size of arr and k is size
           
        
    */
    public static List<Integer> generateSubset(List<Integer> arr, int size) {
        int n = arr.size();

        for (int i = 0; i < n - size; ++i) {
            int randIndex = new Random().nextInt(n-i);
            arr.remove(randIndex);
        }

        return arr;
    }
}