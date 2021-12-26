class Problem12_5 {
    public static void main(String[] args) {
        System.out.println(squareRootReal(27));
    }

    public static float squareRootReal(float num) {
        // determine bounds (if < 1, bounds [0, 1] else [1, num])
        float low;
        float high;
        if (num < 1) {
            low = 0;
            high = 1;
        }
        else {
            low = 1;
            high = num;
        }

        // binary search
        while (low < high) {
            float m = low + (high-low)/2;

            if (closeEnough(m*m, num)) {
                return m;
            }
            if (m*m < num) {
                low = m;
            }
            else if (m*m > num) {
                high = m;
            }

        }
        return -1;
    }

    public static boolean closeEnough(float a, float b) {
        if (Math.abs(a-b) < 0.01) {
            return true;
        }
        return false;
    }
}
