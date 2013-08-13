/**
 * 
 * @author yaoruhao
 *
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (k <= 1 || head == null || head.next == null) {
			return head;
		}
        ListNode prev = new ListNode(Integer.MAX_VALUE);
        prev.next = head;
        head = prev;
        ListNode groupEndNode = head.next;        
        while (groupEndNode != null) {
        	for (int i = 1; i < k; i++) {
				groupEndNode = groupEndNode.next;
				if (groupEndNode == null) {
					return head.next;
				}
			}
        	ListNode cur = prev.next;
        	//store group start node for next iteration
        	ListNode groupStartNode = cur;
        	//last iteration start is this iteration end
        	prev.next = groupEndNode;
        	prev = cur;
        	cur = cur.next;
        	ListNode nextNode = cur.next;
        	prev.next = groupEndNode.next;
        	//reverse linked list from prev.next to groupEndNode
        	while (cur != groupEndNode) {
				cur.next = prev;
				prev = cur;
				cur = nextNode;
				nextNode = nextNode.next;
			}
        	groupEndNode = groupEndNode.next;
        	cur.next = prev;
        	prev = groupStartNode;        	
		}        
        return head.next;
    }
}
