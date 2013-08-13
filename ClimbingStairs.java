/**
 * 
 * @author yaoruhao
 *
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 1) {
			return 1;
		}
        int []cache = new int [n + 1];
        cache[n] = 1;
        for (int i = n - 1; i > 0; i--) {
			cache[i] += cache[i + 1];
			if (i + 2 < n) {
				cache[i] += cache[i + 2];
			} else {
				cache[i]++;
			}
		}
        return cache[1];
    }
}
