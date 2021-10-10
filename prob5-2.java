class Problem5_2 {
    public static void main(String[] args) {
        long ex1 = 0b101110;
        System.out.println(Long.toBinaryString(swapBits(ex1, 4, 5)));
    }

    /*
        Description:
      
        Complexity: 
        
    */
    public static long swapBits(long x, int i, int j) {
        int ival = (int) ((x >>> i) & 1);
        int jval = (int) ((x >>> j) & 1);

        int b = ival ^ jval;
        if (b == 0) {
            return x; // no swap necessary;
        }
        
        // swap i and j using mask
        long mask = (long) Math.pow(2, i) | (long) Math.pow(2, j);
        return x ^ mask;
    }
}