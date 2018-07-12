import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * playground
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int i = (low + high) / 2;
            int temp = nums[i];
            if (temp > target) {
                high = i - 1;
            } else if (temp < target) {
                low = i + 1;
            } else {
                return i;
            }
        }
        return low;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(MainClass.class.getResourceAsStream("input.txt")));
        String line;
        while ((line = in.readLine()) != null) {
            int[] numbers = Utils.stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new Solution().searchInsert(numbers, target);
            System.out.print(ret);
        }
    }
}