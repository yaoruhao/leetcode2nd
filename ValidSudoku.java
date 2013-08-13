import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	HashSet<Integer> cacheSet = new HashSet<Integer>();
        for (int i = 0; i < board.length; i++) {
			cacheSet.clear();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					if (cacheSet.contains(num)) {
						return false;
					}
					cacheSet.add(num);
				}
			}
		}
        for (int j = 0; j < board[0].length; j++) {
			cacheSet.clear();
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					if (cacheSet.contains(num)) {
						return false;
					}
					cacheSet.add(num);
				}
			}
		}
        for (int block = 0; block < 9; block++) {
			cacheSet.clear();
			for (int i = block/3 * 3; i < block/3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						int num = board[i][j] - '0';
						if (cacheSet.contains(num)) {
							return false;
						}
						cacheSet.add(num);
					}
				}
			}
		}
    	return true;
    }
}
