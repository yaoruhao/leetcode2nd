import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 *
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []result = new int [2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
        	if (!map.containsKey(numbers[i])) {
				map.put(target - numbers[i], i);
			}
        	if (map.containsKey(numbers[i])) {
				int idx = map.get(numbers[i]);
				if (idx < i) {
					result[0] = idx + 1;
					result[1] = i + 1;
					break;
				}
			}
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
