public class Solution {
    
    /**
    *问题描述：Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
    *For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.  
    *
    *you need to treat n as an unsigned value
    *   
    *解决思路：不断右移1位然后和1做与运算（但是注意区分：>>用符号位填充，>>>用0填充）
    */ 
    public int hammingWeight(int n) {
        int numOfOne = 0;
        while(n != 0) {
            if((n & 1) != 0)
                numOfOne++;
            n = n>>>1;
        }
        return numOfOne;
    }
}