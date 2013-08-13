/**
 * 
 * @author yaoruhao
 *
 */
public class ConvertSortedArrayToBST {
	
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildBST(num, 0, num.length - 1);
    }
    
    public TreeNode buildBST(int[] num, int left, int right) {
    	if (left > right) {
			return null;
		}
    	if (left == right) {
			return new TreeNode(num[left]);
		}
    	int mid = (left + right) / 2;
    	TreeNode root = new TreeNode(num[mid]);
    	root.left = buildBST(num, left, mid - 1);
    	root.right = buildBST(num, mid + 1, right);
    	return root;
    }

}
