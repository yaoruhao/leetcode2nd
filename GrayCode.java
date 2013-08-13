import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class GrayCode {

    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> resultList = new ArrayList<Integer>();
    	int count = 0x01 << n;
    	for (int i = 0; i < count; i++) {
			resultList.add(i ^ (i >> 1));
		}
    	return resultList;
    }
    

}
