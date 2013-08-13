import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (root == null) {
			return 0;
		}
    	int []result = new int[1];
    	calculateSumNumbers(root, new ArrayList<Integer>(), result);
    	return result[0];
    }
    
    public void calculateSumNumbers(TreeNode root, ArrayList<Integer> pathNum, int []result) {
    	if (root.left == null && root.right == null) {
			int curSum = 0;
			for (int i = 0; i < pathNum.size(); i++) {
				curSum += pathNum.get(i);
				curSum *= 10;
			}
			curSum += root.val;
			result[0] += curSum;
			return;
		}    	
    	pathNum.add(root.val);
    	if (root.left != null) {
			calculateSumNumbers(root.left, pathNum, result);
		}
    	if (root.right != null) {
			calculateSumNumbers(root.right, pathNum, result);
		}
    	pathNum.remove(pathNum.size() - 1);
    }
}
