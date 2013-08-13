/**
 * 
 * @author yaoruhao
 *
 */
public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (A.length == 0) {
			return 0;
		}
    	if (A.length == 1) {
			return A[0];
		}
        int maxSum = A[0];
        int curSum = A[0];
        for (int i = 1; i < A.length; i++) {
			if (curSum < 0) {
				curSum = A[i];
			} else {
				curSum += A[i];
			}
			maxSum = Math.max(maxSum, curSum);
		}
        return maxSum;
    }
}
