import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class TextJustification {

    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> resultList = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
        	int leftLength = L - words[i].length();
        	int count = 0;
        	int curLength = words[i].length();
			for (int j = i + 1; j < words.length; j++) {
				if (leftLength >= words[j].length() + 1) {
					count++;
					curLength += words[j].length();
					leftLength -= words[j].length() + 1;
				} else {
					break;
				}
			}
			if (count == 0) {
				StringBuilder sb = new StringBuilder(words[i]);
				while (sb.length() < L) {
					sb.append(" ");
				}
				resultList.add(sb.toString());
			} else {
				if (i + count == words.length - 1) {
					StringBuilder sb = new StringBuilder(words[i]);
					for (int j = 1; j <= count; j++) {
						sb.append(" ");
						sb.append(words[i + j]);
					}
					while (sb.length() < L) {
						sb.append(" ");
					}
					resultList.add(sb.toString());
					break;
				} else {
					StringBuilder sb = new StringBuilder(words[i]);
					int totalSpace = L - curLength;
					int avgSpace = totalSpace/count;
					int leftSpace = totalSpace % count;
					for (int j = 1; j <= count; j++) {
						if (leftSpace-- > 0) {
							sb.append(" ");
						}
						for (int k = 0; k < avgSpace; k++) {
							sb.append(" ");
						}
						sb.append(words[i + j]);
					}
					resultList.add(sb.toString());
					i += count;
				}
			}
		}
        return resultList;
    }
}
