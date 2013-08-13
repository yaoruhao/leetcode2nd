/**
 * 
 * @author yaoruhao
 *
 */
public class SQRT {

    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x <= 1) {
			return x;
		}
        int mid = x/2;
        while (mid * mid > x || mid > 46340) {
			mid = (mid + x/mid)/2;
		}
        return mid;
    }
}
