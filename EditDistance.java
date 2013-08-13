/**
 * 
 * @author yaoruhao
 *
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (word1.isEmpty()) {
			return word2.length();
		}
        if (word2.isEmpty()) {
			return word1.length();
		}
        int [][]dp = new int [word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
			dp[i] = new int [word2.length() + 1];
		}
        for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
        for (int j = 0; j <= word2.length(); j++) {
			dp[0][j] = j;
		}
        for (int i = 1; i <= word1.length() ; i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
				}
			}
		}
        return dp[word1.length()][word2.length()];
    }
}
