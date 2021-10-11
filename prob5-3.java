class Prob5_3 {
    public static void main(String[] args) {
        long ex1 = 0b110100;
        System.out.println(Long.toBinaryString(reverseBitsSwapping(ex1)));
    }

    /*
        Description:
            NOTE: THIS ALGORITHM DOES NOT TAKE INTO ACCOUNT LEADING ZEROS    
            Create an empty new number r initialized to 0
            
            While x has a digit:
                Extract the rightmost digit in x
                Append to r by leftshift then OR 
                Rightshift x

        Complexity: 
            O(N), where N is the length of x
        
    */
    public static long reverseBits(long x) {
        long r = 0b0;

        while (x != 0) {
            short nextBit = (short) (x & 1);
            r <<= 1;
            r = r | nextBit;
            x >>>= 1;
        }

        return r;
    }

    /*
        Description:
            Repeatedly swap the most and least significant digit

        Complexity: 
            O(N), where N is the length of x
        
    */
    public static long reverseBitsSwapping(long x) {
        final int WORD_LENGTH = 64;
        int low = 0;

        while (low <= (WORD_LENGTH / 2)) {
            x = swapBits(x, low, WORD_LENGTH - low - 1);
            low++;
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

     /*
        Description:
            Optimized using caching

        Complexity: 
            O(n/L), where n is the length of the integers and L is the number of bits of the cache keys
        
    */
    public static long reverseBitsUsingCaching(long x) {
        // assume this lookup table is constructed in a higher level method
        short[] lookup = new short[(int) Math.pow(2, 16)];

        // split x into 4 parts of 16 bits
        long mask = 0xFFFF; // equiv to 16 1's
        long part1 = x >>> 48;
        long part2 = (x >>> 32) & mask;
        long part3 = (x >>> 16) & mask;
        long part4 = x & mask;
        
        // construct the reversed number
        long r =  lookup[(int) part4];
        r <<= 16;
        r = r | lookup[(int) part3];
        r <<= 16;
        r = r | lookup[(int) part2];
        r <<= 16;
        r = r | lookup[(int) part1];

        return r;
    }
}
