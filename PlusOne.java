/**
 * 
 * @author yaoruhao
 *
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int carry = 1;
    	for (int i = digits.length - 1; i >= 0; i--) {
			if (carry == 0) {
				break;
			}
			digits[i] += carry;
			if (digits[i] >= 10) {
				digits[i] -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
		}
    	if (carry == 1) {
			int []result = new int [digits.length + 1];
			result[0] = 1;
			for (int i = 1; i < result.length; i++) {
				result[i] = digits[i - 1];
			}
			return result;
		}    	
    	return digits;
    }
}
