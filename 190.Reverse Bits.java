public class Solution {

    /**
    * Reverse bits of a given 32 bits unsigned integer.
    * 
    *you need treat n as an unsigned value
    * 解决思路：位运算（&, <<, >>>）
    *
    */
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0; i<32; i++) {
            result = result<<1;
            result += n&1;
            n = n>>>1;
        }
        return result;
    }
}