/**
 * 
 * @author yaoruhao
 *
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length <= 1) {
			return A.length;
		}
        int curIndex = 1;
        int curValue = A[0];
        for (int i = 1; i < A.length; i++) {
			if (A[i] == curValue) {
				continue;
			}
			curValue = A[i];
			A[curIndex++] = curValue;
		}
        return curIndex;
    }
}
