/**
 * 
 * @author yaoruhao
 *
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (l1 == null) {
			return l2;
		}
    	if (l2 == null) {
			return l1;
		}
        ListNode head = null;
        ListNode p = null;
        while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				if (head == null) {
					head = l1;
					p = head;
				} else {
					p.next = l1;
					p = p.next;
				}
				l1 = l1.next;
			} else {
				if (head == null) {
					head = l2;
					p = head;
				} else {
					p.next = l2;
					p = p.next;
				}
				l2 = l2.next;
			}
		}
        if (l1 != null) {
			p.next = l1;
		}
        if (l2 != null) {
			p.next = l2;
		}        
        return head;
    }
}
