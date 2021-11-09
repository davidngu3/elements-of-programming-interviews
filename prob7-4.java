class Problem7_4 {
    public static void main(String[] args) {
        replaceAndRemove(new char[]{'a', 'b', 'd', 'a', 'b', 'b', 'c', 'a', 'c'});
    }

    /*
        Description:
            First, replace b and count how many a's there are.
            From this, we can calculate the expected size of the output string

            Then, read backwards through the original array,
                while copying to index e-1, where e is the expected size of the output string (so that the original array is not overwritten),
                    writing 2 d's when there is an a
        
        Complexity: O(n)
        
    */
    public static char[] replaceAndRemove(char[] s) {
        // first pass to remove b's and calculate eventual output size
        // 2 pointers, one write one read index
        int oSize = 0;
        int r, w;
        for (r = 0, w = 0; r < s.length; ++r) {
            if (s[r] != 'b') {
                if (s[r] == 'a') {
                    oSize++;
                }
                s[w] = s[r];
                w++;
                oSize++;
            }
        }        

        // second pass to replace 'a' with 2x 'd'
        for (int i = w-1; i >= 0; i--) {
            if (s[i] == 'a') {
                s[oSize-1] = 'd';
                s[oSize-2] = 'd';
                oSize-=2;
            }
            else {
                s[oSize-1] = s[i];
                oSize--;
            }
        }

        return s;
    }
}