import java.util.*;

/*
strategy:
    when find a search term, put it in a map along an array of all index of occurrences
    once whole text is scanned, iterate hashmap and find lowest index and highest index
*/

class Problem13_7 {
    public static void main(String[] args) {
        ArrayList<String> text = new ArrayList<String>(Arrays.asList("There once was a huge little pony with two big two tails".split(" ")));
        ArrayList<String> terms = new ArrayList<String>(Arrays.asList("huge", "two")); // should return <"huge", "litte", "pony", "with", "two">
    }   

    public List<String> shortestSubarray(List<String> text, List<String> searchTerms) {
        return new ArrayList<String>(Arrays.asList("There once was a huge little pony with two big tails".split(" ")));
    }
}
