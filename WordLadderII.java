import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class WordLadderII {

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
    	if (start.equals(end)) {
			ArrayList<String> tempList = new ArrayList<String>();
			tempList.add(start);
			resultList.add(tempList);
			return resultList;
		}
    	HashMap<String, HashSet<String>> transferMap = new HashMap<String, HashSet<String>>();
    	transferMap.put(start, null);
    	LinkedList<String> bfsList = new LinkedList<String>();
    	bfsList.add(start);
    	bfsList.add(null);
    	HashSet<String> curSet = new HashSet<String>();
    	curSet.add(start);
    	HashSet<String> lastSet = new HashSet<String>();
    	while (!bfsList.isEmpty()) {
			String tempStr = bfsList.pollFirst();
			if (tempStr == null) {
				for (String curStr : curSet) {
					HashSet<String> adjentSet = new HashSet<String>();
					ArrayList<String> adjentList = transferList(curStr);
					for (String lastStr : adjentList) {
						if (lastSet.contains(lastStr)) {
							adjentSet.add(lastStr);
						}
					}
					transferMap.put(curStr, adjentSet);				
					if (end.equals(curStr)) {
						ArrayList<String> tempList = new ArrayList<String>();
						tempList.add(curStr);
						getResult(curStr, start, tempList, resultList, transferMap, dict);
						return resultList;
					}
					if (dict.contains(curStr) && !bfsList.contains(curStr)) {
						bfsList.add(curStr);
					}
				}
				if (bfsList.isEmpty()) {
					return resultList;
				}
				lastSet = curSet;
				curSet = new HashSet<String>();
				bfsList.add(null);
			} else {
				lastSet.add(tempStr);
				ArrayList<String> adjentList = transferList(tempStr);
				for (String str : adjentList) {
					if (!transferMap.containsKey(str)) {
						curSet.add(str);
					}
				}
			}
		}
    	return resultList;
    }
    
    public void getResult(String start, String end, ArrayList<String> curList, ArrayList<ArrayList<String>> resultList, HashMap<String, HashSet<String>> transferMap, HashSet<String> dict) {
    	if (start.equals(end)) {
    		for (int i = 1; i < curList.size() - 1; i++) {
				if (!dict.contains(curList.get(i))) {
					return;
				}
			}
			ArrayList<String> tempList = new ArrayList<String>();
			tempList.addAll(curList);
			Collections.reverse(tempList);
			resultList.add(tempList);
			return;
		}
    	
    	HashSet<String> tempSet = transferMap.get(start);
    	for (String eachStr : tempSet) {
			curList.add(eachStr);
			getResult(eachStr, end, curList, resultList, transferMap, dict);
			curList.remove(curList.size() - 1);
		}
    }
    
    public ArrayList<String> transferList(String str) {
    	ArrayList<String> resultList = new ArrayList<String>();
    	for (int i = 0; i < str.length(); i++) {
			for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
				if (alphabet != str.charAt(i)) {
					StringBuilder sb = new StringBuilder(str);
					sb.setCharAt(i, alphabet);
					resultList.add(sb.toString());
				}
				
			}
		}
    	return resultList;
    }
}
