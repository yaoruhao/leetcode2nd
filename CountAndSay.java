/**
 * 
 * @author yaoruhao
 *
 */
public class CountAndSay {

    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0) {
			return null;
		}
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        while (n > 1) {
			int count = 1;
			StringBuilder temp = new StringBuilder();
			for (int i = 1; i < sb.length(); i++) {
				if (sb.charAt(i) == sb.charAt(i-1)) {
					count++;
				} else {
					temp.append(count);
					temp.append(sb.charAt(i - 1));
					count = 1;
				}
			}
        	temp.append(count);
        	temp.append(sb.charAt(sb.length() - 1));
        	sb = temp;
        	n--;
		}        
        return sb.toString();
    }
}
