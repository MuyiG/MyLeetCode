/**
 You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

 Given n, find the total number of full staircase rows that can be formed.

 n is a non-negative integer and fits within the range of a 32-bit signed integer.

 Example 1:

 n = 5

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤

 Because the 3rd row is incomplete, we return 2.
 Example 2:

 n = 8

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 Because the 4th row is incomplete, we return 3.

 */
class Solution {
    /**
     * 主要纠结的点其实是如如何避免整形溢出，采取了使用long和 *0.5 两种方式
     */
    public int arrangeCoins(int n) {
        long low = 0, high = (long) (Math.sqrt(n) * Math.sqrt(2));
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long temp = mid * (mid + 1) / 2;
            if (temp < n) {
                low = mid + 1;
            } else if (temp > n) {
                high = mid - 1;
            } else {
                return (int) mid;
            }
        }
        return (int) low - 1;
    }

    public int arrangeCoinsV2(int n) {
        int low = 0, high = (int) (Math.sqrt(n) * Math.sqrt(2));
        while (low <= high) {
            int mid = low + (high - low) / 2;
            double temp = 0.5 * mid * (mid + 1);
            if (temp < n) {
                low = mid + 1;
            } else if (temp > n) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low - 1;
    }
}