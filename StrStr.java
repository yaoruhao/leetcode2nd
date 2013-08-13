/**
 * 
 * @author yaoruhao
 *
 */
public class StrStr {

    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (haystack.isEmpty() && needle.isEmpty()) {
			return "";
		}
        if (haystack.length() < needle.length()) {
			return null;
		}
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			boolean match = true;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					match = false;
					break;
				}
			}
			if (match) {
				return haystack.substring(i);
			}
		}
        return null;
    }
}
