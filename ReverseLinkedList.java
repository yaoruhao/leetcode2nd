/**
 * 
 * @author yaoruhao
 *
 */
public class ReverseLinkedList {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null || m == n) {
			return head;
		}
        ListNode mNode = new ListNode(Integer.MAX_VALUE);
        mNode.next = head;
        head = mNode;
        for (int i = 1; i < m; i++) {
			mNode = mNode.next;
		}
        ListNode nNode = mNode;
        for (int i = 0; i <= n - m; i++) {
			nNode = nNode.next;
		}
        ListNode prev = mNode;
        mNode = mNode.next;
        prev.next = nNode;
        prev = mNode;
        ListNode cur = mNode.next;
        mNode.next = nNode.next;
        while (prev != nNode) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
        return head.next;
    }
}
