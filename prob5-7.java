// Write a program that takes a double x and an integer y and returns x^y. You can ignore overflow and underflow.

class Problem5_7 {
    public static void main(String[] args) {
        System.out.println(exponentiation_bruteforce(2, 3));
    }

    /*
        Description:
        
        Complexity:
        
    */
    public static long exponentiation_bruteforce(int x, int y) {
        int res = 1;
        for (int i = 0; i < y; i++) {
            res *= x;
        }
        return res;
    }
}