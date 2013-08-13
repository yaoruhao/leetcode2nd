import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (word.isEmpty() || board.length == 0 || board[0].length == 0) {
			return false;
		}
        HashSet<String> visitSet = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					visitSet.clear();
					visitSet.add(i + ":" + j);
					if (exist(board, word, 1, i, j, visitSet)) {
						return true;
					}
				}
			}
		}
        return false;
    }
    
    public boolean exist(char[][] board, String word, int index, int i, int j, HashSet<String> visitSet) {
    	if (index >= word.length()) {
			return true;
		}
    	if (i-1 >= 0 && word.charAt(index) == board[i-1][j] &&!visitSet.contains((i-1) + ":" + j)) {
    		visitSet.add((i-1) + ":" + j);
    		if (exist(board, word, index + 1, i - 1, j, visitSet)) {
				return true;
			}
    		visitSet.remove((i-1) + ":" + j);
    	}
    	if (i + 1 < board.length && word.charAt(index) == board[i+1][j] && !visitSet.contains((i+1) + ":" + j)) {
			visitSet.add((i+1) + ":" + j);
			if (exist(board, word, index + 1, i + 1, j, visitSet)) {
				return true;
			}
			visitSet.remove((i+1) + ":" + j);
		}
    	if (j-1 >= 0 && word.charAt(index) == board[i][j-1] &&!visitSet.contains(i + ":" + (j-1))) {
    		visitSet.add(i + ":" + (j-1));
    		if (exist(board, word, index + 1, i, j - 1, visitSet)) {
				return true;
			}
    		visitSet.remove(i + ":" + (j-1));
    	}
    	if (j+1 < board[0].length && word.charAt(index) == board[i][j+1] &&!visitSet.contains(i + ":" + (j+1))) {
    		visitSet.add(i + ":" + (j+1));
    		if (exist(board, word, index + 1, i, j + 1, visitSet)) {
				return true;
			}
    		visitSet.remove(i + ":" + (j+1));
    	}
    	return false;
    }
}
