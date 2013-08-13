import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (dividend == 0 || divisor == 1) {
			return dividend;
		}
        if (divisor == -1) {
			return 0 - dividend;
		}
        long divd = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);
        ArrayList<Long> divisors = new ArrayList<Long>();
        while (divs <= divd) {
			divisors.add(divs);
			divs = divs << 1;
		}
        int result = 0;
        int cur = divisors.size() - 1;
        while (divd > 0 && cur >= 0) {
			while (divd >= divisors.get(cur)) {
				divd -= divisors.get(cur);
				result += 1 << cur;
			}
			cur--;
		}
        if (dividend > 0 ^ divisor > 0) {
			return -result;
		} else {
			return result;
		}
    }
}
