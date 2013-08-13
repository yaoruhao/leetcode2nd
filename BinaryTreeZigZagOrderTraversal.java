import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class BinaryTreeZigZagOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
			return resultList;
		}
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        LinkedList<TreeNode> visitQueue = new LinkedList<TreeNode>();
        visitQueue.add(root);
        visitQueue.add(null);
        boolean reverseFlag = false;
        while (!visitQueue.isEmpty()) {
			TreeNode tempNode = visitQueue.pollFirst();
			if (tempNode != null) {
				tempList.add(tempNode.val);
				if (tempNode.left != null) {
					visitQueue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					visitQueue.add(tempNode.right);
				}
			} else {
				if (reverseFlag) {
					Collections.reverse(tempList);
				}
				resultList.add(tempList);
				reverseFlag ^= true;
				if (visitQueue.isEmpty()) {
					break;
				}
				tempList = new ArrayList<Integer>();
				visitQueue.add(null);
			}
		}        
        return resultList;
    }
}
