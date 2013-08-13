/**
 * 
 * @author yaoruhao
 *
 */
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p = new ListNode(Integer.MAX_VALUE);
        p.next = head;
        head = p;
        ListNode q = p.next;
        for (int i = 1; i < n; i++) {
			q = q.next;
		}
    	while (q.next != null) {
			q = q.next;
			p = p.next;
		}
    	p.next = p.next.next;
    	return head.next;
    }
}
