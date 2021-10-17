import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

class Prob6_3 {
    public static void main(String[] args) {
        multiply_integer_by_digit(new ArrayList<Integer>(List.of(-3, 2, 9, 4)), 2);
    }

    /*
        Description:
          
        Complexity: 
         
        
    */
    public static List<Integer> multiply_integers(int a, int b) {




        return new ArrayList<Integer>();
    }

    public static List<Integer> add_integers(List<Integer> a, List<Integer> b) {
        return new ArrayList<Integer>();
    }

    public static List<Integer> multiply_integer_by_digit(List<Integer> a, int b) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        int carry = 0;
        int i = a.size() - 1;

        while (i >= 0) {
            int quot = (a.get(i) * b + carry) % 10;
            carry = (a.get(i) * b + carry) / 10; 

            res.add(0, quot);
            i--;
        }

        // add remaining carry to front of result
        if (carry > 0) {
            res.add(0, carry);
        }

        return res;
    }

}