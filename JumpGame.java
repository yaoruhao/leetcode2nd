/**
 * 
 * @author yaoruhao
 *
 */
public class JumpGame {

    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length <= 1) {
			return true;
		}
        int reach = 1;
        for (int i = 0; i < reach && reach < A.length; i++) {
			reach = Math.max(reach, A[i] + i + 1);
		}
        return reach >= A.length;
    }
}
