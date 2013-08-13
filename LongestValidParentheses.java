import java.util.Stack;

/**
 * 
 * @author yaoruhao
 *
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.isEmpty()) {
			return 0;
		}
        int maxLength = 0;
        int last = -1;
        Stack<Integer> left = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left.push(i);
			} else {
				if (left.isEmpty()) {
					last = i;
				} else {
					left.pop();
					if (left.isEmpty()) {
						maxLength = Math.max(maxLength, i - last);
					} else {
						maxLength = Math.max(maxLength, i - left.peek());
					}
				}
			}
		}
        return maxLength;
    }
}
