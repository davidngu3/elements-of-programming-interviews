// Write a program that takes a double x and an integer y and returns x^y. You can ignore overflow and underflow.

class Problem5_7 {
    public static void main(String[] args) {
       //  System.out.println(exponentiation_bruteforce(2, 3));
        System.out.println(exponentiation(2, 5));
    }

    /*
        Description:
            Repeatedly multiply by x
        Complexity:
            O(2^n), where n is the number of bits in the integer type
    */
    public static double exponentiation_bruteforce(double x, int y) {
        double res = 1;
        for (int i = 0; i < y; i++) {
            res *= x;
        }
        return res;
    }

    /*
        Description:
            Repeatedly square the result
            Check LSB for even/odd
            If odd, then multiply by x too

            If y is negative, then we need to do 1/x instead (and reverse the sign on y)

        Complexity:
            O(N)
        
    */
    public static double exponentiation(double x, int y) {
        long power = y;

        // negative exponent case
        if (y < 0) {
            x = 1/x;
            power = -power;
        }

        return exponentiation_aux_iterative(x, power);
    }
    
    public static double exponentiation_aux(double x, long power) {
        // power is 0
        if (power == 0) {
            return 1;
        }
        
        // power is odd
        if ((power & 1) == 1) {
            return x * exponentiation_aux(x*x, power >>> 1);
        }

        // power is even
        return exponentiation_aux(x*x, power >>> 1);
    }

    public static double exponentiation_aux_iterative(double x, long power) {
        double result = 1.0;

        while (power != 0) {
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }

        return result;
    }

}