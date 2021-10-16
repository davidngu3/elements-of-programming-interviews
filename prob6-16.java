import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Prob6_16 {
    public static void main(String[] args) {
       
    }

    /*
        Description:
           

        Complexity: 
          
          
    */
    public static boolean sudoku_check(List<List<Integer>> arr) {
        int n = arr.size();

        // check horizontals and verticals
        for (int i = 0; i < n; i++) {
            int[] rowSet = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] colSet = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int j = 0; j < n; j++) {
                int rowCell = arr.get(i).get(j);
                if (rowSet[rowCell-1] == 1) {
                    return false;
                }
                rowSet[rowCell-1] = 1;

                int colCell = arr.get(j).get(i);
                if (colSet[colCell-1] == 1) {
                    return false;
                }
                colSet[colCell-1] = 1;
            }
        }

        // check diagonals
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int[] subSet =  new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        int subCell = arr.get(x+i*3).get(y+j*3);
                        if (subSet[subCell-1] == 1) {
                            return false;
                        }
                        subSet[subCell-1] = 1;
                    }    
                }
                    
            }
        }

        return true;
    }
}