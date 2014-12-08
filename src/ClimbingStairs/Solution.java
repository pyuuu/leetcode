package ClimbingStairs;

/**
 * describe:https://oj.leetcode.com/problems/climbing-stairs/
 * Created by xijueyp on 14-12-8.
 */
public class Solution {

    int [] table;

    public int climbStairs(int n) {
        table = new int[n];

        if (n == 1) return 1;

        for (int i:table) table[i] = 0;
        table[0] = 1;
        table[1] = 2;

        return j(n);
    }
    // 参数：
    public int j (int t){
        if (t == 1) return 1;
        else if (t == 2) return 2;
        else if (t < 1) return 0;

        if (table[t-1] != 0){
            return table[t-1];
        }

        int th = j(t-1) + j(t-2);
        table[t-1] = th;
        return th;
    }

    public static void main(String ap[]){
        System.out.println(new Solution().climbStairs(4));
    }
}