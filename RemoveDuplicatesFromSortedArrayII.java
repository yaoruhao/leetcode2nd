/**
 * 
 * @author yao
 *
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (A.length <= 2) {
			return A.length;
		}
        int curIndex = 1;
        for (int i = 2; i < A.length; i++) {
			if (A[i] == A[curIndex] && A[i] == A[curIndex - 1]) {
				continue;
			} else {
				A[++curIndex] = A[i];
			}
		}
        return curIndex + 1;
    }
}
