import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author yaoruhao
 *
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (lists.isEmpty()) {
			return null;
		}
        if (lists.size() == 1) {
			return lists.get(0);
		}
        ListNode head = null;
        ListNode p = null;
        PriorityQueue<ListNode> pqueue = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());
        for (int i = 0; i < lists.size(); i++) {
        	if (lists.get(i) != null) {
        		pqueue.add(lists.get(i));
			}			
		}
        while (!pqueue.isEmpty()) {
			ListNode tempNode = pqueue.poll();
			if (head == null) {
				head = tempNode;
				p = head;
			} else {
				p.next = tempNode;
				p = tempNode;
			}
			if (tempNode.next != null) {
				pqueue.add(tempNode.next);
			}
		}        
        return head;
    }
    
    public class ListNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			// TODO Auto-generated method stub
			return o1.val - o2.val;
		}
    	
    }
}
