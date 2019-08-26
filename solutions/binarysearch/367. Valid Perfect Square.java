/**
 Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True
 Example 2:

 Input: 14
 Returns: False
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1, high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long midSquare = mid * mid;
            if (midSquare < num) {
                low = mid + 1;
            } else if (midSquare > num) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}