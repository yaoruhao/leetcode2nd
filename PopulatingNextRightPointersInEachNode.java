/**
 * 
 * @author yaoruhao
 *
 */
public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null || root.left == null || root.right == null) {
			return;
		}
        root.left.next = root.right;
        if (root.next != null) {
			root.right.next = root.next.left;
		}
        connect(root.left);
        connect(root.right);
    }
}
