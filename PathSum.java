/**
 * 
 * @author yaoruhao
 *
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
			return false;
		}
        if (root.left == null && root.right == null) {
			if (sum == root.val) {
				return true;
			} else {
				return false;
			}
		}
        if (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)) {
			return true;
		} else {
			return false;
		}
    }
}
