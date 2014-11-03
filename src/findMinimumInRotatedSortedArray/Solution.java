package findMinimumInRotatedSortedArray;

/**
 * Created by xijueyp on 14-11-1.
 */
public class Solution {
    public int findMin(int[] num) {
        int size = num.length;
        for (int i = 1; i!= size ; i++) {
            if (num[i] < num[i-1]) {
                return num[i];
            }
        }
        return num[0];
    }

    public static void main(String ap[]){

    }
}