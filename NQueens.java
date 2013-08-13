import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class NQueens {

    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String []> resultList = new ArrayList<String []>();
        if (n == 0) {
			return resultList;
		}
        int []posArray = new int [n];
        boolean []colFlag = new boolean[n];
        boolean []leftDFlag = new boolean[n*2 + 1];
        boolean []rightDFlag = new boolean[n * 2 + 1];
        searchAllQueens(n, 0, posArray, colFlag, leftDFlag, rightDFlag, resultList);
        return resultList;
    }
    
    public void searchAllQueens(int n, int current, int []posArray, boolean []colFlag, boolean []leftDFlag, boolean []rightDFlag, ArrayList<String []> resultList) {
    	if (current == n) {
			String []result = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder(n);
				for (int j = 0; j < n; j++) {
					sb.append(".");
				}
				sb.setCharAt(posArray[i], 'Q');
				result[i] = sb.toString();
			}
			resultList.add(result);
			return;
		}
    	for (int i = 0; i < n; i++) {
			if (colFlag[i] || leftDFlag[i + current] || rightDFlag[n + current - i]) {
				continue;
			}
			colFlag[i] = true;
			leftDFlag[i + current] = true;
			rightDFlag[n + current - i] = true;
			posArray[current] = i;
			searchAllQueens(n, current + 1, posArray, colFlag, leftDFlag, rightDFlag, resultList);
			colFlag[i] = false;
			leftDFlag[i + current] = false;
			rightDFlag[n + current - i] = false;
		}
    }
}
