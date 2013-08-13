/**
 * 
 * @author yaoruhao
 *
 */
public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) {
			return;
		}
        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
			if (A[m] >= B[n]) {
				A[index--] = A[m--];
			} else {
				A[index--] = B[n--];
			}
		}
        while (n >= 0) {
			A[index--] = B[n--];
		}
    }
}
