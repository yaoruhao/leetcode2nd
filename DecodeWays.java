/**
 * 
 * @author yaoruhao
 *
 */
public class DecodeWays {
	
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (s.isEmpty()) {
			return 0;
		}
    	int []dp = new int [s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
			int num = s.charAt(i) - '0';
			if (num <= 0) {
				continue;
			}
			if (i == s.length() - 1) {
				dp[i] = 1;
				continue;
			}
			dp[i] = dp[i + 1];
			int twoDigitNum = Integer.valueOf(s.substring(i, i + 2));
			if (i == s.length() - 2 && twoDigitNum > 0 && twoDigitNum <= 26) {
				dp[i] += 1;
				continue;
			}
			if (twoDigitNum <= 26) {
				dp[i] += dp[i + 2];
			}
		}
        return dp[0];
    }

}
