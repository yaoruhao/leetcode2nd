/**
 * 
 * @author yaoruhao
 *
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
			return true;
		}
        return checkSymmetric(root.left, root.right);
    }
    
    public boolean checkSymmetric(TreeNode left, TreeNode right) {
    	if (left == null && right == null) {
			return true;
		}
    	if (left == null || right == null || left.val != right.val) {
			return false;
		}
    	if (checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left)) {
			return true;
		}
    	return false;
    }
}
