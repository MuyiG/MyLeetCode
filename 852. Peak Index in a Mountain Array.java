/**
 Let's call an array A a mountain if the following properties hold:

 A.length >= 3
 There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

 Example 1:

 Input: [0,1,0]
 Output: 1
 Example 2:

 Input: [0,2,1,0]
 Output: 1
 Note:

 3 <= A.length <= 10000
 0 <= A[i] <= 10^6
 A is a mountain, as defined above.
 */
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int low = 1, high = A.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int left = A[mid - 1];
            int right = A[mid + 1];
            int midValue = A[mid];
            if (left < midValue && midValue > right) {
                return mid;
            } else if (left < midValue && midValue < right) {
                low = mid + 1;
            } else if (left > midValue && midValue > right) {
                high = mid - 1;
            }
        }
        return -1; // not found peak
    }
}