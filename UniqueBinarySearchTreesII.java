import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class UniqueBinarySearchTreesII {

    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<TreeNode> resultList = new ArrayList<TreeNode>();
    	if (n <= 0) {
    		resultList.add(null);
			return resultList;
		}
        return generateAllBST(1, n);
    }
    
    public ArrayList<TreeNode> generateAllBST(int left, int right) {
    	ArrayList<TreeNode> rootList = new ArrayList<TreeNode>();
    	if (left > right) {
			rootList.add(null);
			return rootList;
		}
    	if (left == right) {
			rootList.add(new TreeNode(left));
			return rootList;
		}
    	for (int i = left; i <= right; i++) {
			ArrayList<TreeNode> leftChildList = generateAllBST(left, i - 1);
			ArrayList<TreeNode> rightChildList = generateAllBST(i + 1, right);
			for (int j = 0; j < leftChildList.size(); j++) {
				for (int k = 0; k < rightChildList.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = leftChildList.get(j);
					root.right = rightChildList.get(k);
					rootList.add(root);
				}
			}
		}
    	return rootList;
    }
}
