/**
 * 
 * @author yaoruhao
 *
 */
public class SearchForARange {

    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	return searchForRange(A, 0, A.length - 1, target);
    }
    
    public int[]searchForRange(int[] A, int left, int right, int target) {
        int []result = new int [2];
        if (left > right || left < 0 || right >= A.length || target < A[left] || target > A[right]) {
			result[0] = -1;
			result[1] = -1;
			return result;
		}
        int l = left;
        int r = right;
        result[0] = -1;
        result[1] = -1;
        while (l <= r) {
			int mid = (l + r) / 2;
			if (A[mid] == target) {
				int []leftResult = searchForRange(A, l, mid - 1, target);
				int []rightResult = searchForRange(A, mid + 1, r, target);
				if (leftResult[0] != -1) {
					result[0] = leftResult[0];
				} else {
					result[0] = mid;
				}
				if (rightResult[1] != -1) {
					result[1] = rightResult[1];
				} else {
					result[1] = mid;
				}
				return result;
			} else if (A[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
        return result;
    }
}
