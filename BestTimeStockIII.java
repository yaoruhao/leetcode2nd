/**
 * 
 * @author yaoruhao
 *
 */
public class BestTimeStockIII {

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices.length <= 1) {
			return 0;
		}
        int maxProfit = 0;
        int []leftProfit = new int[prices.length];
        int []rightProfit = new int[prices.length];
        int valley = prices[0];
        int peak = prices[prices.length - 1];
        for (int i = 0; i < prices.length; i++) {
			valley = Math.min(prices[i], valley);
			if (i > 0) {
				leftProfit[i] = Math.max(leftProfit[i-1], prices[i] - valley);
			}
		}
        for (int j = prices.length - 1; j >= 0; j--) {
			peak = Math.max(prices[j], peak);
			if (j < prices.length - 1) {
				rightProfit[j] = Math.max(rightProfit[j + 1], peak - prices[j]);
			}
			maxProfit = Math.max(maxProfit, leftProfit[j] + rightProfit[j]);
		}
        return maxProfit;
    }
}
