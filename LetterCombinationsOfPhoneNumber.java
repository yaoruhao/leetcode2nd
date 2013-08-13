import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class LetterCombinationsOfPhoneNumber {

    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String> resultList = new ArrayList<String>();
    	if (digits.isEmpty()) {
    		resultList.add("");
			return resultList;
		}
    	searchCombinations(digits, 0, new StringBuilder(), resultList);
    	return resultList;        
    }
    
    public void searchCombinations(String digits, int index, StringBuilder prefix, ArrayList<String> resultList) {
    	if (index == digits.length()) {
			resultList.add(prefix.toString());
			return;
		}
    	String []digitToLetter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	int curDigit = digits.charAt(index) - '0';
    	if (curDigit <= 1) {
			searchCombinations(digits, index + 1, prefix, resultList);
		} else {
	    	for (int i = 0; i < digitToLetter[curDigit].length(); i++) {
				prefix.append(digitToLetter[curDigit].charAt(i));
				searchCombinations(digits, index + 1, prefix, resultList);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		}
    }
}
