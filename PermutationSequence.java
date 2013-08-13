import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int []gap = new int[11];
    	gap[0] = 1;
    	gap[1] = 1;
    	for (int i = 1; i < gap.length; i++) {
			gap[i] = i * gap[i - 1];
		}
    	StringBuilder sb = new StringBuilder();
    	ArrayList<Integer> digitList = new ArrayList<Integer>();
    	for (int i = 1; i <= n; i++) {
			digitList.add(i);
		}
    	k--;
    	for (int i = n; i >= 1; i--) {
			int choice = k / gap[i-1];
			sb.append(digitList.get(choice));
			digitList.remove(choice);
			k %= gap[i-1];
		}
    	return sb.toString();        
    }
}
