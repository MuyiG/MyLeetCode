public class Solution {
    /**
    *Reverse digits of an integer.
    *
    *Example1: x = 123, return 321
    *Example2: x = -123, return -321
    */
    public int reverse(int x) {
        //首先反转String，-号除外
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        int j = 0;
        if(s.charAt(j) == '-') {
            sb.append('-');
            j++;
        }
        for(int i=s.length()-1; i>=j; i--) {
            sb.append(s.charAt(i));
        }
        //调用Integer.parseInt()来获得结果，而且此方法在整数溢出的情况下会抛出一个NUmberFormatException
        int result;
        try {
            result = Integer.parseInt(sb.toString());
        } catch(NumberFormatException e) {
            return 0;
        }
        return result;
    }
}