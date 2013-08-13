/**
 * 
 * @author yaoruhao
 *
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && A[i] < A.length) {
				if (A[i] - 1 != i && A[A[i] - 1] != A[i]) {
					int temp = A[A[i] - 1];
					A[A[i] - 1] = A[i];
					A[i] = temp;
					i--;
				}
			}
		}
        for (int i = 0; i < A.length; i++) {
			if (A[i] - 1 != i) {
				return i + 1;
			}
		}
        return A.length + 1;
    }
}
