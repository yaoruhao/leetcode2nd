/**
 * 
 * @author yaoruhao
 *
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        if (s.isEmpty()) {
			return result;
		}
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < s.length(); i++) {
        	for (int j = 0; j < symbols.length; j++) {
				if (s.indexOf(symbols[j], i) == i) {
					result += nums[j];
					i += symbols[j].length() - 1;
					break;
				}
			}			
		}
        return result;
    }
}
