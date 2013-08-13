import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PascalTriangleII {

    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> lastRound = null;
        ArrayList<Integer> curRound = null;
        for (int i = 0; i <= rowIndex; i++) {
			curRound = new ArrayList<Integer>();
			curRound.add(1);
			if (i == 0) {
				lastRound = curRound;
				continue;
			}
			if (i > 1) {
				for (int j = 0; j < lastRound.size() - 1; j++) {
					curRound.add(lastRound.get(j) + lastRound.get(j + 1));
				}
			}
			curRound.add(1);
			lastRound = curRound;
		}
        return curRound;
    }
}
