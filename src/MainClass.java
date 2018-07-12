import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * playground
 */
class Solution {
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

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(MainClass.class.getResourceAsStream("input.txt")));
        String line;
        while ((line = in.readLine()) != null) {
            int[] numbers = Utils.stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(1.0 - 0.9);
        int ret = new Solution().arrangeCoinsV2(1804289383);
        System.out.print(ret);
    }
}