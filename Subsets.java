import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        resultList.add(new ArrayList<Integer>());
        if (S.length == 0) {
        	return resultList;		
        }
        int []choice = new int [S.length];
        Arrays.sort(S);
        while (true) {
			boolean exitFlag = true;
			choice[0]++;
			for (int i = 0; i < choice.length - 1; i++) {
				if (choice[i] > 1) {
					choice[i] = 0;
					choice[i + 1]++;
				} else {
					break;
				}
			}
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			for (int i = 0; i < choice.length; i++) {
				if (choice[i] == 0) {
					exitFlag = false;
				} else {
					tempList.add(S[i]);
				}
			}
			resultList.add(tempList);
			if (exitFlag) {
				break;
			}
		}        
        return resultList;
    }
}
