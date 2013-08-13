/**
 * 
 * @author yaoruhao
 *
 */
public class BestTimeStock {

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (prices.length == 0) {
			return 0;
		}
        int curMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
			maxProfit = Math.max(prices[i] - curMin, maxProfit);
			curMin = Math.min(curMin, prices[i]);
		}        
        return maxProfit;
    }
}
