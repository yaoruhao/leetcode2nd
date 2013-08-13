/**
 * 
 * @author yaoruhao
 * 
 */
public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int lenA = A.length;
		int lenB = B.length;
		if (lenA == 0 && lenB == 0) {
			return 0;
		} else if (lenA == 0) {
			if (lenB % 2 == 1)
				return B[lenB / 2];
			else
				return (B[lenB / 2] + B[lenB / 2 - 1]) / 2.0;
		} else if (lenB == 0) {
			if (lenA % 2 == 1)
				return A[lenA / 2];
			else
				return (A[lenA / 2] + A[lenA / 2 - 1]) / 2.0;
		}
		if (lenA < lenB) {
			return getMedian(A, B, 0, A.length - 1, 0, B.length - 1);
		} else {
			return getMedian(B, A, 0, B.length - 1, 0, A.length - 1);
		}
		
	}

	public double getMedian(int A[], int B[], int aLeft, int aRight, int bLeft,
			int bRight) {
		int n = aRight - aLeft + 1;
		int m = bRight - bLeft + 1;
		if (n == 1) {
			if (m == 1) {
				return (A[aLeft] + B[bLeft]) / 2.0;
			}
			if (m % 2 == 1) {
				return (B[(bLeft + bRight) / 2] + medianOfThree(A[aLeft],
						B[(bLeft + bRight) / 2 - 1],
						B[(bLeft + bRight) / 2 + 1]))/ 2.0;
			} else {
				return medianOfThree(A[aLeft], B[(bLeft + bRight + 1) / 2],
						B[(bLeft + bRight + 1) / 2 - 1]);
			}
		}
		if (n == 2) {
			if (m == 2) {
				return medianOfFour(A[aLeft], A[aRight], B[bLeft], B[bRight]);
			}
			if (m % 2 == 1) {
				return medianOfThree(B[(bLeft + bRight) / 2],
						Math.min(A[aLeft], B[(bLeft + bRight) / 2 + 1]),
						Math.max(A[aRight], B[(bLeft + bRight) / 2 - 1]));
			} else {
				return medianOfFour(B[(bLeft + bRight + 1) / 2],
						B[(bLeft + bRight + 1) / 2 - 1],
						Math.min(A[aLeft], B[(bLeft + bRight + 1) / 2 + 1]),
						Math.max(A[aRight], B[(bLeft + bRight + 1) / 2 - 2]));
			}
		}
		int aMid = (aLeft + aRight + 1) / 2;
		int bMid = (bLeft + bRight + 1) / 2;
		if (A[aMid] <= B[bMid]) {
			if (n % 2 == 0) {
				aMid--;
			}
			int minRemoved = Math.min(aMid - aLeft, m - bMid + bLeft - 1);
			return getMedian(A, B, aLeft + minRemoved, aRight, bLeft, bRight
					- minRemoved);
		} else {
			if (m % 2 == 0) {
				bMid--;
			}
			int minRemoved = Math.min(n - aMid + aLeft - 1, bMid - bLeft);
			return getMedian(A, B, aLeft, aRight - minRemoved, bLeft
					+ minRemoved, bRight);
		}
	}

	public double medianOfThree(int a, int b, int c) {
		int max = Math.max(a, Math.max(b, c));
		int min = Math.min(a, Math.min(b, c));
		return a + b + c - min - max;
	}

	public double medianOfFour(int a, int b, int c, int d) {
		int max = Math.max(a, Math.max(b, Math.max(c, d)));
		int min = Math.min(a, Math.min(b, Math.min(c, d)));
		return (a + b + c + d - max - min) / 2.0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
