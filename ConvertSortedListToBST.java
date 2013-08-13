/**
 * 
 * @author yaoruhao
 *
 */
public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
			return null;
		}
        if (head.next == null) {
			return new TreeNode(head.val);
		}
        ListNode p = head;
        ListNode q = head.next;
        while (q != null && q.next != null) {
			q = q.next.next;
			if (q == null || q.next == null) {
				break;
			}
			p = p.next;
		}
        TreeNode root = new TreeNode(p.next.val);
        root.right = sortedListToBST(p.next.next);
        p.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
