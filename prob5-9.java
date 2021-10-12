/*
    A palindromic string is one which reads the same forwards and backwards, e.g.,
    "redivider". In this problem, you are to write a program which determines if the
    decimal representation of an integer is a palindromic string. For example, your
    program should return true for the inputs 0,1,7,11,121,333, and 2147447412, and
    false for the inputs -1,12,100, and 2147483647.
    Write a program that takes an integer and determines if that integer's representation
    as a decimal string is a palindrome
*/

class Problem5_9 {
    public static void main(String[] args) {
        System.out.println(isPalindromic(323));
        System.out.println(isPalindromic(492294));
        System.out.println(isPalindromic(32));
    }

    /*
        Description:
            Reverse string and compare to original

        Complexity:
            O(N) where N is the length of x
        
    */
    public static boolean isPalindromic(int x) {
        if (x < 0) {
            return false;
        }

       return x == reverseInt(x);
    }

    // Reverse string method from prob 5-8
    public static int reverseInt(int x) {
        int r = 0;

        while (x != 0) {
            r *= 10;        // make room for new digit
            r += x % 10;    // take last digit from x and append to r
            x /= 10;        // remove last digit from x
        }

        return r;
    } 
}
