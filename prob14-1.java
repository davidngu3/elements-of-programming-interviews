import java.util.*;

/*
strategy:
    sorted array: we can gauge where equal elements would be. use 2 iterators

    complexity: O(k), where k is the largest intersecting number
*/

class Problem14_1 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 4, 5, 5, 7, 8));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 4, 7, 8, 10, 16, 23));

        List<Integer> ret = shortestSubarray(list1, list2);
        for (int i : ret) {
            System.out.println(i);
        }
    }   

    public static List<Integer> shortestSubarray(List<Integer> a, List<Integer> b) {
        HashSet<Integer> res = new HashSet<>();

        for (int i = 0, j = 0; i < a.size() && j < b.size(); ) {
            if (a.get(i) == b.get(j)) {
                res.add(a.get(i));
                i++;
                j++;
            }
            else if (a.get(i) < b.get(j)) {
                i++;
            }
            else {
                j++;
            }
        }

        return new ArrayList<Integer>(res);
    }
}
