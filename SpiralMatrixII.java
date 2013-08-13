/**
 * 
 * @author yaoruhao
 *
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][]matrix = new int [n][n];
        for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[n];
		}
        int round = n / 2;
        if (n % 2 == 1) {
			round++;
		}
        int current = 1;
        for (int i = 0; i < round; i++) {
			int leftWidth = n - i;
			int leftHeight = n - i;
			matrix[i][i] = current++;
			for (int j = i + 1; j < leftWidth; j++) {
				matrix[i][j] = current++;
			}
			for (int j = i + 1; j < leftHeight; j++) {
				matrix[j][leftWidth - 1] = current++;
			}
			for (int j = leftWidth - 2; j >= i; j--) {
				matrix[leftHeight - 1][j] = current++;
			}
			for (int j = leftHeight - 2; j > i; j--) {
				matrix[j][i] = current++;
			}
		}        
        return matrix;
    }
}
