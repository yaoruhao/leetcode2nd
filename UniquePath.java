/**
 * 
 * @author yaoruhao
 *
 */
public class UniquePath {

    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[] steps = new int[n];
    	steps[n - 1] = 1;
    	for (int i = 0; i < m + n - 2; i++) {
			for (int j = 0; j < n; j++) {
				if (j + 1 < n) {
					steps[j] += steps[j + 1];
				}
			}
		}
    	return steps[0];
    }
}
