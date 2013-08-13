import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PathSumII {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
			return resultList;
		}
        searchAllPath(root, sum, new ArrayList<Integer>(), resultList);
        return resultList;
    }
    
    public void searchAllPath(TreeNode root, int sum, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> resultList) {
    	if (root == null) {
			return;
		}
    	if (root.left == null && root.right == null && root.val == sum) {
			curList.add(root.val);
			resultList.add((ArrayList<Integer>) curList.clone());
			curList.remove(curList.size() - 1);
			return;
		}
    	curList.add(root.val);
    	searchAllPath(root.left, sum - root.val, curList, resultList);
    	searchAllPath(root.right, sum - root.val, curList, resultList);
    	curList.remove(curList.size() - 1);
    }
}
