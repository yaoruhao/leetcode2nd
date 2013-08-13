import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class WordLadder {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (start.equals(end)) {
			return 0;
		}
        int round = 0;
        HashSet<String> visitSet = new HashSet<String>();
        LinkedList<String> bfsList = new LinkedList<String>();
        bfsList.add(start);
        bfsList.add(null);
        visitSet.add(start);
        while (!bfsList.isEmpty()) {
			String curStr = bfsList.pollFirst();
			if (curStr == null) {
				if (bfsList.isEmpty()) {
					break;
				} else {
					round++;
					bfsList.add(null);
				}
			} else {
				ArrayList<String> changeList = transferList(curStr);
				for (String eachStr : changeList) {
					if (eachStr.equals(end)) {
						return round + 1;
					}
					if (!visitSet.contains(eachStr) && dict.contains(eachStr)) {
						visitSet.add(eachStr);
						bfsList.add(eachStr);
					}
				}
			}
		}        
        return 0;
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
