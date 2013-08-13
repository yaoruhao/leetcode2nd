/**
 * 
 * @author yaoruhao
 *
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int up = 0;
    	int down = matrix.length - 1;
    	int width = matrix[0].length;
    	while (up <= down) {
			int midLine = (up + down) / 2;
			if (target < matrix[midLine][0]) {
				down = midLine - 1;
				continue;
			}
			if (target > matrix[midLine][width - 1]) {
				up = midLine + 1;
				continue;
			}
			int left = 0;
			int right = width - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (target == matrix[midLine][mid]) {
					return true;
				}
				if (target < matrix[midLine][mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			return false;
		}
    	return false;
    }
}
