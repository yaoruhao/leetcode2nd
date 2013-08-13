import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board.length == 0 || board[0].length == 0) {
			return;
		}
        HashMap<String, Boolean> cacheMap = new HashMap<String, Boolean>();
        HashSet<String> visitSet = new HashSet<String>();
        for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[i].length - 1; j++) {
				if (board[i][j] == 'O') {
					solveMatrix(board, i, j, cacheMap, visitSet);
				}
			}
		}
    }
    
    public boolean solveMatrix(char[][] board, int i, int j, HashMap<String, Boolean> cacheMap, HashSet<String> visitSet) {
    	if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
			if (board[i][j] == 'X') {
				return true;
			} else {
				return false;
			}
		}
    	if (board[i][j] == 'X') {
			return true;
		}
    	String cacheKey = i + ":" + j;
    	visitSet.add(cacheKey);
    	if (cacheMap.containsKey(cacheKey)) {
			return cacheMap.get(cacheKey);
		}
    	boolean transferFlag = true;
    	if (!visitSet.contains((i-1) + ":" + j)) {
			transferFlag &= solveMatrix(board, i - 1, j, cacheMap, visitSet);
		}
    	if (!visitSet.contains((i+1) + ":" + j)) {
			transferFlag &= solveMatrix(board, i + 1, j, cacheMap, visitSet);
		}
    	if (!visitSet.contains(i + ":" + (j-1))) {
			transferFlag &= solveMatrix(board, i, j - 1, cacheMap, visitSet);
		}
    	if (!visitSet.contains(i+ ":" + (j + 1))) {
			transferFlag &= solveMatrix(board, i, j + 1, cacheMap, visitSet);
		}
    	cacheMap.put(cacheKey, transferFlag);
    	if (transferFlag) {
			board[i][j] = 'X';
		}
    	return transferFlag;
    }
}
