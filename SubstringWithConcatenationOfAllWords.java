import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 *
 */
public class SubstringWithConcatenationOfAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if (L.length == 0 || S.isEmpty()) {
			return resultList;
		}
        HashMap<String, Integer> dictMap = new HashMap<String, Integer>();
        for (String str : L) {
			if (!dictMap.containsKey(str)) {
				dictMap.put(str, 1);
			} else {
				dictMap.put(str, dictMap.get(str) + 1);
			}
		}
        int len = L[0].length();
        for (int i = 0; i < S.length(); i++) {
			if (len * L.length > S.length() - i) {
				break;
			}
			HashMap<String, Integer> tempMap = (HashMap<String, Integer>) dictMap.clone();
			boolean matchFlag = true;
			for (int j = i; j < S.length(); j += len) {
				String subStr = S.substring(j, j + len);
				if (!tempMap.containsKey(subStr)) {
					matchFlag = false;
					break;
				}
				int count = tempMap.get(subStr);
				count--;
				if (count == 0) {
					tempMap.remove(subStr);
				} else {
					tempMap.put(subStr, count);
				}
				if (tempMap.isEmpty()) {
					break;
				}
			}
			if (matchFlag) {
				resultList.add(i);
			}
		}
        return resultList;
    }
}
