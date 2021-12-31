import java.util.*;

import javax.xml.stream.events.StartElement;

/*
strategy:
   
*/

class Problem14_6 {
    public static void main(String[] args) {
        Interval i1 = new Interval(0, false, 3, false);
        Interval i2 = new Interval(1, true, 1, true);
        Interval i3 = new Interval(2, true, 4, true);
        Interval i4 = new Interval(3, true, 4, false);
        Interval i5 = new Interval(5, true, 7, false);
        Interval i6 = new Interval(7, true, 8, false);
        Interval i7 = new Interval(8, true, 11, false);
        Interval i8 = new Interval(9, false, 11, true);
        Interval i9 = new Interval(12, true, 14, true);
        Interval i10 = new Interval(12, false, 13, true);
        Interval i11 = new Interval(13, false, 15, false);
        Interval i12 = new Interval(16, false, 17, false);
        List<Interval> ans = computeUnionOfIntervals(new ArrayList<Interval>(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12)));

        for (Interval i : ans) {
            System.out.println(String.format("%d %b %d %b", i.start, i.startClosed, i.end, i.endClosed));
        }

    }

    public static List<Interval> computeUnionOfIntervals(List<Interval> intervals) {
        // sort intervals by start time, break ties by prioritizing closed intervals. if both closed/open, doesnt matter
        // continuously build intervals, analyzing how to augment the interval using the fed in intervals
        // e.g. if next intervals starts after current interval ends, build new interval
        // e.g. if nmext interval extends current interval, update projected endpoint

        List<Interval> ret = new ArrayList<Interval>();
        Collections.sort(intervals);

        Interval curr = intervals.get(0);

        for (Interval i : intervals.subList(1, intervals.size())) {
            // augment interval condition: new interval ends later and either: new interval starts before current interval ends 
            //                                                     OR new interval starts exactly where current interval ends AND one is closed
            if (i.end > curr.end && ((i.start < curr.end) || (i.start == curr.end && (i.startClosed || curr.endClosed)))) { 
                curr.end = i.end;
                curr.endClosed = i.endClosed;
            }
            // augment end condition: new interval ends where current ends, and new interval is closed
            else if ((i.end == curr.end) && (!curr.endClosed && i.endClosed)) {
                curr.endClosed = true;
            }
            // new interval condition: new interval starts later than current interval end,
            //                                                    OR new interval starts exactly where current interval ends AND both are closed (negation of augment condition) 
            else if ((i.start > curr.end) || ((i.start == curr.end) && (i.startClosed && curr.endClosed))) {
                ret.add(curr);
                curr = i;
            }
        }

        ret.add(curr);

        return ret;
    }
}

class Interval implements Comparable<Interval> {
    int start;
    boolean startClosed;
    int end;
    boolean endClosed;

    public Interval(int start, boolean startClosed, int end, boolean endClosed) {
        this.start = start;
        this.startClosed = startClosed;
        this.end = end;
        this.endClosed = endClosed;
    }

    @Override
    public int compareTo(Interval o) {
        if (start != o.start) {
            return Integer.compare(start, o.start);
        }
        if (startClosed && o.startClosed) { // both closed
            return 0;
        }
        else {  // one open one closed
            if (startClosed) { return -1; }
            if (o.startClosed) { return 1; }
        } 
        return 0; // both open
    }
}