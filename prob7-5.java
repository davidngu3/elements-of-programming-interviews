class Problem7_5 {
    public static void main(String[] args) {
        System.out.println(testPalindromicity("rAce%@ ca!r"));
    }

    /*
        Description:
           2 pointers
        
        Complexity: O(n)
        
    */
    public static boolean testPalindromicity(String s) {
        // convert to lowercase letters only
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char currChar = s.charAt(i);
            if ((currChar >= 'a' && currChar <= 'z' ) || (currChar >= 'A' && currChar <= 'Z')) {
                sb.append(currChar);
            }
        }
        String s2 = sb.toString().toLowerCase();

        // check palindromicity using 2 pointers
        for (int l = 0, r = s2.length() - 1; l < r; l++, r--) {
            if (s2.charAt(l) != s2.charAt(r)) {
                return false;
            }
        }

        return true;
    }
}