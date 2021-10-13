class Prob6_6 {
    public static void main(String[] args) {
        System.out.println(buy_sell_stock(new int[]{310, 315, 275, 295, 260, 270, 290, 230, 255, 250}));
    }

    /*
        Description:
            Maintain a variable storing the best profit we have found so far, 
            and a variable storing the lowest stock price we have found so far

            Loop through each stock price, and at each,
                if a new lowest price has been found, update it
                if a new highest profit has been found, update it

        Complexity: 
            O(N), N length of arr
           
        
    */
    public static int buy_sell_stock(int[] arr) {
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > min) {
                if (arr[i] - min > profit) {
                    profit = arr[i] - min;
                }
            }
        }

        return profit;
    }
}