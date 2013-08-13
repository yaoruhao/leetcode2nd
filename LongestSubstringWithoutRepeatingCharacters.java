import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        HashMap<Character, Integer> cacheMap = new HashMap<Character, Integer>();
        int current = 0;
        int validPos = 0;
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (cacheMap.containsKey(c) && cacheMap.get(c) >= validPos) {
				validPos = cacheMap.get(c) + 1;
				if (current > result) {
					result = current;
				}
				current = i - validPos + 1;
			} else {
				current++;
			}
			cacheMap.put(c, i);
		}
        if (result < current) {
			result = current;
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		test.lengthOfLongestSubstring("abcabcde");
	}

}
