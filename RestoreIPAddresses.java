import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class RestoreIPAddresses {

    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> resultList = new ArrayList<String>();
        if (s.length() < 4) {
			return resultList;
		}
        searchAllValidIP(s, 0, new ArrayList<String>(4), resultList);
        return resultList;
    }
    
    public void searchAllValidIP(String s, int index, ArrayList<String> curList, ArrayList<String> resultList) {
    	if (index >= s.length()) {
			if (curList.size() == 4) {
				StringBuilder sb = new StringBuilder(s.length() + 3);
				sb.append(curList.get(0));
				for (int i = 1; i < curList.size(); i++) {
					sb.append('.');
					sb.append(curList.get(i));
				}
				resultList.add(sb.toString());
			}
			return;
		}
    	if (curList.size() >= 4) {
			return;
		}
    	int minWindow = 4 - curList.size();
    	int maxWindow = (4 - curList.size()) * 3;
    	int leftLength = s.length() - index;
    	if (leftLength < minWindow || leftLength > maxWindow) {
			return;
		}
    	String tempStr = s.substring(index, index + 1);
		curList.add(tempStr);
		searchAllValidIP(s, index + 1, curList, resultList);
		curList.remove(curList.size() - 1);
		if (tempStr.equals("0")) {
			return;
		}
    	if (index + 2 <= s.length()) {
			tempStr = s.substring(index, index + 2);
			curList.add(tempStr);
			searchAllValidIP(s, index + 2, curList, resultList);
			curList.remove(curList.size() - 1);
		}
    	if (index + 3 <= s.length()) {
			tempStr = s.substring(index, index + 3);
			if (Integer.valueOf(tempStr) <= 255) {
				curList.add(tempStr);
				searchAllValidIP(s, index + 3, curList, resultList);
				curList.remove(curList.size() - 1);
			}
		}
    }
}
