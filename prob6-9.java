import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

class Prob6_9 {
    public static void main(String[] args) {
        apply_permutation_cyclic(new ArrayList<Integer>(List.of(3, 4, 1,6,2)), new ArrayList<Integer>(List.of(1, 0, 2, 4, 3)));
       
    }

    /*
        Description:
            Create result array, iterate perm array and copy elements to their correct spot
           
        Complexity: 
            O(N) time, O(N) space
    */
    public static List<Integer> apply_permutation(List<Integer> arr, List<Integer> perm) {
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(arr.size(), 0));

        for (int i = 0; i < arr.size(); ++i) {
            res.set(perm.get(i), arr.get(i));
        }

        return res;
    }

     /*
        Description:
            Observe that the permutation can be broken down into x cyclic permutations
            Reverse the sign bit to mark that a point in a cycle has been traversed. Once a permutation reaches a negative number, we know the cycle is closed
           
        Complexity: 
            O(N) time, O(1) space
    */
    public static void apply_permutation_cyclic(List<Integer> arr, List<Integer> perm){
        for (int i = 0; i < arr.size(); ++i) {
            int next = i;
            while (perm.get(next) >= 0) {
                Collections.swap(arr, i, perm.get(next));
                int temp = perm.get(next);
                perm.set(next, perm.get(next) - perm.size());
                next = temp; 
            }
        }
    }
}