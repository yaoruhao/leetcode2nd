import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
        if (s.isEmpty()) {
			return resultList;
		}
        boolean [][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
			dp[i] = new boolean [s.length()];
			dp[i][i] = true;
		}
        for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i+1] = true;
			}
		}
        for (int len = 2; len < s.length(); len++) {
			for (int i = 0; i < s.length() - len; i++) {
				if (dp[i + 1][i + len - 1] && s.charAt(i) == s.charAt(i + len)) {
					dp[i][i + len] = true;
				}
			}
		}
        searchAllPalindrome(s, new ArrayList<String>(), 0, resultList, dp);
        return resultList;
    }
    
    public void searchAllPalindrome(String s, ArrayList<String> curList, int index, ArrayList<ArrayList<String>> resultList, boolean [][]flag) {
    	if (index >= s.length()) {
			resultList.add((ArrayList<String>) curList.clone());
			return;
		}
    	for (int i = index; i < s.length(); i++) {
			if (flag[index][i]) {
				String str = s.substring(index, i + 1);
				curList.add(str);
				searchAllPalindrome(s, curList, i + 1, resultList, flag);
				curList.remove(curList.size() - 1);
			}
		}
    }
}
