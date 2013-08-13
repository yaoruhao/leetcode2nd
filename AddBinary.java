/**
 * 
 * @author yaoruhao
 *
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (b.isEmpty()) {
			return a;
		}
    	if (a.isEmpty()) {
			return b;
		}
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        while (aIndex >= 0 || bIndex >= 0) {
			int result = carry;
			if (aIndex >= 0) {
				result += a.charAt(aIndex) - '0';
				aIndex--;
			}
			if (bIndex >= 0) {
				result += b.charAt(bIndex) - '0';
				bIndex--;
			}
			if (result <= 1) {
				sb.append(result);
				carry = 0;
			} else {
				carry = 1;
				sb.append(result % 2);
			}
		}
        if (carry != 0) {
			sb.append(1);
		}
        String result = sb.reverse().toString();
        return result;
    }
}
