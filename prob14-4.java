import java.util.*;

/*
strategy:
    Use a hashmap to store all calendar hours with the number of events running during that hour
    Iterate through the map to extract the highest frequency
*/

class Problem14_4 {
    public static void main(String[] args) {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event(1, 5));
        events.add(new Event(2, 7));
        events.add(new Event(4, 5));
        events.add(new Event(4, 5));
        events.add(new Event(6, 10));
        events.add(new Event(8, 9));
        events.add(new Event(9, 17));
        System.out.println(maxHeightEvent(events));
    }

    public static int maxHeightEvent(List<Event> events) { // max number of concurrent events = ??
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (Event e : events) {
            for (int i = e.start; i < e.end; i++ ) {
                if (!map.containsKey(i)) {
                    map.put(i, 1);
                }
                else {
                    map.put(i, map.get(i)+1);
                }
            }
        }

        int maxHeight = -1;
        for (int j : map.keySet()) {
            maxHeight = Math.max(maxHeight, map.get(j));
        }

        return maxHeight;
    }
}

class Event {
    int start;
    int end;

    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
