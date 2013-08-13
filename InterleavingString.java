/**
 * 
 * @author yaoruhao
 *
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
        int l1 = s1.length();
        int l2 = s2.length();
        boolean [][]dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 0; i < l1; i++) {
			if (s1.charAt(i) == s3.charAt(i)) {
				dp[i + 1][0] = true;
			}
		}
        for (int j = 0; j < l2; j++) {
			if (s2.charAt(j) == s3.charAt(j)) {
				dp[0][j + 1] = true;
			}
		}
        for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (dp[i-1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				}
				if (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				}
			}
		}
        return dp[l1][l2];
    }
}
