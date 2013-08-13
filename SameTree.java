/**
 * 
 * @author yaoruhao
 *
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (p == null && q == null) {
			return true;
		}
        if (p == null || q == null || p.val != q.val) {
			return false;
		}
        if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
			return true;
		}
        return false;
    }
}
