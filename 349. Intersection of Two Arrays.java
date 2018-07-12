/**
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */
class Solution {
    /**
     * Hash的基本应用
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int i : nums1) {
            nums1Set.add(i);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int j : nums2) {
            if (nums1Set.contains(j)) {
                resultSet.add(j);
            }
        }

        int[] result = new int[resultSet.size()];
        int pos = 0;
        for (Integer k : resultSet) {
            result[pos++] = k;
        }
        return result;
    }
}