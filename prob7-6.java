class Problem7_6 {
    public static void main(String[] args) {
        System.out.println(reverseString("Alice had a green house."));
    }

    /*
        Description:
        
        Complexity:
        
    */
    public static String reverseString(String s) {
        String res = "";

        // convert to letters and spaces only
        StringBuilder sb = new StringBuilder();

        for (int i = s.length()-1; i >= 0; i--) {
            char currChar = s.charAt(i);

            if (currChar == ' ') {
                res += sb.reverse().toString() + " ";
                sb.setLength(0);
            }

            if ((currChar >= 'a' && currChar <= 'z' ) || (currChar >= 'A' && currChar <= 'Z')) {
                sb.append(currChar);
            }

        }
        res += sb.reverse().toString();
    
        return res;
    }
}