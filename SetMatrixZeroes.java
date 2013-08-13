/**
 * 
 * @author yaoruhao
 *
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean beginRowFlag = false;
        boolean beginColFlag = false;
        for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				beginColFlag = true;
				break;
			}
		}
        for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				beginRowFlag = true;
				break;
			}
		}
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
        for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
        for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
        if (beginColFlag) {
            for (int i = 0; i < matrix.length; i++) {
            	matrix[i][0] = 0;
    		}
		}
        if (beginRowFlag) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}        
    }
}
