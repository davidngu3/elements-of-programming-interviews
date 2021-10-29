import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problem7_1 {
    public static void main(String[] args) {
        System.out.println(int_to_string(123));
        System.out.println(string_to_int("123"));
        System.out.println(int_to_string(-123));
        System.out.println(string_to_int("-123"));
    }

    /*
        Description:
            Convert a string to int
        
        Complexity:
        
    */
    public static int string_to_int(String x) {
        int res = 0;
        boolean isNegative = false;

        if (x.charAt(0) == '-') {
            isNegative = true;
        }

        for (int i = isNegative ? 1 : 0; i < x.length(); i++) {
            final int dig = x.charAt(i) - '0';
            res *= 10;
            res += dig;
        }

        return isNegative ? -res : res; 
    }

    /*
        Description:
            Convert an int to string
        
        Complexity:
        
    */
    public static String int_to_string(int x) {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false; 
        int y = x;

        if (x < 0) {
            isNegative = true;
            y = -x;
        }

        while (y != 0) {
            sb.append((char) y % 10);
            y = y / 10;
        }

        if (isNegative) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }
}