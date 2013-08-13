/**
 * 
 * @author yaoruhao
 *
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (head == null || head.next == null || n == 0) {
			return head;
		}
        ListNode p = head;
        int count = 1;
        while (p.next != null) {
			count++;
			p = p.next;
		}
    	n %= count;
    	if (n == 0) {
			return head;
		}
    	p = head;
    	for (int i = 1; i < count - n; i++) {
			p = p.next;
		}
        ListNode q = p.next;
        ListNode tempHead = q;
        while (q.next != null) {
			q = q.next;
		}
        q.next = head;
        p.next = null;
    	return tempHead;
    }
}
