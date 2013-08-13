/**
 * 
 * @author yaoruhao
 *
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for (int i = s.length() - 1; i >= 0; i--) {
			if (Character.isLetter(s.charAt(i))) {
				int count = 1;
				for (int j = i - 1; j >= 0; j--) {
					if (!Character.isLetter(s.charAt(j))) {
						break;
					}
					count++;
				}
				return count;
			}
		}    	
    	return 0;
    }
}
