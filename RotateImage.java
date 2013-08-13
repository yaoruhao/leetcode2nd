/**
 * 
 * @author yaoruhao
 *
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	for (int round = 0; round < matrix.length / 2; round++) {
    		int i = round;
    		for (int j = i; j < matrix.length - round - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - j - 1][i];
				matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j - 1];
				matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];
				matrix[j][matrix.length - i - 1] = temp;
			}
		}
    }
}
