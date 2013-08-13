import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
			return resultList;
		}
        LinkedList<TreeNode> visitList = new LinkedList<TreeNode>();
        visitList.add(root);
        visitList.add(null);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        while (!visitList.isEmpty()) {
			TreeNode tempNode = visitList.pollFirst();
			if (tempNode != null) {
				tempList.add(tempNode.val);
				if (tempNode.left != null) {
					visitList.add(tempNode.left);
				}
				if (tempNode.right != null) {
					visitList.add(tempNode.right);
				}
			} else {
				resultList.add(tempList);
				if (visitList.isEmpty()) {
					break;
				}
				visitList.add(null);
				tempList = new ArrayList<Integer>();
			}
		}
        Collections.reverse(resultList);
        return resultList;
    }

}
