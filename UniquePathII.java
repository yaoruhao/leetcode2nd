/**
 * 
 * @author yaoruhao
 *
 */
public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
        int [][]dp = new int[m + 1][n + 1];
        if (obstacleGrid[m-1][n-1] != 1) {
        	dp[m - 1][n - 1] = 1;
		}        
        for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if ((i == m - 1 && j == n - 1) || obstacleGrid[i][j] == 1) {
					continue;
				}
				if (i + 1 < obstacleGrid.length && obstacleGrid[i+1][j] != 1) {
					dp[i][j] += dp[i + 1][j];
				}
				if (j + 1 < obstacleGrid[0].length && obstacleGrid[i][j+1] != 1) {
					dp[i][j] += dp[i][j+1];
				}
			}
		}        
        return dp[0][0];
    }
}
