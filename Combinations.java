import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (k <= 0 || k > n) {
			return resultList;
		}
        searchAllCombinations(n, k, new ArrayList<Integer>(k), resultList);
        return resultList;
    }
    
    public void searchAllCombinations(int n, int k, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> resultList) {
    	if (curList.size() == k) {
			resultList.add((ArrayList<Integer>) curList.clone());
			return;
		}
    	int start = 1;
    	if (!curList.isEmpty()) {
			start = curList.get(curList.size() - 1) + 1;
		}
    	if (k - curList.size() > n - start + 1) {
			return;
		}
    	for (int i = start; i <= n; i++) {
			if (curList.contains(i)) {
				continue;
			}
			curList.add(i);
			searchAllCombinations(n, k, curList, resultList);
			curList.remove(curList.size() - 1);
		}
    }
}
