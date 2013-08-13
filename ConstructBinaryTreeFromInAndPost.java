/**
 * 
 * @author yaoruhao
 *
 */
public class ConstructBinaryTreeFromInAndPost {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        
    }
    
    public TreeNode buildTree(int [] inorder, int iLeft, int iRight, int []postorder, int pLeft, int pRight) {
    	if (iLeft > iRight || pLeft > pRight) {
			return null;
		}
    	TreeNode root = new TreeNode(postorder[pRight]);
    	for (int i = iLeft; i <= iRight ; i++) {
			if (inorder[i] == postorder[pRight]) {
				root.left = buildTree(inorder, iLeft, i - 1, postorder, pLeft, pLeft + i - iLeft - 1);
				root.right = buildTree(inorder, i + 1, iRight, postorder, pLeft + i - iLeft, pRight - 1);
			}
		}
    	return root;
    }
}
