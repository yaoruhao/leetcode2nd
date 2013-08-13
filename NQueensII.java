/**
 * 
 * @author yaoruhao
 *
 */
public class NQueensII {

    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 1) {
			return n;
		}
        int []result = new int[1];
        boolean []colFlag = new boolean[n];
        boolean []leftDFlag = new boolean[n*2 + 1];
        boolean []rightDFlag = new boolean[n * 2 + 1];
        searchAllQueens(n, 0, colFlag, leftDFlag, rightDFlag, result);
        return result[0];
    }
    
    public void searchAllQueens(int n, int current, boolean[] colFlag, boolean[] leftDFlag, boolean[] rightDFlag, int[]result) {
    	if (current == n) {
			result[0]++;
			return;
		}
    	for (int i = 0; i < n; i++) {
			if (colFlag[i] || leftDFlag[i + current] || rightDFlag[n + current - i]) {
				continue;
			}
			colFlag[i] = true;
			leftDFlag[i + current] = true;
			rightDFlag[n + current - i] = true;
			searchAllQueens(n, current + 1, colFlag, leftDFlag, rightDFlag, result);
			colFlag[i] = false;
			leftDFlag[i + current] = false;
			rightDFlag[n + current - i] = false;
		}
    }
}
