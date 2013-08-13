/**
 * 
 * @author yaoruhao
 *
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
    	int []result = new int [num1.length() + num2.length()];
    	for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}
    	for (int i = result.length - 1; i > 0; i--) {
			result[i-1] += result[i] / 10;
			result[i] %= 10;
		}
    	StringBuilder sb = new StringBuilder();
    	boolean flag = false;
    	for (int i = 0; i < result.length; i++) {
			if (!flag && result[i] == 0) {
				continue;
			}
			flag = true;
			sb.append(result[i]);
		}
    	return sb.toString();
    }
    
    public static void main(String []args) {
    	MultiplyStrings test = new MultiplyStrings();
    	System.out.println(test.multiply("121", "13322"));
    }
}
