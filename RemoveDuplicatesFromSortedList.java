/**
 * 
 * @author yaoruhao
 *
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
			return head;
		}
        ListNode p = head;
        while (p.next != null) {
			if (p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}        
        return head;
    }
}
