import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class CombinationSumII {

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
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
        searchAllCombinations(num, usedFlag, 0, new ArrayList<Integer>(), resultList, target);
    	return resultList;
    }
    
    public void searchAllCombinations(int[] candidates, boolean []usedFlag, int canIndex, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> resultList, int target) {
    	if (target == 0) {
			resultList.add((ArrayList<Integer>) curList.clone());
			return;
		}
    	if (canIndex >= candidates.length || candidates[canIndex] > target) {
			return;
		}
    	searchAllCombinations(candidates, usedFlag, canIndex + 1, curList, resultList, target);
    	if (canIndex > 0 && candidates[canIndex-1] == candidates[canIndex]) {
    		if (!usedFlag[canIndex - 1]) {
    			return;
			}			
		}
    	curList.add(candidates[canIndex]);
    	usedFlag[canIndex] = true;
    	searchAllCombinations(candidates, usedFlag, canIndex + 1, curList, resultList, target - candidates[canIndex]);
    	usedFlag[canIndex] = false;
    	curList.remove(curList.size() - 1);		
    }
    
    public static void main(String[] args) {
    	CombinationSumII test = new CombinationSumII();
    	int []inputs = {2, 2, 2};
    	System.out.println(test.combinationSum2(inputs, 4));
    }
}
