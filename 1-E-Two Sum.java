/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
class Solution {
    /**
     * 1.暴力解法 Brute Force
     * 时间复杂度O(n^2)，空间复杂度O(1)
     */ 
    public int[] twoSumV1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int ai = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (ai + nums[j] == target) {
                    int[] result = {i , j};
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 2.Hash 
     * 利用一个HashMap存储数组的值和对应index，然后遍历一次数组，检查Map中是否包含target-当前元素值即可。注意同一个元素不能用两次。
     * 本质上是利用空间换时间，因为Hash能做到O(1)的查找效率，所以时间复杂度能减低到O(n)，但是空间复杂度是O(n)
     */
    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int aj = nums[j];
            int complement = target - aj;
            Integer index = numMap.get(complement);
            if (index != null && index != j) {
                int[] result = {index, j};
                return result;
            }
        }
        return null;
    }

    /**
     * 3.方法2的改进版，思路是在插入Map之前先检查一下当前Map中是否已经存在Complement，如果存在则直接返回，否则再插入。
     * 时间和空间复杂度和2一样，但是代码更加优雅了。
     */
    public int[] twoSumV3(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ai = nums[i];
            int complement = target - ai;
            Integer index = numMap.get(complement);
            if (index != null && index != i) {
                int[] result = {index, i};
                return result;
            }
            numMap.put(ai, i);
        }
        return null;
    }
}