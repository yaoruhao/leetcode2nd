import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class InsertInterval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> resultList = new ArrayList<Interval>(intervals.size() + 1);
        if (intervals.isEmpty()) {
			resultList.add(newInterval);
			return resultList;
		}
        for (int i = 0; i < intervals.size(); i++) {
			if (intervals.get(i).start > newInterval.end) {
				resultList.add(newInterval);
				resultList.addAll(intervals.subList(i, intervals.size()));
				return resultList;
			}
			if (intervals.get(i).end < newInterval.start) {
				resultList.add(intervals.get(i));
				continue;
			}
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
		}
        resultList.add(newInterval);
        return resultList;
    }
    
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
