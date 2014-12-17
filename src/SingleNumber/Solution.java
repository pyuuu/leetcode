package SingleNumber;

/**
 * https://oj.leetcode.com/problems/single-number/
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Created by xijueyp on 14-12-17.
 */
public class Solution {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int a : A){
            result ^= a;
        }
        return result;
    }

    public static void main(String a[]){
        System.out.println(0^1);
    }
}
