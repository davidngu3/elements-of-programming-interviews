class Problem5_1 {
    public static void main(String[] args) {
        long example1 = 0b11011;
        // System.out.println(parityBruteForce(example1));
        // System.out.println(parityBruteForceOptimized(example1));
        System.out.println(example1);
        // paritySimultaneous(example1);
    }

    /*
        Description:
        Repeatedly check bit in least significant digit, then right shift
        At the check, perform XOR operation with result to toggle parity appropriately
        
        Complexity:
        Time complexity: O(N), where N is the number of bits in x
    */
    public static short parityBruteForce(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    /*
        Description:
        Instead of inspecting bits until we find a set bit (1) in the least significant digit, 
        we can exploit the fact that we can 'target' and erase the rightmost set bit using x & (x-1)

        Observe that (x-1) is the same as x, except that the rightmost set bit is turned to 0 and everything (the zeros) after are turned to 1
        Then, taking x & (x-1), by the property of &, will set to 0 any digit which is a 1 in x and a 0 in (x-1) which is precisely the rightmost set bit.

        Complexity:
        Time complexity: O(N), where N is the number of set bits in x
    */
    public static short parityBruteForceOptimized(long x) {
        short result = 0;
        while (x != 0) {
            x = x & (x - 1);
            result ^= 1;
        }
        return result;
    }

    /*
        Description:
        Store the parity of *chunks* (not the whole thing, or we would need 2^64 cells) of the 64-bit integer
        Then combine parity of these chunks to get the parity of the whole input.

        Chunks can be generated by rightshifting, until the chunk in question is in the rightmost position, 
        then use a mask to isolate the chunk from its prefix

        Complexity:


    */
    public static void parityCaching(long x) {
        

    }

    /*

    */
    public static void paritySimultaneous(long x) {

    }
}