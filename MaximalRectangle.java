import java.util.Stack;

/**
 * 
 * @author yaoruhao
 *
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
        int rows = matrix.length;
        int columns = matrix[0].length;
        int [][] lenTable = new int [rows][columns];
        for (int i = 0; i < columns; i++) {
			if (matrix[0][i] == '1') {
				lenTable[0][i] = 1;
			}
		}
        for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] == '0') {
					continue;
				}
				lenTable[i][j] = lenTable[i-1][j] + 1;
			}
		}
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
			maxArea = Math.max(maxArea, maximalHistogram(lenTable[i]));
		}
        return maxArea;
    }
    
    public int maximalHistogram(int []histogram) {
    	int maxArea = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < histogram.length; i++) {
			if (stack.isEmpty() || histogram[stack.peek()] < histogram[i]) {
				stack.push(i);
			} else {
				int lastIndex = stack.pop();
				int width = i;
				if (!stack.isEmpty()) {
					width = i - stack.peek() - 1;
				}
				maxArea = Math.max(maxArea, histogram[lastIndex] * width);
				i--;
			}
		}    	
    	while (!stack.isEmpty()) {
			int lastIndex = stack.pop();
			int width = stack.isEmpty() ? histogram.length : histogram.length - stack.peek() - 1;
			maxArea = Math.max(maxArea, histogram[lastIndex] * width);
		}    	
    	return maxArea;
    }
}
