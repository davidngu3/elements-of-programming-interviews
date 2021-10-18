import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Prob6_14 {
    public static void main(String[] args) {
        computeSubset(5, 2);
    }


    /*
        Return a size-k subset of {0, 1, 2, ... , n-1}
    */
    public static List<Integer> computeSubset(int n, int k) {
        // create array of 0, 1, 2, ..., n-1
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            arr.add(i);
        }

        // generate subset using generateSubset function
        return generateSubset(arr, k);
    }

    /*
        
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