/**
 * 
 * @author yaoruhao
 *
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder sb = new StringBuilder();
        char []romanTensDigit = {'I', 'X', 'C', 'M'};
        //max is 3999, so use * for blank
        char []romanFiveDigit = {'V', 'L', 'D', '*'};
        int division = 1000;
        int curPosition = 3;
        while (num > 0) {
			if (num < division) {
				division /= 10;
				curPosition--;
				continue;
			}
			if (num < division * 4) {
				for (int i = 1; i < 4 && num >= division; i++) {
					num -= division;
					sb.append(romanTensDigit[curPosition]);
				}
			} else if (num >= division * 4  && num < division * 5) {
				num -= division * 4;
				sb.append(romanTensDigit[curPosition]);
				sb.append(romanFiveDigit[curPosition]);
			} else if (num >= division * 5 && num < division * 9 ) {
				num -= division * 5;
				sb.append(romanFiveDigit[curPosition]);
				for (int i = 1; i < 4 && num >= division; i++) {
					num -= division;
					sb.append(romanTensDigit[curPosition]);
				}
			} else {
				num -= division * 9;
				sb.append(romanTensDigit[curPosition]);
				sb.append(romanTensDigit[curPosition + 1]);
			}
			division /= 10;
			curPosition--;
		}        
        return sb.toString();
    }
}
