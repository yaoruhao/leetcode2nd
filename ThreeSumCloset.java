import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class ThreeSumCloset {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean initSum = false;
        int sum = 0;
        if (num.length < 3) {
			return 0;
		}
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int tempSum = num[i] + num[left] + num[right];
				if (tempSum == target) {
					return target;
				}
				if (!initSum) {
					sum = tempSum;
					initSum = true;
				}
				if (Math.abs(sum - target) > Math.abs(tempSum - target)) {
					sum = tempSum;
				}
				if (tempSum > target) {
					right--;
				} else {
					left++;
				}
			}
		}        
        return sum;
    }
}
