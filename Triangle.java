import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []dp = new int [triangle.size()];
        ArrayList<Integer> lastRow = triangle.get(triangle.size() - 1);
        for (int i = 0; i < lastRow.size(); i++) {
			dp[i] = lastRow.get(i);
		}
        for (int row = triangle.size() - 2; row >= 0; row--) {
			lastRow = triangle.get(row);
			for (int i = 0; i < lastRow.size(); i++) {
				dp[i] = Math.min(dp[i], dp[i + 1]) + lastRow.get(i);
			}
		}
        return dp[0];
    }

}
