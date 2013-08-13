/**
 * 
 * @author yaoruhao
 *
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	return match(s, p, 0, 0);
    }
    
    public boolean match(String s, String p, int i, int j) {
    	if (j == p.length()) {
			return i == s.length();
		}
    	if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
			if (i == s.length()) {
				return false;
			}
			return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && match(s, p, ++i, ++j);
		}
    	while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
			if (match(s, p, i++, j + 2)) {
				return true;
			}
		}
    	return match(s, p, i, j + 2);
    }
    
    public static void main(String[] args) {
    	RegularExpressionMatching test = new RegularExpressionMatching();
    	System.out.println(test.isMatch("a", "ab*"));
    }
}
