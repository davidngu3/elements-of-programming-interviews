import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

class Prob6_2 {
    public static void main(String[] args) {
        increment(new ArrayList<Integer>(List.of(1, 9, 9)));
    }

    /*
        Description:

        Complexity: 
           
        
    */
    public static List<Integer> increment(List<Integer> arr) {
        int i = arr.size() - 1;
        int q;
        int c = 1;

        while (c == 1) {
            if (i == -1) { // edge case: add a new digit, stop loop
                arr.add(0, 1);
                c = 0;
            }

            else {
                q = (arr.get(i) + 1) % 10;
                c = (arr.get(i) + 1) / 10;
                arr.set(i, q);
                --i;
            }
        }

        for (int j = 0; j < arr.size(); j++) {
            System.out.println(arr.get(j) + ", ");
        }

        return arr;
    }
}