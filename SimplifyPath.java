import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<String> curDirList = new LinkedList<String>();
        String[] paths = path.split("/");
        for (String tempPath : paths) {
			if (tempPath.isEmpty() || tempPath.equals(".")) {
				continue;
			}
			if (tempPath.equals("..")) {
				if (!curDirList.isEmpty()) {
					curDirList.removeLast();
				}
				continue;
			}
			curDirList.add(tempPath);
		}
        StringBuilder sb = new StringBuilder();
        if (curDirList.isEmpty()) {
			sb.append("/");
		}
        for (String str : curDirList) {
			sb.append("/");
			sb.append(str);
		}
        return sb.toString();
    }
}
