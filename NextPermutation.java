import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num.length <= 1) {
			return;
		}
        boolean isMax = true;
        int index = num.length - 2;
        for (; index >= 0; index--) {
        	if (num[index] < num[index + 1]) {
        		isMax = false;
				break;
			}
        }
        if (isMax) {
        	Arrays.sort(num);
			return;
		}
        for (int i = num.length - 1; i > index; i--) {
        	if (num[i] > num[index]) {
				int temp = num[i];
				num[i] = num[index];
				num[index] = temp;
				break;
			}
		}
        Arrays.sort(num, index + 1, num.length);
    }
}
