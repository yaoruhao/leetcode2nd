/**
 * 
 * @author yaoruhao
 *
 */
public class ConstructBinaryTreeFromPreAndIn {
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int []preorder, int pLeft, int pRight, int []inorder, int iLeft, int iRight) {
    	if (pLeft > pRight || iLeft > iRight) {
			return null;
		}
    	TreeNode root = new TreeNode(preorder[pLeft]);
    	for (int i = iLeft; i <= iRight; i++) {
			if (inorder[i] == preorder[pLeft]) {
				root.left = buildTree(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1);
				root.right = buildTree(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight);
			}
		}    	
    	return root;
    }
}
