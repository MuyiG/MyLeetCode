/**
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */
class Solution {
    /**
     * 主要是HashMap的熟练运用
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1CountMap = new HashMap<>();
        for (int temp : nums1) {
            Integer tempCount = nums1CountMap.get(temp);
            if (tempCount == null) {
                nums1CountMap.put(temp, 1);
            } else {
                nums1CountMap.put(temp, tempCount +1);
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int temp : nums2) {
            Integer tempCount = nums1CountMap.get(temp);
            if (tempCount == null) {
                continue;
            } else {
                resultList.add(temp);
                tempCount--;
                if (tempCount == 0) {
                    nums1CountMap.remove(temp);
                } else {
                    nums1CountMap.put(temp, tempCount);   
                }
            }
        }
        
        int[] result = new int[resultList.size()];
        int pos = 0;
        for (Integer temp : resultList) {
            result[pos++] = temp;
        }
        return result;
    }
}