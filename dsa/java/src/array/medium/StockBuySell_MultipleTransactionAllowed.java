package array.medium;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * The cost of stock on each day is given in an array price[]. Each day you may decide to either
 * buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find
 * the maximum profit that you can get.
 * Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be
 * held on any given day.
 *
 * Examples:
 * Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
 * Output: 865
 * Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210.
 * Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.
 */
// this problem is similar to leetcode: 122. Best Time to Buy and Sell Stock II
public class StockBuySell_MultipleTransactionAllowed {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        int maxiProfit = 0;

        // buying the stock at the first day
        int buy = prices[0];

        for (int i = 1; i < n; i ++){
            // when the current stock price is greater
            // than the price we have bought the stock,
            // we'll immediately sell it.
            if (prices[i] > buy){
                // calculating the current profit
                int currProfit = prices[i] - buy;

                // update the maximum profit
                maxiProfit += currProfit;
            }
            // update the buying price
            buy = prices[i];
        }

        return maxiProfit;
    }

    public static void main(String[] args) {
        var obj = new StockBuySell_MultipleTransactionAllowed();

        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        int maximumProfit = obj.maximumProfit(prices);
        System.out.println("Maximum Profit: "+ maximumProfit);
    }
}
