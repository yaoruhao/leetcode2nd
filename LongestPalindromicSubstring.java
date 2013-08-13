/**
 * 
 * @author yaoruhao
 *
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (s.isEmpty()) {
			return null;
		}
        if (s.length() == 1) {
			return s;
		}
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
        	String p1 = expandFromCenter(s, i, i);
        	if (p1.length() > result.length()) {
				result = p1;
			}
			String p2 = expandFromCenter(s, i, i + 1);
			if (p2.length() > result.length()) {
				result = p2;
			}
		}
        return result;
    }
    
    public String expandFromCenter(String s, int left, int right) {
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
    	return s.substring(left + 1, right);
    }
}
