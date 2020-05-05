package greedy;

class BestTimeBuyAndSellStock_II {

    public int maxProfit(int[] prices) {
        int profits = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (i - 1 >= 0 && prices[i - 1] < prices[i]) {
                profits += prices[i] - prices[i - 1];
            }
        }
        return profits;
    }

}