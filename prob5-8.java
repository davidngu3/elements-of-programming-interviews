class Problem5_8 {
    public static void main(String[] args) {
        System.out.println(Integer.toString(reverseInt(-5324)));
    }

    /*
        Description:
            Repeatedly remove the last digit from x and append to result using combination of module, division, multiplication and addition

        Complexity:
            O(N), where N is the length of x
        
    */
    public static int reverseInt(int x) {
        int r = 0;

        while (x != 0) {
            r *= 10;        // make room for new digit
            r += x % 10;    // take last digit from x and append to r
            x /= 10;        // remove last digit from x
        }

        return r;
    }
}