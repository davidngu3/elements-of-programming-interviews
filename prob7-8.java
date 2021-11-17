import java.util.ArrayList;

class Problem7_8 {
    public static void main(String[] args) {
        System.out.println(lookSay(1));
    }

    /*
        Description: Keep track of how many N has occurred, then add to result string when next char is different
        
        Complexity: O(n2^n), since number of digits can at most double each iteration, and outer loop runs n-1 times (O(N))
        
    */
    public static String lookSay(int n) {
        String res = "1"; // string to be built

        for (int i = 0; i < n-1; ++i) { // outer loop: run n-1 times

            StringBuilder sb = new StringBuilder();

            // initialise occurence count and char pointer
            int occurrences = 0;
            char c;

            for (int j = 0; j < res.length(); j++) { // iterate res string
                c = res.charAt(j); // get jth char
                occurrences++; // increment occurrences

                if ((j == res.length() - 1) || (c != res.charAt(j+1))) { // if next char is different or c is last char
                    sb.append((char) (occurrences + '0')); // append number of occurrences
                    sb.append(c); // append the char

                    // reset occurrences
                    occurrences = 0;
                } 
            }

            res = sb.toString();
        }

        return res;
    }

}
