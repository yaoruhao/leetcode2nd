/**
 * 
 * @author yaoruhao
 *
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (root == null) {
			return 0;
		}
    	if (root.left == null && root.right == null) {
			return 1;
		}
    	if (root.left == null) {
			return 1 + minDepth(root.right);
		}
    	if (root.right == null) {
			return 1 + minDepth(root.left);
		}
    	return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
