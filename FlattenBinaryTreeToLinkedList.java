/**
 * 
 * @author yaoruhao
 *
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        flattenBinaryTree(root);
    }
    
    public TreeNode flattenBinaryTree(TreeNode root) {
    	if (root == null) {
			return null;
		}
    	TreeNode leftNode = flattenBinaryTree(root.left);
    	TreeNode rightNode = flattenBinaryTree(root.right);
    	root.right = leftNode;
    	root.left = null;
    	TreeNode temp = root;
    	while (temp.right != null) {
			temp = temp.right;
		}
    	temp.right = rightNode;
    	return root;
    }
    
    public static void main(String []args) {
    	FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	test.flatten(root);
    }
}
