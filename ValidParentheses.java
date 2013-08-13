import java.util.Stack;

/**
 * 
 * @author yaoruhao
 *
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (s.isEmpty() || s.length() % 2 == 1) {
			return false;
		}
        Stack<Character> status = new Stack<Character>();
        status.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
        	if (s.charAt(i) == ')') {
				if (!status.isEmpty() && status.peek() == '(') {
					status.pop();
				} else {
					return false;
				}
			} else if (s.charAt(i) == ']') {
				if (!status.isEmpty() && status.peek() == '[') {
					status.pop();
				} else {
					return false;
				}
			} else if (s.charAt(i) == '}') {
				if (!status.isEmpty() && status.peek() == '{') {
					status.pop();
				} else {
					return false;
				}
			} else {
				status.push(s.charAt(i));
			}
		}        
        if (status.isEmpty()) {
			return true;
		} else {
			return false;
		}
    }
    
}
