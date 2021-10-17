import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

class Prob6_3 {
    public static void main(String[] args) {
        ArrayList<Integer> result = multiply_integers(new ArrayList<Integer>(List.of(-2, 2)), new ArrayList<Integer>(List.of(5, 6, 3)));

        for (int e : result) {
            System.out.println(e);
        }
    }

    /*
        Description:
            Perform multiplication just like you would on paper
            
            Negative scenarios handled by:
                determining final sign at the start, 
                stripping negatives from operands then replcaing the sign before returning result if necessary
          
        Complexity: 
         
        
    */
    public static ArrayList<Integer> multiply_integers(ArrayList<Integer> a, ArrayList<Integer> b) {
        // determine if result is negative and remove negatives for processing
        boolean negative = a.get(0) < 0 ^ b.get(0) < 0;
        a.set(0, Math.abs(a.get(0)));
        b.set(0, Math.abs(b.get(0)));
        

        ArrayList<Integer> res = new ArrayList<Integer>(List.of(0));
        int b_p = b.size() - 1;
        ArrayList<Integer> quot;

        while (b_p >= 0) {
            int bVal = b.get(b_p);
        
            quot = multiply_integer_by_digit(a, bVal);
            for (int j = 0; j < b.size()- b_p - 1; j++) {
                quot.add(0);
            }

            ArrayList<Integer> sum = add_integers(res, quot);
            res = sum;

            b_p--;
        }

        // add negative sign appropriately
        if (negative) {
            res.set(0, -1 * res.get(0));
        }

        return res;
    }

    public static ArrayList<Integer> add_integers(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int a_p = a.size() - 1;
        int b_p = b.size() - 1;
        int sum, carry = 0;

        while (a_p >= 0 || b_p >= 0) {
            int aVal = (a_p < 0) ? 0 : a.get(a_p);
            int bVal = (b_p < 0) ? 0 : b.get(b_p);
        
            sum = (aVal + bVal + carry) % 10;
            carry = (aVal + bVal + carry) / 10;
            
            res.add(0, sum);

            a_p--;
            b_p--;
        }

        // add remaining carry to front of result
        if (carry > 0) {
            res.add(0, carry);
        }

        return res;
    }

    public static ArrayList<Integer> multiply_integer_by_digit(ArrayList<Integer> a, int b) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        int quot, carry = 0;
        int i = a.size() - 1;

        while (i >= 0) {
            quot = (a.get(i) * b + carry) % 10;
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