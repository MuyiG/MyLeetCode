
public class Solution {
    /**
    * Given numRows, generate the first numRows of Pascal's triangle.
    * 
    * 思路：直接写循环即可，但是注意到泛型的不协变性，创建List<List>时还是有所考究的
    */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> up = new ArrayList<Integer>();
        ArrayList<Integer> down = new ArrayList<Integer>();
        for(int i = 1; i <= numRows; i++) {
            down = new ArrayList<Integer>();
            for(int j = 0; j < i; j++) {
                if(j==0 || j == i-1) down.add(1);
                else down.add(up.get(j-1)+up.get(j));
            }
            result.add(down);
            up = down;
        }
        return result;
    }
}