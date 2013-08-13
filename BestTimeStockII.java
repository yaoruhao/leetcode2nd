/**
 * 
 * @author yaoruhao
 *
 */
public class BestTimeStockII {

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (prices.length <= 1) {
			return 0;
		}
    	int profit = 0;
    	int buyIndex = -1;
    	for (int i = 0; i < prices.length - 1; i++) {
			if (buyIndex == -1 && prices[i+1] > prices[i]) {
				buyIndex = i;
			}
			if (prices[i + 1] < prices[i] && buyIndex != -1) {
				profit += prices[i] - prices[buyIndex];
				buyIndex = -1;
			}
		}
    	if (buyIndex != -1) {
			profit += prices[prices.length - 1] - prices[buyIndex];
		}
    	return profit;
    }
}
