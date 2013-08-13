/**
 * 
 * @author yaoruhao
 *
 */
public class StringToInteger {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        str = str.trim();
    	if (str.isEmpty()) {
			return 0;
		}
    	boolean positive = true;
    	if (str.startsWith("-")) {
			positive = false;
			str = str.substring(1);
		} else if (str.startsWith("+")) {
			str = str.substring(1);
		}
    	int result = 0;
    	int startIndex = 0;
    	while (str.charAt(startIndex) == '0') {
			startIndex++;
		}
    	for ( ; startIndex < str.length(); startIndex++) {
			int num = str.charAt(startIndex) - '0';
			if (num < 0 || num > 9) {
				return result;
			}
			if (positive && result > Integer.MAX_VALUE / 10) {
				return Integer.MAX_VALUE;
			}
			if (!positive && result < Integer.MIN_VALUE / 10) {
				return Integer.MIN_VALUE;
			}
			result *= 10;
			if (positive && result > Integer.MAX_VALUE - num) {
				return Integer.MAX_VALUE;
			}
			if (!positive && result < Integer.MIN_VALUE + num) {
				return Integer.MIN_VALUE;
			}
			if (positive) {
				result += num;
			} else {
				result -= num;
			}
		}
    	return result;
    }
}
