import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
    A 2D array can be written as a sequence in several orders—the most natural ones
    being row-by-row or column-by-column. In this problem we explore the problem
    of writing the 2D array in spiral order. 

    Write a program which takes an nxn 2D array and returns the spiral ordering of the
    array.
*/

class Prob6_17 {
    public static void main(String[] args) {
        spiral_ordering(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    /*
        Description:
            2 cases: odd n and even n
            If odd n, manually append middle element to end of spiral ordering

            Spiral ordering done by 4 loops, one for each direction, done for each layer of the spiral

        Complexity: 
            O(n*n), where n is the size of the array
          
    */
    public static List<Integer> spiral_ordering(int[][] arr) {
        int n = arr.length - 1;

        ArrayList<Integer> spiral = new ArrayList<Integer>();    
    
        for (int layer = 0; layer < arr.length / 2; ++layer ) {
            // add top row
            for (int j = layer; j < n-layer; ++j) {
                spiral.add(arr[layer][j]);
            }

            // add right column
            for (int i = layer; i < n - layer; ++i) {
                spiral.add(arr[i][n-layer]);
            }

            // add bottom row
            for (int k = n-layer; k >= layer + 1; --k) {
                spiral.add(arr[n-layer][k]);
            }

            // add left column
            for (int m = n-layer; m >= layer + 1; --m) {
                spiral.add(arr[m][layer]);
            }
        }

        // manually add single middle element
        if (arr.length % 2 == 1) {
            spiral.add(arr[arr.length / 2][arr.length / 2]);
        }

        return spiral;
    }
}