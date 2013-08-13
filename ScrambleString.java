/**
 * 
 * @author yaoruhao
 * 
 */
public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1.isEmpty() && s2.isEmpty() || s1.equals(s2)) {
			return true;
		}
		boolean[][][] scrambled = new boolean[s1.length()][s2.length()][s1
				.length() + 1];
		for (int i = 0; i < scrambled.length; i++) {
			scrambled[i] = new boolean[s2.length()][s1.length() + 1];
			for (int j = 0; j < scrambled.length; j++) {
				scrambled[i][j] = new boolean[s1.length() + 1];
			}
		}
		for (int i = 0; i < scrambled.length; i++) {
			for (int j = 0; j < scrambled[i].length; j++) {
				scrambled[i][j][0] = true;
				if (s1.charAt(i) == s2.charAt(j)) {
					scrambled[i][j][1] = true;
				}
			}
		}
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				for (int n = 2; n <= Math.min(s1.length() - i, s2.length() - j); n++) {
					for (int m = 1; m < n; m++) {
						scrambled[i][j][n] |= (scrambled[i][j][m] && scrambled[i
								+ m][j + m][n - m])
								|| (scrambled[i][j + n - m][m] && scrambled[i
										+ m][j][n - m]);
						if (scrambled[i][j][n]) {
							break;
						}
					}
				}
			}
		}
		return scrambled[0][0][s1.length()];
	}

}
