/**
 * 
 * @author yaoruhao
 *
 */
public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        while (root != null) {
            TreeLinkNode nextLevel = null;
            TreeLinkNode preNode = null;
            for (; root != null; root = root.next) {
            	if (nextLevel == null) {
					nextLevel = root.left != null? root.left : root.right;
				}
            	if (root.left != null) {
					if (preNode == null) {
						preNode = root.left;
					} else {
						preNode.next = root.left;
						preNode = preNode.next;
					}
				}
            	if (root.right != null) {
					if (preNode == null) {
						preNode = root.right;
					} else {
						preNode.next = root.right;
						preNode = preNode.next;
					}
				}
            }
            root = nextLevel;
		}
    }
}
