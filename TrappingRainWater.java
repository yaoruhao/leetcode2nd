/**
 * 
 * @author yaoruhao
 *
 */
public class TrappingRainWater {

    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length < 3) {
			return 0;
		}
        int mid = 0;
        int sumWater = 0;
        int tempHeight = 0;
        for (int i = 0; i < A.length; i++) {
			if (A[i] > A[mid]) {
				mid = i;
			}
		}
        for (int i = 0; i < mid; i++) {
			if (tempHeight > A[i]) {
				sumWater += tempHeight - A[i];
			} else {
				tempHeight = A[i];
			}
		}
        tempHeight = 0;
        for (int j = A.length - 1; j > mid; j--) {
			if (tempHeight > A[j]) {
				sumWater += tempHeight - A[j];
			} else {
				tempHeight = A[j];
			}
		}
        return sumWater;
    }
}
