import java.util.*;

class Problem13_2 {
    public static void main(String[] args) {
        System.out.println(canBeConstructed("hello", "hellos"));
    }

    // letter can be constructed by magazine if characters in letter is a subset of magazine
    // store magazine characters in hashmap, then iterate letter and decrement
    public static boolean canBeConstructed(String letter, String magazine) {
        HashMap<Character, Integer> availableLetters = new HashMap<Character, Integer>();

        for (char c : magazine.toCharArray()) {
            if (availableLetters.containsKey(c)) {
                availableLetters.put(c, availableLetters.get(c)+1);
            }
            else {
                availableLetters.put(c, 1);
            }
        }

        for (char c : letter.toCharArray()) {
            if (!availableLetters.containsKey(c) || availableLetters.get(c) <= 0) {
                return false;
            }
            else {
                availableLetters.put(c, availableLetters.get(c)-1);
            }
        }


        return true;


    }
}
