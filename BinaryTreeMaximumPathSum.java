/**
 * 
 * @author yaoruhao
 *
 */
public class BinaryTreeMaximumPathSum {

	int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        maxSum = Integer.MIN_VALUE;
        calculatePathSum(root);
        return maxSum;
    }
    
    public int calculatePathSum(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	int leftMax = Math.max(0, calculatePathSum(root.left));
    	int rightMax = Math.max(0, calculatePathSum(root.right));
    	maxSum = Math.max(maxSum, leftMax + rightMax + root.val);
    	return  Math.max(0, Math.max(leftMax, rightMax)) + root.val;
    }
}
