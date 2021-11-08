class Problem7_2 {
    public static void main(String[] args) {
        System.out.println(convertBase("4C", 16, 2));
    }

    /*
        Description:
            Convert base a to base 10 first
            Then convert from base 10 to base b

        Complexity:
        
    */
    public static String convertBase(String x, int a, int b) {
        // Convert to base 10 (if not already)
        int temp = 0;
        for (int i = 0; i < x.length(); ++i) {
            char c = x.charAt(i);
            int val;

            if (isHexChar(c)) {
                val = hexToInt(c);
            }
            else {
                val = c - "0".charAt(0);
            }

            temp += val * Math.pow(a, x.length() - i - 1); 
        }

        // Convert to base x
        StringBuilder sb = new StringBuilder();
        while (temp != 0) {
            char c;

            int rem = temp % b;

            if (rem > 9) {
                c = intToHex(rem);
            }
            else {
                c = (char) (rem + '0');
            }

            sb.append(c);
            temp /= b;
        }
        sb.reverse();

        return sb.toString();
    }

    public static boolean isHexChar(char x) {
        if (x == 'A' || x == 'B' || x == 'C' ||  x == 'D' || x == 'E' || x == 'F') {
            return true;
        }
        return false;
    } 

    public static int hexToInt(char x) {
        int res = 0;
        switch (x) {
            case 'A':
                res = 10;
                break;
            case 'B':
                res = 11;
                break;
            case 'C':
                res = 12;
                break;
            case 'D':
                res = 13;
                break;
            case 'E':
                res = 14;
                break;
            case 'F':
                res = 15;
                break;
        }
        return res;   
    }

    public static char intToHex(int x) {
        char res = '0';
        switch (x) {
            case 10:
                res = 'A';
                break;
            case 11:
                res = 'B';
                break;
            case 12:
                res = 'C';
                break;
            case 13:
                res = 'D';
                break;
            case 14:
                res = 'E';
                break;
            case 15:
                res = 'F';
                break;
        }
        return res;   
    }
}