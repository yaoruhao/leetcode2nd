import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class GenerateParenthese {

    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String> resultList = new ArrayList<String>();
    	if (n == 0) {
			return resultList;
		}
    	findAllParenthese(n, 0, new StringBuilder(), resultList);
    	return resultList;
    }
    
    public void findAllParenthese(int left, int curOpen, StringBuilder prefix, ArrayList<String> resultList) {
    	if (left == 0) {
			for (int i = 0; i < curOpen; i++) {
				prefix.append(")");
			}
			resultList.add(prefix.toString());
			for (int i = 0; i < curOpen; i++) {
				prefix.deleteCharAt(prefix.length() - 1);
			}
			return;
		}
		prefix.append("(");
		findAllParenthese(left - 1, curOpen + 1, prefix, resultList);
		prefix.deleteCharAt(prefix.length() - 1);
		if (curOpen > 0) {
			prefix.append(")");
			findAllParenthese(left, curOpen - 1, prefix, resultList);
			prefix.deleteCharAt(prefix.length() - 1);
		}
    }
}
