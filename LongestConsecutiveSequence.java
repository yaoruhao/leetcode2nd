import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 *
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num.length == 0) {
			return 0;
		}
        int result = 1;
        HashMap<Integer, Boolean> cacheMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < num.length; i++) {
			cacheMap.put(num[i], true);
		}
        for (int key : cacheMap.keySet()) {
			if (cacheMap.get(key)) {
				cacheMap.put(key, false);
				int temp = 1;
				int left = key - 1;
				while (cacheMap.containsKey(left) && cacheMap.get(left)) {
					cacheMap.put(left--, false);
					temp++;
				}
				int right = key + 1;
				while (cacheMap.containsKey(right) && cacheMap.get(right)) {
					cacheMap.put(right++, false);
					temp++;
				}
				result = Math.max(result, temp);
			}
		}
        return result;
    }
}
