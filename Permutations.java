import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) {
			return resultList;
		}
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
			usedFlag[i] = true;
			curList.add(num[i]);
			generatePermutations(num, leftNum - 1, usedFlag, curList, resultList);
			curList.remove(curList.size() - 1);
			usedFlag[i] = false;
		}
    }
}
