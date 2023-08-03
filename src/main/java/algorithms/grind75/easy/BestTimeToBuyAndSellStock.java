package algorithms.grind75.easy;

/**
 * 121. Best Time to Buy and Sell Stock
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day. You
 * want to maximize your profit by choosing a single day to buy one stock and choosing a different
 * day in the future to sell that stock. Return the maximum profit you can achieve from this
 * transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <a
 * href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">best-time-to-buy-and-sell-stock</a>
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Use native approach to iterate all elements tracking the minimum price and counting the
     * profit If prices is empty or has only one element that there is no profit at all
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price
                < minPrice) { // if current price is less than min price, we should update the min price
                minPrice = price;
            } else { //else we should count the current profit and update max price
                int currentProfit = price - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
}
