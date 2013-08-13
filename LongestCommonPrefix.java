/**
 * 
 * @author yaoruhao
 *
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (strs.length == 0) {
			return "";
		}
    	int maxLength = strs[0].length();
    	for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < strs.length; j++) {
				if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}
    	return strs[0].substring(0, maxLength);        
    }
}
