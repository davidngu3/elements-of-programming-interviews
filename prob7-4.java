class Problem7_4 {
    public static void main(String[] args) {
        
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
    public static void replaceAndRemove(char[] s) {
        // first pass to remove b's
        // 2 pointers, one write one read index
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == 'b') {
                s[i] = ' ';
            }
        }        

        return;
    }
}