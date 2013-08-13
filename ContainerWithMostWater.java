/**
 * 
 * @author yaoruhao
 *
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (height.length <= 1) {
			return 0;
		}
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
			int tempArea = (right - left + 1) * Math.min(height[left], height[right]);
			if (maxArea < tempArea) {
				maxArea = tempArea;
			}
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
        return maxArea;
    }
}
