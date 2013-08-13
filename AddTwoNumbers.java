/**
 * 
 * @author yaoruhao
 *
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null) {
			return l2;
		}
        if (l2 == null) {
        	return l1;
        }
        ListNode p = l1;
        ListNode q = l2;
        p.val += q.val;
        while (p.next != null && q.next != null) {
			p = p.next;
			q = q.next;
			p.val += q.val;
		}
        if (p.next == null) {
			p.next = q.next;
		}
        p = l1;
        while (p != null) {
			if (p.val > 9) {
				p.val -= 10;
				if (p.next != null) {
					p.next.val += 1;
				} else {
					p.next = new ListNode(1);
					break;
				}				
			}
			p = p.next;
		}
        return l1;
    }
}
