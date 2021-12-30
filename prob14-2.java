import java.util.*;

/*
strategy:
    sorted array: iterate from the largest element 

    complexity: O(k), where k is the largest intersecting number
*/

class Problem14_2 {
    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1, 5, 7, 8, 9, 11, null, null, null, null));
        List<Integer> a2 = new ArrayList<Integer>(Arrays.asList(2, 3, 10, 15));
        List<Integer> a0 =  mergeTwoSortedArrays(a1, a2);
        for (Integer i : a0) {
            System.out.println(i);
        }
    }

    public static List<Integer> mergeTwoSortedArrays(List<Integer> a, List<Integer> b) {
        // pointer at last element in a
        int i = a.size() - 1;
        while (a.get(i) == null) {
            i--;
        }

        // pointer at last element in b
        int j = b.size() - 1;

        // pointer at end of list a (where to fill elements)
        int k = a.size() - 1;

        while (k >= 0) {
            if (j < 0 || (a.get(i) >= b.get(j))) {
                a.set(k, a.get(i));
                i--;
            }
            else {
                a.set(k, b.get(j));
                j--;
            }
            k--;
        }

        return a;
    }
}
