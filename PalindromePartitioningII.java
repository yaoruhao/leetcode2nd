/**
 * 
 * @author yaoruhao
 *
 */
public class PalindromePartitioningII {

    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() <= 1) {
			return 0;
		}
        boolean [][] pFlag = new boolean[s.length()][s.length()];
        int []dp = new int [s.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
			dp[i] = s.length() - i - 1;
		}
        for (int i = 0; i < pFlag.length; i++) {
			pFlag[i] = new boolean [s.length()];
		}
        for (int i = s.length() - 2; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j) && (j <= i + 2 || pFlag[i + 1][j - 1])) {
					pFlag[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
        return dp[0];
    }
}
