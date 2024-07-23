package murilo.barbosa.array.exercises;


public class TimeToBuyAndSellEasy {

    public static void main(String[] args) {
        maxProfit(new int[]{7, 6, 4, 3, 1});
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            int current = prices[i];

//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] > max) {
//                    max = prices[j];
//                }
//            }
//
//            int currentProfit = max - current;
//            if (currentProfit > profit) {
//                profit = currentProfit;
//            }
        }

        return profit;
    }
}