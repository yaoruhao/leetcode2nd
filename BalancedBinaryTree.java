/**
 * 
 * @author yaoruhao
 *
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (checkBalanced(root) != -1) {
			return true;
		} else {
			return false;
		}
    }
    
    public int checkBalanced(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	int leftCheck = checkBalanced(root.left);
    	if (leftCheck == -1) {
			return -1;
		}
    	int rightCheck = checkBalanced(root.right);
    	if (rightCheck == -1) {
			return -1;
		}
    	if (Math.abs(leftCheck - rightCheck) > 1) {
			return -1;
		}
    	return Math.max(leftCheck, rightCheck) + 1;
    }
}
