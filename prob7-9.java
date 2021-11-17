import java.util.ArrayList;

class Problem7_9 {
    public static void main(String[] args) {
        System.out.println(romanToDecimal("XXXXXIII"));
    }

    /*
        Description: Check pairs of chars in roman numeral to check if a 'compound' numeral is used; 
            if so, calculate the value and increment pointer as to 'skip' the compound suffix
            Else just add a single roman numeral value to sum
        
        Complexity: 
            Loop runs in O(N), each of the utility functions runs in constant time
            Overall time complexity is O(N), N being length of roman string.
        
    */
    public static int romanToDecimal(String n) {
        int sum = 0;

        for (int i = 0; i < n.length(); ++i ) {
            if (i == n.length() - 1 || !isCompoundRomanNumeral(n.charAt(i), n.charAt(i+1))) {
                sum += romanCharToIntValue(n.charAt(i));
            }
            else {
                sum += calculateCompoundRomanNumeral(n.charAt(i), n.charAt(i+1));
                i++;
            }
        }

        return sum;
    }

    public static int romanCharToIntValue(char c) {
        switch (c) {
            case 'I': 
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'P':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static boolean isCompoundRomanNumeral(char a, char b) {
        if (a == 'I' && (b == 'V' || b == 'X')) {
            return true;
        } 
        else if (a == 'X' && (b == 'L' || b == 'C')) {
            return true;
        }
        else if (a == 'C' && (b == 'D' || b == 'M')) {
            return true;
        }
        return false;
    }

    public static int calculateCompoundRomanNumeral(char a, char b) {
        return romanCharToIntValue(b) - romanCharToIntValue(a);
    }
}
