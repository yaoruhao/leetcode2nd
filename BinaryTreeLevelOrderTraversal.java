import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class BinaryTreeLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
    	if (root == null) {
			return resultList;
		}
    	LinkedList<TreeNode> visitQueue = new LinkedList<TreeNode>();
    	visitQueue.add(root);
    	visitQueue.add(null);
    	ArrayList<Integer> tempList = new ArrayList<Integer>();
    	while (!visitQueue.isEmpty()) {
			TreeNode tempNode = visitQueue.getFirst();
			visitQueue.removeFirst();
			if (tempNode == null) {
				resultList.add(tempList);
				if (!visitQueue.isEmpty()) {
					visitQueue.add(null);
					tempList = new ArrayList<Integer>();
				} else {
					break;
				}
			} else {
				tempList.add(tempNode.val);
				if (tempNode.left != null) {
					visitQueue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					visitQueue.add(tempNode.right);
				}
			}
		}
        return resultList;
    }
}
