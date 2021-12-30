import java.util.*;

class Problem13_6 {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<String>(Arrays.asList("word", "repeated", "how", "is", "your", "repeated"));
        System.out.println(nearestRepeatedWord(arr));
    }

    public static String nearestRepeatedWord(List<String> arr) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(); // store <word, last seen index>
        Candidate candidate = new Candidate("NONE", Integer.MAX_VALUE);        

        for (int i = 0; i < arr.size(); i++) {
            if (!map.containsKey(arr.get(i))) {
                map.put(arr.get(i), i);
            }   
            else {
                int gap = i - map.get(arr.get(i));
                if (gap < candidate.gap) {
                    candidate = new Candidate(arr.get(i), gap);
                }
            }   
        }

        return candidate.word;
    }

    
}

class Candidate {
    int gap;
    String word;

    public Candidate(String word, int gap) {
        this.word = word;
        this.gap = gap;
    }
}