import java.util.*;

class Problem13_1 {

    // strategy:
    // a valid palindrome must have either: even counts of all letters OR even counts of all letters and one odd-count letter (in the case of odd length palindrome)
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("carraqce"));
    }

    public static boolean isPalindromePermutation(String s) {  
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }

        boolean oddCharSeen = false;
        // process map
        for (int i : map.values()) {
        
            if (i % 2 != 0) {
                if (oddCharSeen) { return false; }
                oddCharSeen = true;
            }
        }

        return true;
    }

    
}
