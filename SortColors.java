/**
 * 
 * @author yaoruhao
 *
 */
public class SortColors {

    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int red = 0;
    	int white = 0;
    	int blue = A.length - 1;
    	for (white = 0; white <= blue; ) {
			if (A[white] == 0) {
				int temp = A[red];
				A[red] = A[white];
				A[white] = temp;
				red++;
				white++;
			} else if (A[white] == 2) {
				int temp = A[blue];
				A[blue] = A[white];
				A[white] = temp;
				blue--;
			} else {
				white++;
			}
		}
    }
}
