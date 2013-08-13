import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 *
 */
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> resultList = new ArrayList<String>();
        if (strs.length == 0) {
			return resultList;
		}
        HashMap<String, ArrayList<String>> cacheMap = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
			String fp = getFingerPrint(str);
			if (cacheMap.containsKey(fp)) {
				cacheMap.get(fp).add(str);
			} else {
				ArrayList<String> tempList = new ArrayList<String>();
				tempList.add(str);
				cacheMap.put(fp, tempList);
			}
		}
        for (ArrayList<String> tempList : cacheMap.values()) {
			if (tempList.size() > 1) {
				resultList.addAll(tempList);
			}
		}
        return resultList;
    }
    
    public String getFingerPrint(String s){
    	int []alphabet = new int[26];
    	for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
		}
    	ArrayList<Integer> tempList = new ArrayList<Integer>(26);
    	for (int i = 0; i < alphabet.length; i++) {
			tempList.add(alphabet[i]);
		}
    	return tempList.toString();
    }
}
