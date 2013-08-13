import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author yaoruhao
 *
 */
public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if (root == null) {
			return resultList;
		}
        Stack<TreeNode> visitStack = new Stack<TreeNode>();
        while (!visitStack.isEmpty() || root != null) {
        	if (root != null) {
				visitStack.push(root);
				root = root.left;
			} else {
				root = visitStack.pop();
				resultList.add(root.val);
				root = root.right;
			}
		}        
        return resultList;
    }

}
