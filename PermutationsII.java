import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) {
			return resultList;
		}
        Arrays.sort(num);
        boolean []usedFlag = new boolean[num.length];
        for (int i = 0; i < usedFlag.length; i++) {
			usedFlag[i] = false;
		}
        generatePermutations(num, num.length, usedFlag, new ArrayList<Integer>(num.length), resultList);
        return resultList;
    }
    
    public void generatePermutations(int[] num, int leftNum, boolean[] usedFlag, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> resultList) {
    	if (leftNum == 0) {
			resultList.add((ArrayList<Integer>) curList.clone());
			return;
		}    	
    	for (int i = 0; i < num.length; i++) {
			if (usedFlag[i]) {
				continue;
			}
			if (i != 0 && num[i] == num[i-1] && !usedFlag[i-1]) {
				continue;
			}
			usedFlag[i] = true;
			curList.add(num[i]);
			generatePermutations(num, leftNum - 1, usedFlag, curList, resultList);
			curList.remove(curList.size() - 1);
			usedFlag[i] = false;
		}
    }
}
