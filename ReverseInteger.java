/**
 * 
 * @author yaoruhao
 *
 */
public class ReverseInteger {

    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        if (x >= 0) {
            while (x != 0) {
            	if (result > Integer.MAX_VALUE / 10) {
    				return Integer.MAX_VALUE;
    			}
            	result *= 10;
            	if (result > Integer.MAX_VALUE - x % 10) {
    				return Integer.MAX_VALUE;
    			}
    			result += x % 10;
    			x /= 10;
    		}
        } else {
        	while (x != 0) {
				if (result < Integer.MIN_VALUE / 10) {
					return Integer.MIN_VALUE;
				}
				result *= 10;
				if (result < Integer.MIN_VALUE + x % 10 * -1) {
					return Integer.MIN_VALUE;
				}
				result += x % 10;
				x /= 10;
			}
        }
        return result;
    }
}
