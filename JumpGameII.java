/**
 * 
 * @author yaoruhao
 *
 */
public class JumpGameII {

    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int curPos = A.length - 1;
        int count = 0;
        int lastPos = -1;
        while (curPos != 0) {
        	lastPos = curPos;
			for (int i = 0; i < curPos; i++) {
				if (i + A[i] >= curPos) {
					count++;
					curPos = i;
					break;
				}
			}
			if (lastPos == curPos) {
				return -1;
			}
		}
        return count;
    }
}
