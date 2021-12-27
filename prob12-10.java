import java.util.*;


/*
    Array contains 0 to n-1
    But one of the integers 0:n-1 is missing, and one is duplicated

    Strategy 1: Use a hashmap to keep track of what has been seen O(N) space O(N) time
    Strategy 2: Sort, find duplicate element, use sum to find missing element
*/
class Problem12_10 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(3, 0, 5, 2, 4, 5)); // duplicated 5, missing 1
        List<Integer> res = findMissingAndDuplicateInPlace(arr);

        for (int i : res) {
            System.out.println(i);
        }

    }

    public static List<Integer> findMissingAndDuplicateWithHash(List<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int duplicated = -1;
        int missing = -1;

        for (Integer i : arr) {
            if (map.containsKey(i)) {
                duplicated = i;
            }
            else {
                map.put(i, 1);
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            if (!map.containsKey(i)) {
                missing = i;
            }
        }

        return new ArrayList<Integer>(Arrays.asList(duplicated, missing));
    }

    public static List<Integer> findMissingAndDuplicateInPlace(List<Integer> arr) {
        int n = arr.size();
        int calcSum = (n*(n-1))/2;

        Collections.sort(arr);

        int duplicated = -1;
        int sum = 0;

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).equals(arr.get(i-1))) {
                duplicated = i;
            }
            sum += arr.get(i);
        }

        int diff = sum - calcSum;
        
        int missing = duplicated - diff;

        if (duplicated == -1) {
            return new ArrayList<Integer>(Arrays.asList(-1, -1));
        }
        return new ArrayList<Integer>(Arrays.asList(duplicated, missing));
    }
}
