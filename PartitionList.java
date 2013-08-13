/**
 * 
 * @author yaoruhao
 *
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
			return head;
		}
        ListNode smallNodes = null;
        ListNode largeNodes = null;
        ListNode largeHead = null;
        ListNode p = head;
        while (p != null) {
			if (p.val < x) {
				if (smallNodes == null) {
					smallNodes = p;
					head = smallNodes;
				} else {
					smallNodes.next = p;
					smallNodes = smallNodes.next;
				}
			} else {
				if (largeNodes == null) {
					largeNodes = p;
					largeHead = largeNodes;
				} else {
					largeNodes.next = p;
					largeNodes = largeNodes.next;
				}
			}
			p = p.next;
		}
        if (smallNodes != null) {
        	smallNodes.next = largeHead;
		}
        if (largeNodes != null) {
			largeNodes.next = null;
		}
        return head;
    }
}
