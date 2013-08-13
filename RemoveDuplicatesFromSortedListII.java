/**
 * 
 * @author yaoruhao
 *
 */
public class RemoveDuplicatesFromSortedListII {
	
    public ListNode deleteDuplicates(ListNode head) {
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
        	if (q.next.val != q.val) {
				p.next = q;
				p = p.next;
				q = q.next;
			} else {
				int tempVal = q.val;
				while (q != null && q.val == tempVal) {
					q = q.next;
				}				
			}
		}
        p.next = q;
        return head.next;
    }

}
