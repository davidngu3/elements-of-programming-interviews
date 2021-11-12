import java.util.ArrayList;

class Problem7_7 {
    public static void main(String[] args) {
        ArrayList<String> res = computeMnemonics("672");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    /*
        Description:
        
        Complexity:
        
    */
    public static ArrayList<String> computeMnemonics(String phoneNumber) {
        ArrayList<String> res = new ArrayList<String>();
        compute("", phoneNumber, res);
        return res;
    }

    public static void compute(String mnemonic, String phoneNumber, ArrayList<String> temp) {
        if (phoneNumber == "") {
            temp.add(mnemonic);
        }

        else {
            char currDigit = phoneNumber.charAt(0);
            char[] mapping = mapDigit(currDigit);
            for (int i = 0; i < mapping.length; ++i) {
                compute(mnemonic + mapping[i], phoneNumber.length() > 1 ? phoneNumber.substring(1): "", temp);
            }
        }
    }

    public static char[] mapDigit(char digit) {
        switch (digit) {
            case '2':
                return new char[]{'A', 'B', 'C'};
            case '3':
                return new char[]{'D', 'E', 'F'};
            case '4':
                return new char[]{'G', 'H', 'I'};
            case '5':
                return new char[]{'J', 'K', 'L'};
            case '6':
                return new char[]{'M', 'N', 'O'};
            case '7':
                return new char[]{'P', 'Q', 'R', 'S'};
            case '8':
                return new char[]{'T', 'U', 'V'};
            case '9':
                return new char[]{'W', 'X', 'Y', 'Z'};
            default:
                return new char[0];
        }
    }
}
