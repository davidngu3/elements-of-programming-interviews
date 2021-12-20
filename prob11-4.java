import java.util.*;

class Problem11_4 {
    public static void main(String[] args) {
        ArrayList<Coordinate> arr = new ArrayList<Coordinate>();
        arr.add(new Coordinate(0, 0, 0));
        arr.add(new Coordinate(25, 19, -14));
        arr.add(new Coordinate(1, 2, 5));
        arr.add(new Coordinate(0, 2, 9));
        arr.add(new Coordinate(2, 1, -14));
        arr.add(new Coordinate(6, 12, -14));
        
        ArrayList<Coordinate> res = kClosestStars(arr, 2);

        for (Coordinate r : res) {
            System.out.println(r.x + ", " + r.y + ", " + r.z);
        }
    }

    public static ArrayList<Coordinate> kClosestStars(ArrayList<Coordinate> arr, int k) {
        // define max heap with custom comparator (prioritize smaller)
        PriorityQueue<Coordinate> maxHeap = new PriorityQueue<Coordinate>(new Comparator<Coordinate>() {
            public int compare(Coordinate a, Coordinate b) {
                return Double.compare(b.distanceFromOrigin(), a.distanceFromOrigin());
            }
        });

        // add elements from the stream, 'kicking' the max element out if there is no space
        for (Coordinate c : arr) {
            maxHeap.add(c);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // return the values from the heap
        ArrayList<Coordinate> res = new ArrayList<Coordinate>();
        while (!maxHeap.isEmpty()) {
            res.add(maxHeap.poll());
        }

        return res;
    }

}

class Coordinate {
    int x;
    int y;
    int z;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceFromOrigin() {
        return Math.sqrt(x*x + y*y + z*z);
    }
}
