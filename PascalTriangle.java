import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0) {
			return resultList;
		}
        for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			tempList.add(1);
			if (i == 0) {
				resultList.add(tempList);
				continue;
			}
			if (i > 1) {
				ArrayList<Integer> lastList = resultList.get(resultList.size() - 1);
				for (int j = 0; j < lastList.size() - 1; j++) {
					tempList.add(lastList.get(j) + lastList.get(j + 1));
				}
			}
			tempList.add(1);
			resultList.add(tempList);
		}
        return resultList;
    }
}
