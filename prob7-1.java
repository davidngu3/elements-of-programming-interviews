import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problem7_1 {
    public static void main(String[] args) {
        System.out.println(int_to_string(123));
    }

    /*
        Description:
            Convert a string to int
        
        Complexity:
        
    */
    public static int string_to_int(String x) {
        return 0; 
    }

    /*
        Description:
            Convert an int to string
        
        Complexity:
        
    */
    public static String int_to_string(int x) {
        StringBuilder sb = new StringBuilder();
        
        boolean isNegative = (x < 0) ? true : false;

        while (x > 0) {
            int dig = x % 10;
            x = x / 10;
            sb.insert(0, dig);
        }

        if (isNegative) {
            sb.insert(0, '-');
        }

        return sb.toString();
    }

}