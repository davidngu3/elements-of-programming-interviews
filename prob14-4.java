import java.util.*;

/*
strategy:
    extract the endpoints of the events
    sort the endpoints, breaking ties by prioritisng 'end' instead of start
    iterate through endpoints, maintain a counter which increments when a start endpoint is encountered, decrementing when end endpoint is encountered
    return max counter value
*/

class Problem14_4 {
    public static void main(String[] args) {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event(1, 5));
        events.add(new Event(6, 10));
        events.add(new Event(11, 13));
        events.add(new Event(14, 15));
        events.add(new Event(2, 7));
        events.add(new Event(8, 9));
        events.add(new Event(12, 15));
        events.add(new Event(4, 5));
        // events.add(new Event(9, 17));
        System.out.println(maxHeightEvent(events));
    }

    public static int maxHeightEvent(List<Event> events) { // max number of concurrent events = ??
        ArrayList<Endpoint> endpoints = new ArrayList<>();
        // add all events to a list of endpoint
        for (Event e : events) {
            endpoints.add(new Endpoint(e.start, true));
            endpoints.add(new Endpoint(e.end, false));
        }

        Collections.sort(endpoints); // sort by endpoint time, ties broken by end time first so that two concurrent events are not counted as overlapping

        int maxCounter = -1;
        int counter = 0; // raise by 1 when start endpoint encountered, decrease by 1 when end endpoint encountered

        for (Endpoint e : endpoints) {
            if (e.isStart == true) {
                counter++;
            }
            else {
                counter--;
            }

            maxCounter = Math.max(maxCounter, counter);
        }

        return maxCounter;
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

class Endpoint implements Comparable<Endpoint> {
    int time;
    boolean isStart;

    public Endpoint(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }

    @Override
    public int compareTo(Endpoint e) {
        if (time != e.time) {
            return Integer.compare(time, e.time);
        }
        if (isStart == e.isStart) {
            return -1;
        }
        else {
            return isStart == true ? 1 : -1; 
        }
    }
}
