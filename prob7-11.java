import java.util.ArrayList;

class Problem7_11 {
    public static void main(String[] args) {
        System.out.println(stringToSnakestring("Hello World!"));
    }

    /*
        Description: Create 3 strinbuilders. 
            Loop through input string s
            Use maths to determine whether char at index i is in top, middle or bottom partition
            Concatenate the 3 strings 

        Complexity: O(N), N is length of string
            
        
    */
    public static String stringToSnakestring(String s) {
        StringBuilder sbTop = new StringBuilder();
        StringBuilder sbMid = new StringBuilder();
        StringBuilder sbBot = new StringBuilder();


        for (int i = 0; i < s.length(); ++i) {
            if (i % 2 == 0) { // even: middle partition
                sbMid.append(s.charAt(i));
            }
            if ((i - 1) % 4 == 0) { // top partition
                sbTop.append(s.charAt(i));
            }
            else if ((i - 3) % 4 == 0) { // bottom partition
                sbBot.append(s.charAt(i));
            }
        }

        return sbTop.toString() + sbMid.toString() + sbBot.toString();
    }
}
