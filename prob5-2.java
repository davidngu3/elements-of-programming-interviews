class Problem5_2 {
    public static void main(String[] args) {
        long ex1 = 0b101110;
        // System.out.println(Long.toBinaryString(swapBits(ex1, 1, 4)));
        System.out.println(Long.toBinaryString(swapBits(ex1, 4, 5)));
    }

    /*
        Description:

        Complexity: 
        
    */
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