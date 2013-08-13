import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class SpiralMatrix {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> resultList = new ArrayList<Integer>();
    	if (matrix.length == 0 || matrix[0].length == 0) {
			return resultList;
		}
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int round = Math.min(n, m) / 2;
    	if (Math.min(n, m) % 2 == 1) {
			round++;
		}
    	for (int i = 0; i < round; i++) {
			int leftWidth = n - i;
			int leftHeight = m - i;
			resultList.add(matrix[i][i]);
			for (int j = i + 1; j < leftWidth; j++) {
				resultList.add(matrix[i][j]);
			}
			for (int j = i + 1; j < leftHeight; j++) {
				resultList.add(matrix[j][leftWidth - 1]);
			}
			if (i + 1 >= leftHeight || i + 1 >= leftWidth) {
				continue;
			}
			for (int j = leftWidth - 2; j >= i; j--) {
				resultList.add(matrix[leftHeight - 1][j]);
			}
			for (int j = leftHeight - 2; j > i; j--) {
				resultList.add(matrix[j][i]);
			}
		}    	
    	return resultList;        
    }
}
