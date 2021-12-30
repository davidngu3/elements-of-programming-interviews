import java.util.*;

/*
strategy:
   
*/

class Problem14_6 {
    public static void main(String[] args) {

    }

    public static List<Interval> computeUnionOfIntervals(List<Interval> intervals) {
        // sort intervals by start time, break ties by prioritizing closed intervals
        // continuously build intervals, analyzing how to augment the interval using the fed in intervals
        // e.g. if next intervals starts after current interval ends, build new interval
        // e.g. if nmext interval extends current interval, update projected endpoint

        List<Interval> ret = new ArrayList<Interval>();


        return ret;
    }
}

class Interval {
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
}