import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 *
 */
public class MinimumWindowSubstring {

    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character, Integer> statMap = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
			char tempChar = T.charAt(i);
			if (statMap.containsKey(tempChar)) {
				statMap.put(tempChar, statMap.get(tempChar) + 1);
			} else {
				statMap.put(tempChar, 1);
			}
		}
        int count = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> findMap = new HashMap<Character, Integer>();
        String result = "";
        for (; right < S.length(); right++) {
        	char tempChar = S.charAt(right);
        	if (!statMap.containsKey(tempChar)) {
				continue;
			}
        	if (findMap.containsKey(tempChar)) {
				findMap.put(tempChar, findMap.get(tempChar) + 1);
				if (findMap.get(tempChar) <= statMap.get(tempChar)) {
					count++;
				}
			} else {
				findMap.put(tempChar, 1);
				count++;
			}
        	if (count >= T.length()) {
				for (; left <= right; left++) {
					char leftChar = S.charAt(left);
					if (!statMap.containsKey(leftChar)) {
						continue;
					}
					if (findMap.get(leftChar) <= statMap.get(leftChar)) {
						String tempWindow = S.substring(left, right + 1);
						if (result.isEmpty()) {
							result = tempWindow;
						} else if (result.length() > tempWindow.length()) {
							result = tempWindow;
						}
						break;
					} else {
						findMap.put(leftChar, findMap.get(leftChar) - 1);
					}
				}
			}
        }
        return result;
    }
}
