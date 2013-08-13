/**
 * 
 * @author yaoruhao
 *
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
			return head;
		}
        ListNode p = new ListNode(Integer.MAX_VALUE);
        p.next = head;
        head = p;
        ListNode q = p.next;
        while (q != null && q.next != null) {
			p.next = q.next;
			q.next = q.next.next;
			p.next.next = q;
			p = q;
			q = q.next;
		}    	
    	return head.next;
    }
}
