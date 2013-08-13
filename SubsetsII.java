import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class SubsetsII {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        resultList.add(new ArrayList<Integer>());
        if (num.length == 0) {
			return resultList;
		}
        Arrays.sort(num);
        int []choiceBit = new int[num.length];
        int []uniqueNum = new int[num.length];
        uniqueNum[0] = num[0];
        choiceBit[0] = 1;
        int uniqueTotal = 0;
        for (int i = 1; i < num.length; i++) {
			if (num[i] != uniqueNum[uniqueTotal]) {
				uniqueNum[++uniqueTotal] = num[i];
				choiceBit[uniqueTotal] = 1;
			} else {
				choiceBit[uniqueTotal]++;
			}
		}
        uniqueTotal++;
        int []iter = new int[uniqueTotal];
        while (true) {
        	iter[0]++;
        	for (int i = 0; i < iter.length; i++) {
				if (iter[i] > choiceBit[i]) {
					iter[i] = 0;
					iter[i+1]++;
				} else {
					break;
				}
			}
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			for (int i = 0; i < iter.length; i++) {
				if (iter[i] > 0) {
					for (int j = 0; j < iter[i]; j++) {
						tempList.add(uniqueNum[i]);
					}
				}
			}
			resultList.add(tempList);
			if (tempList.size() == num.length) {
				break;
			}
		}        
        return resultList;
    }
}
