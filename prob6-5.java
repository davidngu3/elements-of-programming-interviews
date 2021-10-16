import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

class Prob6_5 {
    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ArrayList<Integer>(List.of(1, 1, 2, 3, 4, 4, 4, 7))));
    }

    /*
        Description:
            2 pointers, one pointer traverses the list, one points at index to place next distinct integer.

        Complexity: 
            O(N) time, O(1) space
           
        
    */
    public static int deleteDuplicates(List<Integer> sortedArr) {
        int i = 1; // stores pos of next distinct int
        int j = 1; // iterates array, checking adjacent elements for duplicates

        while (j < sortedArr.size()) {
            if (sortedArr.get(j) != sortedArr.get(j-1)) {
                sortedArr.set(i, sortedArr.get(j));
                i++;
            }
            j++;
        }

        return --i;
    }
}