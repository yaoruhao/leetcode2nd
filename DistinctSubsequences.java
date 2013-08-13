/**
 * 
 * @author yaoruhao
 *
 */
public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S.isEmpty() || T.isEmpty() || S.length() < T.length()) {
        	return 0;
		}
        int []dp = new int[T.length() + 1];
        dp[T.length()] = 1;
        for (int i = S.length() - 1; i >= 0; i--) {
			for (int j = 0; j < T.length(); j++) {
				if (S.charAt(i) == T.charAt(j)) {
					dp[j] += dp[j+1];
				}
			}
		}
        return dp[0];
    }
    
}
