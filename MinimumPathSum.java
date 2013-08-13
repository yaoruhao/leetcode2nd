/**
 * 
 * @author yaoruhao
 *
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length;
        int n = grid[0].length;
        for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					continue;
				}
				int min = Integer.MAX_VALUE;
				if (i < m - 1) {
					min = Math.min(grid[i + 1][j], min);
				}
				if (j < n - 1) {
					min = Math.min(grid[i][j + 1], min);
				}
				grid[i][j] += min;
			}
		}    	
    	return grid[0][0];
    }
}
