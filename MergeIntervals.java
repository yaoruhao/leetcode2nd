import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author yaoruhao
 * 
 */
public class MergeIntervals {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (intervals.size() <= 1) {
			return intervals;
		}
		ArrayList<Interval> resultList = new ArrayList<Interval>();
		Comparator<Interval> intervalComparator = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		};
		Collections.sort(intervals, intervalComparator);
		Interval tempInterval = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start > tempInterval.end) {
				resultList.add(tempInterval);
				tempInterval = intervals.get(i);
			} else {
				tempInterval.end = Math.max(tempInterval.end, intervals.get(i).end);
			}
		}
		resultList.add(tempInterval);
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
