/**
 * 
 * @author yaoruhao
 *
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (n <= 1) {
			return 1;
		}
    	if (n == 2) {
			return 2;
		}
        int []dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - 1 - j];
			}
		}        
        return dp[n];
    }
}
