class Problem5_4 {
    public static void main(String[] args) {
        closestSameWeightIntTest();
    }

    public static void closestSameWeightIntTest() {
        long ex1 = 0b110;
        long ex2 = 0b11000;
        long ex3 = 0b1011;
        
        System.out.println("Actual: " + Long.toBinaryString(closestSameWeightInt(ex1)) + ", Expected: 101");
        System.out.println("Actual: " + Long.toBinaryString(closestSameWeightInt(ex2)) + ", Expected: 10100");
        System.out.println("Actual: " + Long.toBinaryString(closestSameWeightInt(ex3)) + ", Expected: 1101");
    }

    /*
        Description:
            An integer with the same weight can be constructed by swapping bits 
            The most optimal swap occurs between the least significant 0 and 1
            So use a mask to find these

        Complexity:
            O(N), where N is the size of the word
        
    */
    public static long closestSameWeightInt(long x) {
        int i = 0;
        int j = 1; 

        while (j <= 63) {
            short i_val = (short) ((x >>> i) & 1);
            short j_val = (short) ((x >>> j) & 1);

            if (i_val != j_val) {
                return swapBits(x, i, j);
            }

            i++;
            j++;
        }

        return x;
    }

    // swap bits algo from problem 5-2
    public static long swapBits(long x, int i, int j) {
        int ival = (int) ((x >>> i) & 1);
        int jval = (int) ((x >>> j) & 1);

        if (ival == jval) {
            return x; // no swap necessary;
        }
        
        // toggle values of i and j using a mask
        long mask = (1L << i) | (1L << j);
        x ^= mask;
        
        return x;
    }
}
