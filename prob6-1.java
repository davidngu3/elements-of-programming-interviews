import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

class Prob6_1 {
    public static void main(String[] args) {
        // dutch_national_flag(new int[]{5, 4, 2, 6, 1, 2}, 2);
        dnf_onepass(new ArrayList<>(List.of(2, 4, 2, 3, 1, 5)), 1);
    }

    /*
        Description:
        
        Complexity: 
            Time: O(N), where N is length of array
            Space: O(1), in place
        
    */
    public static void dutch_national_flag(int[] arr, int x) {
        int pivot = arr[x];
        int L = 0;
        int R = arr.length - 1;

        // sort into 2 sections: [<= pivot] and [> pivot]
        while (L < R) {
            if (arr[L] <= pivot) {
                L++; // arr[L] in correct spot, increment L
            }
            else {
                // swap arr[L] and arr[R]
                int temp = arr[L];
                arr[L] = arr[R];
                arr[R] = temp;

                R--; // arr[R] in correct spot, increment R
            }
        }

        L = 0;
        R = arr.length - 1;
        // sort [<= pivot] into 2 sections: [< pivot]  and [== pivot]
        while (L < R) {
            // get R to last element in left section
            if (R > pivot) {
                R--;
            }
            else {
                if (arr[L] < pivot) {
                    L++; // arr[L] in correct spot, increment L
                }
    
                else if (arr[L] == pivot) {
                    // swap arr[L] and arr[R]
                    int temp = arr[L];
                    arr[L] = arr[R];
                    arr[R] = temp;
    
                    R--; // arr[R] in correct spot, increment R
                }
    
                else {
                    System.err.println("shouldnt happen?");
                }
            }
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j] + ", ");
        }
        return;
    }

    /*
        Description: 4 portions <SMALLER><EQUAL><UNCLASSIFIED><LARGER> e.g. 3 2 3 4 4 ? ? ? 7 8
        
        Complexity: 
            Time: O(N), where N is length of array
            Space: O(1), in place
        
    */
    public static List<Integer> dnf_onepass(List<Integer> arr, int x) {
        int pivot = arr.get(x);

        int smaller = 0;
        int equal = 0;
        int larger = arr.size() - 1;

        while (equal < larger) { // change loop condition?
            if (arr.get(equal) < pivot) {
                Collections.swap(arr, equal, smaller);
                smaller++;
                equal++;
            }
            else if (arr.get(equal) == pivot) {
                equal++;
            }
            else if (arr.get(equal) > pivot) {
                Collections.swap(arr, equal, larger);
                larger--;
            }
        }


        for (int j = 0; j < arr.size(); j++) {
            System.out.println(arr.get(j) + ", ");
        }
        
        return arr;
    }
}