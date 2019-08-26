/**
 Implement int sqrt(int x).

 Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

 Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

 Example 1:

 Input: 4
 Output: 2
 Example 2:

 Input: 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since
 the decimal part is truncated, 2 is returned.
 */
class Solution {
    public int mySqrt(int x) {
        int low = 1, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int divide = x / mid; // 注意这里不要用 mid * mid 来算，很容易溢出
            if (divide < mid) {
                high = mid - 1;
            } else if (divide > mid) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low - 1;
    }
}