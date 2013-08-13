/**
 * 
 * @author yaoruhao
 *
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
        int n = matrix[0].length;
        int []heights = new int [n];
        int []lefts = new int [n];
        int []rights = new int [n];
        for (int i = 0; i < rights.length; i++) {
			rights[i] = n;
		}
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
			int left = 0;
			int right = n;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					heights[j]++;
					lefts[j] = Math.max(left, lefts[j]);
				} else {
					heights[j] = 0;
					left = j + 1;
					lefts[j] = 0;
					rights[j] = n;
				}
			}
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					rights[j] = Math.min(rights[j], right);
					result = Math.max(result, heights[j] * (rights[j] - lefts[j]));
				} else {
					right = j;
				}
			}
		}
        return result;
    }
}
