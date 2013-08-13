/**
 * 
 * @author yaoruhao
 *
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return checkValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean checkValidBST(TreeNode root, int leftBound, int rightBound) {
    	if (root == null) {
			return true;
		}
    	if (root.val <= leftBound || root.val >= rightBound) {
			return false;
		}
    	if (checkValidBST(root.left, leftBound, root.val) && checkValidBST(root.right, root.val, rightBound)) {
			return true;
		} else {
			return false;
		}
    }
}
