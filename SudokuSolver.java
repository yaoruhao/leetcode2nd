import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<HashSet<Integer>> rowsCache = new ArrayList<HashSet<Integer>>(9);
    	ArrayList<HashSet<Integer>> colsCache = new ArrayList<HashSet<Integer>>(9);
    	ArrayList<HashSet<Integer>> blocksCache = new ArrayList<HashSet<Integer>>(9);
    	for (int i = 0; i < 9; i++) {
			rowsCache.add(new HashSet<Integer>(9));
			colsCache.add(new HashSet<Integer>(9));
			blocksCache.add(new HashSet<Integer>(9));
		}
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				int num = board[i][j] - '0';
		    	rowsCache.get(i).add(num);
		    	colsCache.get(j).add(num);
		    	blocksCache.get(i/3 * 3 + j/3).add(num);
			}
		}
    	attempToSolve(board, rowsCache, colsCache, blocksCache);
    }
    
    public boolean attempToSolve(char [][] board, ArrayList<HashSet<Integer>> rowsCache, ArrayList<HashSet<Integer>> colsCache, ArrayList<HashSet<Integer>> blocksCache) {
    	int posX = -1;
    	int posY = -1;
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					posX = i;
					posY = j;
					break;
				}
			}
			if (posX != -1) {
				break;
			}
		}
    	if (posX == -1) {
			return true;
		}
    	HashSet<Integer> rowCache = rowsCache.get(posX);
    	HashSet<Integer> colCache = colsCache.get(posY);
    	HashSet<Integer> blockCache = blocksCache.get(posX/3 * 3 + posY/3);
    	HashSet<Integer> totalUsed = new HashSet<Integer>();
    	totalUsed.addAll(rowCache);
    	totalUsed.addAll(colCache);
    	totalUsed.addAll(blockCache);
    	for (int num = 1; num <= 9; num++) {
			if (totalUsed.contains(num)) {
				continue;
			}
			rowCache.add(num);
			colCache.add(num);
			blockCache.add(num);
			board[posX][posY] = (char) ('0' + num);
			if (attempToSolve(board, rowsCache, colsCache, blocksCache)) {
				return true;
			}
			blockCache.remove(num);
			colCache.remove(num);
			rowCache.remove(num);
		}
    	board[posX][posY] = '.';
    	return false;
    }
}
