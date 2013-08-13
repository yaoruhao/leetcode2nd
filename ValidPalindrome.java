/**
 * 
 * @author yaoruhao
 *
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (s.isEmpty()) {
			return true;
		}
    	int left = 0;
    	int right = s.length() - 1;
    	s = s.toLowerCase();
    	while (left < right) {
			while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}
			while (right >= 0 &&!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}
			if (left >= s.length() || right < 0) {
				break;
			}
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
    	return true;
    }
}
