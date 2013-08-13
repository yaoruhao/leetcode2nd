/**
 * 
 * @author yaoruhao
 *
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int curIndex = 0;
    	for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[curIndex++] = A[i];
			}
		}
        return curIndex;
    }
}
