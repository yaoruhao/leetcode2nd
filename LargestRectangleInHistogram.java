import java.util.Stack;

/**
 * 
 * @author yaoruhao
 *
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> heightStack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < height.length; i++) {
			if (heightStack.isEmpty() || height[heightStack.peek()] < height[i]) {
				heightStack.push(i);
			} else {
				int index = heightStack.pop();
				if (heightStack.isEmpty()) {
					max = Math.max(max, height[index] * i);
				} else {
					max = Math.max(max, height[index] * (i - heightStack.peek() - 1));
				}
				i--;
			}
		}
        while (!heightStack.isEmpty()) {
			int index = heightStack.pop();
			int width = heightStack.isEmpty() ? height.length : height.length - heightStack.peek() - 1;
			max = Math.max(max, height[index] * width);
		}
        return max;
    }
}
