import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3) {
			return resultList;
		}
        Arrays.sort(num);
        HashSet<String> resultCache = new HashSet<String>();
        for (int i = 0; i < num.length - 2; i++) {
			int target = 0 - num[i];
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right];
				if (sum == target) {
					ArrayList<Integer> tempList = new ArrayList<Integer>();
					tempList.add(num[i]);
					tempList.add(num[left]);
					tempList.add(num[right]);
					if (!resultCache.contains(tempList.toString())) {
						resultList.add(tempList);
						resultCache.add(tempList.toString());
					}
					left++;
					right--;
					continue;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}        
        return resultList;
    }

}
