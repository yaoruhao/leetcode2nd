import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
    	if (candidates.length == 0) {
			return resultList;
		}
        Arrays.sort(candidates);
        searchAllCombinations(candidates, 0, new ArrayList<Integer>(), resultList, target);
    	return resultList;
    }
    
    public void searchAllCombinations(int[] candidates, int canIndex, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> resultList, int target) {
    	if (target == 0) {
			resultList.add((ArrayList<Integer>) curList.clone());
			return;
		}
    	if (canIndex >= candidates.length || candidates[canIndex] > target) {
			return;
		}
    	searchAllCombinations(candidates, canIndex + 1, curList, resultList, target);
    	int count = 0;
    	while (target >= candidates[canIndex]) {
			curList.add(candidates[canIndex]);
			target -= candidates[canIndex];
			searchAllCombinations(candidates, canIndex + 1, curList, resultList, target);
			count++;
		}
    	while (count-- > 0) {
			curList.remove(curList.size() - 1);
		}    	
    }
}
