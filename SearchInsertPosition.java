/**
 * 
 * @author yaoruhao
 *
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int left = 0;
    	int right = A.length - 1;
    	int mid = 0;
    	while (left <= right) {
			mid = (left + right)/2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
    	return left;
    }
}
